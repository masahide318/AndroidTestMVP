package com.masahide.testmvp.staticメソッド依存の排除


class SomePresenter(val view: SomeView) {
    fun onCreate() {
        view.setUserName(Util.getUserName())
    }
}