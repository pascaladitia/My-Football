package com.pascal.myfootball.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.myfootball.R
import com.pascal.myfootball.model.EventsItem
import com.pascal.myfootball.model.ResponseLastJadwal
import com.pascal.myfootball.model.TeamsItem
import kotlinx.android.synthetic.main.item_jadwal.view.*

class AdapterJadwal(
    private val data: List<EventsItem?>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterJadwal.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterJadwal.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_jadwal, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.bind(item)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: EventsItem?) {
            view.itemJadwal_tgl.text = item?.dateEvent
            view.itemJadwal_waktu.text = item?.strTime
            view.jadwal_home.text = item?.strHomeTeam
            view.jadwal_skor1.text = item?.intHomeScore
            view.jadwal_skor2.text = item?.intAwayScore
            view.jadwal_away.text = item?.strAwayTeam

            view.setOnClickListener{
                itemClick.detail(item)
            }
        }
    }

    interface OnClickListener {
        fun detail(item: EventsItem?)
    }
}