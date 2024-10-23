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
        const val USER_NAME = "user_name"
        const val USER_ADDR = "user_addr"
        const val USER_PROFILE = "user_profile"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        //setContentView(R.layout.activity_user_detail)
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        val userName = intent.getStringExtra(USER_NAME)
        val userProfile = intent.getStringExtra(USER_PROFILE)
        val userAddress = intent.getStringExtra(USER_ADDR)

        binding.nameView.text = userName
        binding.addrView.text = userAddress
        binding.profileView.text = userProfile

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}