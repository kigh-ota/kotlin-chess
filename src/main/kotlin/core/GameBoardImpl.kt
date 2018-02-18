package core

import core.move.Move

class GameBoardImpl : GameBoard {
    private var _pieces: MutableSet<Piece> = mutableSetOf()
    override val pieces: Set<Piece>
        get() = _pieces

    override val size: Int = 8

    private var _record: MutableList<Move> = mutableListOf()
    override val record: List<Move>
        get() = _record

    override fun setup() {
        _pieces = mutableSetOf(
            Rook(Position(1, 1), Player.WHITE),
            Rook(Position(1, 8), Player.WHITE),
            Knight(Position(1, 2), Player.WHITE),
            Knight(Position(1, 7), Player.WHITE),
            Bishop(Position(1, 3), Player.WHITE),
            Bishop(Position(1, 6), Player.WHITE),
            Queen(Position(1, 4), Player.WHITE),
            King(Position(1, 5), Player.WHITE),
            Rook(Position(8, 1), Player.BLACK),
            Rook(Position(8, 8), Player.BLACK),
            Knight(Position(8, 2), Player.BLACK),
            Knight(Position(8, 7), Player.BLACK),
            Bishop(Position(8, 3), Player.BLACK),
            Bishop(Position(8, 6), Player.BLACK),
            Queen(Position(8, 4), Player.BLACK),
            King(Position(8, 5), Player.BLACK),
            Pawn(Position(2, 1), Player.WHITE),
            Pawn(Position(2, 2), Player.WHITE),
            Pawn(Position(2, 3), Player.WHITE),
            Pawn(Position(2, 4), Player.WHITE),
            Pawn(Position(2, 5), Player.WHITE),
            Pawn(Position(2, 6), Player.WHITE),
            Pawn(Position(2, 7), Player.WHITE),
            Pawn(Position(2, 8), Player.WHITE),
            Pawn(Position(7, 1), Player.BLACK),
            Pawn(Position(7, 2), Player.BLACK),
            Pawn(Position(7, 3), Player.BLACK),
            Pawn(Position(7, 4), Player.BLACK),
            Pawn(Position(7, 5), Player.BLACK),
            Pawn(Position(7, 6), Player.BLACK),
            Pawn(Position(7, 7), Player.BLACK),
            Pawn(Position(7, 8), Player.BLACK)
        )
    }

    override fun move(move: Move) {
        record.plus(move)
        move.move()
    }

    override fun pieceAt(pos: Position): Piece? {
        return _pieces.firstOrNull { it.pos == pos }
    }
}