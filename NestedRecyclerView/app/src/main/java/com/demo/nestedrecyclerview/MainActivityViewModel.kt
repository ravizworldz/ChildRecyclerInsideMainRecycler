package com.demo.nestedrecyclerview

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class MainActivityViewModel: ViewModel() {
    lateinit var locList: MutableLiveData<LocationList>
    init {
        locList = MutableLiveData()
    }

    fun getLocListObervable(): MutableLiveData<LocationList> {
        return locList
    }

    fun loadData(context: Context) {
        val json = context.resources.openRawResource(R.raw.data).bufferedReader().use { it.readText() }

        val list = Gson().fromJson<LocationList>(json, LocationList::class.java)

        locList.postValue(list)
    }
}