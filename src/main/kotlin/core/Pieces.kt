package core

abstract class Piece(var pos: Position, val player: Player) {
    private var _moveCount = 0
    val moveCount: Int
        get() = _moveCount

    fun moveTo(dest: Position) {
        pos = dest
        _moveCount++
    }
}

class Pawn(pos: Position, player: Player) : Piece(pos, player)
class Bishop(pos: Position, player: Player) : Piece(pos, player)
class Knight(pos: Position, player: Player) : Piece(pos, player)
class Rook(pos: Position, player: Player) : Piece(pos, player)
class Queen(pos: Position, player: Player) : Piece(pos, player)
class King(pos: Position, player: Player) : Piece(pos, player)
