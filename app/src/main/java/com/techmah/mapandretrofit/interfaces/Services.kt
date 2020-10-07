package com.techmah.mapandretrofit.interfaces

import com.techmah.mapandretrofit.Constants.BASEURL
import com.techmah.mapandretrofit.model.LocationListResponse
import com.techmah.mapandretrofit.network.HttpClientBuilderFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface Services {

    @POST("get_monthly_appointments")
    @FormUrlEncoded
    suspend fun getLocationListMap(@FieldMap params : Map<String,String>): LocationListResponse


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