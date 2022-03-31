package com.example.black8snooker.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.databinding.DataBindingUtil
import com.example.black8snooker.R
import com.example.black8snooker.databinding.ActivitySplashBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)
        supportActionBar?.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            if(Firebase.auth.currentUser != null){
                startActivity(Intent( this,DashboardActivity::class.java))
                finish()
            } else{
                startActivity(Intent( this,LoginActivity::class.java))
                finish()
            }
        }, 3000)
    }
}