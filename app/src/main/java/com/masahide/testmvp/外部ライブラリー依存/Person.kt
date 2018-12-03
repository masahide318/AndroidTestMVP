package com.masahide.testmvp.外部ライブラリー依存

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Person(
    @PrimaryKey open var id: Long,
    open var name: String = ""
) : RealmObject() {}