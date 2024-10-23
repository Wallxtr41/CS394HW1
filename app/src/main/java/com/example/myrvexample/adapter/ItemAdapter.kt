package com.example.myrvexample.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myrvexample.R
import com.example.myrvexample.UserDetailActivity
import com.example.myrvexample.model.User

class ItemAdapter(private val data: List<User>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var user: User

        val nameView: TextView = view.findViewById(R.id.nameTV)
        val profileView: TextView = view.findViewById(R.id.profileDescTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, UserDetailActivity::class.java)
                showUserIntent.putExtra(UserDetailActivity.USER_NAME, user.name)
                showUserIntent.putExtra(UserDetailActivity.USER_ADDR, user.address)
                showUserIntent.putExtra(UserDetailActivity.USER_PROFILE, user.profileDesc)
                context.startActivity(showUserIntent)
            }
        }
        fun bind(user:User){
            this.user = user
            nameView.text = user.name
            profileView.text = user.profileDesc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)
//        holder.nameView.text = user.name
//        holder.profileView.text = user.profileDesc
    }
}