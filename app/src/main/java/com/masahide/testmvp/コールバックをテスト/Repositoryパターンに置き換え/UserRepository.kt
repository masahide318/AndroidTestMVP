package com.masahide.testmvp.コールバックをテスト.Repositoryパターンに置き換え

import com.masahide.testmvp.コールバックをテスト.User
import java.io.IOException

interface UserRepository {

    interface Callback {
        fun onSuccess(user: User)
        fun onFailure(e: IOException)
    }

    fun getUser(callback: Callback)
}
