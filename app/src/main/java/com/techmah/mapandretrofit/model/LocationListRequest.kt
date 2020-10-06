package com.techmah.mapandretrofit.model

data class LocationListRequest(
    val user_employeid : String,
    val status : String,
    val appointment_type : String,
    val month : String
)