package com.masahide.testmvp.staticメソッド依存の排除.移譲用インスタンスメソッド

import com.masahide.testmvp.staticメソッド依存の排除.SomeView

class SomePresenter(
    private val view: SomeView,
    //コンストラクタインジェクションさせる
    val largeUtil: LargeUtil
) {
    fun clickButton(mailAddress: String) {
        if (largeUtil.isMailAddress(mailAddress)) {
            view.setUserName(largeUtil.getName())
        }
    }
}