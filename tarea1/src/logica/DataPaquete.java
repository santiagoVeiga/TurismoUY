package logica;

import java.util.*;

public class DataPaquete {
	
	private String N;
	private String D;
	private String desc;
	private Date F;
	private String V;

	public DataPaquete(String N,String D,String desc,Date F,String V)
	{
		this.N = N;
		this.D = D;
		this.desc = desc;
		this.F = F;
		this.V = V;
	}
	
	public String getNombre() {
		// TODO Auto-generated method stub
		return N;
	}

	public String getDescripcion() {
		// TODO Auto-generated method stub
		return D;
	}

	public Date getFechaAlta() {
		// TODO Auto-generated method stub
		return F;
	}

	public String getDescuento() {
		// TODO Auto-generated method stub
		return desc;
	}

	public String getValidez() {
		// TODO Auto-generated method stub
		return V;
	}

}
