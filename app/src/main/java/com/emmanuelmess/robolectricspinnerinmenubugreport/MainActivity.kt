package com.emmanuelmess.robolectricspinnerinmenubugreport

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

const val DEFAULT_CURRENCY = 0

class MainActivity : AppCompatActivity() {
    private var editableCurrency = ""
    private var currencyName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)

        val currencies = listOf("ARG", "U\$D", "--", "fdfasd") //DO NOT save this List (first item changed)

        val item = menu.findItem(R.id.action_currency)
        val spinner = SpinnerNoUnwantedOnClick(item.actionView as Spinner)
        val adapter = ArrayAdapter(
            this, R.layout.spinner_toolbar,
            currencies.toTypedArray()
        )
        adapter.setDropDownViewResource(R.layout.item_spinner)
        spinner.adapter = adapter
        spinner.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                pos: Int,
                id: Long
            ) {
                if (pos == DEFAULT_CURRENCY)
                    editableCurrency = ""
                else
                    editableCurrency = (view as TextView).text.toString()

                currencyName = if (editableCurrency == "") (view as TextView).text.toString() else editableCurrency
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        })

        currencyName = if (editableCurrency == "") currencies.get(0) else editableCurrency
        return true
    }

}
