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
  
  public void confirmarAltaTuristaPass(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaTuristaPass(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public void confirmarAltaProveedorPass(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaProveedorPass(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }
  
  public servidor.DataUsuario verInfoUsuario(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.verInfoUsuario(arg0);
  }
  
  public servidor.DataColeccionObject getUsuariosComp() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.getUsuariosComp();
  }
  
  public servidor.DataUsuario ingresarDatos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.ingresarDatos(arg0);
  }
  
  public servidor.DataColeccionObject obtenerActividadCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
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
  
  public servidor.DataColeccionObject obtenerPaquetesComprados(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerPaquetesComprados(arg0);
  }
  
  public java.lang.String obtenerNomActPorSalida(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerNomActPorSalida(arg0);
  }
  
  public servidor.DataColeccionObject selecDepartamento(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.selecDepartamento(arg0);
  }
  
  public servidor.DataColeccionObject listarUsuarios() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarUsuarios();
  }
  
  public servidor.DataColeccionObject listarActividadesAgregadas() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarActividadesAgregadas();
  }
  
  public servidor.DataColeccionObject obtenerDataDepartamentos() throws java.rmi.RemoteException, servidor.DepartamentoNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataDepartamentos();
  }
  
  public servidor.DataColeccionObject salidas(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.salidas(arg0);
  }
  
  public void inscribir(java.lang.String arg0, java.lang.String arg1, int arg2, java.util.Calendar arg3, java.lang.String arg4) throws java.rmi.RemoteException, servidor.ExcedeTuristas, servidor.TuristaNoHaNacido, servidor.InscFechaDespSalida, servidor.ActividadNoExisteException, servidor.TuristaConSalida, servidor.InscFechaInconsistente{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.inscribir(arg0, arg1, arg2, arg3, arg4);
  }
  
  public void registrarActividad(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.lang.String arg5, java.util.Calendar arg6, java.lang.String arg7, servidor.DataColeccionObject arg8) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.ProveedorNoNacidoException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.registrarActividad(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
  }
  
  public servidor.DataColeccionObject getUsuarios() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.getUsuarios();
  }
  
  public servidor.DataColeccionObject obtenerNombreCategorias() throws java.rmi.RemoteException, servidor.NoExisteCategoriaException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerNombreCategorias();
  }
  
  public void confirmarAltaTurista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaTurista(arg0, arg1, arg2, arg3, arg4, arg5);
  }
  
  public void confirmarAltaProveedor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaProveedor(arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7);
  }
  
  public void confirmarAltaSalida(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.lang.String arg4, int arg5, java.util.Calendar arg6) throws java.rmi.RemoteException, servidor.SalidaYaExisteExeption, servidor.FechaAltaSalidaInvalida, servidor.FechaAltaSalidaAnteriorActividad{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmarAltaSalida(arg0, arg1, arg2, arg3, arg4, arg5, arg6);
  }
  
  public void registrarCategoria(java.lang.String arg0) throws java.rmi.RemoteException, servidor.CategoriaYaExiste{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.registrarCategoria(arg0);
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
  
  public void aceptarRechazarAct(java.lang.String arg0, servidor.EstadoAct arg1) throws java.rmi.RemoteException, servidor.EstadoActividadIncorrecto, servidor.ActividadNoExisteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.aceptarRechazarAct(arg0, arg1);
  }
  
  public servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.actividadesPorDepartamentoNoEnPaquete(arg0, arg1);
  }
  
  public servidor.DataColeccionObject listarPaquetesNoComprados() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarPaquetesNoComprados();
  }
  
  public void confirmar(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    publicadorIControlador.confirmar(arg0, arg1);
  }
  
  public servidor.DataColeccionObject listarPaquetes() throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.listarPaquetes();
  }
  
  public servidor.DataPaquete obtenerDataPaquete(java.lang.String arg0) throws java.rmi.RemoteException{
    if (publicadorIControlador == null)
      _initPublicadorIControladorProxy();
    return publicadorIControlador.obtenerDataPaquete(arg0);
  }
  
  
}