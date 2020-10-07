package com.techmah.mapandretrofit.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.techmah.mapandretrofit.model.LocationListResponse
import com.techmah.mapandretrofit.network.ResultWrapper
import com.techmah.mapandretrofit.repo.ListRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListFragmentViewModel @ViewModelInject constructor(val listRepo: ListRepo): ViewModel(){


    val locationResponseData = MutableLiveData<LocationListResponse>()
    val errorValue = MutableLiveData<String>()

    val params = HashMap<String,String>()

    fun fetchLocationList(){

        params.put("user_employeid","VI020PE0016")
        params.put("status","All")
        params.put("appointment_type","Employee")
        params.put("month","2020-07-25")

        viewModelScope.launch(Dispatchers.Default) {

            val locationListResponse = listRepo.fetchLocationList(params)

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