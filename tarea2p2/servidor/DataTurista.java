
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataTurista complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataTurista">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataUsuario">
 *       &lt;sequence>
 *         &lt;element name="actFavoritas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="comprasPaq" type="{http://servidor/}dataCompraPaquete" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="inscripcionesSal" type="{http://servidor/}dataCompraGeneral" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="paquetes" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataTurista", propOrder = {
    "actFavoritas",
    "comprasPaq",
    "inscripcionesSal",
    "paquetes"
})
public class DataTurista
    extends DataUsuario
{

    @XmlElement(nillable = true)
    protected List<String> actFavoritas;
    @XmlElement(nillable = true)
    protected List<DataCompraPaquete> comprasPaq;
    @XmlElement(nillable = true)
    protected List<DataCompraGeneral> inscripcionesSal;
    @XmlElement(nillable = true)
    protected List<String> paquetes;

    /**
     * Gets the value of the actFavoritas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the actFavoritas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActFavoritas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActFavoritas() {
        if (actFavoritas == null) {
            actFavoritas = new ArrayList<String>();
        }
        return this.actFavoritas;
    }

    /**
     * Gets the value of the comprasPaq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the comprasPaq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getComprasPaq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataCompraPaquete }
     * 
     * 
     */
    public List<DataCompraPaquete> getComprasPaq() {
        if (comprasPaq == null) {
            comprasPaq = new ArrayList<DataCompraPaquete>();
        }
        return this.comprasPaq;
    }

    /**
     * Gets the value of the inscripcionesSal property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inscripcionesSal property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInscripcionesSal().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataCompraGeneral }
     * 
     * 
     */
    public List<DataCompraGeneral> getInscripcionesSal() {
        if (inscripcionesSal == null) {
            inscripcionesSal = new ArrayList<DataCompraGeneral>();
        }
        return this.inscripcionesSal;
    }

    /**
     * Gets the value of the paquetes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paquetes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaquetes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getPaquetes() {
        if (paquetes == null) {
            paquetes = new ArrayList<String>();
        }
        return this.paquetes;
    }

}
