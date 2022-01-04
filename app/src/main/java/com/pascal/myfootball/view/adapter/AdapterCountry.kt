package com.pascal.myfootball.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.myfootball.R
import com.pascal.myfootball.model.CountriesItem
import kotlinx.android.synthetic.main.item_country.view.*

class AdapterCountry(
    private val data: List<CountriesItem?>?,
    private val itemClick: OnClickListener
) : RecyclerView.Adapter<AdapterCountry.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCountry.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.bind(item)
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: CountriesItem?) {
            view.itemCountry_name.text = item?.nameEn.toString()

            view.setOnClickListener{
                itemClick.detail(item)
            }
        }
    }

    interface OnClickListener {
        fun detail(item: CountriesItem?)
    }
}