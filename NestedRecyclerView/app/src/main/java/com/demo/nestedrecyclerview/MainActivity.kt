package com.demo.nestedrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.OnRecyclerItemClick {

    lateinit var recyclerViewAdapter: RecyclerViewAdapter
    lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        initRecyclerView()
        loadData()
    }

    private fun initRecyclerView(){
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration  = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter(this@MainActivity)
            adapter =recyclerViewAdapter
        }
    }


    private fun loadData() {
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLocListObervable().observe(this, Observer<LocationList> {
            recyclerViewAdapter.locListData = it.data.toMutableList()
            recyclerViewAdapter.notifyDataSetChanged()
        })
        viewModel.loadData(this@MainActivity)
    }

    override fun onItemClickListener(data: LocationData) {
        val intent = Intent(this@MainActivity, DescActivity::class.java)
        intent.putExtra("loc_data", data)

        startActivity(intent)
    }
}