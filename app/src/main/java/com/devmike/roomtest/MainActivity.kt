package com.devmike.roomtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.devmike.roomtest.model.WallPaperModel
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var numberofWallPapers : TextView
    lateinit var clicktoadd: Button

    private val mainActivityViewModel : MainActivityViewModel by viewModels {
WallViewModelFactory((application as RoomtestingApplication).repository,(application as RoomtestingApplication).sharedPreferences)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberofWallPapers = findViewById(R.id.numberwall)
        clicktoadd = findViewById(R.id.clickToAdd)


        mainActivityViewModel.wallpaperlist.observe(this){
            mainActivityViewModel.insertIntoSharedPref()

            numberofWallPapers.text = mainActivityViewModel.readPref().toString()
        }

        clicktoadd.setOnClickListener {

            val newWallaper = WallPaperModel(
                Date().hashCode(),
                "Pubg",
                "https://images.pexels.com/photos/2406450/pexels-photo-2406450.jpeg",
                "https://images.pexels.com/photos/2406450/pexels-photo-2406450.jpeg",
                "MIKEWIL",
                false,
                "Pubg"
            )

            mainActivityViewModel.insert(newWallaper)


        }
    }

}