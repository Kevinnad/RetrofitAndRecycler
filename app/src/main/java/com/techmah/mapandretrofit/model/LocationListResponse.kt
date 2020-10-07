package com.techmah.mapandretrofit.model

data class LocationListResponse(val status_code : String, val unassigned : List<Unassigned>)

data class Unassigned(
    val Address_Line_1 :String,
    val Address_Line_2 : String,
    val Land_Mark : String,
    val City : String,
    val State : String,
    val PIN : String,
    val Institution_Name : String,
    val POC_Name : String

)