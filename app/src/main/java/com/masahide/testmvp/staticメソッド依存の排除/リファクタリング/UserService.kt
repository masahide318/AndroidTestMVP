package com.masahide.testmvp.staticメソッド依存の排除.リファクタリング

import android.content.SharedPreferences

//Utilクラスをリファクタリング
class UserService(private val pref: SharedPreferences) {
    fun getUserName(): String {
        return pref.getString("userName", "")
    }
}