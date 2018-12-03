package com.masahide.testmvp.zissenMVP

import android.util.Patterns
import java.util.regex.Pattern

class Validator {
    fun validatePassword(password: String): Boolean {
        return password.length > 6 && Pattern.matches("^[0-9a-zA-Z]+$", password)
    }

    fun validateMailAddress(mailAddress: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(mailAddress).matches()
    }
}