package com.deromang.mvp_kotlin.ui.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deromang.domain.data.Url
import com.deromang.mvp_kotlin.R
import kotlinx.android.synthetic.main.detail_list_item.view.*

class DetailAdapter(private val items: List<Url>, private val context: Context?, private val listener: OnItemClickListener) :
    RecyclerView.Adapter<DetailViewHolder>() {

    // Gets the number of items in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.detail_list_item,
                parent,
                false
            )
        )
    }

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.tvUrl.text = items[position].type

        holder.clUrl.setOnClickListener {
            listener.onItemClick(items[position].url)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(url: String)
    }

}

class DetailViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvUrl = view.tvUrl
    val clUrl = view.clUrl
}