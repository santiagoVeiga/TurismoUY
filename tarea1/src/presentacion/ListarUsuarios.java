 package presentacion;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import logica.DataProveedor;
import logica.DataTurista;
import logica.DataUsuario;
import logica.IControladorConsulta;

/**
 * JInternalFrame que permite listar todos los usuarios del sistema.
 * @author TProg2017
 *
 */
@SuppressWarnings("serial")
public class ListarUsuarios extends JInternalFrame {

	private IControladorConsulta controlUsr;
	private JComboBox<String> comboBoxUsuarios;
    private JLabel lblUsuarios;
    private JButton btnCerrar;
    private DataUsuario[] dataUsuario2;
    private ConsultaSalidaTuristica sal;
    private ConsultarActividad act;
	
	
    public ListarUsuarios(IControladorConsulta ICC) {
        // Se inicializa con el controlador de usuarios
        controlUsr = ICC;
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        
        
        setTitle("Consultar un Usuario");
        setBounds(30, 30, 300, 100);
        
        // En este caso se utiliza un BorderLayout en donde los componentes se ubican según una orientación.
        getContentPane().setLayout(new BorderLayout(0, 0));

        // Una etiqueta (JLabel) muestra el título de la lista que vendrá después.
        // Se ubica al norte del layout y el texto se centra horizontalmente.
        lblUsuarios = new JLabel("Usuarios Registrados");
        lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(lblUsuarios, BorderLayout.NORTH);

        // Un combo (JComboBox) muestra la lista de usuarios registrados en el sistema.
        // Es posible utilizar otros componentes gráficos, esta es sólo una opción.
        // Se ubica al centro del layout.
        comboBoxUsuarios = new JComboBox<String>();
        getContentPane().add(comboBoxUsuarios, BorderLayout.CENTER);

        // Un botón (JButton) con un evento asociado que permite limpiar la lista 
        // de usuarios y cerrar la ventana (sólo la oculta).
        // Se ubica al sur del layout.
        btnCerrar = new JButton("Informacion del Usuario");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int i = comboBoxUsuarios.getSelectedIndex();
                setVisible(false);
                if(dataUsuario2[i] instanceof DataTurista)
                {
                	InfoTurista it = new InfoTurista((DataTurista) dataUsuario2[i],sal);
                	it.setVisible(true);
                	it.cargar();
                }else if(dataUsuario2[i] instanceof DataProveedor)
                {
                	InfoProveedor it = new InfoProveedor((DataProveedor) dataUsuario2[i],ICC,sal,act);
                	it.setVisible(true);
                	it.cargar();
                }
                
            }
        });
        getContentPane().add(btnCerrar, BorderLayout.SOUTH);
    }

    // Método que permite cargar un nuevo modelo para el combo con la información
    // actualizada de usuarios, provista por la operación del sistema getUsuarios(). 
    // Se invoca el método antes de hacer visible el JInternalFrame
    
    
    
    public void cargarUsuarios(){
        
        setVisible(false);
        try {
        	DefaultComboBoxModel<String> model;
        	DataUsuario[] DU = controlUsr.listarUsuarios();
        	String[] nomUsuarios = new String[DU.length]; 
        	int i=0;
        	while(i<DU.length) 
        	{
        		if (DU[i] instanceof DataTurista){
        			nomUsuarios[i]=((DU[i].getNick()) + " - Turista");
        		}else if(DU[i] instanceof DataProveedor){
        			nomUsuarios[i]=((DU[i].getNick()) + " - Proveedor");
        		}
        		i++;
        	}
        	dataUsuario2 = DU;
            model = new DefaultComboBoxModel<String>(nomUsuarios);
            comboBoxUsuarios.setModel(model);
            setVisible(true);
        } catch (NullPointerException e) {
            // No se imprime mensaje de error sino que simplemente no se muestra ningún elemento
        	ErrorUsuario EU = new ErrorUsuario();
        	EU.setVisible(true);
        	setVisible(false);
        }

    }

	public void setSal(ConsultaSalidaTuristica sal) {
		this.sal = sal;
	}

	public void setAct(ConsultarActividad act) {
		this.act = act;
	}

}
