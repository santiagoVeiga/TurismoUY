/**
 * DataPaquete.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public class DataPaquete  extends servidor.DataBuscar  implements java.io.Serializable {
    private java.lang.String descripcion;

    private int descuento;

    private servidor.DataActividad[] dtAct;

    private java.util.Calendar fechaAlta;

    private java.lang.String nombre;

    private int validez;

    public DataPaquete() {
    }

    public DataPaquete(
           java.lang.String descripcion,
           int descuento,
           servidor.DataActividad[] dtAct,
           java.util.Calendar fechaAlta,
           java.lang.String nombre,
           int validez) {
        this.descripcion = descripcion;
        this.descuento = descuento;
        this.dtAct = dtAct;
        this.fechaAlta = fechaAlta;
        this.nombre = nombre;
        this.validez = validez;
    }


    /**
     * Gets the descripcion value for this DataPaquete.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DataPaquete.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the descuento value for this DataPaquete.
     * 
     * @return descuento
     */
    public int getDescuento() {
        return descuento;
    }


    /**
     * Sets the descuento value for this DataPaquete.
     * 
     * @param descuento
     */
    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }


    /**
     * Gets the dtAct value for this DataPaquete.
     * 
     * @return dtAct
     */
    public servidor.DataActividad[] getDtAct() {
        return dtAct;
    }


    /**
     * Sets the dtAct value for this DataPaquete.
     * 
     * @param dtAct
     */
    public void setDtAct(servidor.DataActividad[] dtAct) {
        this.dtAct = dtAct;
    }

    public servidor.DataActividad getDtAct(int i) {
        return this.dtAct[i];
    }

    public void setDtAct(int i, servidor.DataActividad _value) {
        this.dtAct[i] = _value;
    }


    /**
     * Gets the fechaAlta value for this DataPaquete.
     * 
     * @return fechaAlta
     */
    public java.util.Calendar getFechaAlta() {
        return fechaAlta;
    }


    /**
     * Sets the fechaAlta value for this DataPaquete.
     * 
     * @param fechaAlta
     */
    public void setFechaAlta(java.util.Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    /**
     * Gets the nombre value for this DataPaquete.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DataPaquete.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the validez value for this DataPaquete.
     * 
     * @return validez
     */
    public int getValidez() {
        return validez;
    }


    /**
     * Sets the validez value for this DataPaquete.
     * 
     * @param validez
     */
    public void setValidez(int validez) {
        this.validez = validez;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataPaquete)) return false;
        DataPaquete other = (DataPaquete) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.descuento == other.getDescuento() &&
            ((this.dtAct==null && other.getDtAct()==null) || 
             (this.dtAct!=null &&
              java.util.Arrays.equals(this.dtAct, other.getDtAct()))) &&
            ((this.fechaAlta==null && other.getFechaAlta()==null) || 
             (this.fechaAlta!=null &&
              this.fechaAlta.equals(other.getFechaAlta()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            this.validez == other.getValidez();
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getDescuento();
        if (getDtAct() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDtAct());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDtAct(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFechaAlta() != null) {
            _hashCode += getFechaAlta().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        _hashCode += getValidez();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataPaquete.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataPaquete"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descuento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descuento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dtAct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "dtAct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataActividad"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaAlta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaAlta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("validez");
        elemField.setXmlName(new javax.xml.namespace.QName("", "validez"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
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
