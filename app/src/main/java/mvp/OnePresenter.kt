package mvp

import android.util.Log
import com.example.viewpager.Data
import fragment.OneFragment
import retrofit.RetrofitManager

class OnePresenter(val oneFragment: OneFragment) : OneContract.Presenter {


    override fun getApiData(position: Int) {

        val thread = Thread(Runnable {
            Log.d("thread_", "" + Thread.currentThread().id)
            getData()
        })

        thread.start()
    }


    fun getData() {
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
                    oneFragment.showData(data)
                }

                failure?.run {
                    oneFragment.showData("Load Failure")
                }

                error?.run {
                    oneFragment.showData("Load Error")
                }
            })
    }

}