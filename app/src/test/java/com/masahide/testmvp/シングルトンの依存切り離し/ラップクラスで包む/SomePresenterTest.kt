package com.masahide.testmvp.シングルトンの依存切り離し.ラップクラスで包む

import com.masahide.testmvp.シングルトンの依存切り離し.SomeView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class SomePresenterTest {

    lateinit var target: SomePresenter
    val view = mock<SomeView>()
    //ラップクラスはシングルトンではないのでmockを作成できる
    val preferenceWrapper = mock<PreferenceManagerObjectWrapper>()

    @Before
    fun setUp() {
        target = SomePresenter(view, preferenceWrapper)
    }

    @Test
    fun clickSomething() {
        whenever(preferenceWrapper.getUserName()).thenReturn("hoge")
        target.clickSomething()
        verify(view).setName("hoge")
    }
}

