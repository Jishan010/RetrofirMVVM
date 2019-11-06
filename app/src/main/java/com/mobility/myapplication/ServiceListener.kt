package com.mobility.myapplication

import androidx.lifecycle.LiveData
import com.mobility.myapplication.model.UserList

/**
 *
 * Created By JISHAN ANSARI On 11/6/2019
 */

interface ServiceListener {

    fun onSuccess(userList: LiveData<List<UserList>>)
    fun onFailure()
    fun showProgress()
    fun hideProgress()
}