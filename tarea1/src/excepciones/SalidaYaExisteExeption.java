package excepciones;

@SuppressWarnings("serial")
public class SalidaYaExisteExeption extends Exception {
    public SalidaYaExisteExeption(String string) {
        super(string);
    }
}
