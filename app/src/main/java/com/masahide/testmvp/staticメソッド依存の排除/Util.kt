package com.masahide.testmvp.staticメソッド依存の排除

import android.preference.PreferenceManager
import com.masahide.testmvp.シングルトンの依存切り離し.MyApplication

class Util {
    companion object {
        @JvmStatic
        fun getUserName(): String {
            val pref = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.getInstance())
            return pref.getString("userName", "")
        }
    }
}