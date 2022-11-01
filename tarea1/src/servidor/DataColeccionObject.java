package servidor;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DataColeccionObject {
	private Set<Object> set;
	private Object[] array;
	
	public DataColeccionObject(Set<Object> elset) {
		setSet(elset);
		int tamanio = set.size();
        Object[] arrayAux = new Object[tamanio];
        int iter = 0;
        for (Object asig : set)
            arrayAux[iter++] = asig;
        setArray(arrayAux);
	}
	
	public DataColeccionObject(Object[] arr) {
		set = new HashSet<Object>();
		Collections.addAll(set,arr);
		setArray(arr);
	}

	public Set<Object> getSet() {
		return set;
	}

	public void setSet(Set<Object> set) {
		this.set = set;
	}

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object[] array) {
		this.array = array;
	}
}
