package liuuu.laurence.foundationprojectmvcandroid.utility

import android.content.Context
import android.content.SharedPreferences

object Preference {
    private lateinit var mSharedPreferences: SharedPreferences

    fun init(context: Context) {
        mSharedPreferences = context.getSharedPreferences(Constants.SETTING_PREFERENCE, 0)
    }

    fun clearAll() {
        mSharedPreferences.edit().clear().apply()
    }

    fun saveInt(key: String, value: Int) {
        mSharedPreferences.edit().putInt(key, value).apply()
    }

    fun getInt(key: String, value: Int): Int {
        return mSharedPreferences.getInt(key, value);
    }

    fun saveString(key: String, value: String) {
        mSharedPreferences.edit().putString(key, value).apply()
    }

    fun getString(key: String, value: String): String? {
        return mSharedPreferences.getString(key, value)
    }

    fun removeString(key: String) {
        mSharedPreferences.edit().remove(key).apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        mSharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun getBoolean(key: String, value: Boolean): Boolean {
        return mSharedPreferences.getBoolean(key, value)
    }
}