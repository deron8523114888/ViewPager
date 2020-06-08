package com.example.viewpager

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import mvp.Presenter

class View : AppCompatActivity() {


    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        actionBar?.setIcon(R.drawable.item_actionbar_icon)
//        actionBar?.setLogo(R.drawable.item_actionbar_icon)
//        actionBar?.setDisplayUseLogoEnabled(true)
//        supportActionBar?.setLogo(R.drawable.item_actionbar_icon)


        init()


    }

    fun init() {
        presenter = Presenter()

        vp_data.adapter = PagerAdapter(supportFragmentManager)
        psts_data.run {

            // 是否平分螢幕
            setShouldExpand(true)

            // 文字大小
            textSize = 50

            // 文字顏色
            textColor = Color.WHITE

            // title 選中物件的 底線顏色
            indicatorColor = Color.parseColor("#FF9224")

            // 整個 bar 的底線顏色
            underlineColor = Color.parseColor("#FF359A")

            // Tab 綁定 PagerView
            setViewPager(vp_data)

        }


    }

}
