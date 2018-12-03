package com.masahide.testmvp.コールバックをテスト.Timer処理もテストする

import com.masahide.testmvp.コールバックをテスト.SomeView
import com.masahide.testmvp.コールバックをテスト.User

class SomePresenter(
    private val view: SomeView,
    private val customTimer: CustomTimer
) {

    val runnable = Runnable {
        view.bind(User(1, "aaa"))
    }

    fun onCreate() {
        customTimer.postDelayed(runnable, 1000)
    }
}