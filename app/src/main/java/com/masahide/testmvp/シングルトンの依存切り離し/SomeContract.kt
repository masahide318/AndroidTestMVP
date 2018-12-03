package com.masahide.testmvp.シングルトンの依存切り離し

interface SomeView {
    fun setName(name: String)
}

interface Presenter {
    fun clickSomething()
}

/**
 * 本来は以下の用にContractを書く必要がありますが
 * 書籍の見やすさのため省略したものを使ってます
 */
//interface SomeContract {
//    interface SomeView {
//        fun setName(name: String)
//    }
//
//    interface Presenter {
//        fun clickSomething()
//    }
//}