package com.example.chess.pieces

// My imports
import androidx.compose.ui.unit.IntOffset

// Queen class
class Queen(
    // Queen properties
    override val color: Piece.Color,
    override var position: IntOffset
) : Piece {

    // Sets the type to queen
    override val type: Piece.Type = Piece.Type.Queen

    // Determines the available moves
    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}