
package servidor;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the servidor package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _FechaAltaSalidaAnteriorActividad_QNAME = new QName("http://servidor/", "FechaAltaSalidaAnteriorActividad");
    private final static QName _TuristaConSalida_QNAME = new QName("http://servidor/", "TuristaConSalida");
    private final static QName _ActividadNoExisteException_QNAME = new QName("http://servidor/", "ActividadNoExisteException");
    private final static QName _UsuarioRepetidoException_QNAME = new QName("http://servidor/", "UsuarioRepetidoException");
    private final static QName _FechaAltaSalidaInvalida_QNAME = new QName("http://servidor/", "FechaAltaSalidaInvalida");
    private final static QName _IOException_QNAME = new QName("http://servidor/", "IOException");
    private final static QName _PaqueteNoExisteException_QNAME = new QName("http://servidor/", "PaqueteNoExisteException");
    private final static QName _SalidasVigentesException_QNAME = new QName("http://servidor/", "SalidasVigentesException");
    private final static QName _InscFechaDespSalida_QNAME = new QName("http://servidor/", "InscFechaDespSalida");
    private final static QName _SalidaYaExisteExeption_QNAME = new QName("http://servidor/", "SalidaYaExisteExeption");
    private final static QName _UsuarioNoExisteException_QNAME = new QName("http://servidor/", "UsuarioNoExisteException");
    private final static QName _DepartamentoYaExisteExeption_QNAME = new QName("http://servidor/", "DepartamentoYaExisteExeption");
    private final static QName _InscFechaInconsistente_QNAME = new QName("http://servidor/", "InscFechaInconsistente");
    private final static QName _EstadoActividadIncorrecto_QNAME = new QName("http://servidor/", "estadoActividadIncorrecto");
    private final static QName _NoExisteCategoriaException_QNAME = new QName("http://servidor/", "NoExisteCategoriaException");
    private final static QName _NoHayCuposException_QNAME = new QName("http://servidor/", "NoHayCuposException");
    private final static QName _PaqueteRepetidoException_QNAME = new QName("http://servidor/", "PaqueteRepetidoException");
    private final static QName _CategoriaYaExiste_QNAME = new QName("http://servidor/", "CategoriaYaExiste");
    private final static QName _TuristaNoHaNacido_QNAME = new QName("http://servidor/", "TuristaNoHaNacido");
    private final static QName _DepartamentoNoExisteException_QNAME = new QName("http://servidor/", "DepartamentoNoExisteException");
    private final static QName _ActividadRepetidaException_QNAME = new QName("http://servidor/", "ActividadRepetidaException");
    private final static QName _ExcedeTuristas_QNAME = new QName("http://servidor/", "ExcedeTuristas");
    private final static QName _ProveedorNoNacidoException_QNAME = new QName("http://servidor/", "ProveedorNoNacidoException");
    private final static QName _SalidasNoExisteException_QNAME = new QName("http://servidor/", "SalidasNoExisteException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: servidor
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DataCompraPaquete }
     * 
     */
    public DataCompraPaquete createDataCompraPaquete() {
        return new DataCompraPaquete();
    }

    /**
     * Create an instance of {@link DataCompraPaquete.RestAct }
     * 
     */
    public DataCompraPaquete.RestAct createDataCompraPaqueteRestAct() {
        return new DataCompraPaquete.RestAct();
    }

    /**
     * Create an instance of {@link DepartamentoYaExisteExeption }
     * 
     */
    public DepartamentoYaExisteExeption createDepartamentoYaExisteExeption() {
        return new DepartamentoYaExisteExeption();
    }

    /**
     * Create an instance of {@link UsuarioNoExisteException }
     * 
     */
    public UsuarioNoExisteException createUsuarioNoExisteException() {
        return new UsuarioNoExisteException();
    }

    /**
     * Create an instance of {@link SalidaYaExisteExeption }
     * 
     */
    public SalidaYaExisteExeption createSalidaYaExisteExeption() {
        return new SalidaYaExisteExeption();
    }

    /**
     * Create an instance of {@link InscFechaDespSalida }
     * 
     */
    public InscFechaDespSalida createInscFechaDespSalida() {
        return new InscFechaDespSalida();
    }

    /**
     * Create an instance of {@link SalidasVigentesException }
     * 
     */
    public SalidasVigentesException createSalidasVigentesException() {
        return new SalidasVigentesException();
    }

    /**
     * Create an instance of {@link PaqueteNoExisteException }
     * 
     */
    public PaqueteNoExisteException createPaqueteNoExisteException() {
        return new PaqueteNoExisteException();
    }

    /**
     * Create an instance of {@link IOException }
     * 
     */
    public IOException createIOException() {
        return new IOException();
    }

    /**
     * Create an instance of {@link FechaAltaSalidaInvalida }
     * 
     */
    public FechaAltaSalidaInvalida createFechaAltaSalidaInvalida() {
        return new FechaAltaSalidaInvalida();
    }

    /**
     * Create an instance of {@link ActividadNoExisteException }
     * 
     */
    public ActividadNoExisteException createActividadNoExisteException() {
        return new ActividadNoExisteException();
    }

    /**
     * Create an instance of {@link UsuarioRepetidoException }
     * 
     */
    public UsuarioRepetidoException createUsuarioRepetidoException() {
        return new UsuarioRepetidoException();
    }

    /**
     * Create an instance of {@link FechaAltaSalidaAnteriorActividad }
     * 
     */
    public FechaAltaSalidaAnteriorActividad createFechaAltaSalidaAnteriorActividad() {
        return new FechaAltaSalidaAnteriorActividad();
    }

    /**
     * Create an instance of {@link TuristaConSalida }
     * 
     */
    public TuristaConSalida createTuristaConSalida() {
        return new TuristaConSalida();
    }

    /**
     * Create an instance of {@link ActividadRepetidaException }
     * 
     */
    public ActividadRepetidaException createActividadRepetidaException() {
        return new ActividadRepetidaException();
    }

    /**
     * Create an instance of {@link ExcedeTuristas }
     * 
     */
    public ExcedeTuristas createExcedeTuristas() {
        return new ExcedeTuristas();
    }

    /**
     * Create an instance of {@link ProveedorNoNacidoException }
     * 
     */
    public ProveedorNoNacidoException createProveedorNoNacidoException() {
        return new ProveedorNoNacidoException();
    }

    /**
     * Create an instance of {@link SalidasNoExisteException }
     * 
     */
    public SalidasNoExisteException createSalidasNoExisteException() {
        return new SalidasNoExisteException();
    }

    /**
     * Create an instance of {@link DepartamentoNoExisteException }
     * 
     */
    public DepartamentoNoExisteException createDepartamentoNoExisteException() {
        return new DepartamentoNoExisteException();
    }

    /**
     * Create an instance of {@link TuristaNoHaNacido }
     * 
     */
    public TuristaNoHaNacido createTuristaNoHaNacido() {
        return new TuristaNoHaNacido();
    }

    /**
     * Create an instance of {@link CategoriaYaExiste }
     * 
     */
    public CategoriaYaExiste createCategoriaYaExiste() {
        return new CategoriaYaExiste();
    }

    /**
     * Create an instance of {@link PaqueteRepetidoException }
     * 
     */
    public PaqueteRepetidoException createPaqueteRepetidoException() {
        return new PaqueteRepetidoException();
    }

    /**
     * Create an instance of {@link NoHayCuposException }
     * 
     */
    public NoHayCuposException createNoHayCuposException() {
        return new NoHayCuposException();
    }

    /**
     * Create an instance of {@link NoExisteCategoriaException }
     * 
     */
    public NoExisteCategoriaException createNoExisteCategoriaException() {
        return new NoExisteCategoriaException();
    }

    /**
     * Create an instance of {@link EstadoActividadIncorrecto }
     * 
     */
    public EstadoActividadIncorrecto createEstadoActividadIncorrecto() {
        return new EstadoActividadIncorrecto();
    }

    /**
     * Create an instance of {@link InscFechaInconsistente }
     * 
     */
    public InscFechaInconsistente createInscFechaInconsistente() {
        return new InscFechaInconsistente();
    }

    /**
     * Create an instance of {@link DataDepartamento }
     * 
     */
    public DataDepartamento createDataDepartamento() {
        return new DataDepartamento();
    }

    /**
     * Create an instance of {@link DataSalida }
     * 
     */
    public DataSalida createDataSalida() {
        return new DataSalida();
    }

    /**
     * Create an instance of {@link DataColeccionObject }
     * 
     */
    public DataColeccionObject createDataColeccionObject() {
        return new DataColeccionObject();
    }

    /**
     * Create an instance of {@link DataProveedor }
     * 
     */
    public DataProveedor createDataProveedor() {
        return new DataProveedor();
    }

    /**
     * Create an instance of {@link DataActividad }
     * 
     */
    public DataActividad createDataActividad() {
        return new DataActividad();
    }

    /**
     * Create an instance of {@link DataCompraGeneral }
     * 
     */
    public DataCompraGeneral createDataCompraGeneral() {
        return new DataCompraGeneral();
    }

    /**
     * Create an instance of {@link DataUsuario }
     * 
     */
    public DataUsuario createDataUsuario() {
        return new DataUsuario();
    }

    /**
     * Create an instance of {@link DataPaquete }
     * 
     */
    public DataPaquete createDataPaquete() {
        return new DataPaquete();
    }

    /**
     * Create an instance of {@link DataTurista }
     * 
     */
    public DataTurista createDataTurista() {
        return new DataTurista();
    }

    /**
     * Create an instance of {@link DataBuscar }
     * 
     */
    public DataBuscar createDataBuscar() {
        return new DataBuscar();
    }

    /**
     * Create an instance of {@link DataCompraPaquete.RestAct.Entry }
     * 
     */
    public DataCompraPaquete.RestAct.Entry createDataCompraPaqueteRestActEntry() {
        return new DataCompraPaquete.RestAct.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FechaAltaSalidaAnteriorActividad }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "FechaAltaSalidaAnteriorActividad")
    public JAXBElement<FechaAltaSalidaAnteriorActividad> createFechaAltaSalidaAnteriorActividad(FechaAltaSalidaAnteriorActividad value) {
        return new JAXBElement<FechaAltaSalidaAnteriorActividad>(_FechaAltaSalidaAnteriorActividad_QNAME, FechaAltaSalidaAnteriorActividad.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TuristaConSalida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "TuristaConSalida")
    public JAXBElement<TuristaConSalida> createTuristaConSalida(TuristaConSalida value) {
        return new JAXBElement<TuristaConSalida>(_TuristaConSalida_QNAME, TuristaConSalida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActividadNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "ActividadNoExisteException")
    public JAXBElement<ActividadNoExisteException> createActividadNoExisteException(ActividadNoExisteException value) {
        return new JAXBElement<ActividadNoExisteException>(_ActividadNoExisteException_QNAME, ActividadNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioRepetidoException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "UsuarioRepetidoException")
    public JAXBElement<UsuarioRepetidoException> createUsuarioRepetidoException(UsuarioRepetidoException value) {
        return new JAXBElement<UsuarioRepetidoException>(_UsuarioRepetidoException_QNAME, UsuarioRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FechaAltaSalidaInvalida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "FechaAltaSalidaInvalida")
    public JAXBElement<FechaAltaSalidaInvalida> createFechaAltaSalidaInvalida(FechaAltaSalidaInvalida value) {
        return new JAXBElement<FechaAltaSalidaInvalida>(_FechaAltaSalidaInvalida_QNAME, FechaAltaSalidaInvalida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IOException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "IOException")
    public JAXBElement<IOException> createIOException(IOException value) {
        return new JAXBElement<IOException>(_IOException_QNAME, IOException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaqueteNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "PaqueteNoExisteException")
    public JAXBElement<PaqueteNoExisteException> createPaqueteNoExisteException(PaqueteNoExisteException value) {
        return new JAXBElement<PaqueteNoExisteException>(_PaqueteNoExisteException_QNAME, PaqueteNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalidasVigentesException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "SalidasVigentesException")
    public JAXBElement<SalidasVigentesException> createSalidasVigentesException(SalidasVigentesException value) {
        return new JAXBElement<SalidasVigentesException>(_SalidasVigentesException_QNAME, SalidasVigentesException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InscFechaDespSalida }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "InscFechaDespSalida")
    public JAXBElement<InscFechaDespSalida> createInscFechaDespSalida(InscFechaDespSalida value) {
        return new JAXBElement<InscFechaDespSalida>(_InscFechaDespSalida_QNAME, InscFechaDespSalida.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalidaYaExisteExeption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "SalidaYaExisteExeption")
    public JAXBElement<SalidaYaExisteExeption> createSalidaYaExisteExeption(SalidaYaExisteExeption value) {
        return new JAXBElement<SalidaYaExisteExeption>(_SalidaYaExisteExeption_QNAME, SalidaYaExisteExeption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UsuarioNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "UsuarioNoExisteException")
    public JAXBElement<UsuarioNoExisteException> createUsuarioNoExisteException(UsuarioNoExisteException value) {
        return new JAXBElement<UsuarioNoExisteException>(_UsuarioNoExisteException_QNAME, UsuarioNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepartamentoYaExisteExeption }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "DepartamentoYaExisteExeption")
    public JAXBElement<DepartamentoYaExisteExeption> createDepartamentoYaExisteExeption(DepartamentoYaExisteExeption value) {
        return new JAXBElement<DepartamentoYaExisteExeption>(_DepartamentoYaExisteExeption_QNAME, DepartamentoYaExisteExeption.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InscFechaInconsistente }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "InscFechaInconsistente")
    public JAXBElement<InscFechaInconsistente> createInscFechaInconsistente(InscFechaInconsistente value) {
        return new JAXBElement<InscFechaInconsistente>(_InscFechaInconsistente_QNAME, InscFechaInconsistente.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EstadoActividadIncorrecto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "estadoActividadIncorrecto")
    public JAXBElement<EstadoActividadIncorrecto> createEstadoActividadIncorrecto(EstadoActividadIncorrecto value) {
        return new JAXBElement<EstadoActividadIncorrecto>(_EstadoActividadIncorrecto_QNAME, EstadoActividadIncorrecto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoExisteCategoriaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "NoExisteCategoriaException")
    public JAXBElement<NoExisteCategoriaException> createNoExisteCategoriaException(NoExisteCategoriaException value) {
        return new JAXBElement<NoExisteCategoriaException>(_NoExisteCategoriaException_QNAME, NoExisteCategoriaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NoHayCuposException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "NoHayCuposException")
    public JAXBElement<NoHayCuposException> createNoHayCuposException(NoHayCuposException value) {
        return new JAXBElement<NoHayCuposException>(_NoHayCuposException_QNAME, NoHayCuposException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaqueteRepetidoException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "PaqueteRepetidoException")
    public JAXBElement<PaqueteRepetidoException> createPaqueteRepetidoException(PaqueteRepetidoException value) {
        return new JAXBElement<PaqueteRepetidoException>(_PaqueteRepetidoException_QNAME, PaqueteRepetidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CategoriaYaExiste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "CategoriaYaExiste")
    public JAXBElement<CategoriaYaExiste> createCategoriaYaExiste(CategoriaYaExiste value) {
        return new JAXBElement<CategoriaYaExiste>(_CategoriaYaExiste_QNAME, CategoriaYaExiste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TuristaNoHaNacido }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "TuristaNoHaNacido")
    public JAXBElement<TuristaNoHaNacido> createTuristaNoHaNacido(TuristaNoHaNacido value) {
        return new JAXBElement<TuristaNoHaNacido>(_TuristaNoHaNacido_QNAME, TuristaNoHaNacido.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DepartamentoNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "DepartamentoNoExisteException")
    public JAXBElement<DepartamentoNoExisteException> createDepartamentoNoExisteException(DepartamentoNoExisteException value) {
        return new JAXBElement<DepartamentoNoExisteException>(_DepartamentoNoExisteException_QNAME, DepartamentoNoExisteException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActividadRepetidaException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "ActividadRepetidaException")
    public JAXBElement<ActividadRepetidaException> createActividadRepetidaException(ActividadRepetidaException value) {
        return new JAXBElement<ActividadRepetidaException>(_ActividadRepetidaException_QNAME, ActividadRepetidaException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExcedeTuristas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "ExcedeTuristas")
    public JAXBElement<ExcedeTuristas> createExcedeTuristas(ExcedeTuristas value) {
        return new JAXBElement<ExcedeTuristas>(_ExcedeTuristas_QNAME, ExcedeTuristas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProveedorNoNacidoException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "ProveedorNoNacidoException")
    public JAXBElement<ProveedorNoNacidoException> createProveedorNoNacidoException(ProveedorNoNacidoException value) {
        return new JAXBElement<ProveedorNoNacidoException>(_ProveedorNoNacidoException_QNAME, ProveedorNoNacidoException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SalidasNoExisteException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://servidor/", name = "SalidasNoExisteException")
    public JAXBElement<SalidasNoExisteException> createSalidasNoExisteException(SalidasNoExisteException value) {
        return new JAXBElement<SalidasNoExisteException>(_SalidasNoExisteException_QNAME, SalidasNoExisteException.class, null, value);
    }

}
