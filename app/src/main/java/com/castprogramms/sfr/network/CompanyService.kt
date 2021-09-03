package com.castprogramms.sfr.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

object CompanyService {
    private var mInstance: CompanyService? = null
    private const val BASE_URL = "https://api-fns.ru/api/"
    private var mRetrofit: Retrofit? = null
    val gson = GsonBuilder().setLenient().create()

    init {
        val client = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

        mRetrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .build()
    }

    fun getInstance(): CompanyService {
        if (mInstance == null) {
            mInstance = CompanyService
        }
        return mInstance!!
    }

    fun getJSONApi(): CompanyApi {
        return mRetrofit!!.create(CompanyApi::class.java)
    }
}