package com.example.investapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class investAdapter(
    private val context: Context,
    private val investList: ArrayList <investGuide>): RecyclerView.Adapter <investAdapter.InvestViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestViewHolder {
        val newsView =LayoutInflater.from(parent.context).inflate(R.layout.investguide,parent, false)
        return InvestViewHolder(newsView)
    }

    override fun getItemCount(): Int {
        return investList.size
    }

    override fun onBindViewHolder(holder: InvestViewHolder, position: Int) {
        val currentItem = investList[position]
        holder.investImage.setImageResource(currentItem.investImage)
        holder.nheading.text= currentItem.heading
        holder.subheading.text= currentItem.subheading

    }

    class InvestViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val investImage : ImageView = itemView.findViewById(R.id.newsimg)
        val nheading : TextView =itemView.findViewById(R.id.titlenews)
        val subheading : TextView =itemView.findViewById(R.id.subtnews)
    }
}