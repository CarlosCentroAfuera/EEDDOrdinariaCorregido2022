import java.io.File

class ObtenerPersonasRequest {

    companion object {
        fun get(): Array<Persona> {
            return arrayOf(
                Persona("hombre", "Paco", Pokemon("Pikachu", "Eléctrico", "hembra",10), true, medalla2 = false),
                Persona("mujer", "Paca", Pokemon("Pikachu", "Eléctrico", "hembra",15), false, medalla2 = false),
                Persona("hombre", "Antonio", Pokemon("Charmander", "Fuego", "macho",22), true, medalla2 = false),
                Persona("mujer", "Antonia", Pokemon("Charmander", "Fuego", "macho",0), true, medalla2 = true),
                Persona("hombre", "Lolo", Pokemon("Charmander", "Fuego", "hembra",21), true, medalla2 = true),
                Persona("mujer", "Lola", Pokemon("Charmander", "Fuego", "hembra",15), true, medalla2 = false),
                Persona("no especificado", "Andrea", Pokemon("Mew", "Psíquico", "no tiene",10), true, medalla2 = false),
            )
        }
    }

}