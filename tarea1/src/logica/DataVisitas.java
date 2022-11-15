package logica;

public class DataVisitas {
	private boolean esAct;
	private int cantVis;
	private String nombre;
	private String prov;
	

	public DataVisitas(boolean esA, int cVis, String nom, String pro) {
		setEsAct(esA);
		setCantVis(cVis);
		setNombre(nom);
		setProv(pro);
	}


	public boolean isEsAct() {
		return esAct;
	}


	public void setEsAct(boolean esAct) {
		this.esAct = esAct;
	}


	public int getCantVis() {
		return cantVis;
	}


	public void setCantVis(int cantVis) {
		this.cantVis = cantVis;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getProv() {
		return prov;
	}


	public void setProv(String prov) {
		this.prov = prov;
	}
}
