package com.example.myrvexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myrvexample.databinding.ActivityUserDetailBinding
import android.util.Base64;
import android.widget.ImageView;

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
        val userSellerAvatar = decodeBase64ToBitmap(intent.getStringExtra(USER_SELLER_AVATAR))

        binding.idView.text = userId
        binding.carModelView.text = "Car Model: " + userCarModel
        binding.carModelYearView.text = "Car Model Year: "+userCarModelYear
        binding.countryView.text = "Country: " +userCountry
        binding.priceView.text = "Price: " +userPrice
        binding.sellerFirstNameView.text = "First Name: " +userSellerFirstName
        binding.sellerLastNameView.text = "Last Name: " + userSellerLastName
        binding.sellerGenderView.text = "Gender: " + userSellerGender
        binding.sellerAvatarView.setImageBitmap(userSellerAvatar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    fun decodeBase64ToBitmap(base64String: String?): Bitmap {
        val decodedBytes: ByteArray = Base64.decode(base64String, Base64.DEFAULT)
        return BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    }
}