package com.example.pokeimages.data_class

//data class Credential(
//    val email: String,
//    val password: String
//)

//{
//    "email": "eve.holt@reqres.in",
//    "password": "cityslicka"
//}

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val token: String,
    val error: String
)