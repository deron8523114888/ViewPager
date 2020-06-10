package mvp

import android.util.Log
import com.example.viewpager.Data
import fragment.TwoFragment
import retrofit.RetrofitManager


class TwoPresenter(val twoFragment: TwoFragment) : TwoContract.Presenter {

    override fun getApiData() {
        val thread = Thread(Runnable {
            Log.d("thread_", "" + Thread.currentThread().id)
            getData()
        })

        thread.start()
    }

    fun getData() {
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

                    // Todo 判斷 Fragment 是否還存在

                    if(twoFragment.detectVisible()) {
                        twoFragment.showData(data)
                    }
                }

                failure?.run {
                    twoFragment.showData("Load Failure")
                }

                error?.run {
                    twoFragment.showData("Load Error")
                }
            })
    }

}