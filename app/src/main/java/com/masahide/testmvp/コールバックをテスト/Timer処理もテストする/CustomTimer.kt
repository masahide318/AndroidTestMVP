package com.masahide.testmvp.コールバックをテスト.Timer処理もテストする

import android.os.Handler

class CustomTimer() {
    val handler = Handler()

    //HandlerのpostDelayedの処理をラップする
    fun postDelayed(runnable: Runnable, delayMills: Long) {
        handler.postDelayed(runnable, delayMills)
    }
}