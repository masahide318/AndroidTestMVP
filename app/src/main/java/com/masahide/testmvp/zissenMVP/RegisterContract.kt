package com.masahide.testmvp.zissenMVP

interface RegisterContract {
    interface View {
        fun showMailAddressFormatError()
        fun dismissMailAddressFormatError()
        fun showValidateError()
        fun showRegisteredSucceeded()
        fun showRegisteredError(reason: String)
    }

    interface Presenter {
        fun clickRegisteredButton(mailAddress: String, password: String)
        fun mailAddressFormatCheck(mailAddress: String)
    }
}