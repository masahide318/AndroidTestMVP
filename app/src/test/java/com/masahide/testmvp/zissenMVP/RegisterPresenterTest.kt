package com.masahide.testmvp.zissenMVP

import com.nhaarman.mockitokotlin2.*
import org.junit.Before
import org.junit.Test

class RegisterPresenterTest {

    lateinit var target: RegisterPresenter
    val view = mock<RegisterContract.View>()
    val registerAPI = mock<RegisterAPI>()
    //パスワードのチェックは実処理を走らせても問題ないのでspyにしています
    val validator = spy(Validator())

    @Before
    fun setUp() {
        target = RegisterPresenter(view, registerAPI, validator)
    }

    @Test
    fun clickRegisteredButton_password6文字未満() {
        doReturn(true).whenever(validator)
            .validateMailAddress("hoge@example.com")
        target.clickRegisteredButton("hoge@example.com", "passw")
        verify(view).showValidateError()
    }

    @Test
    fun clickRegisteredButton_password形式エラー() {
        doReturn(true).whenever(validator)
            .validateMailAddress("hoge@example.com")
        target.clickRegisteredButton("hoge@example.com", "passああ")
        verify(view).showValidateError()
    }

    @Test
    fun clickRegisteredButton_mailaddressエラー() {
        doReturn(false).whenever(validator)
            .validateMailAddress("hoge")
        target.clickRegisteredButton("hoge", "password")
        verify(view).showValidateError()
    }

    @Test
    fun clickRegisteredButton_正常() {
        doReturn(true).whenever(validator)
            .validateMailAddress("hoge@example.com")
        target.clickRegisteredButton("hoge@example.com", "password")
        verify(registerAPI)
            .register("hoge@example.com","password",target.registerCallback)
    }

    @Test
    fun mailAddressFormatCheck_Error(){
        doReturn(false).whenever(validator)
            .validateMailAddress("hoge")
        target.mailAddressFormatCheck("hoge")
        verify(view).showMailAddressFormatError()
    }

    @Test
    fun mailAddressFormatCheck_正常(){
        doReturn(true).whenever(validator)
            .validateMailAddress("hoge@example.com")
        target.mailAddressFormatCheck("hoge@example.com")
        verify(view).dismissMailAddressFormatError()
    }
}