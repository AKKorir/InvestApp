package com.example.investapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AssetAdapter(
    private val assetList: ArrayList<asset>
): RecyclerView.Adapter  <AssetAdapter.AssetViewHolder>(){

    override fun getItemCount(): Int {
        return assetList.size
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetViewHolder
    {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.asset,
            parent,false)
        return AssetViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: AssetViewHolder, position: Int) {
        val currentItem = assetList[position]
        holder.cardImage.setImageResource(currentItem.cardImage)
        holder.heading.text = currentItem.heading
        holder.descrip.text = currentItem.descrip

    }
    class AssetViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val cardImage : ImageView = itemView.findViewById(R.id.imgasset)
        val heading : TextView =itemView.findViewById(R.id.assval)
        val descrip : TextView =itemView.findViewById(R.id.assetperc)


    }

}





