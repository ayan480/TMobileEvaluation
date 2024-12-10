package com.syncoders.data.dataSource.sharedPreferences


import android.content.Context
import android.content.SharedPreferences
import com.syncoders.domain.model.auth.User
import javax.inject.Inject

class SharedPreferencesHelper @Inject constructor(context: Context) {

    // for remember me
    private val rememberMeSharedPreferences: SharedPreferences = context.getSharedPreferences(
        RememberMePreferences,
        Context.MODE_PRIVATE
    )

    fun saveLoginId(id: String?) {
        rememberMeSharedPreferences.edit().putString(LOGIN_ID, id?:"").apply()
    }

    fun saveLoginPassword(password: String?) {
        rememberMeSharedPreferences.edit().putString(LOGIN_PASSWORD, password?:"").apply()
    }

    fun getLoginId(): String? {
        return rememberMeSharedPreferences.getString(LOGIN_ID, null)
    }

    fun getLoginPassword(): String? {
        return rememberMeSharedPreferences.getString(LOGIN_PASSWORD, null)
    }


    // for storing user data after login
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        UserPreferences,
        Context.MODE_PRIVATE
    )

    fun putString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String): String? {
        return sharedPreferences.getString(key, null)
    }

    fun saveUser(user: User) {
        sharedPreferences.edit().apply {
            putString(USER_ID, user.id)
            putString(USER_NAME, user.name)
            putString(USER_EMAIL, user.email)
            putString(USER_MOBILE_NO, user.mobileNo)
            putString(USER_PROFILE_PICTURE, user.profilePic?:"")
            putBoolean(IS_LOGGED_IN, true)
            apply()
        }.commit()
    }

    fun getUser(): User? {
        val id = sharedPreferences.getString(USER_ID, null)
        val name = sharedPreferences.getString(USER_NAME, null)
        val email = sharedPreferences.getString(USER_EMAIL, null)
        val mobile = sharedPreferences.getString(USER_MOBILE_NO, null)
        val profilePic = sharedPreferences.getString(USER_PROFILE_PICTURE, null)
        return if (name != null && email != null && mobile != null) {

            if (id != null) {
                User(
                    name = name,
                    email = email,
                    mobileNo = mobile,
                    id = id,
                    profilePic = profilePic
                )
            } else {
                null
            }
        } else {
            null
        }
    }

    fun isLoggedIn(): Boolean {
        return sharedPreferences.getBoolean(IS_LOGGED_IN, false)
    }

    fun getUserId(): String? {
        return sharedPreferences.getString(USER_ID, null)
    }

    fun logout() {
        // Clear user data and login state
        sharedPreferences.edit().apply {
            clear()
            apply()
        }
    }


}
