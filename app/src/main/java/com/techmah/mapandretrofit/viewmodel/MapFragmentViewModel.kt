package com.techmah.mapandretrofit.viewmodel

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.techmah.mapandretrofit.view.Address


class MapFragmentViewModel @ViewModelInject constructor(@Assisted private val savedStateHandle: SavedStateHandle): ViewModel(){

    val argDate = savedStateHandle.get<String>(Address)


}