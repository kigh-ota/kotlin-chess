package core

import core.move.SinglePieceMove
import core.piece.Piece

data class Position(val rank: Int, val file: Int) {
    init {
        require(valid(rank, file))
    }

    fun to(r: Int, f: Int): Position? = maybe(rank + r, file + f)
    fun toUpper(i: Int): Position? = to(i, 0)
    fun toLower(i: Int): Position? = to(-i, 0)
    fun toLeft(i: Int): Position? = to(0, -i)
    fun toRight(i: Int): Position? = to(0, i)
    fun toUpperLeft(i: Int): Position? = to(i, -i)
    fun toUpperRight(i: Int): Position? = to(i, i)
    fun toLowerLeft(i: Int): Position? = to(-i, -i)
    fun toLowerRight(i: Int): Position? = to(-i, i)

    override fun toString(): String {
        return ('a' + file - 1).toString() + ('0' + rank)
    }

    fun isUnderAttackBy(enemySide: Player, board: GameBoard): Set<Piece> {
        return board
            .possibleMoves(enemySide)
            .filter { it.capturing()?.pos == this }
            .map { (it as SinglePieceMove).piece }
            .toSet()
    }

    companion object {
        fun of(notion: String): Position {
            require(notion.length == 2)
            val (fileChar, rankChar) = notion.toCharArray()

            require(fileChar >= 'a' && fileChar < 'a' + GameBoard.SIZE)
            val file: Int = fileChar - 'a' + 1

            require(rankChar.isDigit())
            val rank: Int = rankChar - '1' + 1
            require(rank >= 1 && rank <= GameBoard.SIZE)

            return Position(rank, file)
        }

        fun valid(rank: Int, file: Int): Boolean {
            return rank >= 1 && rank <= GameBoard.SIZE && file >= 1 && file <= GameBoard.SIZE
        }

        fun maybe(rank: Int, file: Int): Position? {
            return if (valid(rank, file)) Position(rank, file) else null
        }
    }
}