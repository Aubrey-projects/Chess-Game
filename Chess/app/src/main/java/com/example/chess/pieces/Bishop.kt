package com.example.chess.pieces

// My imports
import androidx.compose.ui.unit.IntOffset

// Bishop class
class Bishop(
    // Bishop properties
    override val color: Piece.Color,
    override var position: IntOffset
) : Piece {

    // Sets the type to bishop
    override val type: Piece.Type = Piece.Type.Bishop

    // Determines the available moves
    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}