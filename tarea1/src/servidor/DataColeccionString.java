package servidor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DataColeccionString {
	private Set<String> set;
	private String[] array;
	
	public DataColeccionString(Set<String> elset) {
		set = elset;
		int tamanio = set.size();
        array = new String[tamanio];
        int iter = 0;
        for (String asig : set)
            array[iter++] = asig;
	}
	
	public DataColeccionString(String[] arr) {
		set = new HashSet<String>();
		Collections.addAll(set,arr);
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}
}
