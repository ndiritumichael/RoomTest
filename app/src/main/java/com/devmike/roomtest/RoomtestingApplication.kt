package com.devmike.roomtest

import android.app.Application
import com.devmike.roomtest.data.SharedPref
import com.devmike.roomtest.data.WallpapersRepository
import com.keapps.futurewallpapers.data.WallPaperRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class RoomtestingApplication : Application() {

    private val database by lazy {
        WallPaperRoomDatabase.getDatabase(this)

    }
    val sharedPreferences by lazy {
        SharedPref(this)
    }
    val repository by lazy {
        WallpapersRepository(database.wallDao())
    }
}
