package com.example.chess.pieces

import androidx.compose.ui.unit.IntOffset

class Pawn(
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {

    override val type: Piece.Type = Piece.Type.Pawn

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}