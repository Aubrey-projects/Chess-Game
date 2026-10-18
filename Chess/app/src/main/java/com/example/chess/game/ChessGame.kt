package com.example.chess.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntOffset
import com.example.chess.pieces.*

class ChessGame {
    // List of all chess pieces on the board
    val pieces = mutableStateListOf<Piece>()

    // Current turn
    var currentTurn by mutableStateOf(Piece.Color.White)
        private set

    // Currently selected piece
    var selectedPiece by mutableStateOf<Piece?>(null)
        private set

    // Available moves for the selected piece
    var validMoves by mutableStateOf<Set<IntOffset>>(emptySet())
        private set

    // Runs when chess game is called
    init {
        // Calls the function to initialize the chess board
        initializeBoard()
    }

    // Function to place pieces in their starting position
    fun initializeBoard() {
        pieces.clear()
        currentTurn = Piece.Color.White
        selectedPiece = null
        validMoves = emptySet()

        // Places white pieces on the board
        pieces.add(Rook(Piece.Color.White, IntOffset(1, 1)))
        pieces.add(Knight(Piece.Color.White, IntOffset(2, 1)))
        pieces.add(Bishop(Piece.Color.White, IntOffset(3, 1)))
        pieces.add(Queen(Piece.Color.White, IntOffset(4, 1)))
        pieces.add(King(Piece.Color.White, IntOffset(5, 1)))
        pieces.add(Bishop(Piece.Color.White, IntOffset(6, 1)))
        pieces.add(Knight(Piece.Color.White, IntOffset(7, 1)))
        pieces.add(Rook(Piece.Color.White, IntOffset(8, 1)))
        // Places white pawns
        pieces.add(Pawn(Piece.Color.White, IntOffset(1, 2)))
        pieces.add(Pawn(Piece.Color.White, IntOffset(2, 2)))
        pieces.add(Pawn(Piece.Color.White, IntOffset(3, 2)))
        pieces.add(Pawn(Piece.Color.White, IntOffset(4, 5)))
        pieces.add(Pawn(Piece.Color.White, IntOffset(5, 2)))
        pieces.add(Pawn(Piece.Color.White, IntOffset(6, 2)))
        pieces.add(Pawn(Piece.Color.White, IntOffset(7, 2)))
        pieces.add(Pawn(Piece.Color.White, IntOffset(8, 2)))

        // Places black pieces on the board
        pieces.add(Rook(Piece.Color.Black, IntOffset(1, 8)))
        pieces.add(Knight(Piece.Color.Black, IntOffset(2, 8)))
        pieces.add(Bishop(Piece.Color.Black, IntOffset(3, 8)))
        pieces.add(Queen(Piece.Color.Black, IntOffset(4, 8)))
        pieces.add(King(Piece.Color.Black, IntOffset(5, 8)))
        pieces.add(Bishop(Piece.Color.Black, IntOffset(6, 8)))
        pieces.add(Knight(Piece.Color.Black, IntOffset(7, 8)))
        pieces.add(Rook(Piece.Color.Black, IntOffset(8, 8)))
        // Places black pawns
        pieces.add(Pawn(Piece.Color.Black, IntOffset(1, 7)))
        pieces.add(Pawn(Piece.Color.Black, IntOffset(2, 7)))
        pieces.add(Pawn(Piece.Color.Black, IntOffset(3, 6)))
        pieces.add(Pawn(Piece.Color.Black, IntOffset(4, 7)))
        pieces.add(Pawn(Piece.Color.Black, IntOffset(5, 7)))
        pieces.add(Pawn(Piece.Color.Black, IntOffset(6, 7)))
        pieces.add(Pawn(Piece.Color.Black, IntOffset(7, 7)))
        pieces.add(Pawn(Piece.Color.Black, IntOffset(8, 7)))

    }

    // Function for when a piece is tapped
    fun onPieceTapped(piece: Piece) {
        // If it is your turn,
        if (piece.color == currentTurn) {
            // Makes the tapped piece the selected piece and finds the available moves
            selectedPiece = piece
            validMoves = piece.getAvailableMoves(pieces)

        // Executes if you click on an enemy piece while your piece is selected and the move is valid
        } else if (selectedPiece != null && validMoves.contains(piece.position)) {
            // Calls execute move function
            executeMove(selectedPiece!!, piece.position)
        }
    }

    // Function to execute a move
    fun executeMove(piece: Piece, targetPosition: IntOffset) {
        //  Removes a captured piece
        val capturedPiece = pieces.find { it.position == targetPosition }
        if (capturedPiece != null) {
            pieces.remove(capturedPiece)
        }

        // Moves a piece
        piece.position = targetPosition

        // Clears selection and swap turns
        selectedPiece = null
        validMoves = emptySet()
        currentTurn = if (currentTurn.isWhite) Piece.Color.Black else Piece.Color.White
    }
}