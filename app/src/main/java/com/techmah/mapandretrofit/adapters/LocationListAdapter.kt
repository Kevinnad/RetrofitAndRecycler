package com.techmah.mapandretrofit.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.techmah.mapandretrofit.R
import com.techmah.mapandretrofit.interfaces.AdapterClickListener
import com.techmah.mapandretrofit.model.Unassigned

class LocationListAdapter(private val listener: AdapterClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listItem = emptyList<Unassigned>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return LocationListViewHolder(
            (LayoutInflater.from(parent.context)
                .inflate(R.layout.location_list_item, parent, false)),listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as LocationListViewHolder).bind(listItem[position])
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    fun setDataList(listItem : List<Unassigned>){
        this.listItem = listItem
        notifyDataSetChanged()
    }
}