package com.masahide.testmvp.シングルトンの依存切り離し.ラップクラスで包む;

import com.masahide.testmvp.シングルトンの依存切り離し.SomeView

class SomePresenter(
    val view: SomeView,
    //Wrapper クラスを Presenter に移譲する
    val prefence: PreferenceManagerObjectWrapper
) {
    fun clickSomething() {
        view.setName(prefence.getUserName())
    }
}
