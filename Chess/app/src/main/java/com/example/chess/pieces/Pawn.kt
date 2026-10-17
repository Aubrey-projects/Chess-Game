package com.example.chess.pieces

// My imports
import androidx.compose.ui.unit.IntOffset

// Pawn class
class Pawn(
    // Pawn properties
    override val color: Piece.Color,
    override var position: IntOffset
): Piece {

    // Sets the type to pawn
    override val type: Piece.Type = Piece.Type.Pawn

    // Determines the available moves
    override fun getAvailableMoves(pieces: List<Piece>): Set<IntOffset> {
        // Creates a set of moves
        val moves = mutableSetOf<IntOffset>()

        // Depending on whether the piece is black or white, sets the direction to either move up or down on the board.
        val direction = if (color.isWhite) 1 else -1

        // Determines whether black and white pieces are still at their starting positions
        val isFirstMove = position.y == 2 && color.isWhite || position.y == 7 && color.isBlack

        // Possible positions the pawns can move to
        val nextPosition1 = IntOffset(
            x = position.x,
            y = position.y + direction
        )
        val nextPosition2 = IntOffset(
            x = position.x,
            y = position.y + direction * 2
        )

        // Checks whether there is a piece in the possible positions
        val nextPiece1 = pieces.find { it.position == nextPosition1 }
        val nextPiece2 = pieces.find { it.position == nextPosition2 }

        // If there is no piece in the position, adds the position to the set of possible moves
        if (nextPiece1 == null)
            moves.add(nextPosition1)
        if (nextPiece1 == null && nextPiece2 == null && isFirstMove)
            moves.add(nextPosition2)

        // Returns the set of possible moves
        return moves
    }

}