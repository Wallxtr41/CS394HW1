package com.example.myrvexample.data

import android.content.Context
import com.example.myrvexample.R
import com.example.myrvexample.model.User

class DataSource(val context: Context) {
    fun getUserNamesList(): Array<String>{
        return context.resources.getStringArray(R.array.name_array)
    }
    fun getUserAddressList(): Array<String>{
        return context.resources.getStringArray(R.array.address_array)
    }
    fun getUserProfileList(): Array<String>{
        return context.resources.getStringArray(R.array.profiledesc_array)
    }

    fun loadUsers(): List<User>{
        val namesList = getUserNamesList()
        val addressList = getUserAddressList()
        val profileList  = getUserProfileList()

        val users = mutableListOf<User>()
        for (i in namesList.indices){
            users.add(User(namesList[i], address = addressList[i], profileDesc = profileList[i]))
        }
        return users
    }
}