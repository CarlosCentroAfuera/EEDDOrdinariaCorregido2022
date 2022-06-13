import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonajeTest {


    Examen examen = new Examen();

    @Test
    public void testBuscarHombres(){
        Persona[] resultadoEsperado = {
                examen.personas[0],
                examen.personas[2],
                examen.personas[4],
        };

        Persona[] resultadoReal = examen.obtenerHombres();
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testBuscarMujeres_CasoNormal() throws PersonaNulaException {
        Persona[] resultadoEsperado = {
                examen.personas[1],
                examen.personas[3],
                examen.personas[5],
        };

        Persona[] subArray = examen.personas;
        Persona[] resultadoReal = examen.obtenerMujeres(subArray);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testBuscarMujeres_NullPointerException() {
        Persona[] subArray = null;
        Assertions.assertThrows(NullPointerException.class, () -> examen.obtenerMujeres(subArray));
    }

    @Test
    public void testBuscarMujeres_PersonaNulaException() {
        Persona[] subArray = new Persona[2];
        subArray[0] = examen.personas[0];
        subArray[1] = null;

        Assertions.assertThrows(PersonaNulaException.class, () -> examen.obtenerMujeres(subArray));
    }

    @Test
    public void testBuscarPikachus_CasoNormal() throws PersonaNulaException, PokemonNuloException {
        Persona[] resultadoEsperado = {
                examen.personas[0],
                examen.personas[1],
        };

        Persona[] subArray = examen.personas;
        Persona[] resultadoReal = examen.obtenerPikachus(subArray);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testBuscarPikachus_NullPointerException() {
        Persona[] subArray = null;
        Assertions.assertThrows(NullPointerException.class, () -> examen.obtenerPikachus(subArray));
    }

    @Test
    public void testBuscarPikachus_PersonaNulaException() {
        Persona[] subArray = new Persona[2];
        subArray[0] = examen.personas[0];
        subArray[1] = null;

        Assertions.assertThrows(PersonaNulaException.class, () -> examen.obtenerPikachus(subArray));
    }

    @Test
    public void testBuscarPikachus_PokemonNuloException() {
        Persona[] subArray = new Persona[2];
        subArray[0] = examen.personas[0];
        // Cambiando una Persona que ya existe.
        // subArray[1] = examen.personas[1];
        // subArray[0].setPokemon(null);
        // Creando una persona de 0
        subArray[1] = new Persona("", "", null, true, true);
        Assertions.assertThrows(PokemonNuloException.class, () -> examen.obtenerPikachus(subArray));
    }

    @Test
    public void testBuscarPorNombreYNivel_CasoNormal1() throws PersonaNulaException, PokemonNuloException, PokemonNoEncontrado {
        Persona[] resultadoEsperado = {
                examen.personas[0],
                examen.personas[1],
        };

        Persona[] subArray = examen.personas;
        Persona[] resultadoReal = examen.obtenerPokemonPorNombreYNivel(subArray, "Pikachu", 0);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testBuscarPorNombreYNivel_CasoNormal2() throws PersonaNulaException, PokemonNuloException, PokemonNoEncontrado {
        Persona[] resultadoEsperado = {
                examen.personas[1],
        };

        Persona[] subArray = examen.personas;
        Persona[] resultadoReal = examen.obtenerPokemonPorNombreYNivel(subArray, "Pikachu", 10);
        Assertions.assertArrayEquals(resultadoEsperado, resultadoReal);
    }

    @Test
    public void testBuscarPorNombreYNivel_NullPointerException() {
        Persona[] subArray = null;
        Assertions.assertThrows(NullPointerException.class, () -> examen.obtenerPokemonPorNombreYNivel(subArray, "",100));
    }

    @Test
    public void testBuscarPorNombreYNivel_PersonaNulaException() {
        Persona[] subArray = new Persona[2];
        subArray[0] = examen.personas[0];
        subArray[1] = null;

        Assertions.assertThrows(PersonaNulaException.class, () -> examen.obtenerPokemonPorNombreYNivel(subArray, "",100));

    }

    @Test
    public void testBuscarPorNombreYNivel_PokemonNuloException() {
        Persona[] subArray = new Persona[2];
        subArray[0] = examen.personas[0];
        // Cambiando una Persona que ya existe.
        // subArray[1] = examen.personas[1];
        // subArray[0].setPokemon(null);
        // Creando una persona de 0
        subArray[1] = new Persona("", "", null, true, true);
        Assertions.assertThrows(PokemonNuloException.class, () -> examen.obtenerPokemonPorNombreYNivel(subArray, "",100));
    }


    @Test
    public void testBuscarPorNombreYNivel_PokemonNoEncontrado() {
        Persona[] subArray = new Persona[2];
        subArray[0] = examen.personas[0];
        subArray[1] = examen.personas[1];

        Assertions.assertThrows(PokemonNoEncontrado.class, () -> examen.obtenerPokemonPorNombreYNivel(subArray, "Charmander",1));
    }


    // TODO: (2,5 puntos) Piensa en que test son necesarios para probar la función "esPokemonObediente" y realizalos.
    //  Si la persona es null deberá devolver la excepción PersonaNulaException
    //  Si el pokemon tiene un nivel igual a 0 debe devolver la excepcion PokemonFallido
    //  Si la pokemon es null debe devolver PokemonNuloException:
    //  Si la persona tiene la medalla 1, los pokémon le obedecen hasta el nivel 10 (no incluido) como máximo. La función devuelve true
    //  Si la persona tiene la medalla 2, los pokémon le obedecen hasta el nivel 20 (no incluido) como máximo. La función devuelve true
    @Test
    public void testEsPokemonObediente_XXX() {
        // TODO 2,5p
        // PersonasFun.Companion.esPokemonObediente(examen.personas[0]);

    }

    // TODO: (2,5 puntos) Piensa en que test son necesarios para probar la función "corroborarTipo" y realizalos.
    //  Si el Pokémon es null deberá devolver PokemonNuloException
    //  Si el Pokémon no es ni Charmander, ni Mew ni Pikachu, devolverá PokemonFallidoException
    //  Si la pokemon es ni Charmander, devolverá "Fuego"
    //  Si la pokemon es ni Pikachu, devolverá "Eléctrico"
    //  Si la pokemon es ni Mew, devolverá "Psíquico"
    @Test
    public void testTipoPokemon_XXX() {
        // TODO 2,5p
        // PersonasFun.Companion.corroborarTipo(examen.personas[0].getPokemon());

    }

}