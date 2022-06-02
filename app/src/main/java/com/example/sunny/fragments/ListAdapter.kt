package com.example.sunny.fragments.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sunny.R
import com.example.sunny.data.Entry
import com.example.sunny.fragments.ListFragmentDirections
import kotlinx.android.synthetic.main.custom_row.view.*

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>(){

    private var entryList = emptyList<Entry>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.custom_row,
            parent, false))
    }

    // returns the number of recyclerview objects we need; the number of records
    override fun getItemCount(): Int {
        return entryList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = entryList[position]
        holder.itemView.defaultId.text = currentItem.id.toString()
        holder.itemView.defaultDate.text = currentItem.date
        holder.itemView.defaultTitle.text = currentItem.title

        holder.itemView.rowLayout.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(user: List<Entry>){
        this.entryList = user
        notifyDataSetChanged()
    }
}