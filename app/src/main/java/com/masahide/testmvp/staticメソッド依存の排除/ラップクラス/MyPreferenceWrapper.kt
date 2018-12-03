package com.masahide.testmvp.staticメソッド依存の排除.ラップクラス

import android.content.Context

class MyPreferenceUtilWrapper(private val context: Context) {
    fun setName(name: String) {
        MyPreferenceUtil.saveName(context, name)
    }

    fun getName(): String {
        return MyPreferenceUtil.getName(context)
    }

    //以下Utilの持つメソッドを全て続く……
}