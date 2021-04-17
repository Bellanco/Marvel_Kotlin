package com.deromang.mvp_kotlin.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.deromang.domain.data.Result
import com.deromang.mvp_kotlin.R
import com.deromang.mvp_kotlin.ui.utils.loadImageFromUrl
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainAdapter(private val items: List<Result>, private val context: Context?, val listener: OnItemClickListener) :
    RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of items in the list
    override fun getItemCount(): Int {
        return items.size
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.main_list_item,
                parent,
                false
            )
        )
    }

    // Binds each item in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvItem.text = items[position].name
        val thumbnail = items[position].thumbnail
        holder.ivItem.loadImageFromUrl("""${thumbnail.path}.${thumbnail.extension}""")

        holder.cvItem.setOnClickListener {
            listener.onItemClick(items[position].id)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(characterId: Int)
    }

}

class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvItem = view.tvItem
    val ivItem = view.ivItem
    val cvItem = view.cvItem
}