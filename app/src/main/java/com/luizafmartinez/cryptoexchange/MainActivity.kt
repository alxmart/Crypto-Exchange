package com.luizafmartinez.cryptoexchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.luizafmartinez.cryptoexchange.api.CotacaoAPI
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var btnRecuperar: Button
    lateinit var textBitcoin: TextView
    lateinit var textEthereum: TextView

    val cotacaoAPI: CotacaoAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://www.mercadobitcoin.net/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CotacaoAPI::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRecuperar = findViewById(R.id.btn_recuperar)
        textBitcoin = findViewById(R.id.tv_bitcoin)
        textEthereum = findViewById(R.id.tv_ethereum)

        btnRecuperar.setOnClickListener {
            //Permissão de internet necessária !!
            CoroutineScope(Dispatchers.IO).launch {

              // Recupera o preço da BITCOIN
              val resposta = cotacaoAPI.recuperarCotacaoBitcoin()
              if(resposta.isSuccessful) {
                  val cotacao = resposta.body()
                  if(cotacao != null) {

                      withContext(Dispatchers.Main) {
                        textBitcoin.text = "Bitcoin R$ ${cotacao.ticker.last}"
                      }
                  }
              }

                // Recupera o preço da ETHEREUM
                val respostaEthereum = cotacaoAPI.recuperarCotacaoEthereum()
                if(respostaEthereum.isSuccessful) {
                    val cotacao = respostaEthereum.body()
                    if(cotacao != null) {

                        withContext(Dispatchers.Main) {
                            textEthereum.text = "Ethereum R$ ${cotacao.ticker.last}"
                        }
                    }
                }

            } // Fechamento Coroutine




        }



    }
}