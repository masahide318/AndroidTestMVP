package com.masahide.testmvp.コールバックをテスト.Repositoryパターンに置き換え

import com.masahide.testmvp.コールバックをテスト.SomeView
import com.masahide.testmvp.コールバックをテスト.User
import java.io.IOException

class SomePresenter(
    val view: SomeView,
    //interfaceなのでこのPresenterは内部の実装を知らない
    private val userRepository: UserRepository
) {

    val callback: UserRepository.Callback = object : UserRepository.Callback {
        override fun onFailure(e: IOException) {
            view.showError()
        }

        override fun onSuccess(user: User) {
            view.bind(user)
        }
    }

    fun onCreate() {
        userRepository.getUser(callback)
    }
}