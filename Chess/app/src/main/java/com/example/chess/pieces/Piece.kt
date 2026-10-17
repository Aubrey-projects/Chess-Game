package com.example.chess.pieces

import androidx.compose.ui.unit.IntOffset

interface Piece {
    val color: Color
    val type: Type
    var position: IntOffset
    enum class Color {
        White,
        Black;

        val isWhite: Boolean
            get() = this == White

        val isBlack: Boolean
            get() = this == Black
    }

    enum class Type(val type: String) {
        Pawn("pawn"),
        Knight("knight"),
        Bishop("bishop"),
        Rook("rook"),
        Queen("queen"),
        King("king");

        fun getModelPath(color: Color): String {
            val colorPrefix = if (color.isWhite) "white" else "black"
            return "models/${colorPrefix}${type}.glb"
        }
    }

    fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset>
}