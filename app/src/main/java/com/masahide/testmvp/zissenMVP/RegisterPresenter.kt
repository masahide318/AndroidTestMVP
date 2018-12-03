package com.masahide.testmvp.zissenMVP

class RegisterPresenter(
    private val view: RegisterContract.View,
    //依存オブジェクトはコンストラクタインジェクションします
    private val registerAPI: RegisterAPI,
    private val validator: Validator) : RegisterContract.Presenter {

    //Callbackをpublicな変数にします
    val registerCallback = object : RegisterAPI.Callback {
        override fun onSuccess() {
            view.showRegisteredSucceeded()
        }

        override fun onFailure(reason: String) {
            view.showRegisteredError(reason)
        }
    }

    override fun clickRegisteredButton(mailAddress: String, password: String) {
        if (!validator.validatePassword(password)) {
            view.showValidateError()
            return
        }
        if (!validator.validateMailAddress(mailAddress)) {
            view.showValidateError()
            return
        }
        registerAPI.register(mailAddress, password, registerCallback)
    }

    override fun mailAddressFormatCheck(mailAddress: String) {
        if (!validator.validateMailAddress(mailAddress)) {
            view.showMailAddressFormatError()
        } else {
            view.dismissMailAddressFormatError()
        }
    }
}