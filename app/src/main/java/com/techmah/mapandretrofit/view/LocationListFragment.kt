package com.techmah.mapandretrofit.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.techmah.mapandretrofit.R
import com.techmah.mapandretrofit.adapters.LocationListAdapter
import com.techmah.mapandretrofit.interfaces.AdapterClickListener
import com.techmah.mapandretrofit.model.Unassigned
import com.techmah.mapandretrofit.viewmodel.ListFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.location_list_fragment_view.*

const val Address = "address"
@AndroidEntryPoint
class LocationListFragment : Fragment(R.layout.location_list_fragment_view){

    private val viewModel : ListFragmentViewModel by viewModels()
    lateinit var locationList : List<Unassigned>

    private val listAdapter by lazy {
        LocationListAdapter(object : AdapterClickListener {
            override fun onItemClick(position: Int, value: String) {

                NavHostFragment.findNavController(this@LocationListFragment)
                    .navigate(R.id.action_map_fragment,Bundle().apply {
                        this.putString(Address, value)
                    })
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fetchLocationList()
        dataobservers()

        rv_location_list.adapter = listAdapter
    }

    private fun dataobservers(){

        viewModel.errorValue.observe(requireActivity(), Observer {

            Toast.makeText(requireContext(),it,Toast.LENGTH_LONG).show()
            location_list_text.setText("Tap to Try Again")
            location_list_text.setOnClickListener {
                viewModel.fetchLocationList()
            }
        })

        viewModel.locationResponseData.observe(requireActivity(), Observer {

            location_list_text.visibility = View.GONE
            locationList = it.unassigned
            listAdapter.setDataList(it.unassigned)
        })

    }


}