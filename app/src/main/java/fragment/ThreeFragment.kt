package fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.viewpager.R
import kotlinx.android.synthetic.main.activity_main.*
import mvp.ThreeContract
import mvp.ThreePresenter

class ThreeFragment : Fragment(), ThreeContract.View {

    var presenter = ThreePresenter(this)
    var tv_data: TextView? = null
    var handler: Handler? = null
    var isLoading = false
    var position: Int? = null
    var activity: Activity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)


        position = arguments?.getInt("position")
        activity = context as Activity


        Log.d("test_", "onAttach" + position)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("test_", "onCreate" + position)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d("test_", "onCreateView" + position)



        handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                tv_data?.setText(msg.data.getString("data"))
                isLoading = false
            }
        }

        // 解析 ViewPager 上要顯示的 layout
        val view = inflater.inflate(R.layout.item_pagerview, container, false)
        tv_data = view.findViewById(R.id.tv_data)



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("test_", "onActivityCreated" + position)
        super.onActivityCreated(savedInstanceState)
    }

    override fun showData(data: String) {

        val bundle = Bundle()
        bundle.putString("data", data)
        val message = Message()
        message.data = bundle

        handler?.sendMessage(message)


        super.showData(data)
    }


    override fun onStart() {
        Log.d("test_", "onStart" + position)
        super.onStart()
    }


    override fun onResume() {
        Log.d("test_", "onResume" + position)
        super.onResume()

        activity?.tv_test?.setText("position:" + position)
        if (!isLoading) {
            // 以目前畫面的 position 請 presenter 呼叫對應的 API
            presenter.getApiData(position!!)
            isLoading = true
        }
    }


    override fun onPause() {
        Log.d("test_", "onPause" + position)
        super.onPause()
    }

    override fun onStop() {
        Log.d("test_", "onStop" + position)
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("test_", "onDestroyView" + position)
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d("test_", "onDestroy" + position)
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d("test_", "onDetach" + position)
        super.onDetach()
    }

}