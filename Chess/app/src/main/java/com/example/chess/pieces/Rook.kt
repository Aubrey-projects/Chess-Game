package com.example.chess.pieces

import androidx.compose.ui.unit.IntOffset

class Rook(
    override val color: Piece.Color,
    override var position: IntOffset
) : Piece {

    override val type: Piece.Type = Piece.Type.Rook

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}