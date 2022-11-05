package servidor;

public class PublicadorIControladorProxy implements servidor.PublicadorIControlador {
  private String _endpoint = null;
  private servidor.PublicadorIControlador publicadorIControlador = null;
  
  public PublicadorIControladorProxy() {
    _initPublicadorIControladorProxy();
  }
  
  public PublicadorIControladorProxy(String endpoint) {
    _endpoint = endpoint;
    _initPublicadorIControladorProxy();
  }
  
  private void _initPublicadorIControladorProxy() {
    try {
      publicadorIControlador = (new servidor.PublicadorIControladorServiceLocator()).getPublicadorIControladorPort();
      if (publicadorIControlador != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)publicadorIControlador)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)publicadorIControlador)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (publicadorIControlador != null)
      ((javax.xml.rpc.Stub)publicadorIControlador)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public servidor.PublicadorIControlador getPublicadorIControlador() {
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador;
  }
  
  public byte[] getFile(java.lang.String fileName) throws java.rmi.RemoteException, servidor.IOException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.getFile(fileName);
  }
  
  public servidor.DataDepartamento dataDepartamentoNull() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.dataDepartamentoNull();
  }
  
  public servidor.DataTurista dataTuristaNull() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.dataTuristaNull();
  }
  
  public servidor.DataProveedor dataProveedorNull() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.dataProveedorNull();
  }
  
  public servidor.DataActividad dataActividadNull() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.dataActividadNull();
  }
  
  public servidor.DataCompraGeneral dataCGNull() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.dataCGNull();
  }
  
  public servidor.DataCompraPaquete dataCPNull() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.dataCPNull();
  }
  
  public servidor.EstadoAct estadoActNull() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.estadoActNull();
  }
  
  public void confirmarAltaTuristaCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaTuristaCompleto(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public void confirmarAltaProveedorCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8, byte[] arg9) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaProveedorCompleto(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }
  
  public void registrarActividadImagen(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.lang.String arg5, java.util.Calendar arg6, java.lang.String arg7, java.lang.Object[] arg8, byte[] arg9) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.ProveedorNoNacidoException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.registrarActividadImagen(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }
  
  public servidor.DataUsuario verInfoUsuario(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.verInfoUsuario(arg0);
  }
  
  public java.lang.Object[] getUsuariosComp() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.getUsuariosComp();
  }
  
  public void confirmarAltaSalidaImagen(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.lang.String arg4, int arg5, java.util.Calendar arg6, byte[] arg7) throws java.rmi.RemoteException, servidor.SalidaYaExisteExeption, servidor.FechaAltaSalidaInvalida, servidor.FechaAltaSalidaAnteriorActividad{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaSalidaImagen(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public void actualizarDatosTuristaCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.actualizarDatosTuristaCompleto(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public void actualizarDatosProveedorCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8, byte[] arg9) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.actualizarDatosProveedorCompleto(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);
  }
  
  public servidor.DataUsuario ingresarDatos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.ingresarDatos(arg0);
  }
  
  public java.lang.Object[] obtenerActividadCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerActividadCategoria(arg0);
  }
  
  public servidor.DataUsuario obtenerDataUsuarioNick(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataUsuarioNick(arg0);
  }
  
  public servidor.DataUsuario obtenerDataUsuarioMail(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataUsuarioMail(arg0);
  }
  
  public servidor.DataActividad obtenerDataActividad(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataActividad(arg0);
  }
  
  public servidor.DataSalida obtenerDataSalida(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataSalida(arg0);
  }
  
  public void comprarPaquete(java.lang.String arg0, java.util.Calendar arg1, int arg2, java.lang.String arg3) throws java.rmi.RemoteException, servidor.PaqueteRepetidoException, servidor.PaqueteNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.comprarPaquete(arg0, arg1, arg2, arg3);
  }
  
  public void inscribirPaq(java.lang.String arg0, java.lang.String arg1, int arg2, java.util.Calendar arg3, java.lang.String arg4, java.lang.String arg5) throws java.rmi.RemoteException, servidor.ExcedeTuristas, servidor.TuristaNoHaNacido, servidor.PaqueteRepetidoException, servidor.NoHayCuposException, servidor.InscFechaDespSalida, servidor.ActividadNoExisteException, servidor.TuristaConSalida, servidor.InscFechaInconsistente{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.inscribirPaq(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public java.lang.Object[] obtenerPaquetesComprados(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerPaquetesComprados(arg0);
  }
  
  public java.lang.String obtenerNomActPorSalida(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerNomActPorSalida(arg0);
  }
  
  public java.lang.Object[] selecDepartamento(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.selecDepartamento(arg0);
  }
  
  public java.lang.Object[] salidas(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.salidas(arg0);
  }
  
  public void inscribir(java.lang.String arg0, java.lang.String arg1, int arg2, java.util.Calendar arg3, java.lang.String arg4) throws java.rmi.RemoteException, servidor.ExcedeTuristas, servidor.TuristaNoHaNacido, servidor.InscFechaDespSalida, servidor.ActividadNoExisteException, servidor.TuristaConSalida, servidor.InscFechaInconsistente{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.inscribir(arg0, arg1, arg2, arg3, arg4);
  }
  
  public java.lang.Object[] listarUsuarios() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarUsuarios();
  }
  
  public void registrarActividad(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.lang.String arg5, java.util.Calendar arg6, java.lang.String arg7, java.lang.Object[] arg8) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.ProveedorNoNacidoException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.registrarActividad(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }
  
  public java.lang.Object[] getUsuarios() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.getUsuarios();
  }
  
  public java.lang.Object[] obtenerNombreCategorias() throws java.rmi.RemoteException, servidor.NoExisteCategoriaException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerNombreCategorias();
  }
  
  public void confirmarAltaSalida(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.lang.String arg4, int arg5, java.util.Calendar arg6) throws java.rmi.RemoteException, servidor.SalidaYaExisteExeption, servidor.FechaAltaSalidaInvalida, servidor.FechaAltaSalidaAnteriorActividad{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaSalida(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public void confirmarAltaTurista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaTurista(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public void confirmarAltaProveedor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaProveedor(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }
  
  public java.lang.Object[] listarPaquetes() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarPaquetes();
  }
  
  public servidor.DataPaquete obtenerDataPaquete(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataPaquete(arg0);
  }
  
  public void actualizarDatosTurista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.actualizarDatosTurista(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public void actualizarDatosProveedor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.actualizarDatosProveedor(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public java.lang.Object[] listarActividadesAgregadas() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarActividadesAgregadas();
  }
  
  public java.lang.Object[] actividadesPorDepartamentoNoEnPaquete(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.actividadesPorDepartamentoNoEnPaquete(arg0, arg1);
  }
  
  public java.lang.Object[] listarPaquetesNoComprados() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarPaquetesNoComprados();
  }
  
  public void excepciones() throws java.rmi.RemoteException, servidor.DepartamentoYaExisteExeption, servidor.UsuarioNoExisteException, servidor.InscFechaDespSalida, servidor.SalidasVigentesException, servidor.PaqueteNoExisteException, servidor.FechaAltaSalidaInvalida, servidor.ActividadNoExisteException, servidor.UsuarioRepetidoException, servidor.FechaAltaSalidaAnteriorActividad, servidor.TuristaConSalida, servidor.ActividadRepetidaException, servidor.ExcedeTuristas, servidor.ProveedorNoNacidoException, servidor.SalidasNoExisteException, servidor.DepartamentoNoExisteException, servidor.TuristaNoHaNacido, servidor.CategoriaYaExiste, servidor.PaqueteRepetidoException, servidor.NoHayCuposException, servidor.NoExisteCategoriaException, servidor.EstadoActividadIncorrecto, servidor.InscFechaInconsistente{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.excepciones();
  }
  
  public java.lang.Object[] obtenerDataDepartamentos() throws java.rmi.RemoteException, servidor.DepartamentoNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataDepartamentos();
  }
  
  
}