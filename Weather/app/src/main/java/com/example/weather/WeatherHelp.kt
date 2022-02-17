package com.example.weather

import retrofit2.Call

import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WeatherAPI {

    @GET("b3273de493453f865b0e")
    fun getForecast() : Call<List<Forecast>>


}


class Forecast(val high: String, val low: String)

class WeatherRetriever {
    val service : WeatherAPI

    init {
        val retrofit = Retrofit.Builder().baseUrl("https://api.npoint.io/").addConverterFactory(GsonConverterFactory.create()).build()
        service = retrofit.create(WeatherAPI :: class.java)
    }

    fun getForecast(callback : Callback<List<Forecast>>){
        val call = service.getForecast()
        call.enqueue(callback)
    }
}
