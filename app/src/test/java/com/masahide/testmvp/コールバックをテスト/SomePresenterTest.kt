package com.masahide.testmvp.コールバックをテスト

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import java.io.IOException

class SomePresenterTest {

    private lateinit var target: SomePresenter
    private val view = mock<SomeView>()
    private val userRepository = mock<SampleAPI>()

    @Before
    fun setUp() {
        target = SomePresenter(view, userRepository)
    }

    @Test
    fun onCreateが呼ばれたらuserRepositoryのgetUserが呼ばれること() {
        target.onCreate()
        verify(userRepository).getUser(target.callback)
    }

    @Test
    fun onSuccess時にviewのbindメソッドが呼ばれること() {
        val user = User(1, "name")
        target.callback.onSuccess(user)
        verify(view).bind(user)
    }

    @Test
    fun onError時にviewのshowErrorメソッドが呼ばれること() {
        target.callback.onFailure(IOException())
        verify(view).showError()
    }
}
