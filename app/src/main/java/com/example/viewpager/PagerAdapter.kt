package com.example.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {


    val arrayList = arrayListOf("1", "2", "3", "4")


    override fun getPageTitle(position: Int): CharSequence? {
        return arrayList[position]
    }


    // 每次切換頁面會進入一次
    override fun getItem(position: Int): Fragment {

        var pagerFragment = PagerFragment()

        // 將目前的頁碼丟入 Bundle
        val bundle = Bundle()
        bundle.putString("position", "" + position)

        // 將 Bundle 丟給 Fragment
        pagerFragment.arguments = bundle


        return pagerFragment
    }

    override fun getCount(): Int {
        return 4
    }


}