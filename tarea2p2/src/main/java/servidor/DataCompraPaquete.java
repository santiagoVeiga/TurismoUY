/**
 * DataCompraPaquete.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public class DataCompraPaquete  implements java.io.Serializable {
    private int cantidad;

    private float costo;

    private java.util.Calendar fecha;

    private servidor.DataPaquete paq;

    private servidor.DataCompraPaqueteRestActEntry[] restAct;

    private java.util.Calendar vencimiento;

    public DataCompraPaquete() {
    }

    public DataCompraPaquete(
           int cantidad,
           float costo,
           java.util.Calendar fecha,
           servidor.DataPaquete paq,
           servidor.DataCompraPaqueteRestActEntry[] restAct,
           java.util.Calendar vencimiento) {
           this.cantidad = cantidad;
           this.costo = costo;
           this.fecha = fecha;
           this.paq = paq;
           this.restAct = restAct;
           this.vencimiento = vencimiento;
    }


    /**
     * Gets the cantidad value for this DataCompraPaquete.
     * 
     * @return cantidad
     */
    public int getCantidad() {
        return cantidad;
    }


    /**
     * Sets the cantidad value for this DataCompraPaquete.
     * 
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    /**
     * Gets the costo value for this DataCompraPaquete.
     * 
     * @return costo
     */
    public float getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this DataCompraPaquete.
     * 
     * @param costo
     */
    public void setCosto(float costo) {
        this.costo = costo;
    }


    /**
     * Gets the fecha value for this DataCompraPaquete.
     * 
     * @return fecha
     */
    public java.util.Calendar getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this DataCompraPaquete.
     * 
     * @param fecha
     */
    public void setFecha(java.util.Calendar fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the paq value for this DataCompraPaquete.
     * 
     * @return paq
     */
    public servidor.DataPaquete getPaq() {
        return paq;
    }


    /**
     * Sets the paq value for this DataCompraPaquete.
     * 
     * @param paq
     */
    public void setPaq(servidor.DataPaquete paq) {
        this.paq = paq;
    }


    /**
     * Gets the restAct value for this DataCompraPaquete.
     * 
     * @return restAct
     */
    public servidor.DataCompraPaqueteRestActEntry[] getRestAct() {
        return restAct;
    }


    /**
     * Sets the restAct value for this DataCompraPaquete.
     * 
     * @param restAct
     */
    public void setRestAct(servidor.DataCompraPaqueteRestActEntry[] restAct) {
        this.restAct = restAct;
    }


    /**
     * Gets the vencimiento value for this DataCompraPaquete.
     * 
     * @return vencimiento
     */
    public java.util.Calendar getVencimiento() {
        return vencimiento;
    }


    /**
     * Sets the vencimiento value for this DataCompraPaquete.
     * 
     * @param vencimiento
     */
    public void setVencimiento(java.util.Calendar vencimiento) {
        this.vencimiento = vencimiento;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataCompraPaquete)) return false;
        DataCompraPaquete other = (DataCompraPaquete) obj;
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
            ((this.paq==null && other.getPaq()==null) || 
             (this.paq!=null &&
              this.paq.equals(other.getPaq()))) &&
            ((this.restAct==null && other.getRestAct()==null) || 
             (this.restAct!=null &&
              java.util.Arrays.equals(this.restAct, other.getRestAct()))) &&
            ((this.vencimiento==null && other.getVencimiento()==null) || 
             (this.vencimiento!=null &&
              this.vencimiento.equals(other.getVencimiento())));
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
        _hashCode += new Float(getCosto()).hashCode();
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getPaq() != null) {
            _hashCode += getPaq().hashCode();
        }
        if (getRestAct() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRestAct());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRestAct(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getVencimiento() != null) {
            _hashCode += getVencimiento().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DataCompraPaquete.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataCompraPaquete"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantidad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantidad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
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
        elemField.setFieldName("paq");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paq"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataPaquete"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("restAct");
        elemField.setXmlName(new javax.xml.namespace.QName("", "restAct"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", ">>dataCompraPaquete>restAct>entry"));
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("", "entry"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("vencimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "vencimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
