package com.masahide.testmvp.シングルトンの依存切り離し.インターフェースの抽出

import com.masahide.testmvp.シングルトンの依存切り離し.PreferenceManagerInterface
import com.masahide.testmvp.シングルトンの依存切り離し.SomeView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class SomePresenterTest {
    lateinit var target: SomePresenter
    val view = mock<SomeView>()
    //インターフェースの mock が作れる
    val preferenceManager = mock<PreferenceManagerInterface>()

    @Before
    fun setUp() {
        target = SomePresenter(view, preferenceManager)
    }

    @Test
    fun clickSomething() {
        whenever(preferenceManager.getUserName()).thenReturn("hoge")
        target.clickSomething()
        verify(view).setName("hoge")
    }
}