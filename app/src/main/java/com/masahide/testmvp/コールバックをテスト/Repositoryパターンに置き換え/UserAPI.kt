package com.masahide.testmvp.コールバックをテスト.Repositoryパターンに置き換え

import android.content.Context
import android.os.Handler

//Repositoryをimplements
class UserAPI(context: Context) : UserRepository {

    val mainHandler = Handler(context.mainLooper)

    override fun getUser(callback: UserRepository.Callback) {
        //中身は先程のUserRepositoryと同じ為略
    }
}