package com.masahide.testmvp.staticメソッド依存の排除.移譲用インスタンスメソッド

import com.masahide.testmvp.staticメソッド依存の排除.SomeView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test


class SomePresenterTest {
    private lateinit var target: SomePresenter
    private val view = mock<SomeView>()
    private val largeUtil = mock<LargeUtil>()

    @Before
    fun setUp() {
        target = SomePresenter(view, largeUtil)
    }

    @Test
    fun clickTest_isMailAddress() {
        whenever(largeUtil.isMailAddress("mailAddress")).thenReturn(true)
        whenever(largeUtil.getName()).thenReturn("name")
        target.clickButton("mailAddress")
        verify(view).setUserName("name")
    }

    @Test
    fun clickTest_isNotMailAddress() {
        whenever(largeUtil.isMailAddress("mailAddress")).thenReturn(false)
        whenever(largeUtil.getName()).thenReturn("name")
        target.clickButton("mailAddress")
        verify(view, never()).setUserName("name")
    }
}