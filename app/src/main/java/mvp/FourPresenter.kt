package mvp

import android.util.Log
import com.example.viewpager.Data
import fragment.FourFragment
import retrofit.RetrofitManager

class FourPresenter(val fourFragment: FourFragment) : FourContract.Presenter {

    override fun getApiData() {
        val thread = Thread(Runnable {
            Log.d("thread_", "" + Thread.currentThread().id)
            getData()
        })

        thread.start()
    }

    fun getData() {
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


                    Log.d("boolean_","FOUR："+fourFragment.detectVisible())
                    // Todo 判斷 Fragment 是否還存在 (
                    if(fourFragment.detectVisible()) {
                        fourFragment.showData(data)
                    }
                }

                failure?.run {
                    fourFragment.showData("Load Failure")
                }

                error?.run {
                    fourFragment.showData("Load Error")
                }
            })
    }

}