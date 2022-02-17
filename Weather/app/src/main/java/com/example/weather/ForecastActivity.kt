package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//import retrofit2

class ForecastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        var listView = findViewById<ListView>(R.id.forecastListView)

        var randomThings = listOf("Hello", "How are you ?", "I am Charan", "Hello", "How are you ?", "I am Charan","Hello", "How are you ?", "I am Charan","Hello", "How are you ?", "I am Charan")
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, randomThings)

        listView.adapter = adapter

        var retriver = WeatherRetriever()

        val callback = object: Callback<List<Forecast>>{
            override fun onResponse(
                call: Call<List<Forecast>>, response: Response<List<Forecast>>) {

                println("We got a response")
                println(response?.body())

                for (forecastDay in response!!.body()!! ){
                    println("High: ${forecastDay.high} Low:${forecastDay.low}")

                }

            }

            override fun onFailure(call: Call<List<Forecast>>, t: Throwable) {
                println("It failed")
            }
        }

        retriver.getForecast(callback)
    }
}