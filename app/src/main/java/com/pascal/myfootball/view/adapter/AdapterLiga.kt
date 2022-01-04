package com.pascal.myfootball.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.myfootball.R
import com.pascal.myfootball.model.LeaguesItem
import kotlinx.android.synthetic.main.item_country.view.*
import kotlinx.android.synthetic.main.item_liga.view.*

class AdapterLiga(
    private val data: List<LeaguesItem?>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterLiga.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterLiga.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_liga, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.bind(item)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: LeaguesItem?) {
            view.itemLiga_name.text = item?.strLeague
            view.itemLiga_status.text = item?.strLeagueAlternate

            view.setOnClickListener{
                itemClick.detail(item)
            }
        }
    }

    interface OnClickListener {
        fun detail(item: LeaguesItem?)
    }
}