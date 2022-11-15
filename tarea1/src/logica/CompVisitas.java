package logica;

import java.util.Comparator;

public class CompVisitas implements Comparator<DataVisitas> {
	public CompVisitas() {
		
	}

	@Override
	public int compare(DataVisitas ob1, DataVisitas ob2) {
		return ob2.getCantVis() - ob1.getCantVis();
	}

}
