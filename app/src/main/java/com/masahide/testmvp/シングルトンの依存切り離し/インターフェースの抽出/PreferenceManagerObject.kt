package com.masahide.testmvp.シングルトンの依存切り離し.インターフェースの抽出

import android.preference.PreferenceManager
import com.masahide.testmvp.シングルトンの依存切り離し.MyApplication
import com.masahide.testmvp.シングルトンの依存切り離し.PreferenceManagerInterface

//object PreferenceManagerObject : PreferenceManagerInterface {
//    var preferences = PreferenceManager
//        .getDefaultSharedPreferences(MyApplication.getInstance());
//
//    override fun getUserName(): String {
//        return preferences.getString("name", "")
//    }
//}

object PreferenceManagerObject : PreferenceManagerInterface {
    var preferences = PreferenceManager
        .getDefaultSharedPreferences(MyApplication.getInstance());

    override fun getUserName(): String {
        return preferences.getString("name", "")
    }
}