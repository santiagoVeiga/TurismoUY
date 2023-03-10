/**
 * DataUsuario.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public class DataUsuario  implements java.io.Serializable {
    private java.lang.String apellido;

    private java.lang.String imagen;

    private java.lang.String mail;

    private java.util.Calendar nacimiento;

    private java.lang.String nick;

    private java.lang.String nombre;

    private java.lang.String password;

    private java.lang.String[] seguidores;

    private java.lang.String[] seguidos;

    public DataUsuario() {
    }

    public DataUsuario(
           java.lang.String apellido,
           java.lang.String imagen,
           java.lang.String mail,
           java.util.Calendar nacimiento,
           java.lang.String nick,
           java.lang.String nombre,
           java.lang.String password,
           java.lang.String[] seguidores,
           java.lang.String[] seguidos) {
           this.apellido = apellido;
           this.imagen = imagen;
           this.mail = mail;
           this.nacimiento = nacimiento;
           this.nick = nick;
           this.nombre = nombre;
           this.password = password;
           this.seguidores = seguidores;
           this.seguidos = seguidos;
    }


    /**
     * Gets the apellido value for this DataUsuario.
     * 
     * @return apellido
     */
    public java.lang.String getApellido() {
        return apellido;
    }


    /**
     * Sets the apellido value for this DataUsuario.
     * 
     * @param apellido
     */
    public void setApellido(java.lang.String apellido) {
        this.apellido = apellido;
    }


    /**
     * Gets the imagen value for this DataUsuario.
     * 
     * @return imagen
     */
    public java.lang.String getImagen() {
        return imagen;
    }


    /**
     * Sets the imagen value for this DataUsuario.
     * 
     * @param imagen
     */
    public void setImagen(java.lang.String imagen) {
        this.imagen = imagen;
    }


    /**
     * Gets the mail value for this DataUsuario.
     * 
     * @return mail
     */
    public java.lang.String getMail() {
        return mail;
    }


    /**
     * Sets the mail value for this DataUsuario.
     * 
     * @param mail
     */
    public void setMail(java.lang.String mail) {
        this.mail = mail;
    }


    /**
     * Gets the nacimiento value for this DataUsuario.
     * 
     * @return nacimiento
     */
    public java.util.Calendar getNacimiento() {
        return nacimiento;
    }


    /**
     * Sets the nacimiento value for this DataUsuario.
     * 
     * @param nacimiento
     */
    public void setNacimiento(java.util.Calendar nacimiento) {
        this.nacimiento = nacimiento;
    }


    /**
     * Gets the nick value for this DataUsuario.
     * 
     * @return nick
     */
    public java.lang.String getNick() {
        return nick;
    }


    /**
     * Sets the nick value for this DataUsuario.
     * 
     * @param nick
     */
    public void setNick(java.lang.String nick) {
        this.nick = nick;
    }


    /**
     * Gets the nombre value for this DataUsuario.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this DataUsuario.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the password value for this DataUsuario.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this DataUsuario.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the seguidores value for this DataUsuario.
     * 
     * @return seguidores
     */
    public java.lang.String[] getSeguidores() {
        return seguidores;
    }


    /**
     * Sets the seguidores value for this DataUsuario.
     * 
     * @param seguidores
     */
    public void setSeguidores(java.lang.String[] seguidores) {
        this.seguidores = seguidores;
    }

    public java.lang.String getSeguidores(int i) {
        return this.seguidores[i];
    }

    public void setSeguidores(int i, java.lang.String _value) {
        this.seguidores[i] = _value;
    }


    /**
     * Gets the seguidos value for this DataUsuario.
     * 
     * @return seguidos
     */
    public java.lang.String[] getSeguidos() {
        return seguidos;
    }


    /**
     * Sets the seguidos value for this DataUsuario.
     * 
     * @param seguidos
     */
    public void setSeguidos(java.lang.String[] seguidos) {
        this.seguidos = seguidos;
    }

    public java.lang.String getSeguidos(int i) {
        return this.seguidos[i];
    }

    public void setSeguidos(int i, java.lang.String _value) {
        this.seguidos[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DataUsuario)) return false;
        DataUsuario other = (DataUsuario) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.apellido==null && other.getApellido()==null) || 
             (this.apellido!=null &&
              this.apellido.equals(other.getApellido()))) &&
            ((this.imagen==null && other.getImagen()==null) || 
             (this.imagen!=null &&
              this.imagen.equals(other.getImagen()))) &&
            ((this.mail==null && other.getMail()==null) || 
             (this.mail!=null &&
              this.mail.equals(other.getMail()))) &&
            ((this.nacimiento==null && other.getNacimiento()==null) || 
             (this.nacimiento!=null &&
              this.nacimiento.equals(other.getNacimiento()))) &&
            ((this.nick==null && other.getNick()==null) || 
             (this.nick!=null &&
              this.nick.equals(other.getNick()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.seguidores==null && other.getSeguidores()==null) || 
             (this.seguidores!=null &&
              java.util.Arrays.equals(this.seguidores, other.getSeguidores()))) &&
            ((this.seguidos==null && other.getSeguidos()==null) || 
             (this.seguidos!=null &&
              java.util.Arrays.equals(this.seguidos, other.getSeguidos())));
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
        if (getApellido() != null) {
            _hashCode += getApellido().hashCode();
        }
        if (getImagen() != null) {
            _hashCode += getImagen().hashCode();
        }
        if (getMail() != null) {
            _hashCode += getMail().hashCode();
        }
        if (getNacimiento() != null) {
            _hashCode += getNacimiento().hashCode();
        }
        if (getNick() != null) {
            _hashCode += getNick().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getSeguidores() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSeguidores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSeguidores(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSeguidos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSeguidos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSeguidos(), i);
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
        new org.apache.axis.description.TypeDesc(DataUsuario.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://servidor/", "dataUsuario"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apellido");
        elemField.setXmlName(new javax.xml.namespace.QName("", "apellido"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("mail");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mail"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nacimiento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nacimiento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nick");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nick"));
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
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seguidores");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seguidores"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seguidos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seguidos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
