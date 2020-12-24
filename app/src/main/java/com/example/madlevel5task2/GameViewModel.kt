package com.example.madlevel5task2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)
    private val mainScope = CoroutineScope(Dispatchers.Main)

    val game = gameRepository.getGames()

    fun insertGame(game: Game) {
        mainScope.launch {
            gameRepository.insertGame(game)
        }
    }

    fun deleteGame(game: Game) {
        mainScope.launch {
            gameRepository.deleteGame(game)
        }
    }

    fun deleteGames() {
        mainScope.launch {
            gameRepository.deleteGames()
        }
    }
}