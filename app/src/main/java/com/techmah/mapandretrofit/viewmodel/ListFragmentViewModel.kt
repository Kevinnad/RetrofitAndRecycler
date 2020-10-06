package com.techmah.mapandretrofit.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techmah.mapandretrofit.model.LocationListRequest
import com.techmah.mapandretrofit.model.LocationListResponse
import com.techmah.mapandretrofit.network.ResultWrapper
import com.techmah.mapandretrofit.repo.ListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragmentViewModel @ViewModelInject constructor(private val listRepo: ListRepo): ViewModel(){

    val locationListRequest = LocationListRequest("VI020PE0016","All","Employee","2020-07-25")

    val locationResponseData = MutableLiveData<LocationListResponse>()
    val errorValue = MutableLiveData<String>()

    fun fetchLocationList(){

        viewModelScope.launch(Dispatchers.Default) {

            val locationListResponse = listRepo.fetchLocationList(locationListRequest)

            when(locationListResponse){

                is ResultWrapper.Success ->{
                    locationResponseData.postValue(locationListResponse.value)
                }
                is ResultWrapper.NetworkError -> {
                    errorValue.postValue(locationListResponse.value)
                }
                is ResultWrapper.GenericError -> {
                    errorValue.postValue(locationListResponse.value)
                }
            }
        }


    }


}