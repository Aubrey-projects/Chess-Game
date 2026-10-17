package com.example.chess.pieces

// My imports
import androidx.compose.ui.unit.IntOffset

// Rook class
class Rook(
    // Rook properties
    override val color: Piece.Color,
    override var position: IntOffset
) : Piece {

    // Sets the type to rook
    override val type: Piece.Type = Piece.Type.Rook

    // Determines the available moves
    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}