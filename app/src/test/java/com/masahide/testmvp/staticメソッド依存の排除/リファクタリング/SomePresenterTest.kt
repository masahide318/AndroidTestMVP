package com.masahide.testmvp.staticメソッド依存の排除.リファクタリング

import com.masahide.testmvp.staticメソッド依存の排除.SomeView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

/**
 * リスト4.6
 */
class SomePresenterTest {
    private lateinit var target: SomePresenter
    private val view = mock<SomeView>()
    private val userService = mock<UserService>()
    @Before
    fun setUp() {
        target = SomePresenter(view, userService)
    }

    @Test
    fun onCreate_SharedPreferenceから取得したユーザー名が表示される() {
        whenever(userService.getUserName()).thenReturn("masahide")
        target.onCreate()
        verify(view).setUserName("masahide")
    }

}