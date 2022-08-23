package excepciones;

@SuppressWarnings("serial")
public class DepartamentoNoExisteException extends Exception {

    public DepartamentoNoExisteException(String string) {
        super(string);
    }
}

