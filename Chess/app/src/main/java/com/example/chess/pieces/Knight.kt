package com.example.chess.pieces

import androidx.compose.ui.unit.IntOffset

class Knight(
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {

    override val type: Piece.Type = Piece.Type.Knight

    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        return emptySet()
    }

}