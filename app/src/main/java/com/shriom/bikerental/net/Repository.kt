package com.shriom.bikerental.net

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.shriom.bikerental.net.models.Home
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun getDiscoverItems(mData: MutableLiveData<List<Home>>): MutableLiveData<List<Home>> {

        RetrofitClient.mBikeService.getDiscoverItems().enqueue(object : Callback<List<Home>> {

            override fun onFailure(call: Call<List<Home>>, t: Throwable) {
                Log.d("error", t.message)
            }

            override fun onResponse(call: Call<List<Home>>, response: Response<List<Home>>) {
                if( response.isSuccessful && response.body() != null ) {
                    mData.value = response.body()
                }
            }

        })

        return mData


    }


}