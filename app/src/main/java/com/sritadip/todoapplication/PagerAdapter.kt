package com.sritadip.todoapplication

import androidx.fragment.app.*
import androidx.viewpager2.adapter.FragmentStateAdapter

/*class PagerAdapter(val fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {

    lateinit var mFragment:Fragment
    var mtitle:String?=null

    override fun getItemCount()=1

    override fun createFragment(position: Int): Fragment {
        return mFragment

    }
    fun addFragment(fragment: Fragment,title:String){
        mFragment=fragment
        mtitle=title
    }


}*/

class PagerAdapter(supportFragmentManager: FragmentManager) :
    FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentList = ArrayList<Fragment>()
    private val mFragmentTitleList = ArrayList<String>()

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence{
        return mFragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }
}
