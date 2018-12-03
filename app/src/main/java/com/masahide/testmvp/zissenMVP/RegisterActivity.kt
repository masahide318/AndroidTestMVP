package com.masahide.testmvp.zissenMVP

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.masahide.testmvp.R
import kotlinx.android.synthetic.main.activity_login.*

class RegisterActivity : AppCompatActivity(), RegisterContract.View {

    val presenter by lazy {
        RegisterPresenter(this, RegisterAPI(applicationContext), Validator())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mail_address.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                presenter.mailAddressFormatCheck(s.toString())
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int, count: Int,
                after: Int) {
            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int) {
            }
        })

        buttonRegister.setOnClickListener {
            presenter.clickRegisteredButton(mail_address.text.toString(), password.text.toString())
        }
    }

    override fun showMailAddressFormatError() {
        error_message.text = "メールアドレスが正しくありません"
    }

    override fun dismissMailAddressFormatError() {
        error_message.text = ""
    }

    override fun showValidateError() {
        Toast.makeText(
            this,
            "パスワードまたはメールアドレスが不正です",
            Toast.LENGTH_SHORT).show()
    }

    override fun showRegisteredSucceeded() {
        Toast.makeText(
            this ,
            "登録完了しました",
            Toast.LENGTH_SHORT).show()
    }

    override fun showRegisteredError(reason: String) {
        Toast.makeText(
            this,
            "エラーメッセージ : $reason",
            Toast.LENGTH_SHORT).show()
    }
}