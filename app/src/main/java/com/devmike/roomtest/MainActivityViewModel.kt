package com.devmike.roomtest

import androidx.lifecycle.*
import com.devmike.roomtest.data.SharedPref
import com.devmike.roomtest.data.WallpapersRepository
import com.devmike.roomtest.model.WallPaperModel
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class MainActivityViewModel(val wallpapersRepo: WallpapersRepository,val sharedPref: SharedPref): ViewModel() {

    val wallpaperlist  : LiveData<List<WallPaperModel>> =wallpapersRepo.allWallappers.asLiveData()


    fun insert(wallpaper : WallPaperModel) = viewModelScope.launch {
        wallpapersRepo.insertWallpaper(wallpaper)
    }

    fun  insertIntoSharedPref(){
        wallpaperlist.value?.let { list ->
            sharedPref.setNumberofWallpapers(list.size)

        }

    }

   fun readPref():Int{
       return  sharedPref.readNumberofwallpapers()
   }
}

class WallViewModelFactory(private val repository:WallpapersRepository,private val sharedPref: SharedPref): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)){
            return MainActivityViewModel(repository,sharedPref)as T
        }
        throw IllegalArgumentException("Unkown Viewmodel Class")
    }

}