package servidor;

public class DataColeccionObject {
	private Object[] array;
	private Object obj = null;
	
	public DataColeccionObject() {
		
	}
	
	public DataColeccionObject(Object[] arr) {
		setArray(arr);
	}

	public Object[] getArray() {
		return array;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public void setArray(Object[] array) {
		this.array = array;
	}
}
