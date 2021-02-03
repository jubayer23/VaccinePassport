package com.sprytech.vaccinepassport.ui.vaccineHistory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sprytech.vaccinepassport.R
import com.sprytech.vaccinepassport.model.Vaccine
import kotlinx.android.synthetic.main.card_layout.view.*


class NewInnerAdapter(val items : ArrayList<Vaccine>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views


    // Binds each animal in the ArrayList to a view


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.name?.text = items.get(position).name
        holder?.date?.text = items.get(position).datte
    }


}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val name = view.tv_name
    val date = view.tv_date
}