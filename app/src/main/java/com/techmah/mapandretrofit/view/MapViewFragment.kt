package com.techmah.mapandretrofit.view

import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.techmah.mapandretrofit.R
import com.techmah.mapandretrofit.viewmodel.MapFragmentViewModel

class MapViewFragment : Fragment(R.layout.map_fragment_view), OnMapReadyCallback{

    val viewModel : MapFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val mMapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mMapFragment.getMapAsync(this)
    }


    override fun onMapReady(p0: GoogleMap?) {

//        Toast.makeText(requireActivity(),"Map ready",Toast.LENGTH_LONG).show()
        findLatLong(viewModel.argDate!!, p0!!)

    }

    fun findLatLong(address : String, map : GoogleMap){

        val geocoder = Geocoder(requireActivity())
        val list : List<Address>

        try{
            list = geocoder.getFromLocationName(address,5)

            val location = list.get(0)



//            Toast.makeText(requireActivity(),"Map ready"+location.getLongitude(),Toast.LENGTH_LONG).show()
            val latlong = LatLng(location.getLatitude(),location.getLongitude())
            val marker = map.addMarker(
                MarkerOptions()
                    .position(latlong)
                    .title(address)
            )

            val cameraPosition = CameraPosition.builder().target(latlong).zoom(15f).build()
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))

        }catch (e : Exception){
            e.printStackTrace()
        }
    }

}