package com.techmah.mapandretrofit.repo


import com.techmah.mapandretrofit.interfaces.Services
import com.techmah.mapandretrofit.network.handleRequest
import javax.inject.Inject


class ListRepo @Inject constructor(private val services: Services) {

    suspend fun fetchLocationList(params : HashMap<String, String>) = handleRequest { services.getLocationListMap(params) }
}