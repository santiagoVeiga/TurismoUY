package logica;

import java.util.Date;

public class Paquete {

	private String N;
	private String D;
	private String desc;
	private Date F;
	private String V;

	public Paquete(String N,String D,String desc,Date F,String V)
	{
		this.N = N;
		this.D = D;
		this.desc = desc;
		this.F = F;
		this.V = V;
	}
	
	public DataPaquete getDataP()
	{
		return new DataPaquete(N, D, desc, F, V);
	}
	
}
