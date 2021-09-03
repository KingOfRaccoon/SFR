package com.castprogramms.sfr.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface CompanyApi {
    @Headers("Accept: application/json")
    @POST("search")
    fun post(@Body requestCompany: RequestCompany): Call<ResponseCompany>
}