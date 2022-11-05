package servidor;

public class DataColeccionObject {
	private Object[] array;
	
	public DataColeccionObject(Object[] arr) {
		setArray(arr);
	}

	public Object[] getArray() {
		return array;
	}

	public void setArray(Object[] array) {
		this.array = array;
	}
}
