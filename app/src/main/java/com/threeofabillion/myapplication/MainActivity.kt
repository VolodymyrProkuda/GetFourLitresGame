package com.threeofabillion.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.threeofabillion.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val full5L = 5
    val full3L = 3
    var in5L = 0
    var in3L = 0
    var part =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imageView6.setOnClickListener { craneTo5L() }
        binding.imageView7.setOnClickListener { craneTo3L() }
        binding.imageView8.setOnClickListener { from5LToDrinage() }
        binding.imageView9.setOnClickListener { from3LToDrinage() }
        binding.imageView10.setOnClickListener { from5LTo3L() }
        binding.imageView11.setOnClickListener { from3LTo5L() }
    }
    fun craneTo5L() {
        in5L = 5
        draw5L()
    }
    fun craneTo3L() {
        in3L = 3
        draw3L()
    }
    fun from5LTo3L() {
        if (( in5L + in3L)<= full3L) {
            part = in5L
            in3L = in3L + part
            in5L = in5L - part
        }
        if (( in5L + in3L)> full3L) {
            part = full3L - in3L
            in3L = in3L + part
            in5L = in5L - part
        }
        draw5L()
        draw3L()
        if (in5L == 4) binding.textView.text = "WIN!!!"
        part = 0
    }
    fun from3LTo5L() {
        if (( in5L + in3L)<= full5L) {
            part = in3L
            in5L = in5L + part
            in3L = in3L - part
        }
        if (( in5L + in3L)> full5L) {
            part = full5L - in5L
            in5L = in5L + part
            in3L = in3L - part
        }

        draw5L()
        draw3L()
        if (in5L == 4) binding.textView.text = "WIN!!!"
        part = 0
    }
    fun from5LToDrinage() {
        in5L = 0
        draw5L()
    }
    fun from3LToDrinage() {
        in3L = 0
        draw3L()
    }
    fun draw5L() {
        if (in5L == 0)  binding.imageView.setImageResource(R.drawable.k5_0)
        if (in5L == 1)  binding.imageView.setImageResource(R.drawable.k5_1)
        if (in5L == 2)  binding.imageView.setImageResource(R.drawable.k5_2)
        if (in5L == 3)  binding.imageView.setImageResource(R.drawable.k5_3)
        if (in5L == 4)  binding.imageView.setImageResource(R.drawable.k5_4)
        if (in5L == 5)  binding.imageView.setImageResource(R.drawable.k5_5)


    }
    fun draw3L() {
        if (in3L == 0)  binding.imageView2.setImageResource(R.drawable.k3_0)
        if (in3L == 1)  binding.imageView2.setImageResource(R.drawable.k3_1)
        if (in3L == 2)  binding.imageView2.setImageResource(R.drawable.k3_2)
        if (in3L == 3)  binding.imageView2.setImageResource(R.drawable.k3_3)
    }
}