package fragment

import android.os.Bundle
import android.os.Handler
import android.os.Message
import com.example.viewpager.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_pagerview.*
import mvp.OneContract
import mvp.OnePresenter

class OneFragment : BaseFragment(), OneContract.View {


    var presenter = OnePresenter(this)
    var apiHandler: Handler? = null
    var isLoading = false
    var position = 1


    override fun bindlayout(): Int {
        return R.layout.item_pagerview
    }

    override fun initailView() {
        handler()
    }

    override fun initailData() {
    }

    override fun handler() {
        apiHandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                tv_data.setText(msg.data.getString("data"))
                isLoading = false
                super.handleMessage(msg)
            }
        }
    }

    override fun showData(data: String) {

        val bundle = Bundle()
        bundle.putString("data", data)
        val message = Message()
        message.data = bundle

        apiHandler?.sendMessage(message)
    }

    override fun detectVisible(): Boolean {

        return detectVisibleBo!!
    }


    override fun setMenuVisibility(menuVisible: Boolean) {
        super.setMenuVisibility(menuVisible)

        // lazyload
        if (menuVisible && !isLoading) {
            load()
        }
    }

    fun load() {
        // 向 presenter 呼叫對應的 API
        presenter.getApiData()
        isLoading = true
    }

}