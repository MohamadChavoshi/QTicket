package com.easyetech.qticket

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.widget.Button
import com.budiyev.android.codescanner.CodeScanner
import com.easyetech.qticket.databinding.ActivityLoginBinding
import com.easyetech.qticket.databinding.ActivityScannerBinding
import kotlin.math.absoluteValue

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.Username.setOnClickListener {
//            val set: AnimatorSet = AnimatorInflater.loadAnimator(this,R.anim.input_feild_anim)
//                .apply {
//                    start()
//                }
//        }


        binding.NewAcountBtn.setOnClickListener {
            val intent = Intent(this@Login, Signup::class.java)
            startActivity(intent)
        }

        binding.backBtnLogin.setOnClickListener {
            val intent = Intent(this@Login, MainActivity::class.java)
            startActivity(intent)
        }


    }
}