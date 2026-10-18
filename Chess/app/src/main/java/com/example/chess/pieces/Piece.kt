package com.example.chess.pieces

// My imports
import androidx.compose.ui.unit.IntOffset

// Piece interface
interface Piece {
    // Piece properties
    val color: Color
    val type: Type
    var position: IntOffset

    // Color class
    enum class Color {
        White,
        Black;

        val isWhite: Boolean
            get() = this == White

        val isBlack: Boolean
            get() = this == Black
    }

    // Type class
    enum class Type(val type: String) {
        // Possible piece types
        Pawn("pawn"),
        Knight("horse"),
        Bishop("bishop"),
        Rook("castle"),
        Queen("queen"),
        King("king");

        // Depending on the color and type, returns the correct path to the 3D model
        fun getModelPath(color: Color): String {
            val colorPrefix = if (color.isWhite) "white" else "black"
            return "models/${colorPrefix}${type}.glb"
        }
    }

    // Depending on where the other pieces are on the board, returns a set of possible moves
    fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset>

    fun IntOffset.isOnBoard(): Boolean {
        return x in 1..8 && y in 1..8
    }
}