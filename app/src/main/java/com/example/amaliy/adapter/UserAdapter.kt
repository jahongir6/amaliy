package com.example.amaliy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amaliy.databinding.ItemRvBinding
import com.example.amaliy.models.User

class UserAdapter(var list: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.Vh>() {

    inner class Vh(val itemRvBinding: ItemRvBinding) : RecyclerView.ViewHolder(itemRvBinding.root) {
        fun onBind(user: User) {
            itemRvBinding.tvName.text = user.name
            itemRvBinding.tvAge.text = user.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

}