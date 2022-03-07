package com.sritadip.todoapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTabs()

    }

    private fun setUpTabs() {
        val adapter=PagerAdapter(supportFragmentManager)
        adapter.addFragment(TaskFragment(),"Today")
        adapter.addFragment(TaskFragment(),"Later")
        viewPager.adapter=adapter
        tabs.setupWithViewPager(viewPager)
    }
}