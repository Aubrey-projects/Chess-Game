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
        val nextPosition3 = IntOffset(
            x = position.x + 1,
            y = position.y + direction
        )
        val nextPosition4 = IntOffset(
            x = position.x - 1,
            y = position.y + direction
        )

        // Checks whether there is a piece in the possible positions
        val nextPiece1 = pieces.find { it.position == nextPosition1 }
        val nextPiece2 = pieces.find { it.position == nextPosition2 }
        val nextPiece3 = pieces.find { it.position == nextPosition3 }
        val nextPiece4 = pieces.find { it.position == nextPosition4 }

        // If there is no pieces in front of the pawn, and it is on the board, adds the position to the set of possible moves
        if (nextPiece1 == null && nextPosition1.isOnBoard())
            moves.add(nextPosition1)
        if (nextPiece1 == null && nextPiece2 == null && nextPosition2.isOnBoard() && isFirstMove)
            moves.add(nextPosition2)

        // If there is an enemy piece to the right or left diagonally, and it is on the board, adds the position to the set of possible moves
        if (nextPiece3 != null && nextPiece3.color != this.color && nextPosition3.isOnBoard())
            moves.add(nextPosition3)
        if (nextPiece4 != null && nextPiece4.color != this.color && nextPosition4.isOnBoard())
            moves.add(nextPosition4)

        // Returns the set of possible moves
        return moves
    }
}