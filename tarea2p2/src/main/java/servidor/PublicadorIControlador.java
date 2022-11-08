/**
 * PublicadorIControlador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public interface PublicadorIControlador extends java.rmi.Remote {
    public byte[] getFile(java.lang.String fileName) throws java.rmi.RemoteException, servidor.IOException;
    public servidor.DataDepartamento dataDepartamentoNull() throws java.rmi.RemoteException;
    public servidor.DataTurista dataTuristaNull() throws java.rmi.RemoteException;
    public servidor.DataProveedor dataProveedorNull() throws java.rmi.RemoteException;
    public servidor.DataActividad dataActividadNull() throws java.rmi.RemoteException;
    public servidor.DataCompraGeneral dataCGNull() throws java.rmi.RemoteException;
    public servidor.DataCompraPaquete dataCPNull() throws java.rmi.RemoteException;
    public servidor.EstadoAct estadoActNull() throws java.rmi.RemoteException;
    public void confirmarAltaTuristaCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void confirmarAltaProveedorCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8, byte[] arg9) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void registrarActividadImagen(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.lang.String arg5, java.util.Calendar arg6, java.lang.String arg7, java.lang.Object[] arg8, java.lang.String arg9, boolean arg10, byte[] arg11) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.ProveedorNoNacidoException, servidor.UsuarioNoExisteException;
    public servidor.DataUsuario verInfoUsuario(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public void sumarVistaAAct(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException;
    public void sumarVistaASal(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException, servidor.ActividadNoExisteException;
    public java.lang.Object[] getUsuariosComp() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public void confirmarAltaSalidaImagen(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.lang.String arg4, int arg5, java.util.Calendar arg6, byte[] arg7) throws java.rmi.RemoteException, servidor.SalidaYaExisteExeption, servidor.FechaAltaSalidaInvalida, servidor.FechaAltaSalidaAnteriorActividad;
    public void actualizarDatosTuristaCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException;
    public void actualizarDatosProveedorCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8, byte[] arg9) throws java.rmi.RemoteException;
    public servidor.DataUsuario ingresarDatos(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.Object[] obtenerActividadCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public servidor.DataUsuario obtenerDataUsuarioNick(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public servidor.DataUsuario obtenerDataUsuarioMail(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public servidor.DataActividad obtenerDataActividad(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException;
    public servidor.DataSalida obtenerDataSalida(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException;
    public void comprarPaquete(java.lang.String arg0, java.util.Calendar arg1, int arg2, java.lang.String arg3) throws java.rmi.RemoteException, servidor.PaqueteRepetidoException, servidor.PaqueteNoExisteException;
    public void inscribirPaq(java.lang.String arg0, java.lang.String arg1, int arg2, java.util.Calendar arg3, java.lang.String arg4, java.lang.String arg5) throws java.rmi.RemoteException, servidor.ExcedeTuristas, servidor.TuristaNoHaNacido, servidor.PaqueteRepetidoException, servidor.NoHayCuposException, servidor.InscFechaDespSalida, servidor.ActividadNoExisteException, servidor.TuristaConSalida, servidor.InscFechaInconsistente;
    public java.lang.Object[] obtenerPaquetesComprados(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerNomActPorSalida(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException;
    public void seguirDejarDeSeguirUsuario(java.lang.String arg0, java.lang.String arg1, boolean arg2) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException, servidor.UsuarioRepetidoException;
    public void agregarQuitarActividadFavorita(java.lang.String arg0, java.lang.String arg1, boolean arg2) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.UsuarioNoExisteException, servidor.ActividadNoExisteException;
    public void finalizarActividad(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasVigentesException, servidor.ActividadNoExisteException;
    public java.lang.Object[] listarUsuarios() throws java.rmi.RemoteException;
    public java.lang.Object[] obtenerDataDepartamentos() throws java.rmi.RemoteException, servidor.DepartamentoNoExisteException;
    public void confirmarAltaSalida(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.lang.String arg4, int arg5, java.util.Calendar arg6) throws java.rmi.RemoteException, servidor.SalidaYaExisteExeption, servidor.FechaAltaSalidaInvalida, servidor.FechaAltaSalidaAnteriorActividad;
    public void registrarActividad(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.lang.String arg5, java.util.Calendar arg6, java.lang.String arg7, java.lang.Object[] arg8, java.lang.String arg9, boolean arg10) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.ProveedorNoNacidoException, servidor.UsuarioNoExisteException;
    public java.lang.Object[] getUsuarios() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public java.lang.Object[] obtenerNombreCategorias() throws java.rmi.RemoteException, servidor.NoExisteCategoriaException;
    public java.lang.Object[] selecDepartamento(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.Object[] salidas(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException;
    public void inscribir(java.lang.String arg0, java.lang.String arg1, int arg2, java.util.Calendar arg3, java.lang.String arg4) throws java.rmi.RemoteException, servidor.ExcedeTuristas, servidor.TuristaNoHaNacido, servidor.InscFechaDespSalida, servidor.ActividadNoExisteException, servidor.TuristaConSalida, servidor.InscFechaInconsistente;
    public java.lang.Object[] listarActividadesAgregadas() throws java.rmi.RemoteException;
    public java.lang.Object[] listarPaquetes() throws java.rmi.RemoteException;
    public servidor.DataPaquete obtenerDataPaquete(java.lang.String arg0) throws java.rmi.RemoteException;
    public void actualizarDatosTurista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5) throws java.rmi.RemoteException;
    public void actualizarDatosProveedor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7) throws java.rmi.RemoteException;
    public void excepciones() throws java.rmi.RemoteException, servidor.DepartamentoYaExisteExeption, servidor.UsuarioNoExisteException, servidor.InscFechaDespSalida, servidor.SalidasVigentesException, servidor.PaqueteNoExisteException, servidor.FechaAltaSalidaInvalida, servidor.ActividadNoExisteException, servidor.UsuarioRepetidoException, servidor.FechaAltaSalidaAnteriorActividad, servidor.TuristaConSalida, servidor.ActividadRepetidaException, servidor.ExcedeTuristas, servidor.ProveedorNoNacidoException, servidor.SalidasNoExisteException, servidor.DepartamentoNoExisteException, servidor.TuristaNoHaNacido, servidor.CategoriaYaExiste, servidor.PaqueteRepetidoException, servidor.NoHayCuposException, servidor.NoExisteCategoriaException, servidor.EstadoActividadIncorrecto, servidor.InscFechaInconsistente;
    public void confirmarAltaTurista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void confirmarAltaProveedor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public java.lang.Object[] actividadesPorDepartamentoNoEnPaquete(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.Object[] listarPaquetesNoComprados() throws java.rmi.RemoteException;
}
