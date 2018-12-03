package com.masahide.testmvp.外部ライブラリー依存.コンストラクタインジェクションする

import com.google.gson.Gson
import com.masahide.testmvp.外部ライブラリー依存.Person
import com.masahide.testmvp.外部ライブラリー依存.View
import io.realm.Realm

class SomePresenter(
    private val view: View,
    private val realm: Realm,
    private val gson: Gson = Gson()
) {

    fun getUser(id: Long) {

        val result = realm.where(Person::class.java)
            .equalTo("id", id).findFirst()
        if (result != null) {
            val person = realm.copyFromRealm(result)
            view.bind(gson.toJson(person))
        }
        view.bind("")
    }
}