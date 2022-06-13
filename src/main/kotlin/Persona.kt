

data class Persona (
    var genero: String?,
    var name: String?,
    var pokemon: Pokemon?,
    var medalla1: Boolean,
    var medalla2: Boolean,
)


data class Pokemon (
    var name: String?,
    var type: String?,
    var genero: String?,
    var nivel: Int,
)
