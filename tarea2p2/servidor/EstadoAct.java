
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoAct.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoAct">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="agregada"/>
 *     &lt;enumeration value="confirmada"/>
 *     &lt;enumeration value="rechazada"/>
 *     &lt;enumeration value="finalizada"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estadoAct")
@XmlEnum
public enum EstadoAct {

    @XmlEnumValue("agregada")
    AGREGADA("agregada"),
    @XmlEnumValue("confirmada")
    CONFIRMADA("confirmada"),
    @XmlEnumValue("rechazada")
    RECHAZADA("rechazada"),
    @XmlEnumValue("finalizada")
    FINALIZADA("finalizada");
    private final String value;

    EstadoAct(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static EstadoAct fromValue(String v) {
        for (EstadoAct c: EstadoAct.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
