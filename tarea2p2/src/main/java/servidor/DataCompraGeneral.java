/**
 * DataCompraGeneral.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public class DataCompraGeneral  implements java.io.Serializable {
    private int cantidad;

    private int costo;

    private java.util.Calendar fecha;

    private boolean porPaquete;

    private servidor.DataSalida salida;

    public DataCompraGeneral() {
    }

    public DataCompraGeneral(
           int cantidad,
           int costo,
           java.util.Calendar fecha,
           boolean porPaquete,
           servidor.DataSalida salida) {
           this.cantidad = cantidad;
           this.costo = costo;
           this.fecha = fecha;
           this.porPaquete = porPaquete;
           this.salida = salida;
    }


    /**
     * Gets the cantidad value for this DataCompraGeneral.
     * 
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this DataCompraGeneral.
     * 
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the costo value for this DataCompraGeneral.
     * 
     * @return costo
     */
    public int getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this DataCompraGeneral.
     * 
     * @param costo
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }


    /**
     * Gets the fecha value for this DataCompraGeneral.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this DataCompraGeneral.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the porPaquete value for this DataCompraGeneral.
     * 
     * @return porPaquete
     */
    public boolean isPorPaquete() {
        return porPaquete;
    }


    /**
     * Sets the porPaquete value for this DataCompraGeneral.
     * 
     * @param porPaquete
     */
    public void setPorPaquete(boolean porPaquete) {
        this.porPaquete = porPaquete;
    }


    /**
     * Gets the salida value for this DataCompraGeneral.
     * 
     * @return salida
     */
    public servidor.DataSalida getSalida() {
        return salida;
    }


    /**
     * Sets the salida value for this DataCompraGeneral.
     * 
     * @param salida
     */
    public void setSalida(servidor.DataSalida salida) {
        this.salida = salida;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataCompraGeneral)) return false;
        DataCompraGeneral other = (DataCompraGeneral) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cantidad == other.getCantidad() &&
            this.costo == other.getCosto() &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            this.porPaquete == other.isPorPaquete() &&
            ((this.salida==null && other.getSalida()==null) || 
             (this.salida!=null &&
              this.salida.equals(other.getSalida())));
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
        _hashCode += getCantidad();
        _hashCode += getCosto();
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        _hashCode += (isPorPaquete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getSalida() != null) {
            _hashCode += getSalida().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataCompraGeneral.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataCompraGeneral"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porPaquete");
        elemField.setXmlName(new javax.xml.namespace.QName("", "porPaquete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salida");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salida"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataSalida"));
        elemField.setMinOccurs(0);
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
