class DocumentoInvalidoException: Exception()
class PassInvalidaException: Exception()

class PersonasFun {

    companion object {

        fun esPokemonObediente(persona: Persona?) : Boolean {
            if (persona == null) throw PersonaNulaException()
            persona.pokemon?.let {
                if (persona.medalla2 && it.nivel > 20) return true
                if (persona.medalla1 && it.nivel > 10) return true
            } ?: throw PokemonNuloException()
            return false
        }

        fun corroborarTipo(pokemon: Pokemon?) : String{
            pokemon?.let {
                return when (it.name) {
                    "Pikachu" -> "Eléctrico"
                    "Charmander" -> "Fuego"
                    "Mew"-> "Síkico"
                    else -> { throw PokemonFallido()}
                }
            } ?: throw  PokemonNuloException()
        }
    }
}