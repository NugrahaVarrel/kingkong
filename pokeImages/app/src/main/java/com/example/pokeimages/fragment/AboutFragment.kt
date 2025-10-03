package com.example.pokeimages.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.pokeimages.R
import com.example.pokeimages.vm.AboutViewModel
import com.example.pokeimages.vm.StatusState

class AboutFragment : Fragment() {

    private val vm : AboutViewModel by viewModels()
    private lateinit var progress: ProgressBar
    private lateinit var tvConnectionStatus: TextView

    private lateinit var checkButton: Button

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        if (savedInstanceState == null){
//            vm.loadStatus()
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_about_page, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        progress = view.findViewById<ProgressBar>(R.id.progressBarStatus)
        tvConnectionStatus = view.findViewById(R.id.tvConnectionStatus)
        checkButton = view.findViewById(R.id.btnCheckConnection)

        vm.status.observe(viewLifecycleOwner) { state ->
            when (state) {
                is StatusState.Idle -> {
                    progress.visibility = View.GONE
                    tvConnectionStatus.text = ""
                }
                is StatusState.Loading -> {
                    progress.visibility = View.VISIBLE
                    tvConnectionStatus.text = "Loading..."
                }
                is StatusState.Success -> {
                    progress.visibility = View.GONE
                    tvConnectionStatus.text = state.message
                }
                is StatusState.Error -> {
                    progress.visibility = View.GONE
                    tvConnectionStatus.text = state.message
                    Toast.makeText(requireContext(), state.message, Toast.LENGTH_LONG).show()
                }
            }
        }
        checkButton.setOnClickListener {
            vm.loadStatus()
        }
    }
}