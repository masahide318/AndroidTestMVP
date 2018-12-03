package com.masahide.testmvp.staticメソッド依存の排除.リファクタリング

import com.masahide.testmvp.staticメソッド依存の排除.SomeView

//SomePresenterをリファクタリング
class SomePresenter(
    private val view: SomeView,
    private val userService: UserService
) {

    fun onCreate() {
        view.setUserName(userService.getUserName())
    }
}