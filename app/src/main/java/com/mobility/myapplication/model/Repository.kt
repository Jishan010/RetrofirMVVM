package com.mobility.myapplication.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mobility.myapplication.model.network.ServiceBuilder
import com.mobility.myapplication.model.network.ServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 *
 * Created By JISHAN ANSARI On 11/5/2019
 */

class Repository {

    private var serviceInterface: ServiceInterface? = null


    fun getUsers(): LiveData<List<UserList>> {
        val userList = MutableLiveData<List<UserList>>()
        serviceInterface = ServiceBuilder.getServiceInstance
        val callUserList = serviceInterface!!.getAllUsers()
        callUserList.enqueue(object : Callback<List<UserList>> {
            override fun onFailure(call: Call<List<UserList>>, t: Throwable) {
                Log.e("Repository", t.message!!)
            }

            override fun onResponse(
                call: Call<List<UserList>>,
                response: Response<List<UserList>>
            ) {

                if (response.isSuccessful) {
                    userList.value = response.body()
                    Log.d("Response", userList.toString())
                }
            }

        })

        return userList
    }


}