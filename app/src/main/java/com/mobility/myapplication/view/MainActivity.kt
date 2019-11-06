package com.mobility.myapplication.view

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mobility.myapplication.R
import com.mobility.myapplication.ServiceListener
import com.mobility.myapplication.handleProgress
import com.mobility.myapplication.model.UserList
import com.mobility.myapplication.showMessage
import com.mobility.myapplication.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ServiceListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userViewModel = ViewModelProviders.of(this).get(UserViewModel::class.java)
        userViewModel.serviceListener = this
        userViewModel.getData()
    }

    override fun onSuccess(userList: LiveData<List<UserList>>) {
        userList.observe(this, Observer<List<UserList>> {
            hideProgress()
            showMessage("Success")
            // to make textView scrollable
            responseTextView.movementMethod = ScrollingMovementMethod()
            responseTextView.text = it.toString()
        })
    }

    override fun onFailure() {
        showMessage("Failure")
    }

    override fun showProgress() {
        progressBar.handleProgress()
    }

    override fun hideProgress() {
        progressBar.handleProgress(View.GONE)
    }
}