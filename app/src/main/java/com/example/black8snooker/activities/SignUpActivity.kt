package com.example.black8snooker.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.black8snooker.R
import com.example.black8snooker.databinding.ActivitySignUpBinding
import com.example.messenger.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var dataBaseRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()
        binding.loginTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.signUpBtn.setOnClickListener {
            val name = binding.userNameEditText.text.trim().toString()
            val email = binding.userEmailEditText.text.trim().toString()
            val password = binding.userPasswordEditText.text.trim().toString()

            signUp(name, email, password)
        }

    }

    private fun signUp(name: String, email: String, password: String) {
        if (areFieldReady()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        addUserToDatabase(name, email, auth.currentUser?.uid!!)
                        val intent = Intent(this@SignUpActivity, DashboardActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        Toast.makeText(
                            this@SignUpActivity, "Some Error Occurred..",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
        }
    }

    private fun addUserToDatabase(name: String, email: String, uid: String) {
        dataBaseRef = FirebaseDatabase.getInstance().reference
        dataBaseRef.child("user").child(uid).setValue(User(name, email, uid))
    }

    private fun areFieldReady(): Boolean {

        val email = binding.userEmailEditText.text.trim().toString()
        val name = binding.userNameEditText.text.trim().toString()
        val password = binding.userPasswordEditText.text.trim().toString()

        var view: View? = null
        var flag = false

        when {

            email.isEmpty() -> {
                binding.userEmailEditText.error = "Field is required"
                view = binding.userEmailEditText
                flag = true
            }
            name.isEmpty() -> {
                binding.userNameEditText.error = "Field is required"
                view = binding.userNameEditText
                flag = true
            }
            password.isEmpty() -> {
                binding.userPasswordEditText.error = "Field is required"
                view = binding.userPasswordEditText
                flag = true
            }

            password.length < 8 -> {
                binding.userPasswordEditText.error = "Minimum 8 characters"
                view = binding.userPasswordEditText
                flag = true
            }

        }
        return if (flag) {
            view?.requestFocus()
            false
        } else
            true
    }
}