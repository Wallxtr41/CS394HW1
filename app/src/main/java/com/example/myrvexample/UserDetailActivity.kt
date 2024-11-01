package com.example.myrvexample

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myrvexample.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {
    companion object{
        const val USER_ID = "user_id"
        const val USER_CAR_MODEL = "user_car_model"
        const val USER_CAR_MODEL_YEAR = "user_car_model_year"
        const val USER_COUNTRY = "user_country"
        const val USER_PRICE = "user_price"
        const val USER_SELLER_FIRST_NAME = "user_seller_first_name"
        const val USER_SELLER_LAST_NAME = "user_seller_last_name"
        const val USER_SELLER_GENDER = "user_seller_gender"
        const val USER_SELLER_AVATAR = "user_seller_avatar"



    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_user_detail)
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        val userId= intent.getStringExtra(USER_ID)
        val userCarModel = intent.getStringExtra(USER_CAR_MODEL)
        val userCarModelYear = intent.getStringExtra(USER_CAR_MODEL_YEAR)
        val userCountry = intent.getStringExtra(USER_COUNTRY)
        val userPrice = intent.getStringExtra(USER_PRICE)
        val userSellerFirstName = intent.getStringExtra(USER_SELLER_FIRST_NAME)
        val userSellerLastName = intent.getStringExtra(USER_SELLER_LAST_NAME)
        val userSellerGender = intent.getStringExtra(USER_SELLER_GENDER)
        val userSellerAvatar = intent.getStringExtra(USER_SELLER_AVATAR)

        binding.idView.text = userId
        binding.carModelView.text = userCarModel
        binding.carModelYearView.text = userCarModelYear
        binding.countryView.text = userCountry
        binding.priceView.text = userPrice
        binding.sellerFirstNameView.text = userSellerFirstName
        binding.sellerLastNameView.text = userSellerLastName
        binding.sellerGenderView.text = userSellerGender
        binding.sellerAvatarView.text = userSellerAvatar

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}