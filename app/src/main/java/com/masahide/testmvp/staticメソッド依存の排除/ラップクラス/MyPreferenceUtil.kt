package com.masahide.testmvp.staticメソッド依存の排除.ラップクラス

import android.content.Context

class MyPreferenceUtil {
    companion object {

        fun saveName(context: Context, name: String): String {
            return "name"
        }

        fun getName(context: Context): String {
            return "name"
        }
    }
}