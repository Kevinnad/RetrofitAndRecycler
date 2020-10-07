package com.techmah.mapandretrofit.adapters

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.techmah.mapandretrofit.interfaces.AdapterClickListener
import com.techmah.mapandretrofit.model.Unassigned
import kotlinx.android.synthetic.main.location_list_item.view.*

class LocationListViewHolder(itemView: View,
                             private val listener: AdapterClickListener
) : RecyclerView.ViewHolder(itemView) {

    fun bind(unassignItem: Unassigned) {
        val address = unassignItem.Address_Line_1 +", "+ unassignItem.Address_Line_2 +", "+ unassignItem.Land_Mark +", "+ unassignItem.City +", "+ unassignItem.State +", "+ unassignItem.PIN

        itemView.tv_inst_name.text = "Institute Name : "+unassignItem.Institution_Name
        itemView.user_lay.setOnClickListener {
            listener.onItemClick(adapterPosition,address)
        }
        itemView.tv_poc_name.text = "POC Name : "+unassignItem.POC_Name
        itemView.tv_employee_id.text = "EmployeeID : VI020PE0016"
        itemView.tv_address.text = "Address : " + address
    }

}