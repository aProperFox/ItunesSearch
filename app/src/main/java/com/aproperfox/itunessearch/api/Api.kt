package com.aproperfox.itunessearch.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Api {

  private const val ITUNES_BASE_URL = "https://itunes.apple.com/"

  private val client: OkHttpClient by lazy {
    OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()
  }

  private val retrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(ITUNES_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(client)
        .build()
  }

  private val iTunesApi: iTunesSearchApi by lazy { retrofit.create(iTunesSearchApi::class.java) }

  val iTunesSearchManager: BetteriTunesSearchApi by lazy { BetteriTunesSearchManager(iTunesApi) }

}