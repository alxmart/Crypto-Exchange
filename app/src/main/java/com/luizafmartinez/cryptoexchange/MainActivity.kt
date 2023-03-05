package com.luizafmartinez.cryptoexchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var btnRecuperar: Button
    lateinit var textBitcoin: TextView
    lateinit var textEthereum: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRecuperar = findViewById(R.id.btn_recuperar)
        textBitcoin = findViewById(R.id.tv_bitcoin)
        textEthereum = findViewById(R.id.tv_ethereum)

        btnRecuperar.setOnClickListener {

        }



    }
}