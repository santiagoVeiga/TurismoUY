package excepciones;

@SuppressWarnings("serial")
public class TuristaNoHaNacido extends Exception {
	public TuristaNoHaNacido(String string) {
		super(string);
	}
}
