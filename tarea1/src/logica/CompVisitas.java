package logica;

import java.util.Comparator;

public class CompVisitas implements Comparator<DataVisitas> {
	public CompVisitas() {
		
	}

	@Override
	public int compare(DataVisitas o1, DataVisitas o2) {
		return o1.getCantVis() - o2.getCantVis();
	}

}
