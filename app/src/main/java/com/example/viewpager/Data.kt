package com.example.viewpager

import bean.DataBeanFour
import bean.DataBeanOne
import bean.DataBeanThree
import bean.DataBeanTwo
import retrofit2.http.GET
import retrofit2.http.Query

interface Data {

    @GET("InformationModel")  //HTTP 使用GET請求
    fun getJsonDataOne(
        @Query("UnitId") UnitId: String = "1262"
    ): retrofit2.Call<ArrayList<DataBeanOne>>


    @GET("api/service/get/14fe516d-ac62-4905-9325-70daae7616bd")  //HTTP 使用GET請求
    fun getJsonDataTwo(): retrofit2.Call<DataBeanTwo>


    @GET("api/service/get/02a18991-bed7-439a-867f-75d3e2920223")  //HTTP 使用GET請求
    fun getJsonDataThree(): retrofit2.Call<DataBeanThree>

    @GET("Service/OpenData/TransService.aspx")  //HTTP 使用GET請求
    fun getJsonDataFour(
        @Query("UnitId") UnitId: String = "qNRePfOf8YMS"
    ): retrofit2.Call<ArrayList<DataBeanFour>>

}
