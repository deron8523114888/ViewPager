package mvp

import android.util.Log
import com.example.viewpager.Data
import com.example.viewpager.PagerFragment
import retrofit.RetrofitManager

class Presenter(val pagerFragment: PagerFragment) : Constract.Presenter {


    override fun getApiData(position: Int) {

        val thread = Thread(Runnable {
            Log.d("thread_",""+Thread.currentThread().id)
            when (position) {
                0 -> getDataOne()
                1 -> getDatatwo()
                2 -> getDatathree()
                3 -> getDatafour()
            }
        })

        thread.start()

    }


    fun getDataOne() {
        val URL = "https://www.ttcsec.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataOne()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                Log.d("Tag", "getDataOne")
                success?.run {
                    var data = ""
                    body()?.forEach {
                        data =
                            data + "編號：" + it.Id + "\n" + "時間：" + it.PublishTime + "\n" + "網址：" + it.PageUrl + "\n\n"
                    }
                    pagerFragment.showData(data)
                }

                failure?.run {
                    pagerFragment.showData("Load Failure")
                }

                error?.run {
                    pagerFragment.showData("Load Error")
                }
            })
    }

    fun getDatatwo() {
        val URL = "https://api.kcg.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataTwo()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                Log.d("Tag", "getDataTwo")
                success?.run {
                    var data = ""
                    body()?.data?.forEach {
                        data =
                            data + "地點：" + it.area + it.village + it.caption + "\n車牌：" + it.car_licence + "\n\n"
                    }
                    pagerFragment.showData(data)
                }

                failure?.run {
                    pagerFragment.showData("Load Failure")
                }

                error?.run {
                    pagerFragment.showData("Load Error")
                }
            })
    }

    fun getDatathree() {
        val URL = "https://api.kcg.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataThree()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                Log.d("Tag", "getDataThree")
                success?.run {
                    var data = ""
                    body()?.data?.forEach {
                        data =
                            data + "概要：" + it.subject + "\n" + "案件名稱：" + it.caseName + "\n" + "負責單位：" + it.orgName + "\n\n"
                    }
                    pagerFragment.showData(data)
                }

                failure?.run {
                    pagerFragment.showData("Load Failure")
                }

                error?.run {
                    pagerFragment.showData("Load Error")
                }
            })
    }

    fun getDatafour() {
        val URL = "https://data.coa.gov.tw/"
        RetrofitManager.retrofitCreate(Data::class.java, URL).getJsonDataFour()
            .enqueue(RetrofitManager.customCallback { success
                                                      , failure
                                                      , error ->
                Log.d("Tag", "getDataFour")
                success?.run {
                    var data = ""
                    body()?.forEach {
                        data =
                            data + "公司名稱：" + it.Factory_CName + "\n" + "地址：" + it.Factory_Address + "\n" + "商品名稱：" + it.Product_Name + "\n\n"
                    }
                    pagerFragment.showData(data)
                }

                failure?.run {
                    pagerFragment.showData("Load Failure")
                }

                error?.run {
                    pagerFragment.showData("Load Error")
                }
            })
    }


}