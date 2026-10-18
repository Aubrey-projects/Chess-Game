package com.example.chess

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.chess.game.ChessGame
import com.example.chess.game.ChessBoard3D
import com.example.chess.ui.theme.ChessTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChessTheme {
                // Create and remember the chess game state
                val game = remember { ChessGame() }

                // Display the 3D Chess Board
                ChessBoard3D(
                    game = game,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}