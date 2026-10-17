package com.example.chess.pieces

// My imports
import androidx.compose.ui.unit.IntOffset

// Knight class
class Knight(
    // Knight properties
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {

    // Sets the type to knight
    override val type: Piece.Type = Piece.Type.Knight

    // Determines the available moves
    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}