package core

import core.move.Move
import core.piece.*

class GameBoardImpl : GameBoard {
    private var _pieces: MutableSet<Piece> = mutableSetOf()
    override val pieces: Set<Piece>
        get() = _pieces

    private var _record: MutableList<Move> = mutableListOf()
    override val record: List<Move>
        get() = _record

    private var _nextTurn: Player = Player.WHITE
    override val nextTurn: Player
        get() = _nextTurn

    override fun set(strs: Array<String>) {
        require(strs.size == 8)
        _pieces = mutableSetOf()
        strs.forEachIndexed { i, str ->
            run {
                require(str.length == 8)
                val rank = GameBoard.SIZE - i
                str.forEachIndexed { j, c ->
                    run {
                        val file = j + 1
                        val piece = charToPiece(c, Position(rank, file))
                        if (piece != null) {
                            _pieces.add(piece)
                        }
                    }
                }
            }
        }
    }

    val capturedPieces: MutableSet<Piece> = mutableSetOf()

    override fun setup() {
        set(
            arrayOf(
                "rnbqkbnr",
                "pppppppp",
                "........",
                "........",
                "........",
                "........",
                "PPPPPPPP",
                "RNBQKBNR"
            )
        )
        _nextTurn = Player.WHITE
    }

    override fun move(move: Move) {
        require(move.player == nextTurn)
        val captured = move.capturing()
        move.move()
        if (captured != null) {
            capturedPieces.add(captured)
            _pieces.remove(captured)
        }

        _record.add(move)
        _nextTurn = _nextTurn.opponent
    }

    override fun pieceAt(pos: Position?): Piece? {
        checkNotNull(pos)
        return _pieces.firstOrNull { it.pos == pos }
    }

    override fun pieceAt(notion: String): Piece? {
        return pieceAt(Position.of(notion))
    }

    override fun put(piece: Piece) {
        require(_pieces.all { it.pos != piece.pos })
        _pieces.add(piece)
    }

    override fun possibleMoves(player: Player): Set<Move> {
        return _pieces
            .filter { it.player == player }
            .map { it.possibleMoves(this) }
            .flatten()
            .toSet()
    }

    override fun isInCheck(player: Player): Boolean {
        return _pieces.find { it.player == player && it is King }!!
            .isBeingAttackedBy(this)
            .isNotEmpty()
    }
}

private fun charToPiece(c: Char, pos: Position): Piece? {
    return when (c) {
        'P' -> Pawn(pos, Player.WHITE)
        'R' -> Rook(pos, Player.WHITE)
        'N' -> Knight(pos, Player.WHITE)
        'B' -> Bishop(pos, Player.WHITE)
        'Q' -> Queen(pos, Player.WHITE)
        'K' -> King(pos, Player.WHITE)
        'p' -> Pawn(pos, Player.BLACK)
        'r' -> Rook(pos, Player.BLACK)
        'n' -> Knight(pos, Player.BLACK)
        'b' -> Bishop(pos, Player.BLACK)
        'q' -> Queen(pos, Player.BLACK)
        'k' -> King(pos, Player.BLACK)
        else -> null
    }
}