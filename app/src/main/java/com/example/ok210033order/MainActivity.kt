package com.example.ok210033order

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var btMenu1 = findViewById<Button>(R.id.btMenu1)
        //btMenu1.setOnClickListener(btClickListener())
        //var btMenu2 = findViewById<Button>(R.id.btMenu2)
        //btMenu2.setOnClickListener(btClickListener())
        //var btMenu3 = findViewById<Button>(R.id.btMenu3)
        //btMenu3.setOnClickListener(btClickListener())
        //var btMenu4 = findViewById<Button>(R.id.btMenu4)
        //btMenu4.setOnClickListener(btClickListener())

        var rbMenu1 = findViewById<RadioButton>(R.id.rbMenu1)
        rbMenu1.setOnClickListener(rbClickListener())
        var rbMenu2 = findViewById<RadioButton>(R.id.rbMenu2)
        rbMenu2.setOnClickListener(rbClickListener())
        var rbMenu3 = findViewById<RadioButton>(R.id.rbMenu3)
        rbMenu3.setOnClickListener(rbClickListener())
        var rbMenu4 = findViewById<RadioButton>(R.id.rbMenu4)
        rbMenu4.setOnClickListener(rbClickListener())
        var lvTest = findViewById<ListView>(R.id.lvTest)
        lvTest.setOnItemClickListener(lvClickListener())
        //var lvOsusume = findViewById<ListView>(R.id.lvOsusume)
        //lvOsusume.setOnItemClickListener(lvClickListener())
        //var lvIppin = findViewById<ListView>(R.id.lvIppin)
        //lvIppin.setOnItemClickListener(lvClickListener())
        //var lvDezat = findViewById<ListView>(R.id.lvDezat)
        //lvDezat.setOnItemClickListener(lvClickListener())
        //var lvDrink = findViewById<ListView>(R.id.lvTest)
        //lvDrink.setOnItemClickListener(lvClickListener())

        val btMenu1 = findViewById<Button>(R.id.btMenu1)
        btMenu1.setOnClickListener(OrderClickListener())
        val btMenu2 = findViewById<Button>(R.id.btMenu2)
        btMenu2.setOnClickListener(btClickListener())

    }

    private inner class rbClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            var lvTest = findViewById<ListView>(R.id.lvTest)
            var rbTest = view as RadioButton
            var text = ""
            when (view.id) {
                R.id.rbMenu1 -> {
                    text = text + "おすすめ　"
                    var listarray = resources.getStringArray(R.array.lvOsusume)
                    lvTest.adapter = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_list_item_activated_1,
                        listarray
                    )
                }
                R.id.rbMenu2 -> {
                    text = text + "一品料理　"
                    var listarray = resources.getStringArray(R.array.lvIppin)
                    lvTest.adapter = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_list_item_activated_1,
                        listarray
                    )
                }
                R.id.rbMenu3 -> {
                    text = text + "デザート　"
                    var listarray = resources.getStringArray(R.array.lvDezat)
                    lvTest.adapter = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_list_item_activated_1,
                        listarray
                    )
                }
                R.id.rbMenu4 -> {
                    text = text + "ドリンク　"
                    var listarray = resources.getStringArray(R.array.lvDrink)
                    lvTest.adapter = ArrayAdapter(
                        applicationContext,
                        android.R.layout.simple_list_item_activated_1,
                        listarray
                    )
                }
            }
        }
    }

    private inner class lvClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(
            parent: AdapterView<*>, view: View, pos: Int, id: Long
        ) {
            val tvOrder = findViewById<TextView>(R.id.tvOrder)
            val tvTotal = findViewById<TextView>(R.id.tvTotal)
            val tvItem = view as TextView
            val order = tvItem.text.split(",")
            tvOrder.setText(tvOrder.text.toString() + "\n" + order[0])
            tvTotal.setText((tvTotal.text.toString().toInt() + order[1].toInt()).toString())
        }
    }

    private inner class OrderClickListener : View.OnClickListener {
        override fun onClick(view: View) {
//注文確認ダイアログフラグメントオブジェクトを生成。
            val dialogFragment = ConfirmDialogFlagment()
//ダイアログ表示。
            dialogFragment.show(supportFragmentManager, "ConfirmDialogFragment")
        }
    }

    private inner class btClickListener : View.OnClickListener {
        override fun onClick(view: View) {
            var tvTotal = findViewById<TextView>(R.id.tvTotal)
            var tvOrder = findViewById<TextView>(R.id.tvOrder)
            when (view.id) {
                R.id.btMenu2 -> {
                    tvTotal.setText("0")
                    tvOrder.setText("全キャンセル")
                }
            }
        }
    }
}