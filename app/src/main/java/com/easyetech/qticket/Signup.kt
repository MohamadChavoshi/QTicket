package com.easyetech.qticket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.easyetech.qticket.databinding.ActivityLoginBinding
import com.easyetech.qticket.databinding.ActivitySignupBinding

class Signup : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtnSignup.setOnClickListener {
            val intent = Intent(this@Signup, Login::class.java)
            startActivity(intent)
        }

        binding.SignupBtn.setOnClickListener {
            val intent = Intent(this@Signup, Login::class.java)
            startActivity(intent)
        }


        binding.SignupBtn.isClickable = false
        binding.TermAcceptBtn.setOnClickListener {
            if (binding.TermAcceptBtn.isChecked){
                binding.SignupBtn.alpha = 1.0F
                binding.SignupBtn.isClickable = true
            }else {
                binding.SignupBtn.alpha = 0.3F
                binding.SignupBtn.isClickable = false
            }
        }


    }
}