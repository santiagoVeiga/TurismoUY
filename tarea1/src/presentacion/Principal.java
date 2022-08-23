package presentacion;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import excepciones.DepartamentoYaExisteExeption;
import excepciones.UsuarioNoExisteException;
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
     */
    public Principal() throws DepartamentoYaExisteExeption, IOException {
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
        

        //****** ACTIVIDAD *********/

        creActInternalFrame = new CrearActividad(ICA);
        creActInternalFrame.setVisible(false);

        conActInternalFrame = new ConsultarActividad(ICC);
        conActInternalFrame.setVisible(false);

        
        
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
        
        
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        // Se crea el Frame con las dimensiones indicadas.
        frmGestionDeUsuarios = new JFrame();
        frmGestionDeUsuarios.setTitle("Gestion de Usuarios 1.0");
        frmGestionDeUsuarios.setBounds(100, 100, 450, 400);
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

        JMenuItem menuItemVerInfo = new JMenuItem("Ver Información");
        menuItemVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Muestro el InternalFrame para ver información de un usuario
                conUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(menuItemVerInfo);

        JMenuItem mntmListaUsuarios = new JMenuItem("ListarUsuarios");
        mntmListaUsuarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                lisUsrInternalFrame.cargarUsuarios();
                lisUsrInternalFrame.setVisible(true);
            }
        });
        menuUsuarios.add(mntmListaUsuarios);
        
        /* **** Actividad **** */
        
        JMenu menuActividad = new JMenu("Actividad");
        menuBar.add(menuActividad);

        JMenuItem menuItemRegistrarActividad = new JMenuItem("Registrar Actividad");
        menuItemRegistrarActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creActInternalFrame.cargarDepartamentos();
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
        
        /* Inscripcion */
        
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
        
        JMenu mnCargar = new JMenu("Cargar");
        menuBar.add(mnCargar);
        
        JMenuItem mntmCargarDepartamentos = new JMenuItem("Cargar Departamentos");
        mntmCargarDepartamentos.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					ICA.cargarDptos();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (DepartamentoYaExisteExeption e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        mnCargar.add(mntmCargarDepartamentos);
    
    }
}
