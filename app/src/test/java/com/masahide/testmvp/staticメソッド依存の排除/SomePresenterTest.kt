package com.masahide.testmvp.staticメソッド依存の排除

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class SomePresenterTest {
    private lateinit var target: SomePresenter
    private val view = mock<SomeView>()

    @Before
    fun setUp() {
        target = SomePresenter(view)

    }

    @Test
    fun onCreate_SharedPreferenceから取得したユーザー名が表示される()
    {
        target.onCreate()
        verify(view).setUserName(any())//テストできない
    }
}