package retrofit

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitManager {

    private lateinit var retrofit: Retrofit
    private const val timeout = 10L


    fun <S> retrofitCreate(serviceClass: Class<S>, URL: String): S {

        val okhttpclient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .build()


        val gson = GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            .create()


        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))  // 用什麼
            .client(okhttpclient)
            .baseUrl(URL)
            .build()

        return retrofit.create(serviceClass)
    }


    fun <T> customCallback(returnFunction: (success: Response<T>?, failure: Response<T>?, error: Throwable?) -> Unit): Callback<T> {
        return object : Callback<T> {
            override fun onResponse(call: Call<T>, response: Response<T>) {

                Log.d("response", "response_code = " + response.code())

                if (response.code() == 200) {
                    returnFunction(response, null, null)
                } else {
                    returnFunction(null, response, null)
                }
            }

            override fun onFailure(call: Call<T>, t: Throwable) = returnFunction(null, null, t)

        }
    }

}