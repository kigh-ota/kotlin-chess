package core

abstract class Piece(var pos: Position, val player: Player) {
    fun moveTo(dest: Position) {
        pos = dest
    }
}

class Pawn(pos: Position, player: Player) : Piece(pos, player)
class Bishop(pos: Position, player: Player) : Piece(pos, player)
class Knight(pos: Position, player: Player) : Piece(pos, player)
class Rook(pos: Position, player: Player) : Piece(pos, player)
class Queen(pos: Position, player: Player) : Piece(pos, player)
class King(pos: Position, player: Player) : Piece(pos, player)
