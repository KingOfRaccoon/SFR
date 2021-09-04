package com.castprogramms.sfr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import com.android.volley.*
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.castprogramms.sfr.network.CompanyService
import com.castprogramms.sfr.network.RequestCompany
import com.castprogramms.sfr.network.ResponseCompany
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        CompanyService.getInstance().getJSONApi().post(RequestCompany("с")).enqueue(
            object : Callback<ResponseCompany>{
                override fun onResponse(
                    call: Call<ResponseCompany>,
                    response: retrofit2.Response<ResponseCompany>
                ) {
                    Log.e("data", response.body().toString())
                }

                override fun onFailure(call: Call<ResponseCompany>, t: Throwable) {
                    Log.e("error", t.message.toString())
                    Log.e("error", t.cause.toString())
                }
            }
        )
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}