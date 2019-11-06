package com.mobility.myapplication.model.network

import com.mobility.myapplication.model.UserList
import retrofit2.Call
import retrofit2.http.GET

/**
 *
 * Created By JISHAN ANSARI On 11/5/2019
 */

interface ServiceInterface {

    @GET("users")
    fun getAllUsers() : Call<List<UserList>>

}