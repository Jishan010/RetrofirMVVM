package com.mobility.myapplication.model

import com.google.gson.annotations.SerializedName

/**
 *
 * Created By JISHAN ANSARI On 11/5/2019
 */

data class UserList (
    @SerializedName("avatar_url")
    var avatar_url : String?=null,
    @SerializedName("login")
    var login : String?=null,
    @SerializedName("type")
    var type : String?=null
)