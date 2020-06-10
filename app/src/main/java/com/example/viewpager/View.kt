package com.example.viewpager

import android.graphics.Color
import kotlinx.android.synthetic.main.activity_main.*

class View : BaseActivity() {


    override fun bindlayout(): Int {
        return R.layout.activity_main
    }

    override fun initailView() {


        vp_data.adapter = PagerAdapter(
            supportFragmentManager
        )
        psts_data.run {

            // 是否平分螢幕
            setShouldExpand(false)

            // 文字大小
            textSize = 40

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

    override fun initailData() {

    }

    override fun initailEvnet() {
        TODO("Not yet implemented")
    }



}
