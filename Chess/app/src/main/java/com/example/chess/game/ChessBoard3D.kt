package com.example.chess.game

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import io.github.sceneview.SceneView
import io.github.sceneview.math.Position
import io.github.sceneview.math.Rotation
import io.github.sceneview.rememberCameraNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelInstance
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.math.Scale

// Converts from 2D grid to 3D world position
fun IntOffset.to3DWorldPosition(squareSize: Float = 1f): Position {
    val x3D = (this.x - 4.5f) * squareSize
    val y3D = 0f
    val z3D = (this.y - 4.5f) * squareSize
    return Position(x = x3D, y = y3D, z = z3D)
}

@Composable
fun ChessBoard3D(
    game: ChessGame,
    modifier: Modifier = Modifier
) {
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)

    // Creates camera looking at board
    val cameraNode = rememberCameraNode(engine).apply {
        position = Position(x = 0f, y = 10f, z = 8f)
        rotation = Rotation(x = -50f, y = 0f, z = 0f)
    }

    SceneView(
        modifier = modifier.fillMaxSize(),
        engine = engine,
        modelLoader = modelLoader,
        cameraNode = cameraNode
    ) {
        // Grabs 3D model of board
        rememberModelInstance(modelLoader, "models/board.glb")?.let { boardInstance ->
            ModelNode(
                modelInstance = boardInstance,
                scaleToUnits = 8.0f
            )
        }

        // When game pieces change, updates the 3D models
        for (chessPiece in game.pieces) {
            rememberModelInstance(modelLoader, chessPiece.type.getModelPath(chessPiece.color))?.let { pieceInstance ->
                ModelNode(
                    modelInstance = pieceInstance,
                    scale = Scale(0.8f),
                    position = chessPiece.position.to3DWorldPosition(),
                    rotation = if (chessPiece.color.isBlack) Rotation(y = 180f) else Rotation(x = 0f, y = 0f, z = 0f),
                    apply = {
                        onSingleTapUp = { _ ->
                            game.onPieceTapped(chessPiece)
                            true
                        }
                    }
                )
            }
        }
    }
}
