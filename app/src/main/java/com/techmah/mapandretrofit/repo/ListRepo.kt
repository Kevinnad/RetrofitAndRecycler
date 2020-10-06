package com.techmah.mapandretrofit.repo

import com.techmah.mapandretrofit.`interface`.Services
import com.techmah.mapandretrofit.model.LocationListRequest
import com.techmah.mapandretrofit.network.handleRequest
import javax.inject.Inject

class ListRepo @Inject constructor(private val service : Services){

    suspend fun fetchLocationList(locationListRequest : LocationListRequest) = handleRequest { service.getGoalTile(locationListRequest) }
}