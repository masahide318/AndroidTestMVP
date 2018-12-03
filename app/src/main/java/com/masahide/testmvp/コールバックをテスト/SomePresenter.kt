package com.masahide.testmvp.コールバックをテスト

import java.io.IOException

class SomePresenter(
    private val view: SomeView,
    private val sampleAPI: SampleAPI
) {

    //callbackを変数として持つ
    val callback: SampleAPI.APICallback = object : SampleAPI.APICallback {
        override fun onFailure(e: IOException) {
            view.showError()
        }

        override fun onSuccess(user: User) {
            view.bind(user)
        }
    }

    fun onCreate() {
        sampleAPI.getUser(callback)
    }
}