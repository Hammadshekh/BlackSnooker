package com.example.black8snooker.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.black8snooker.R
import com.example.black8snooker.databinding.ActivityAboutBinding
import com.example.black8snooker.databinding.ActivityPrivacyBinding

class PrivacyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPrivacyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_privacy)

        binding.backBtn.setOnClickListener {
            onBackPressed()
        }
    }
}