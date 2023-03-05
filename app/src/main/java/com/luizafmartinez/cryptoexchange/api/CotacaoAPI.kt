package com.luizafmartinez.cryptoexchange.api

import okhttp3.Response
import retrofit2.http.GET

interface CotacaoAPI {

    //https://www.mercadobitcoin.net/api/ + BTC/ticker/
    @GET(/* value = */ "BTC/ticker")
    suspend fun recuperarCotacaoBitcoin() : retrofit2.Response<Cotacao>

    //https://www.mercadobitcoin.net/api/ + ETH/ticker/
    @GET(/* value = */ "ETH/ticker")
    suspend fun recuperarCotacaoEthereum() : retrofit2.Response<Cotacao>

}