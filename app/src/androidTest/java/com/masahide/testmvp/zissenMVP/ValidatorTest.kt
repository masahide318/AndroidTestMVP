package com.masahide.testmvp.zissenMVP

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ValidatorTest {

    lateinit var target: Validator

    @Before
    fun setUp() {
        target = Validator()
    }

    @Test
    fun メールアドレスの形式が正しい() {
        Assert.assertTrue(target.validateMailAddress("hoge@example.com"))
    }

    @Test
    fun メールアドレスの形式ではない() {
        Assert.assertFalse(target.validateMailAddress("hoge"))
    }

    @Test
    fun パスワードが正しい() {
        target.validatePassword("a234567")
    }

    @Test
    fun パスワードに使用不可な文字が含まれている() {
        target.validatePassword("a23456-")
    }
}