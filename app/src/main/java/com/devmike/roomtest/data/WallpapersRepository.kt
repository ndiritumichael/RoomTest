package com.devmike.roomtest.data


import com.devmike.roomtest.model.WallPaperModel
import com.keapps.futurewallpapers.data.WallDAO


class WallpapersRepository(val wallpaperdao : WallDAO){
    val allWallappers
    get() = wallpaperdao.getAllWallpapers()




val favWallPapers
get() = wallpaperdao.getFavorites()

    suspend fun insertWallpaper(wallpaper: WallPaperModel){
        wallpaperdao.insert(wallpaper)
    }

    suspend fun updateData(wallPaper: WallPaperModel) {
        wallpaperdao.update(wallPaper)

    }

   suspend fun fullWallpaper(id: Int) = wallpaperdao.getWallPaper(id)




}