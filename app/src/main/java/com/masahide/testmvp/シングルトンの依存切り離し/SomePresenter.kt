package com.masahide.testmvp.シングルトンの依存切り離し

//class SomePresenter(val view: SomeContract.SomeView) {
//    fun clickSomething() {
//        view.setName(PreferenceManagerSingleton.getInstance().getUserName())
//    }
//}

class SomePresenter(
    val view: SomeView,
    val managerSingleton: PreferenceManagerSingleton = PreferenceManagerSingleton.getInstance()
) : Presenter {
    override fun clickSomething() {
        view.setName(managerSingleton.userName)
    }
}

