package mvp

import android.util.Log
import com.example.viewpager.Data
import fragment.ThreeFragment
import retrofit.RetrofitManager

class ThreePresenter(val threeFragment: ThreeFragment) : ThreeContract.Presenter {

    override fun getApiData() {
        val thread = Thread(Runnable {
            Log.d("thread_", "" + Thread.currentThread().id)
            getData()
        })

        thread.start()
    }

    fun getData() {
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

                    // Todo 判斷 Fragment 是否還存在
                    if(threeFragment.detectVisible()) {
                        threeFragment.showData(data)
                    }

                }

                failure?.run {
                    threeFragment.showData("Load Failure")
                }

                error?.run {
                    threeFragment.showData("Load Error")
                }
            })
    }

}