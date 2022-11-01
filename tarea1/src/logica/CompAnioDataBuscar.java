package logica;

import java.util.Comparator;

public class CompAnioDataBuscar implements Comparator<DataBuscar> {
	public CompAnioDataBuscar() {
		
	}
	@Override
	public int compare(DataBuscar dtb1, DataBuscar dtb2) {
		if ((dtb1 instanceof DataActividad)&&(dtb2 instanceof DataActividad)) {
			DataActividad act1 = (DataActividad) dtb1;
			DataActividad act2 = (DataActividad) dtb2;
			return act2.getFechaAlta().getYear() - act1.getFechaAlta().getYear();
		}
		else if ((dtb1 instanceof DataActividad)&&(dtb2 instanceof DataPaquete)) {
			DataActividad act1 = (DataActividad) dtb1;
			DataPaquete paq1 = (DataPaquete) dtb2;
			return paq1.getFechaAlta().getYear() - act1.getFechaAlta().getYear();
		}
		else if ((dtb1 instanceof DataPaquete)&&(dtb2 instanceof DataActividad)) {
			DataPaquete paq1 = (DataPaquete) dtb1;
			DataActividad act1 = (DataActividad) dtb2;
			return act1.getFechaAlta().getYear() - paq1.getFechaAlta().getYear();
		}
		else {
			DataPaquete paq1 = (DataPaquete) dtb1;
			DataPaquete paq2 = (DataPaquete) dtb2;
			return paq2.getFechaAlta().getYear() - paq1.getFechaAlta().getYear();
		}
	}

}
