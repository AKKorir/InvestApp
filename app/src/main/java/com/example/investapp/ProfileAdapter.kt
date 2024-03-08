package com.example.investapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler


class ProfileAdapter( private val profile: ArrayList<profile_list>):  RecyclerView.Adapter<ProfileAdapter.ProfileViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int
    ): ProfileAdapter.ProfileViewHolder {
        return ProfileViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.profile_list, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProfileAdapter.ProfileViewHolder, position: Int) {
        val plan = profile[position]

        holder.profile_icon.setImageResource(plan.profile_icon)
        holder.profile_value.text = plan.profile_value
    }

    override fun getItemCount(): Int {
        return profile.size
    }

    class ProfileViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var profile_icon: ImageView = view.findViewById(R.id.profile_icon)
        val profile_value: TextView = view.findViewById(R.id.profile_value)
    }
}