package com.masahide.testmvp.シングルトンの依存切り離し.コンストラクタインジェクション

import com.masahide.testmvp.シングルトンの依存切り離し.PreferenceManagerSingleton
import com.masahide.testmvp.シングルトンの依存切り離し.SomePresenter
import com.masahide.testmvp.シングルトンの依存切り離し.SomeView
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

/**
 * リスト3.4
 * コンストラクタインジェクション
 */
class SomePresenterTest {
    lateinit var target: SomePresenter
    val view = mock<SomeView>()
    //singleton の mock クラスを作成
    val preferenceManagerSingleton =
        mock<PreferenceManagerSingleton>()


    @Before
    fun setUp() {
        //mock の preferenceManagerSingleton を注入する
        target = SomePresenter(view, preferenceManagerSingleton)

    }

    @Test
    fun clickSomething() {
        //振る舞いを変えることができる
        whenever(preferenceManagerSingleton.getUserName()).thenReturn("hoge")
        target.clickSomething()
        verify(view).setName("hoge")
    }

}