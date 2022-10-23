package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import excepciones.ActividadNoExisteException;
import excepciones.ActividadRepetidaException;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.ExcedeTuristas;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NoHayCuposException;
import excepciones.PaqueteNoExisteException;
import excepciones.PaqueteRepetidoException;
import excepciones.ProveedorNoNacidoException;
import excepciones.SalidaYaExisteExeption;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;
import logica.IControladorInsc;


public class Principal {

    private JFrame frmGestionDeUsuarios;
    private IControladorConsulta conCons;
    private IControladorAlta conAlta;
    private IControladorInsc conInsc;
    private CrearUsuario creUsrInternalFrame;
    private ListarUsuarios lisUsrInternalFrame;
    private CrearActividad creActInternalFrame;
    private ConsultarActividad conActInternalFrame;
    private Inscribir insInternalFrame;
    private AltaSalida creSalInternalFrame ;
    private ConsultaSalidaTuristica consultaSalidaInternalFrame;
    private CrearPaquete crePaqInternalFrame;
    private AgregarActPaquete agrPaqInternalFrame;
    private ConsultaPaquete conPaqInternalFrame;
    private ModificarUsuario modUsrInternalFrame;
    private AltaCategoria creCatInternalFrame;
	private AceptarRechazar acepRecInternalFrame;




    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                    Principal window;
					try {
						window = new Principal();
	                    window.frmGestionDeUsuarios.setVisible(true);
					} catch (DepartamentoYaExisteExeption | IOException | DepartamentoNoExisteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            }
        });
    }

    /**
     * Create the application.
     * @throws DepartamentoYaExisteExeption 
     * @throws IOException 
     * @throws DepartamentoNoExisteException 
     */
    public Principal() throws DepartamentoYaExisteExeption, IOException, DepartamentoNoExisteException {
        initialize();

     // Inicialización
        Fabrica fabrica = Fabrica.getInstance();
        conAlta = fabrica.getIControladorAlta();
        conCons = fabrica.getIControladorConsulta();
        conInsc = fabrica.getIControladorInsc();
        // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        
        // ******** USUARIO *******
        creUsrInternalFrame = new CrearUsuario(conAlta);
        creUsrInternalFrame.setVisible(false);

        lisUsrInternalFrame = new ListarUsuarios(conCons);
        lisUsrInternalFrame.setVisible(false);
        
        frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
        //****** MODIFICAR *********/
        modUsrInternalFrame= new ModificarUsuario(conAlta);
        modUsrInternalFrame.setVisible(false);


        //****** ACTIVIDAD *********/
        
     
        creActInternalFrame = new CrearActividad(conAlta);
        creActInternalFrame.setVisible(false);

        conActInternalFrame = new ConsultarActividad(conCons);
        conActInternalFrame.setVisible(false);
        
        acepRecInternalFrame = new AceptarRechazar(conInsc);
        acepRecInternalFrame.setVisible(false);
        
        //categoria
        
        creCatInternalFrame = new AltaCategoria();
        creCatInternalFrame.setVisible(false);
        
        //****** SALIDA *********/----------------------------------------------------
        creSalInternalFrame = new AltaSalida(conAlta);
        creSalInternalFrame.setVisible(false);
       
        consultaSalidaInternalFrame = new ConsultaSalidaTuristica(conCons);
        consultaSalidaInternalFrame.setVisible(false);
        //----------------------------------------------------------------------------

        /* Inscripcion */
        
        insInternalFrame = new Inscribir(conInsc);
        insInternalFrame.setVisible(false);
        insInternalFrame.setLocation(10, 30);
        
        //Paquetes
        
        crePaqInternalFrame = new CrearPaquete(conAlta);
        crePaqInternalFrame.setVisible(false);
        
        agrPaqInternalFrame = new AgregarActPaquete(conInsc);
        agrPaqInternalFrame.setVisible(false);
        
        conPaqInternalFrame = new ConsultaPaquete(conCons);
        conPaqInternalFrame.setVisible(false);
        
    	conActInternalFrame.setConPaquete(conPaqInternalFrame);
        conPaqInternalFrame.setConActividad(conActInternalFrame);
        
        frmGestionDeUsuarios.getContentPane().setLayout(null);
        frmGestionDeUsuarios.getContentPane().add(insInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(conActInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(creUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(creActInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(creCatInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(creSalInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(consultaSalidaInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(crePaqInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(agrPaqInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(conPaqInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(modUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(acepRecInternalFrame);
        lisUsrInternalFrame.setSal(consultaSalidaInternalFrame);
        lisUsrInternalFrame.setAct(conActInternalFrame);
        conActInternalFrame.setSalida(consultaSalidaInternalFrame);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        // Se crea el Frame con las dimensiones indicadas.
        frmGestionDeUsuarios = new JFrame();
        frmGestionDeUsuarios.setTitle("Gestion de Actividades Turisticas");
        frmGestionDeUsuarios.setBounds(100, 100, 953, 667);
        frmGestionDeUsuarios.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crea una barra de menú (JMenuBar) con dos menú (JMenu) desplegables.
        // Cada menú contiene diferentes opciones (JMenuItem), los cuales tienen un
        // evento asociado que permite realizar una acción una vez se seleccionan.
        JMenuBar menuBar = new JMenuBar();
        frmGestionDeUsuarios.setJMenuBar(menuBar);

        JMenu menuSistema = new JMenu("Sistema");
        menuBar.add(menuSistema);

        JMenuItem menuSalir = new JMenuItem("Salir");
        menuSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicación
                frmGestionDeUsuarios.setVisible(false);
                frmGestionDeUsuarios.dispose();
            }
        });
        menuSistema.add(menuSalir);
        
        /* ******************* */
        /* **** Usuarios **** */
        /* ****************** */

        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);

        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem mntmListaUsuarios = new JMenuItem("Consulta de Usuario");
        mntmListaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                lisUsrInternalFrame.cargarUsuarios();
            }
        });
        menuUsuarios.add(mntmListaUsuarios);

        /* *** *** *** *** ***  *** */
        /* *** Modificar usuario *** */
        /* *** *** *** *** ****** */

        JMenu menuModificar = new JMenu("Modificar Usuario");
        menuBar.add(menuModificar);

        JMenuItem menuItemModificar = new JMenuItem("Modificar Datos");
        menuItemModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
					modUsrInternalFrame.limpiarFormulario();
					try {
						modUsrInternalFrame.cargarUsuarios();
					} catch (UsuarioNoExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            }
        });
        menuModificar.add(menuItemModificar);

        
        
        /* ******************** */
        /* **** Actividad **** */
        /* ******************** */
        
        JMenu menuActividad = new JMenu("Actividad");
        menuBar.add(menuActividad);

        JMenuItem menuItemRegistrarActividad = new JMenuItem("Registrar Actividad");
        menuItemRegistrarActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                creActInternalFrame.cargarDepartamentos();
                creActInternalFrame.cargarProveedores();
            	creActInternalFrame.setVisible(true);
                creActInternalFrame.cargarCategorias();
            }
        });
        menuActividad.add(menuItemRegistrarActividad);
        
        JMenuItem menuItemConsultaActividad = new JMenuItem("Consulta Actividad");
        menuItemConsultaActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	conActInternalFrame.cargarDepartamentos();
                conActInternalFrame.setVisible(true);
            }
        });
        menuActividad.add(menuItemConsultaActividad);
        
        JMenuItem mntmAceptarRechazar = new JMenuItem("AceptarRechazar");
        mntmAceptarRechazar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent eve) {
        		acepRecInternalFrame.actCategorias();
        		acepRecInternalFrame.setVisible(true);
        	}
        });
        menuActividad.add(mntmAceptarRechazar);
       
        
        
        /* ******************** */
        /* ****  Categoria ****** */
        /* ******************** */
        
        
        JMenu menuCategoria = new JMenu("Categoria");
        menuBar.add(menuCategoria);

        JMenuItem menuItemRegistrarCategoria = new JMenuItem("Registrar Categoria");
        menuItemRegistrarCategoria.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	creCatInternalFrame.setVisible(true);
            }
        });
        menuCategoria.add(menuItemRegistrarCategoria);
        
        
        
        
        
        /* ******************** */
        /* ****  Salida ****** */
        /* ******************** */

        JMenu menuSalida = new JMenu("Salida");
        menuBar.add(menuSalida);

        JMenuItem menuItemAltaSalida = new JMenuItem("Alta Salida");
        menuItemAltaSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	creSalInternalFrame.cargarDepartamentos();
            	creSalInternalFrame.setVisible(true);
            }
        });
        menuSalida.add(menuItemAltaSalida);
        
        JMenuItem menuItemConsultaSalida = new JMenuItem("Consulta Salida");
        menuItemConsultaSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	consultaSalidaInternalFrame.cargarDepartamentos();
            	consultaSalidaInternalFrame.setVisible(true);
            }
        });
        menuSalida.add(menuItemConsultaSalida);
        

        /* ************ */
        /* Inscripcion */
        /* ************ */
        
        JMenu mnInscripcion = new JMenu("Inscripcion");
        menuBar.add(mnInscripcion);
        
        JMenuItem mntmInscribirTuristaA = new JMenuItem("Inscribir turista a salida");
        mntmInscribirTuristaA.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent eve) {
        		insInternalFrame.actualizarDptos();
        		insInternalFrame.setVisible(true);
        	}
        });
        mnInscripcion.add(mntmInscribirTuristaA);
        
        /* ******************** */
        /* **** Paquete **** */
        /* ******************** */
        
        JMenu menuPaquete = new JMenu("Paquete");
        menuBar.add(menuPaquete);

        JMenuItem menuItemRegistrarPaquete = new JMenuItem("Crear Paquete");
        menuItemRegistrarPaquete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	crePaqInternalFrame.setVisible(true);
            }
        });
        menuPaquete.add(menuItemRegistrarPaquete);
        
        JMenuItem menuItemAgregarPaquete = new JMenuItem("Agregar Actvidad a Paquete");
        menuItemAgregarPaquete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	agrPaqInternalFrame.cargarDepartamentos();
            	agrPaqInternalFrame.cargarPaquetes();
            	agrPaqInternalFrame.setVisible(true);
            }
        });
        menuPaquete.add(menuItemAgregarPaquete);
        
        JMenuItem menuItemConsultaPaquete = new JMenuItem("Consultar un Paquete");
        menuItemConsultaPaquete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	conPaqInternalFrame.cargarPaquetes();
            	conPaqInternalFrame.setVisible(true);
            }
        });
        menuPaquete.add(menuItemConsultaPaquete);
        
        /* *************** */
        /* Carga de Datos */
        /* ************* */
        
        JMenu mnCargar = new JMenu("Cargar");
        menuBar.add(mnCargar);
        
        JMenuItem mntmCargarusuarios = new JMenuItem("Cargar Datos");
        mntmCargarusuarios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent eve) {
					try {
						conAlta.cargarDatos();
					} catch (NumberFormatException | IOException | UsuarioRepetidoException | ParseException
							| DepartamentoYaExisteExeption | ActividadRepetidaException | UsuarioNoExisteException
							| ProveedorNoNacidoException | SalidaYaExisteExeption | PaqueteRepetidoException
							| FechaAltaSalidaInvalida | FechaAltaSalidaAnteriorActividad | TuristaConSalida
							| ExcedeTuristas | InscFechaInconsistente | ActividadNoExisteException | InscFechaDespSalida
							| TuristaNoHaNacido | NoHayCuposException | PaqueteNoExisteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					mntmCargarusuarios.setVisible(false);
				} 
        	
        });
        mnCargar.add(mntmCargarusuarios);
    
    }
}
