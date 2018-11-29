package com.example.mshadrin.weatherapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mshadrin.weatherapp.data.ForecastRequest
import com.example.mshadrin.weatherapp.domain.Forecast
import com.example.mshadrin.weatherapp.domain.RequestForecastCommand
import kotlinx.android.synthetic.main.content_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val forecastList = find<RecyclerView>(R.id.forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)

        toast("ForecastRequest", Toast.LENGTH_LONG)

        doAsync {
             val result = RequestForecastCommand("94043").execute()

            uiThread {
                forecastList.adapter = ForecastListAdapter(result,
                         object : ForecastListAdapter.OnItemClickListener{
                 override fun invoke(forecast: Forecast) {
                     toast(forecast.date)
                     }
                 })
                toast("Request DONE!!!")
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.

        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
