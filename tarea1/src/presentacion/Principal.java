package presentacion;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import excepciones.ActividadRepetidaException;
import excepciones.DepartamentoNoExisteException;
import excepciones.DepartamentoYaExisteExeption;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaInconsistente;
import excepciones.SalidaYaExisteExeption;
import excepciones.TuristaConSalida;
import excepciones.UsuarioNoExisteException;
import excepciones.UsuarioRepetidoException;
import logica.Fabrica;
import logica.IControladorAlta;
import logica.IControladorConsulta;
import logica.IControladorInsc;
import javax.swing.JMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.DefaultComboBoxModel;


public class Principal {

    private JFrame frmGestionDeUsuarios;
    private IControladorConsulta ICC;
    private IControladorAlta ICA;
    private IControladorInsc ICI;
    private CrearUsuario creUsrInternalFrame;
    private ConsultarUsuario conUsrInternalFrame;
    private ListarUsuarios lisUsrInternalFrame;
    private CrearActividad creActInternalFrame;
    private ConsultarActividad conActInternalFrame;
    private Inscribir insInternalFrame;
    private AltaSalida creSalInternalFrame ;
    private ConsultaSalidaTuristica consultaSalidaInternalFrame ;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Principal window = new Principal();
                    window.frmGestionDeUsuarios.setVisible(true);
                } catch (Exception e) {
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
        ICA = fabrica.getIControladorAlta();
        ICC = fabrica.getIControladorConsulta();
        ICI = fabrica.getIControladorInsc();
        // Se crean los tres InternalFrame y se incluyen al Frame principal ocultos.
        // De esta forma, no es necesario crear y destruir objetos lo que enlentece la ejecución.
        // Cada InternalFrame usa un layout diferente, simplemente para mostrar distintas opciones.
        creUsrInternalFrame = new CrearUsuario(ICA);
        creUsrInternalFrame.setVisible(false);

        conUsrInternalFrame = new ConsultarUsuario(ICC);
        conUsrInternalFrame.setVisible(false);

        lisUsrInternalFrame = new ListarUsuarios(ICC);
        lisUsrInternalFrame.setVisible(false);
        


        //frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
 
        //****** ACTIVIDAD *********/

        creActInternalFrame = new CrearActividad(ICA);
        creActInternalFrame.setVisible(false);

        conActInternalFrame = new ConsultarActividad(ICC);
        conActInternalFrame.setVisible(false);

        //****** SALIDA *********/----------------------------------------------------
       creSalInternalFrame = new AltaSalida(ICA);
       creSalInternalFrame.setVisible(false);
       
       consultaSalidaInternalFrame = new ConsultaSalidaTuristica(ICC);
       consultaSalidaInternalFrame.setVisible(false);
        //----------------------------------------------------------------------------
      
        
        
        /* Inscripcion */
        
        insInternalFrame = new Inscribir(ICI);
        insInternalFrame.setVisible(false);
        insInternalFrame.setLocation(10, 30);
        
        frmGestionDeUsuarios.getContentPane().setLayout(null);
        frmGestionDeUsuarios.getContentPane().add(insInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(conActInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(creUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(creActInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(conUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(lisUsrInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(creSalInternalFrame);
        frmGestionDeUsuarios.getContentPane().add(consultaSalidaInternalFrame);
        


        
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        // Se crea el Frame con las dimensiones indicadas.
        frmGestionDeUsuarios = new JFrame();
        frmGestionDeUsuarios.setTitle("Gestion de Usuarios 1.0");
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
        
        /* **** Usuarios **** */
        
        JMenu menuUsuarios = new JMenu("Usuarios");
        menuBar.add(menuUsuarios);

        JMenuItem menuItemRegistrar = new JMenuItem("Registrar Usuario");
        menuItemRegistrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para registrar un usuario
                creUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemRegistrar);

        JMenuItem mntmListaUsuarios = new JMenuItem("Consulta de Usuario");
        mntmListaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lisUsrInternalFrame.cargarUsuarios();
                lisUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(mntmListaUsuarios);
        
        /* ******************** */
        /* **** Actividad **** */
        /* ******************** */
        
        JMenu menuActividad = new JMenu("Actividad");
        menuBar.add(menuActividad);

        JMenuItem menuItemRegistrarActividad = new JMenuItem("Registrar Actividad");
        menuItemRegistrarActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creActInternalFrame.cargarDepartamentos();
                creActInternalFrame.cargarProveedores();
            	creActInternalFrame.setVisible(true);
            }
        });
        menuActividad.add(menuItemRegistrarActividad);
        
        JMenuItem menuItemConsultaActividad = new JMenuItem("Consulta Actividad");
        menuItemConsultaActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	conActInternalFrame.cargarDepartamentos();
                conActInternalFrame.setVisible(true);
            }
        });
        menuActividad.add(menuItemConsultaActividad);
        
        /* ******************** */
        /* ****  Salida ****** */
        /* ******************** */

        JMenu menuSalida = new JMenu("Salida");
        menuBar.add(menuSalida);

        JMenuItem menuItemAltaSalida = new JMenuItem("Alta Salida");
        menuItemAltaSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	creSalInternalFrame.cargarDepartamentos();
            	creSalInternalFrame.setVisible(true);
            }
        });
        menuSalida.add(menuItemAltaSalida);
        
        JMenuItem menuItemConsultaSalida = new JMenuItem("Consulta Salida");
        menuItemConsultaSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
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
        	public void actionPerformed(ActionEvent e) {
        		insInternalFrame.actualizarDptos();
        		insInternalFrame.setVisible(true);
        	}
        });
        mnInscripcion.add(mntmInscribirTuristaA);
        
        
        /* *************** */
        /* Carga de Datos */
        /* ************* */
        
        JMenu mnCargar = new JMenu("Cargar");
        menuBar.add(mnCargar);
        
        JMenuItem mntmCargarDepartamentos = new JMenuItem("Cargar Departamentos");
        mntmCargarDepartamentos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ICA.cargarDptos();
					mntmCargarDepartamentos.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DepartamentoYaExisteExeption e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        
        JMenuItem mntmCargarusuarios = new JMenuItem("Cargar Usuarios");
        mntmCargarusuarios.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ICA.cargarUsuarios();
					mntmCargarusuarios.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UsuarioRepetidoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        mnCargar.add(mntmCargarusuarios);
        mnCargar.add(mntmCargarDepartamentos);
        
        JMenuItem mntmCargarActividades = new JMenuItem("Cargar Actividades");
        mntmCargarActividades.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ICA.cargarActs();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DepartamentoYaExisteExeption e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ActividadRepetidaException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        mnCargar.add(mntmCargarActividades);
        
        JMenuItem mntmCargarsalidas = new JMenuItem("CargarSalidas");
        mntmCargarsalidas.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ICA.cargarSalidas();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SalidaYaExisteExeption e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        mnCargar.add(mntmCargarsalidas);
        
        JMenuItem mntmCargarInscripciones = new JMenuItem("Cargar Inscripciones");
        mntmCargarInscripciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ICI.cargarInsc();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (TuristaConSalida e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ExcedeTuristas e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InscFechaInconsistente e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
        	}
        });
        mnCargar.add(mntmCargarInscripciones);
    
    }
}
