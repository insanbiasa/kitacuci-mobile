package com.cadastralshop.loginui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cadastralshop.loginui.R
import com.cadastralshop.loginui.model.KatalogItem

class KatalogAdapters(var context: Context, var arrayList: ArrayList<KatalogItem>) :
    RecyclerView.Adapter<KatalogAdapters.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_grid, parent, false)
        return ItemHolder(itemHolder)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var katalogItem : KatalogItem = arrayList.get(position)

        holder.icons.setImageResource(katalogItem.icons!!)
        holder.names.text = katalogItem.iconNames

        holder.names.setOnClickListener{
            Toast.makeText(context, katalogItem.iconNames, Toast.LENGTH_LONG).show()
        }
    }

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var icons = itemView.findViewById<ImageView>(R.id.icons_image)
        var names = itemView.findViewById<TextView>(R.id.icons_name)
    }

}