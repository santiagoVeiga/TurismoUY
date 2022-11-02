/**
 * DataColeccionObject.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public class DataColeccionObject  implements java.io.Serializable {
    private java.lang.Object[] array;

    private java.lang.Object[] set;

    public DataColeccionObject() {
    }

    public DataColeccionObject(
           java.lang.Object[] array,
           java.lang.Object[] set) {
           this.array = array;
           this.set = set;
    }


    /**
     * Gets the array value for this DataColeccionObject.
     * 
     * @return array
     */
    public java.lang.Object[] getArray() {
        return array;
    }


    /**
     * Sets the array value for this DataColeccionObject.
     * 
     * @param array
     */
    public void setArray(java.lang.Object[] array) {
        this.array = array;
    }

    public java.lang.Object getArray(int i) {
        return this.array[i];
    }

    public void setArray(int i, java.lang.Object _value) {
        this.array[i] = _value;
    }


    /**
     * Gets the set value for this DataColeccionObject.
     * 
     * @return set
     */
    public java.lang.Object[] getSet() {
        return set;
    }


    /**
     * Sets the set value for this DataColeccionObject.
     * 
     * @param set
     */
    public void setSet(java.lang.Object[] set) {
        this.set = set;
    }

    public java.lang.Object getSet(int i) {
        return this.set[i];
    }

    public void setSet(int i, java.lang.Object _value) {
        this.set[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataColeccionObject)) return false;
        DataColeccionObject other = (DataColeccionObject) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.array==null && other.getArray()==null) || 
             (this.array!=null &&
              java.util.Arrays.equals(this.array, other.getArray()))) &&
            ((this.set==null && other.getSet()==null) || 
             (this.set!=null &&
              java.util.Arrays.equals(this.set, other.getSet())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getArray() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArray());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArray(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataColeccionObject.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataColeccionObject"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("array");
        elemField.setXmlName(new javax.xml.namespace.QName("", "array"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("set");
        elemField.setXmlName(new javax.xml.namespace.QName("", "set"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
