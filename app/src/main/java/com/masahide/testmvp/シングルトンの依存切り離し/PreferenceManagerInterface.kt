package com.masahide.testmvp.シングルトンの依存切り離し

/**
 * リスト3.8
 */
//Singleton内のメソッドを抽出する
interface PreferenceManagerInterface {
    fun getUserName(): String
}