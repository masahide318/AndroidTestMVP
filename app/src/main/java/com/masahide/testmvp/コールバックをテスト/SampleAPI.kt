package com.masahide.testmvp.コールバックをテスト

import android.content.Context
import android.os.Handler
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class SampleAPI(context: Context) {

    val mainHandler = Handler(context.mainLooper)

    interface APICallback {
        fun onSuccess(user: User)
        fun onFailure(e: IOException)
    }

    fun getUser(callback: APICallback) {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/users/masahide318")
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException?) {
                if (e != null) {
                    mainHandler.post { callback.onFailure(e) }
                }
            }

            override fun onResponse(call: Call?, response: Response?) {
                response?.let {
                    if (response.isSuccessful) {
                        val result = response.body()?.string() ?: ""
                        val user = Gson().fromJson(result, User::class.java)
                        mainHandler.post { callback.onSuccess(user) }
                    }
                }
            }
        })
    }
}