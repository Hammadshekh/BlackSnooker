package com.example.black8snooker.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.black8snooker.R
import com.example.black8snooker.activities.*
import com.example.black8snooker.model.Dashboard

class DashboardAdapter(val list: ArrayList<Dashboard>, val context: Context) :
    RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.dashboard_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindToView(list[position])
        holder.itemView.setOnClickListener {


        when (position) {
            0 -> {
                val intent = Intent(context, ChatlistActivity::class.java)
                context.startActivity(intent)
            }
            1 -> {
                val intent = Intent(context, LiveVideoActivity::class.java)
                context.startActivity(intent)
            }
            2 -> {
                val intent = Intent(context, YoutubeActivity::class.java)
                context.startActivity(intent)
            }

            3 -> {
                val intent = Intent(context, FacebookActivity::class.java)
                context.startActivity(intent)
            }
            4 -> {
                val intent = Intent(context, PromotionActivity::class.java)
                context.startActivity(intent)
            }
        }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val title: TextView = itemView.findViewById(R.id.dashboard_title)
    private val image: ImageView = itemView.findViewById(R.id.dashboard_imageView)

    fun bindToView(dashboard: Dashboard) {
        title.text = dashboard.titles
        image.setImageResource(dashboard.images)
    }
}