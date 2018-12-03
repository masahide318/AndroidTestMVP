package com.masahide.testmvp.コールバックをテスト.Repositoryパターンに置き換え

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.masahide.testmvp.コールバックをテスト.SomeView
import com.masahide.testmvp.コールバックをテスト.User

class SomeActivity : AppCompatActivity(), SomeView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val presenter = SomePresenter(this, UserAPI(applicationContext))
//        もしくは上下どちらのPresenterも問題なく動きます
//        val presenter = SomePresenter(
//            this,
//            UserPreferenceRepository(applicationContext))
    }

    override fun bind(user: User) {
    }

    override fun showError() {
    }

}