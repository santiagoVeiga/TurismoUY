/**
 * PublicadorIControlador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package servidor;

public interface PublicadorIControlador extends java.rmi.Remote {
    public servidor.DataDepartamento dataDepartamentoNull() throws java.rmi.RemoteException, servidor.DepartamentoYaExisteExeption;
    public void confirmarAltaTuristaPass(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void confirmarAltaTuristaCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, byte[] arg7) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void confirmarAltaProveedorPass(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void confirmarAltaProveedorCompleto(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7, java.lang.String arg8, byte[] arg9) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void registrarActividadImagen(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.lang.String arg5, java.util.Calendar arg6, java.lang.String arg7, servidor.DataColeccionObject arg8, byte[] arg9) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.ProveedorNoNacidoException, servidor.UsuarioNoExisteException;
    public servidor.DataUsuario verInfoUsuario(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public servidor.DataColeccionObject getUsuariosComp() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public servidor.DataUsuario ingresarDatos(java.lang.String arg0) throws java.rmi.RemoteException;
    public servidor.DataColeccionObject obtenerActividadCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public servidor.DataUsuario obtenerDataUsuarioNick(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public servidor.DataUsuario obtenerDataUsuarioMail(java.lang.String arg0) throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public servidor.DataActividad obtenerDataActividad(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException;
    public servidor.DataSalida obtenerDataSalida(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException;
    public void comprarPaquete(java.lang.String arg0, java.util.Calendar arg1, int arg2, java.lang.String arg3) throws java.rmi.RemoteException, servidor.PaqueteRepetidoException, servidor.PaqueteNoExisteException;
    public void inscribirPaq(java.lang.String arg0, java.lang.String arg1, int arg2, java.util.Calendar arg3, java.lang.String arg4, java.lang.String arg5) throws java.rmi.RemoteException, servidor.ExcedeTuristas, servidor.TuristaNoHaNacido, servidor.PaqueteRepetidoException, servidor.NoHayCuposException, servidor.InscFechaDespSalida, servidor.ActividadNoExisteException, servidor.TuristaConSalida, servidor.InscFechaInconsistente;
    public servidor.DataColeccionObject obtenerPaquetesComprados(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerNomActPorSalida(java.lang.String arg0) throws java.rmi.RemoteException, servidor.SalidasNoExisteException;
    public servidor.DataColeccionObject selecDepartamento(java.lang.String arg0) throws java.rmi.RemoteException;
    public servidor.DataColeccionObject salidas(java.lang.String arg0) throws java.rmi.RemoteException, servidor.ActividadNoExisteException;
    public void inscribir(java.lang.String arg0, java.lang.String arg1, int arg2, java.util.Calendar arg3, java.lang.String arg4) throws java.rmi.RemoteException, servidor.ExcedeTuristas, servidor.TuristaNoHaNacido, servidor.InscFechaDespSalida, servidor.ActividadNoExisteException, servidor.TuristaConSalida, servidor.InscFechaInconsistente;
    public servidor.DataColeccionObject listarUsuarios() throws java.rmi.RemoteException;
    public void registrarActividad(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, int arg3, int arg4, java.lang.String arg5, java.util.Calendar arg6, java.lang.String arg7, servidor.DataColeccionObject arg8) throws java.rmi.RemoteException, servidor.ActividadRepetidaException, servidor.ProveedorNoNacidoException, servidor.UsuarioNoExisteException;
    public servidor.DataColeccionObject getUsuarios() throws java.rmi.RemoteException, servidor.UsuarioNoExisteException;
    public servidor.DataColeccionObject obtenerNombreCategorias() throws java.rmi.RemoteException, servidor.NoExisteCategoriaException;
    public void confirmarAltaSalida(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2, java.util.Calendar arg3, java.lang.String arg4, int arg5, java.util.Calendar arg6) throws java.rmi.RemoteException, servidor.SalidaYaExisteExeption, servidor.FechaAltaSalidaInvalida, servidor.FechaAltaSalidaAnteriorActividad;
    public void registrarCategoria(java.lang.String arg0) throws java.rmi.RemoteException, servidor.CategoriaYaExiste;
    public void confirmarAltaTurista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public void confirmarAltaProveedor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7) throws java.rmi.RemoteException, servidor.UsuarioRepetidoException;
    public servidor.DataColeccionObject listarPaquetes() throws java.rmi.RemoteException;
    public servidor.DataPaquete obtenerDataPaquete(java.lang.String arg0) throws java.rmi.RemoteException;
    public void actualizarDatosTurista(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5) throws java.rmi.RemoteException;
    public void actualizarDatosProveedor(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.util.Calendar arg4, java.lang.String arg5, java.lang.String arg6, boolean arg7) throws java.rmi.RemoteException;
    public void aceptarRechazarAct(java.lang.String arg0, servidor.EstadoAct arg1) throws java.rmi.RemoteException, servidor.EstadoActividadIncorrecto, servidor.ActividadNoExisteException;
    public servidor.DataColeccionObject listarActividadesAgregadas() throws java.rmi.RemoteException;
    public servidor.DataColeccionObject actividadesPorDepartamentoNoEnPaquete(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public servidor.DataColeccionObject listarPaquetesNoComprados() throws java.rmi.RemoteException;
    public void confirmar(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public servidor.DataColeccionObject obtenerDataDepartamentos() throws java.rmi.RemoteException, servidor.DepartamentoNoExisteException;
}
