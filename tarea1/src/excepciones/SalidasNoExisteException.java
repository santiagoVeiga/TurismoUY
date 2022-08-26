package excepciones;

@SuppressWarnings("serial")
public class SalidasNoExisteException extends Exception {

    public SalidasNoExisteException(String string) {
        super(string);
    }
}
