package com.sritadip.todoapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sritadip.todoapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //lateinit var viewModel: ToDoViewModel
    //private val retroInstance = RetroInstance
    private lateinit var binding:ActivityMainBinding
    //private var adapter: ToDoAdapter? = null
    //private lateinit var linearLayoutManager: LinearLayoutManager




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpTabs()
        //init()

    }
  /*  private fun init(){
        viewModel = ViewModelProvider(this, ViewModelFactory(ToDoRepository((retroInstance)))).get(ToDoViewModel::class.java)

        attachObserver()

        setupAdapter()
    }*/

    /*private fun setupAdapter() {
        adapter = ToDoAdapter()
        binding.rv.adapter = adapter
        linearLayoutManager = LinearLayoutManager(this)
        rv.layoutManager = linearLayoutManager

    }

    private fun attachObserver() {
        viewModel.getToDoList()
        Handler().postDelayed({
            viewModel.toDOLiveData.observe(this, Observer {
                if (it != null) {
                    Log.e("data", it.todo.toString())
                    //adapter?.addData(it.data)
                } else {
                    Toast.makeText(this, "Error getting data", Toast.LENGTH_SHORT).show()
                }
            })
        }, 1000)
        viewModel.toDOLiveData.removeObservers(this)
    }*/

    private fun setUpTabs() {
        val adapter=PagerAdapter(supportFragmentManager)
        adapter.addFragment(TaskFragment(),"Today")
        adapter.addFragment(TaskFragment(),"Later")
        viewPager.adapter=adapter
        tabs.setupWithViewPager(viewPager)
    }
}