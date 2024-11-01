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

        val idView: TextView = view.findViewById(R.id.idTV)
        val carModelView: TextView = view.findViewById(R.id.carModelTV)
        val countryView: TextView = view.findViewById(R.id.countryTV)
        val priceView: TextView = view.findViewById(R.id.priceTV)

        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, UserDetailActivity::class.java)
                showUserIntent.putExtra(UserDetailActivity.USER_ID, user.id)
                showUserIntent.putExtra(UserDetailActivity.USER_CAR_MODEL, user.carModel)
                showUserIntent.putExtra(UserDetailActivity.USER_CAR_MODEL_YEAR, user.carModelYear)
                showUserIntent.putExtra(UserDetailActivity.USER_COUNTRY, user.country)
                showUserIntent.putExtra(UserDetailActivity.USER_PRICE, user.price)
                showUserIntent.putExtra(UserDetailActivity.USER_SELLER_FIRST_NAME, user.sellerFirstName)
                showUserIntent.putExtra(UserDetailActivity.USER_SELLER_LAST_NAME, user.sellerLastName)
                showUserIntent.putExtra(UserDetailActivity.USER_SELLER_GENDER, user.sellerGender)
                showUserIntent.putExtra(UserDetailActivity.USER_SELLER_AVATAR, user.sellerAvatar)

                context.startActivity(showUserIntent)
            }
        }
        fun bind(user:User){
            this.user = user
            idView.text = user.id
            carModelView.text = user.carModel
            countryView.text = user.country
            priceView.text = user.price

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