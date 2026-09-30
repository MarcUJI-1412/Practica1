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
                dato = iter.next();
                if (dato == null)
                    return resultado;
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
        Iterator<Set<String>> col_iter = col.iterator();
        while (col_iter.hasNext()){
            return null;
        }
        return null;
    }


    public static Set<Integer> interseccionImpares (Collection<Set<Integer>> col) {
       return null;
    }


}
