package com.syncoders.core.utill

object Validator {

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    fun isValidPhone(email: String): Boolean {
        return email.length>=10 && android.util.Patterns.PHONE.matcher(email).matches()
    }

    fun isValidPassword(password: String): Boolean {
        // Regular expression to check password validity
        val passwordPattern = Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\$%^&*(),.?\":{}|<>])[A-Za-z\\d!@#\$%^&*(),.?\":{}|<>]{8,}$")
        return password.matches(passwordPattern)
    }
}