package com.example.myrvexample.data

import android.content.Context
import com.example.myrvexample.R
import com.example.myrvexample.model.User

class DataSource(val context: Context) {
    private fun getIdList(): Array<String> {
        return context.resources.getStringArray(R.array.id)
    }

    private fun getCarModelList(): Array<String> {
        return context.resources.getStringArray(R.array.car_model)
    }

    private fun getCarModelYearList(): Array<String> {
        return context.resources.getStringArray(R.array.car_model_year)
    }

    private fun getCountry(): Array<String> {
        return context.resources.getStringArray(R.array.country)
    }

    private fun getPrice(): Array<String> {
        return context.resources.getStringArray(R.array.price)
    }

    private fun getSellerFirstName(): Array<String> {
        return context.resources.getStringArray(R.array.seller_first_name)
    }

    private fun getSellerLastName(): Array<String> {
        return context.resources.getStringArray(R.array.seller_last_name)
    }

    private fun getSellerGender(): Array<String> {
        return context.resources.getStringArray(R.array.seller_gender)
    }

    private fun getSellerAvatar(): Array<String> {
        return context.resources.getStringArray(R.array.seller_avatars)
    }

    fun loadUsers(): List<User> {
        val idList = getIdList()
        val carModelList = getCarModelList()
        val carModelYearList = getCarModelYearList()
        val countryList = getCountry()
        val priceList = getPrice()
        val sellerFirstNameList = getSellerFirstName()
        val sellerLastNameList = getSellerLastName()
        val sellerGenderList = getSellerGender()
        val sellerAvatarList = getSellerAvatar()


        val users = mutableListOf<User>()
        for (i in idList.indices) {
            users.add(
                User(
                    idList[i],
                    carModelList[i],
                    carModelYearList[i],
                    countryList[i],
                    priceList[i],
                    sellerFirstNameList[i],
                    sellerLastNameList[i],
                    sellerGenderList[i],
                    sellerAvatarList[i]
                )
            )
        }
        return users
    }

}