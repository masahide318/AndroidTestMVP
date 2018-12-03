package com.masahide.testmvp.コールバックをテスト.Timer処理もテストする

import com.masahide.testmvp.コールバックをテスト.SomeView
import com.masahide.testmvp.コールバックをテスト.User
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class SomePresenterTest {

    private lateinit var target: SomePresenter
    private val view = mock<SomeView>()
    private val customTimer = mock<CustomTimer>()

    @Before
    fun setUp() {
        target = SomePresenter(view, customTimer)
    }

    @Test
    fun onCreateが呼ばれたらcustomTimerの処理が適切に呼ばれること() {
        target.onCreate()
        verify(customTimer).postDelayed(target.runnable, 1000)
    }

    @Test
    fun timer処理完了時にUser情報がviewにbindされること() {
        val user = User(1, "aaa")
        target.runnable.run()
        verify(view).bind(user)
    }
}
