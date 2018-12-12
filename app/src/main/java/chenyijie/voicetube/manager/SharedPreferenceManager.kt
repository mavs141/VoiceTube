package chenyijie.voicetube.manager

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferenceManager @Inject constructor(private val sharedPreferences: SharedPreferences) {

    fun putString(key: String, info: String) {
        sharedPreferences.edit().putString(key, info).apply()
    }

    fun putBoolean(key: String, info: Boolean) {
        sharedPreferences.edit().putBoolean(key, info).apply()
    }

    fun putInt(key: String, info: Int) {
        sharedPreferences.edit().putInt(key, info).apply()
    }

    fun putFloat(key: String, info: Float) {
        sharedPreferences.edit().putFloat(key, info).apply()
    }

    fun putLong(key: String, info: Long) {
        sharedPreferences.edit().putLong(key, info).apply()
    }

    fun getString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue)
    }

    fun getString(key: String): String {
        return sharedPreferences.getString(key, "")
    }

    fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun getBoolean(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }

    fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    fun getInt(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun getFloat(key: String): Float {
        return sharedPreferences.getFloat(key, 0f)
    }

    fun getFloat(key: String, defaultValue: Float): Float {
        return sharedPreferences.getFloat(key, defaultValue)
    }

    fun getLong(key: String): Long {
        return sharedPreferences.getLong(key, 0L)
    }

    fun getLong(key: String, defaultValue: Long): Long {
        return sharedPreferences.getLong(key, defaultValue)
    }
}