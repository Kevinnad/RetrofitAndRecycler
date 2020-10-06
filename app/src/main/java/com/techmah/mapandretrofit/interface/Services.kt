package com.techmah.mapandretrofit.`interface`

import com.techmah.mapandretrofit.Constants.BASEURL
import com.techmah.mapandretrofit.model.LocationListRequest
import com.techmah.mapandretrofit.model.LocationListResponse
import com.techmah.mapandretrofit.network.HttpClientBuilderFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface Services {

    @POST("goaltile/")
    suspend fun getGoalTile(@Body locationListRequest: LocationListRequest): LocationListResponse


    companion object {

        fun createService(
            httpClient: HttpClientBuilderFactory
        ): Services {

            val okHttpClient = httpClient.create().build()

            return Retrofit.Builder()
                .baseUrl(BASEURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(Services::class.java)
        }
    }
}