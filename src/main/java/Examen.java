import java.util.Arrays;

public class Examen {

    public Persona[] personas;

    public Examen() {
        personas = ObtenerPersonasRequest.Companion.get();
    }


    /**
     * busca en personas aquellas personas que son hombres y devuelve una array de "Personas" con ellas
     * @return array con las personas que son hombres
     */
    public Persona[] obtenerHombres() {
        // TODO 0.5p
        Persona[] out = new Persona[personas.length];
        int contador = 0;
        for (Persona p: personas){
            if (p.getGenero().contentEquals("hombre")) {
                out[contador] = p;
                contador++;
            }
        }
        return getArraySinNulos(out,contador);
    }

    /**
     * busca en personas aquellas personas que son mujeres y devuelve una array de "Personas" con ellas
     * @return array con las personas que son mujeres
     * @param subArray array de personas sobre las que vas a buscar
     * @throws PersonaNulaException cuando encuentras una persona que es null
     * @throws NullPointerException cuando subArray es null
     */
    public Persona[] obtenerMujeres(Persona[] subArray) throws PersonaNulaException {
        // TODO 1p
        Persona[] out = new Persona[subArray.length];
        int contador = 0;
        for (Persona p: subArray){
            if (p == null) throw new PersonaNulaException();
            if (p.getGenero().contentEquals("mujer")) {
                out[contador] = p;
                contador++;
            }
        }
        return getArraySinNulos(out,contador);
    }

    /**
     * busca en personas aquellas personas que tienen un pikachu como pokémon y devuelve una array de "Personas" formado por esas personas
     * @return array con las personas que son tienen un pikachu
     * @param subArray array de personas sobre las que vas a buscar
     * @throws PersonaNulaException cuando encuentras una persona que es null
     * @throws PokemonNuloException cuando encuentras un pokemon que es null
     * @throws NullPointerException cuando subArray es null
     */
    public Persona[] obtenerPikachus(Persona[] subArray) throws PersonaNulaException, PokemonNuloException {
        // TODO 1,5p
        Persona[] out = new Persona[subArray.length];
        int contador = 0;
        for (Persona p: subArray){
            if (p == null) throw new PersonaNulaException();
            if (p.getPokemon() == null) throw new PokemonNuloException();
            if (p.getPokemon().getName().contentEquals("Pikachu")) {
                out[contador] = p;
                contador++;
            }
        }
        return getArraySinNulos(out,contador);
    }

    /**
     * busca en personas aquellas personas que tienen un pokemon que se llama como "nombrePokemon" y que tiene como mínimo el nivel de "nivel"
     * @return un array con las personas que cumple el criterio anterior
     * @param subArray array de personas sobre las que vas a buscar
     * @param nivel nivel mínimo el pokémon buscado
     * @param nombrePokemon nombrePokemon del pokemon buscado
     * @throws PersonaNulaException cuando encuentras una persona que es null
     * @throws PokemonNuloException cuando encuentras un pokemon que es null
     * @throws NullPointerException cuando subArray o nombrePokemon es null
     * @throws PokemonNoEncontrado cuando el nombrePokemon no coincide con el nombrePokemon de ningún pokemon
     */
    public Persona[] obtenerPokemonPorNombreYNivel(Persona[] subArray, String nombrePokemon, int nivel) throws PersonaNulaException, PokemonNuloException, PokemonNoEncontrado {
        // TODO 2p
        Persona[] out = new Persona[subArray.length];
        int contador = 0;
        boolean encontrado = false;
        for (Persona p: subArray){
            if (p == null) throw new PersonaNulaException();
            if (p.getPokemon() == null) throw new PokemonNuloException();
            if (p.getPokemon().getName().contentEquals(nombrePokemon)) {
                encontrado = true;
                if (p.getPokemon().getNivel() > nivel) {
                    out[contador] = p;
                    contador++;
                }
            }
        }
        if (!encontrado) throw new PokemonNoEncontrado();
        return getArraySinNulos(out,contador);
    }


    public Persona[] getArraySinNulos(Persona[] persona, int comienzoNulos) {
        return Arrays.copyOfRange(persona, 0, comienzoNulos);
    }
}
