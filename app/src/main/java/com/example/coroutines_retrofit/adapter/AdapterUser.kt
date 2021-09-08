package com.example.coroutines_retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coroutines_retrofit.R
import com.example.coroutines_retrofit.databinding.ItensListBinding
import com.example.coroutines_retrofit.model.Users

class AdapterUser : RecyclerView.Adapter<UserViewHolder>() {

    private var listUsers: MutableList<Users> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.itens_list,parent,false).let {
            UserViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        listUsers[position].apply {
            holder.bind(this)
        }
    }

    override fun getItemCount(): Int = listUsers.size

    fun refresh(users: List<Users>) {
        listUsers = mutableListOf()
        listUsers.addAll(users)
        notifyDataSetChanged()
    }

}

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var binding : ItensListBinding = ItensListBinding.bind(itemView)

    fun bind(users: Users){

        binding.idName.text = users.name
        binding.idId.text = users.id

        users.let {
            Glide.with(itemView.context)
                .load(it.image)
                .into(binding.idImagem)
        }
    }
}