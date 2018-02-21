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
    }

    override fun move(move: Move) {
        _record.add(move)
        move.move()
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