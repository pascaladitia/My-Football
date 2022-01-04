package com.pascal.myfootball.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.pascal.myfootball.R
import com.pascal.myfootball.model.CountriesItem
import com.pascal.myfootball.model.TeamsItem
import kotlinx.android.synthetic.main.item_country.view.*
import kotlinx.android.synthetic.main.item_tim.view.*

class AdapterTim(
    private val data: List<TeamsItem?>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterTim.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTim.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_tim, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.bind(item)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: TeamsItem?) {
            view.itemTim_name.text = item?.strTeam
            view.itemTim_status.text = item?.strLeague

            Glide.with(itemView.context)
                .load(item?.strTeamBadge)
                .apply(
                    RequestOptions()
                    .override(500, 500)
                    .placeholder(R.drawable.ic_liga)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .priority(Priority.HIGH))
                .into(itemView.itemTim_image)

            view.setOnClickListener{
                itemClick.detail(item)
            }
        }
    }

    interface OnClickListener {
        fun detail(item: TeamsItem?)
    }
}