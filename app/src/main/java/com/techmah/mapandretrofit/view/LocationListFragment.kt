package com.techmah.mapandretrofit.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.techmah.mapandretrofit.R
import com.techmah.mapandretrofit.viewmodel.ListFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LocationListFragment : Fragment(R.layout.location_list_fragment_view){

    private val viewModel : ListFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchLocationList()
        dataobservers()
    }

    private fun dataobservers(){

        viewModel.errorValue.observe(requireActivity(), Observer {

            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
        })

        viewModel.locationResponseData.observe(requireActivity(), Observer {

            Toast.makeText(requireContext(),"Success",Toast.LENGTH_LONG).show()
        })

    }

}