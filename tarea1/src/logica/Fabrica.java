package logica;

/**
 * Fábrica para la construcción de un controlador de usuarios (uno distinto para cada invocación).
 * Se implementa en base al patrón Singleton.
 * @author TProg2017
 *
 */
public class Fabrica {

    private static Fabrica instancia;

    private Fabrica() {
    };

    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }

    public IControladorAlta getIControladorAlta() {
        return new ControladorAlta();
    }

	public IControladorInsc getIControladorInsc() {
		return new ControladorInsc();
	}
    
    public IControladorConsulta getIControladorConsulta() {
       return new ControladorConsulta();
    }
}
