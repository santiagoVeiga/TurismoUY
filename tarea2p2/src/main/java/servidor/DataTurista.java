/**
 * DataTurista.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public class DataTurista  extends servidor.DataUsuario  implements java.io.Serializable {
    private java.lang.String[] actFavoritas;

    private servidor.DataCompraPaquete[] comprasPaq;

    private servidor.DataCompraGeneral[] inscripcionesSal;

    public DataTurista() {
    }

    public DataTurista(
           java.lang.String apellido,
           java.lang.String mail,
           java.util.Calendar nacimiento,
           java.lang.String nick,
           java.lang.String nombre,
           java.lang.String password,
           java.lang.String[] seguidores,
           java.lang.String[] seguidos,
           java.lang.String[] actFavoritas,
           servidor.DataCompraPaquete[] comprasPaq,
           servidor.DataCompraGeneral[] inscripcionesSal) {
        super(
            apellido,
            mail,
            nacimiento,
            nick,
            nombre,
            password,
            seguidores,
            seguidos);
        this.actFavoritas = actFavoritas;
        this.comprasPaq = comprasPaq;
        this.inscripcionesSal = inscripcionesSal;
    }


    /**
     * Gets the actFavoritas value for this DataTurista.
     * 
     * @return actFavoritas
     */
    public java.lang.String[] getActFavoritas() {
        return actFavoritas;
    }


    /**
     * Sets the actFavoritas value for this DataTurista.
     * 
     * @param actFavoritas
     */
    public void setActFavoritas(java.lang.String[] actFavoritas) {
        this.actFavoritas = actFavoritas;
    }

    public java.lang.String getActFavoritas(int i) {
        return this.actFavoritas[i];
    }

    public void setActFavoritas(int i, java.lang.String _value) {
        this.actFavoritas[i] = _value;
    }


    /**
     * Gets the comprasPaq value for this DataTurista.
     * 
     * @return comprasPaq
     */
    public servidor.DataCompraPaquete[] getComprasPaq() {
        return comprasPaq;
    }


    /**
     * Sets the comprasPaq value for this DataTurista.
     * 
     * @param comprasPaq
     */
    public void setComprasPaq(servidor.DataCompraPaquete[] comprasPaq) {
        this.comprasPaq = comprasPaq;
    }

    public servidor.DataCompraPaquete getComprasPaq(int i) {
        return this.comprasPaq[i];
    }

    public void setComprasPaq(int i, servidor.DataCompraPaquete _value) {
        this.comprasPaq[i] = _value;
    }


    /**
     * Gets the inscripcionesSal value for this DataTurista.
     * 
     * @return inscripcionesSal
     */
    public servidor.DataCompraGeneral[] getInscripcionesSal() {
        return inscripcionesSal;
    }


    /**
     * Sets the inscripcionesSal value for this DataTurista.
     * 
     * @param inscripcionesSal
     */
    public void setInscripcionesSal(servidor.DataCompraGeneral[] inscripcionesSal) {
        this.inscripcionesSal = inscripcionesSal;
    }

    public servidor.DataCompraGeneral getInscripcionesSal(int i) {
        return this.inscripcionesSal[i];
    }

    public void setInscripcionesSal(int i, servidor.DataCompraGeneral _value) {
        this.inscripcionesSal[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataTurista)) return false;
        DataTurista other = (DataTurista) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.actFavoritas==null && other.getActFavoritas()==null) || 
             (this.actFavoritas!=null &&
              java.util.Arrays.equals(this.actFavoritas, other.getActFavoritas()))) &&
            ((this.comprasPaq==null && other.getComprasPaq()==null) || 
             (this.comprasPaq!=null &&
              java.util.Arrays.equals(this.comprasPaq, other.getComprasPaq()))) &&
            ((this.inscripcionesSal==null && other.getInscripcionesSal()==null) || 
             (this.inscripcionesSal!=null &&
              java.util.Arrays.equals(this.inscripcionesSal, other.getInscripcionesSal())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getActFavoritas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getActFavoritas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getActFavoritas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getComprasPaq() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getComprasPaq());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getComprasPaq(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getInscripcionesSal() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getInscripcionesSal());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getInscripcionesSal(), i);
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
        new org.apache.axis.description.TypeDesc(DataTurista.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataTurista"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actFavoritas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actFavoritas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comprasPaq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comprasPaq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataCompraPaquete"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("inscripcionesSal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "inscripcionesSal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataCompraGeneral"));
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
