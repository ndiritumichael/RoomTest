package com.devmike.roomtest.data

import android.content.Context
import android.content.SharedPreferences


class SharedPref(var context: Context) {
    private val sharedPrefFile = "com.roomtesting"


    private var mPreferences: SharedPreferences =
        context.getSharedPreferences(sharedPrefFile,Context.MODE_PRIVATE)
    val  editor = mPreferences.edit()

    fun setNumberofWallpapers( b:Int){
        editor.putInt("wallpapers",b)
        editor.apply()
        editor.commit()

    }


    fun readNumberofwallpapers() :Int{

        return mPreferences.getInt("wallpapers",0)
    }











}