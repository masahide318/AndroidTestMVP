package com.masahide.testmvp.シングルトンの依存切り離し.ラップクラスで包む

import com.masahide.testmvp.シングルトンの依存切り離し.インターフェースの抽出.PreferenceManagerObject

//ラップクラスを用意する
class PreferenceManagerObjectWrapper {
    fun getUserName(): String {
        //間接的に Singletonメソッドにアクセスする
        return PreferenceManagerObject.preferences.getString("name", "")
    }
}
