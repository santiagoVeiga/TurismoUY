package excepciones;


@SuppressWarnings("serial")
public class DepartamentoYaExisteExeption extends Exception {

    public DepartamentoYaExisteExeption(String string) {
        super(string);
    }

}
