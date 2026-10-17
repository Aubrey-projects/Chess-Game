package com.example.chess.pieces

import androidx.compose.ui.unit.IntOffset

class Queen(
    override val color: Piece.Color,
    override var position: IntOffset
) : Piece {

    override val type: Piece.Type = Piece.Type.Queen

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}