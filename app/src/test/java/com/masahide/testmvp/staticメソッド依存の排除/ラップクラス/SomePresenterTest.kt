package com.masahide.testmvp.staticメソッド依存の排除.ラップクラス

import com.masahide.testmvp.staticメソッド依存の排除.SomeView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class SomePresenterTest {
    lateinit var target: SomePresenter
    val view = mock<SomeView>()
    //ラップクラスはシングルトンではないのでmockを作成できる
    val preferenceUtil = mock<MyPreferenceUtilWrapper>()

    @Before
    fun setUp() {
        target = SomePresenter(view, preferenceUtil)
    }

    @Test
    fun hoge() {
        whenever(preferenceUtil.getName()).thenReturn("hoge")
        target.onCreate()
        verify(view).setUserName("hoge")
    }
}