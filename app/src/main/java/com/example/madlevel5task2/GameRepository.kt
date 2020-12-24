package com.example.madlevel5task2

import android.content.Context
import androidx.lifecycle.LiveData

class GameRepository(context: Context) {

    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    suspend fun insertGame(game: Game){
        gameDao.insertGame(game)
    }

    suspend fun updateGame(game: Game){
        gameDao.updateGame(game)
    }

    suspend fun deleteGame(game: Game){
        gameDao.deleteGame(game)
    }

    fun getGames(): LiveData<List<Game>>{
        return gameDao.getGames()
    }

    suspend fun deleteGames(){
        gameDao.deleteGames()
    }

}