package com.example.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.timchentw.loadingview.LoadingView
import retrofit.RetrofitManager

class PagerFragment : Fragment() {


    var tv_data: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //region init

        // 解析 ViewPager 上要顯示的 layout
        val view = inflater.inflate(R.layout.item_pagerview, container, false)
        tv_data = view.findViewById(R.id.tv_data)

        // LodingView
        var lv_data = view.findViewById<LoadingView>(R.id.lv_data)

        //endregion


        // 當畫面滑動時， Adapter 會傳來新的 position
        val position = arguments?.getString("position")?.toInt()

        // 依照 position 跟 Model 拿 API 資料
        when (position) {
            0 -> getDataOne()
            1 -> getDatatwo()
            2 -> getDatathree()
            3 -> getDatafour()
        }

        return view
    }

    fun getDataOne() {
        val URL = "https://www.ttcsec.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataOne()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                success?.run {
                    body()?.forEach {
                        tv_data?.append("編號：" + it.Id + "\n" + "時間：" + it.PublishTime + "\n" + "網址：" + it.PageUrl + "\n\n")
                    }
                }

                failure?.run {
                    tv_data?.setText("Load Failure")
                }

                error?.run {
                    tv_data?.setText("Load Error")
                }
            })
    }

    fun getDatatwo() {
        val URL = "https://api.kcg.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataTwo()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                success?.run {
                    body()?.data?.forEach {
                        tv_data?.append("地點：" + it.area + it.village + it.caption + "\n車牌：" + it.car_licence + "\n\n")
                    }
                }

                failure?.run {
                    tv_data?.setText("Load Failure")
                }

                error?.run {
                    tv_data?.setText("Load Error")
                }
            })
    }

    fun getDatathree() {
        val URL = "https://api.kcg.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataThree()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                success?.run {
                    body()?.data?.forEach {
                        tv_data?.append("概要：" + it.subject + "\n" + "案件名稱：" + it.caseName + "\n" + "負責單位：" + it.orgName + "\n\n")
                    }
                }

                failure?.run {
                    tv_data?.setText("Load Failure")
                }

                error?.run {
                    tv_data?.setText("Load Error")
                }
            })
    }

    fun getDatafour() {
        val URL = "https://data.coa.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataFour()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                success?.run {
                    body()?.forEach {
                        tv_data?.append("公司名稱：" + it.Factory_CName + "\n" + "地址：" + it.Factorry_Address + "\n" + "商品名稱：" + it.Product_Name + "\n\n")
                    }
                }

                failure?.run {
                    tv_data?.setText("Load Failure")
                }

                error?.run {
                    tv_data?.setText("Load Error")
                }
            })
    }

}