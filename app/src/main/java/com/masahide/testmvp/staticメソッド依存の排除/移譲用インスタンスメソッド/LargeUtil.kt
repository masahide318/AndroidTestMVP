package com.masahide.testmvp.staticメソッド依存の排除.移譲用インスタンスメソッド

import android.preference.PreferenceManager
import android.text.TextUtils
import com.masahide.testmvp.シングルトンの依存切り離し.MyApplication

class LargeUtil {
    companion object {
        @JvmStatic
        fun validateMailAddress(target: String): Boolean {
            return if (TextUtils.isEmpty(target)) {
                false
            } else {
                android.util.Patterns.EMAIL_ADDRESS
                    .matcher(target).matches()
            }
        }

        @JvmStatic
        fun getUserName(): String {
            val pref = PreferenceManager
                .getDefaultSharedPreferences(MyApplication.getInstance())
            return pref.getString("userName", "")
        }
        //その他便利メソッドが続く

    }

    //メソッドを追加
    fun getName(): String {
        //staticメソッドに移譲
        return getUserName()
    }

    //メソッドを追加
    fun isMailAddress(target: String): Boolean {
        //staticメソッドに移譲
        return validateMailAddress(target);
    }
}