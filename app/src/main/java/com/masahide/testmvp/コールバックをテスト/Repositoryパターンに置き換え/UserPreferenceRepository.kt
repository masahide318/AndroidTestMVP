package com.masahide.testmvp.コールバックをテスト.Repositoryパターンに置き換え

import android.content.Context
import android.preference.PreferenceManager
import com.masahide.testmvp.コールバックをテスト.User

class UserPreferenceRepository(context: Context) : UserRepository {

    private val preferences =
        PreferenceManager.getDefaultSharedPreferences(context)!!

    override fun getUser(callback: UserRepository.Callback) {
        val user = User(
            preferences.getInt("id", 0),
            preferences.getString("name", "")
        )
        //APIと同じようにcallbackでSharedPreferenceから取得したUser情報を返す
        callback.onSuccess(user)
    }
}