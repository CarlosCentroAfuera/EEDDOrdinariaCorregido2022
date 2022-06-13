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

        fun corroborarTipo(pokemon: Pokemon?) : Boolean{
            pokemon?.let {
                return when (it.name) {
                    "Pikachu" -> it.type == "Eléctrico"
                    "Charmander" -> it.type == "Fuego"
                    "Mew"-> it.type == "Síkico"
                    else -> { throw PokemonFallido()}
                }
            } ?: throw  PokemonNuloException()
        }
    }
}