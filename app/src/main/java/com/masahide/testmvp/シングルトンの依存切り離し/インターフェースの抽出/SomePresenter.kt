package com.masahide.testmvp.シングルトンの依存切り離し.インターフェースの抽出

import com.masahide.testmvp.シングルトンの依存切り離し.PreferenceManagerInterface
import com.masahide.testmvp.シングルトンの依存切り離し.SomeView

class SomePresenter(
    val view: SomeView,
    //Presenterが依存するのはインターフェースになり依存を切り離せる。
    val prefence: PreferenceManagerInterface = PreferenceManagerObject
) {
    fun clickSomething() {
        view.setName(prefence.getUserName())
    }
}