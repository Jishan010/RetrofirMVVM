package com.mobility.myapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mobility.myapplication.ServiceListener
import com.mobility.myapplication.model.Repository
import com.mobility.myapplication.model.UserList

/**
 *
 * Created By JISHAN ANSARI On 11/5/2019
 */

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: Repository? = null
    private var userList: LiveData<List<UserList>>? = null
    var serviceListener: ServiceListener? = null

    init {
        repository = Repository()
    }

    fun getData() {
        serviceListener!!.showProgress()
        userList = repository!!.getUsers()
        serviceListener!!.onSuccess(userList!!)
    }


}