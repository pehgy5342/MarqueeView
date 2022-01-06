package com.example.marqueeview

import android.app.Notification
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gongwen.marqueen.MarqueeView
import com.gongwen.marqueen.SimpleMF
import com.gongwen.marqueen.SimpleMarqueeView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayListOf("Google谷歌", "Yahoo奇摩", "Baidu百度")
        val marqueeView = findViewById<SimpleMarqueeView<String>>(R.id.marqueeView)
        val marqueeFactory: SimpleMF<String> = SimpleMF(this)
        marqueeFactory.data = list
        marqueeView.setMarqueeFactory(marqueeFactory)
        marqueeView.startFlipping()
        marqueeView.setOnItemClickListener { mView, mData, mPosition ->
            when (mPosition) {
                0 -> {
                    IntentWeb("https://www.google.com.tw/?hl=zh_TW")
                }
                1 -> {
                    IntentWeb("https://tw.yahoo.com/")
                }
                2 -> {
                    IntentWeb("https://www.baidu.com/")
                }
            }
        }
    }

    fun IntentWeb(URL: String) {
        val uri = Uri.parse(URL)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }

}