package com.example.clientcameraprojectmvvmkotlin.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.clientcameraprojectmvvmkotlin.R
import com.example.clientcameraprojectmvvmkotlin.model.User
import com.example.clientcameraprojectmvvmkotlin.utils.UserClickListener


class UserAdapter(val userClickListener: UserClickListener): RecyclerView.Adapter<UserViewholder>() {
    var userList: List<User?> = emptyList()
    set(value) {
        field = value
        notifyDataSetChanged()
    }
    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewholder {
        context = parent.context
        val v = LayoutInflater.from(context)
            .inflate(R.layout.user_item, parent, false)
        return UserViewholder(v);
    }

    override fun onBindViewHolder(holder: UserViewholder, position: Int) {
        val currentUser = userList[position]
        holder.userName.text = currentUser?.username
        Glide.with(context)
            .load(currentUser?.profilePictureUrl)
            .into(holder.profilePicture)
        holder.setItemClickListener(userClickListener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}

class UserViewholder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
    //let's declare and initialize our views
    var userName: TextView
    var fullName: TextView
    var profilePicture: ImageView
    lateinit var userClickListener: UserClickListener

    init {
        userName = itemView.findViewById(R.id.username)
        fullName = itemView.findViewById(R.id.full_name)
        profilePicture = itemView.findViewById(R.id.profile_picture)
    }

    fun setItemClickListener(userClickListener: UserClickListener) {
        this.userClickListener = userClickListener
    }

    override fun onClick(v: View?) {
        userClickListener.onUserClicked(v!!, adapterPosition)
    }
}