package logica;

public class InscripcionesPK {
	private int salida;
    private int turista;

    public int getSalida() {
		return salida;
	}

	public void setSalida(int salida) {
		this.salida = salida;
	}

	public int getTurista() {
		return turista;
	}

	public void setTurista(int id_turista) {
		this.turista = id_turista;
	}

	public InscripcionesPK() {
    }

    public int hashCode() {
    	
        return (int) Integer.valueOf(turista).hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof InscripcionesPK)) return false;
        InscripcionesPK pk = (InscripcionesPK) obj;
        return pk.turista == this.getTurista() && pk.salida == this.getSalida();
    }
}
