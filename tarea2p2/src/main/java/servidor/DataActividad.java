/**
 * DataActividad.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public class DataActividad  extends servidor.DataBuscar  implements java.io.Serializable {
    private java.lang.String[] categorias;

    private java.lang.String ciudad;

    private int costo;

    private java.lang.String departamento;

    private java.lang.String descripcion;

    private int duracion;

    private servidor.EstadoAct estado;

    private java.util.Calendar fechaAlta;

    private java.lang.String imagen;

    private java.lang.String nombre;

    private java.lang.String[] paquetes;

    private servidor.DataSalida[] salidas;

    public DataActividad() {
    }

    public DataActividad(
           java.lang.String[] categorias,
           java.lang.String ciudad,
           int costo,
           java.lang.String departamento,
           java.lang.String descripcion,
           int duracion,
           servidor.EstadoAct estado,
           java.util.Calendar fechaAlta,
           java.lang.String imagen,
           java.lang.String nombre,
           java.lang.String[] paquetes,
           servidor.DataSalida[] salidas) {
        this.categorias = categorias;
        this.ciudad = ciudad;
        this.costo = costo;
        this.departamento = departamento;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.fechaAlta = fechaAlta;
        this.imagen = imagen;
        this.nombre = nombre;
        this.paquetes = paquetes;
        this.salidas = salidas;
    }


    /**
     * Gets the categorias value for this DataActividad.
     * 
     * @return categorias
     */
    public java.lang.String[] getCategorias() {
        return categorias;
    }


    /**
     * Sets the categorias value for this DataActividad.
     * 
     * @param categorias
     */
    public void setCategorias(java.lang.String[] categorias) {
        this.categorias = categorias;
    }

    public java.lang.String getCategorias(int i) {
        return this.categorias[i];
    }

    public void setCategorias(int i, java.lang.String _value) {
        this.categorias[i] = _value;
    }


    /**
     * Gets the ciudad value for this DataActividad.
     * 
     * @return ciudad
     */
    public java.lang.String getCiudad() {
        return ciudad;
    }


    /**
     * Sets the ciudad value for this DataActividad.
     * 
     * @param ciudad
     */
    public void setCiudad(java.lang.String ciudad) {
        this.ciudad = ciudad;
    }


    /**
     * Gets the costo value for this DataActividad.
     * 
     * @return costo
     */
    public int getCosto() {
        return costo;
    }


    /**
     * Sets the costo value for this DataActividad.
     * 
     * @param costo
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }


    /**
     * Gets the departamento value for this DataActividad.
     * 
     * @return departamento
     */
    public java.lang.String getDepartamento() {
        return departamento;
    }


    /**
     * Sets the departamento value for this DataActividad.
     * 
     * @param departamento
     */
    public void setDepartamento(java.lang.String departamento) {
        this.departamento = departamento;
    }


    /**
     * Gets the descripcion value for this DataActividad.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this DataActividad.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the duracion value for this DataActividad.
     * 
     * @return duracion
     */
    public int getDuracion() {
        return duracion;
    }


    /**
     * Sets the duracion value for this DataActividad.
     * 
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    /**
     * Gets the estado value for this DataActividad.
     * 
     * @return estado
     */
    public servidor.EstadoAct getEstado() {
        return estado;
    }


    /**
     * Sets the estado value for this DataActividad.
     * 
     * @param estado
     */
    public void setEstado(servidor.EstadoAct estado) {
        this.estado = estado;
    }


    /**
     * Gets the fechaAlta value for this DataActividad.
     * 
     * @return fechaAlta
     */
    public java.util.Calendar getFechaAlta() {
        return fechaAlta;
    }


    /**
     * Sets the fechaAlta value for this DataActividad.
     * 
     * @param fechaAlta
     */
    public void setFechaAlta(java.util.Calendar fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    /**
     * Gets the imagen value for this DataActividad.
     * 
     * @return imagen
     */
    public java.lang.String getImagen() {
        return imagen;
    }


    /**
     * Sets the imagen value for this DataActividad.
     * 
     * @param imagen
     */
    public void setImagen(java.lang.String imagen) {
        this.imagen = imagen;
    }


    /**
     * Gets the nombre value for this DataActividad.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DataActividad.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the paquetes value for this DataActividad.
     * 
     * @return paquetes
     */
    public java.lang.String[] getPaquetes() {
        return paquetes;
    }


    /**
     * Sets the paquetes value for this DataActividad.
     * 
     * @param paquetes
     */
    public void setPaquetes(java.lang.String[] paquetes) {
        this.paquetes = paquetes;
    }

    public java.lang.String getPaquetes(int i) {
        return this.paquetes[i];
    }

    public void setPaquetes(int i, java.lang.String _value) {
        this.paquetes[i] = _value;
    }


    /**
     * Gets the salidas value for this DataActividad.
     * 
     * @return salidas
     */
    public servidor.DataSalida[] getSalidas() {
        return salidas;
    }


    /**
     * Sets the salidas value for this DataActividad.
     * 
     * @param salidas
     */
    public void setSalidas(servidor.DataSalida[] salidas) {
        this.salidas = salidas;
    }

    public servidor.DataSalida getSalidas(int i) {
        return this.salidas[i];
    }

    public void setSalidas(int i, servidor.DataSalida _value) {
        this.salidas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataActividad)) return false;
        DataActividad other = (DataActividad) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.categorias==null && other.getCategorias()==null) || 
             (this.categorias!=null &&
              java.util.Arrays.equals(this.categorias, other.getCategorias()))) &&
            ((this.ciudad==null && other.getCiudad()==null) || 
             (this.ciudad!=null &&
              this.ciudad.equals(other.getCiudad()))) &&
            this.costo == other.getCosto() &&
            ((this.departamento==null && other.getDepartamento()==null) || 
             (this.departamento!=null &&
              this.departamento.equals(other.getDepartamento()))) &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.duracion == other.getDuracion() &&
            ((this.estado==null && other.getEstado()==null) || 
             (this.estado!=null &&
              this.estado.equals(other.getEstado()))) &&
            ((this.fechaAlta==null && other.getFechaAlta()==null) || 
             (this.fechaAlta!=null &&
              this.fechaAlta.equals(other.getFechaAlta()))) &&
            ((this.imagen==null && other.getImagen()==null) || 
             (this.imagen!=null &&
              this.imagen.equals(other.getImagen()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.paquetes==null && other.getPaquetes()==null) || 
             (this.paquetes!=null &&
              java.util.Arrays.equals(this.paquetes, other.getPaquetes()))) &&
            ((this.salidas==null && other.getSalidas()==null) || 
             (this.salidas!=null &&
              java.util.Arrays.equals(this.salidas, other.getSalidas())));
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
        if (getCategorias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategorias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategorias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCiudad() != null) {
            _hashCode += getCiudad().hashCode();
        }
        _hashCode += getCosto();
        if (getDepartamento() != null) {
            _hashCode += getDepartamento().hashCode();
        }
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getDuracion();
        if (getEstado() != null) {
            _hashCode += getEstado().hashCode();
        }
        if (getFechaAlta() != null) {
            _hashCode += getFechaAlta().hashCode();
        }
        if (getImagen() != null) {
            _hashCode += getImagen().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getPaquetes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPaquetes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPaquetes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSalidas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSalidas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSalidas(), i);
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
        new org.apache.axis.description.TypeDesc(DataActividad.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataActividad"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categorias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ciudad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ciudad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("costo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "costo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("departamento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "departamento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", "estadoAct"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaAlta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaAlta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("paquetes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "paquetes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salidas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "salidas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataSalida"));
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
