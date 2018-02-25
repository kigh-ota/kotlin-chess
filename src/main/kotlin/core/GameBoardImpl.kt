package core

import core.move.*
import core.piece.*

class GameBoardImpl : GameBoard {
    override fun possibleMoves(piece: Piece): Set<Move> {
        return when (piece) {
            is King ->  // kintmove, king-side castling
                KingMove(
                    piece.pos.toString(),
                    this
                ).possibleDestinations().map { KingMove(piece.pos.toString(), this).to(it.toString()) }.toSet()
            is Queen -> QueenMove(
                piece.pos.toString(),
                this
            ).possibleDestinations().map { QueenMove(piece.pos.toString(), this).to(it.toString()) }.toSet()
            is Rook -> setOf()  // rookmove, kingside castling  TODO
            is Bishop -> BishopMove(
                piece.pos.toString(),
                this
            ).possibleDestinations().map { BishopMove(piece.pos.toString(), this).to(it.toString()) }.toSet()
            is Knight -> KnightMove(
                piece.pos.toString(),
                this
            ).possibleDestinations().map { KnightMove(piece.pos.toString(), this).to(it.toString()) }.toSet()
            is Pawn -> setOf()  // single, double, enpassant  TODO
            else -> throw RuntimeException("Illegal Piece Type")
        }
    }

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
        val captured = move.capturedPiece()
        if (captured != null) {
            capturedPieces.add(captured)
            _pieces.remove(captured)
        }
        move.move()
        _record.add(move)
        _nextTurn = if (_nextTurn == Player.WHITE) Player.BLACK else Player.WHITE
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