package excepciones;

@SuppressWarnings("serial")
public class CategoriaYaExiste extends Exception {

    public CategoriaYaExiste(String string) {
        super(string);
    }
}