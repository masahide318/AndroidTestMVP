package com.masahide.testmvp.zissenMVP

import android.content.Context

class RegisterAPI(val context: Context) {

    fun register(
        mailAddress: String,
        password: String,
        registerCallback: RegisterAPI.Callback) {
        //非同期処理してコールバックメソッドを呼ぶ想定
    }

    interface Callback {
        fun onSuccess()
        fun onFailure(error: String)
    }

}