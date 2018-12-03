package com.masahide.testmvp.staticメソッド依存の排除.ラップクラス

import com.masahide.testmvp.staticメソッド依存の排除.SomeView

class SomePresenter(
    private val view: SomeView,
    private val myPreferenceUtilWrapper: MyPreferenceUtilWrapper
) {
    fun onCreate() {
        view.setUserName(myPreferenceUtilWrapper.getName())
    }
}