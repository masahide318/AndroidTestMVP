package com.masahide.testmvp.外部ライブラリー依存

import com.google.gson.Gson
import io.realm.Realm

class SomePresenter(val view: View) {

    fun getUser(id: Long) {

        val realm = Realm.getDefaultInstance()
        val result = realm.where(Person::class.java)
            .equalTo("id", id).findFirst()
        if (result != null) {
            val person = realm.copyFromRealm(result)
            view.bind(Gson().toJson(person))
        }
        view.bind("")
    }
}