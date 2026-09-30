import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Practica1 {

    static public void separa(Set<String> unicos, Set<String> repetidos) {
        Set<String> copia_repetidos = new HashSet<>(repetidos);
        repetidos.retainAll(unicos);
        unicos.addAll(copia_repetidos);
        unicos.removeAll(repetidos);
    }


    static public Set <Integer> filtra(Iterator<Integer> iter) {
        Set<Integer> vistos = new HashSet<>();
        Set<Integer> resultado = new HashSet<>();

        while (iter.hasNext()) {
            Integer dato = iter.next();
            while (dato <= 0) {
                if (dato == null)
                    return resultado;
                dato = iter.next();
            }

            boolean es_multiple = false;

            Iterator<Integer> itera_vistos = vistos.iterator();
            while (itera_vistos.hasNext()) {
                int dato_vistos = itera_vistos.next();
                if (dato % dato_vistos == 0)
                    es_multiple = true;
                else
                    if (dato_vistos % dato == 0)
                        resultado.remove(dato_vistos);
            }

            if (! es_multiple)
                resultado.add(dato);

            vistos.add(dato);
        }

        return resultado;
    }


    static public Set<String> repetidos (Collection<Set<String>> col) {
        Set<String> resultado = new HashSet<>();

        // Iteramos cada set de la coleccion
        Iterator<Set<String>> set_iter = col.iterator();
        while (set_iter.hasNext()){
            Set<String> set_actual = set_iter.next();

            // Iteramos cada elemento de cada Set
            Iterator<String> elem_iter = set_actual.iterator();
            while (elem_iter.hasNext()) {
                String elemento = elem_iter.next();

                int apariciones = 0;

                // Iteramos de nuevo la coleccion
                Iterator<Set<String>> otro_set_iter = col.iterator();
                while (otro_set_iter.hasNext() && apariciones < 2) {
                    Set<String> otro_set = otro_set_iter.next();
                    if (otro_set.contains(elemento))
                        apariciones++;
                }

                if (apariciones >= 2) {
                    resultado.add(elemento);
                }
            }
        }

        return resultado;
    }


    public static Set<Integer> interseccionImpares (Collection<Set<Integer>> col) {
        Iterator<Set<Integer>> set_iter = col.iterator();

        // Entrada vacía
        if (! set_iter.hasNext())
            return new HashSet<>();

        Set<Integer> resultado = new HashSet<>(set_iter.next());

        while (set_iter.hasNext()) {
            resultado.retainAll(set_iter.next());
        }

        // Itera y elimina pares
        Iterator<Integer> pares_iter = resultado.iterator();

        while (pares_iter.hasNext()) {
            if (pares_iter.next() % 2 == 0) {
                pares_iter.remove();
            }
        }

        return resultado;
    }


}
