package service

import entity.Animal
import entity.Burung
import entity.Mamalia
import entity.Reptil

class ActionService{

   private val listAnimal = mutableListOf<Animal>()

    fun createData(name: String, category: String, age: Int): Animal{
        val animal: Animal = when(category.lowercase()){
            "mamalia"-> Mamalia(name, age)
            "burung" -> Burung(name, age)
            "reptil"-> Reptil(name, age)
            else -> throw IllegalArgumentException("Unknown category: $category")
        }

        listAnimal.add(animal)
        return animal
    }

    fun addFeedSchedule(id: Int, schedule:Int) {
        if (schedule !in 0..24){
            throw IllegalArgumentException("Unknown Schedule: $schedule")
        }
        val animal = listAnimal.find { it.id == id }
        animal?.addFeedSchedule(schedule) ?: println("Animal with ID $id not found.")
    }

    fun getAllAnimal(): List<Animal> = listAnimal.toList()

    fun soundParade(){
        println("---INCOMING NOICE---")
        listAnimal.sortedBy { it.id }
        for (animal in listAnimal){
            println("[${animal.id}] ${animal.name} : ${animal.sound()}")
        }
    }

    fun report(){
        println("---FEEDING SCHEDULE---")
        for (animal in listAnimal){
            println("[${animal.id}] ${animal.name} : ${animal.getFeedSchedule().joinToString(", ")}:00")
        }
    }
}