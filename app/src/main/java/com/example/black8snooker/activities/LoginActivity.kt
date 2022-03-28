package com.example.black8snooker.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.black8snooker.R
import com.example.black8snooker.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        auth = FirebaseAuth.getInstance()
        supportActionBar?.hide()
        binding.signUpTextView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.loginBtn.setOnClickListener {
            val email = binding.emailEditText.text.toString().trim()
            val password = binding.passwordEditText.text.toString().trim()
            login(email, password)
        }
    }

    private fun login(email: String, password: String) {
        if (areFieldReady()) {
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val intent = Intent(this@LoginActivity, DashboardActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this@LoginActivity, "User Does Not Exist..",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                }
        }

    }

    private fun areFieldReady(): Boolean {

        val email = binding.emailEditText.text.trim().toString()
        val password = binding.passwordEditText.text.trim().toString()

        var view: View? = null
        var flag = false

        when {

            email.isEmpty() -> {
                binding.emailEditText.error = "Field is required"
                view = binding.emailEditText
                flag = true
            }
            password.isEmpty() -> {
                binding.passwordEditText.error = "Field is required"
                view = binding.passwordEditText
                flag = true
            }

            password.length < 8 -> {
                binding.passwordEditText.error = "Minimum 8 characters"
                view = binding.passwordEditText
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