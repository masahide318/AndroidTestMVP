package com.masahide.testmvp.シングルトンの依存切り離し.コンストラクタインジェクション

import com.masahide.testmvp.シングルトンの依存切り離し.PreferenceManagerSingleton
import com.masahide.testmvp.シングルトンの依存切り離し.Presenter
import com.masahide.testmvp.シングルトンの依存切り離し.SomeView

class SomePresenter(
    val view: SomeView,
    val managerSingleton: PreferenceManagerSingleton = PreferenceManagerSingleton.getInstance()
) : Presenter {
    override fun clickSomething() {
        view.setName(managerSingleton.userName)
    }
}