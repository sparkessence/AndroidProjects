package com.example.retrofitkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitkotlin.R
import com.example.retrofitkotlin.model.AlbumDataModel
import com.example.retrofitkotlin.uicontroller.MainActivity
import java.util.ArrayList

class DataAdapter(private var dataList: List<AlbumDataModel>, private val context: Context) : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {

    class MyViewHolder(itemLayoutView: View) : RecyclerView.ViewHolder(itemLayoutView) {
        lateinit var titleTextView: TextView
        init {
            titleTextView = itemLayoutView.findViewById(R.id.titlehere)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_home, parent, false))

    }

    override fun onBindViewHolder(holder: DataAdapter.MyViewHolder, position: Int) {
        val dataModel = dataList.get(position)
        holder.titleTextView.text = dataModel.title
    }

    override fun getItemCount(): Int {
       return dataList.size
    }
}


