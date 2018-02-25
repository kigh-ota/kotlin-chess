package core

enum class Player {
    WHITE, BLACK;

    val opponent: Player
        get() = when (this) {
            WHITE -> BLACK
            BLACK -> WHITE
        }
}