//incompleto


package presentacion;

import javax.swing.JInternalFrame;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.IControladorConsulta;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;

/**
 * JInternalFrame que permite consultar la información de un usuario del sistema.
 * @author TProg2017
 *
 */
@SuppressWarnings("serial")
public class ConsultaSalidaTuristica extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorConsulta controlCons;
    private JButton btnBuscar;
    private JButton btnCerrar;
    private JComboBox<String> jcbDepartamentos;
    private JComboBox<DataSalida> jcbActividades;
    private DataDepartamento[] DD;
    private DataSalida[] DA;
    private JLabel Actividades;

    /**
     * Create the frame.
     */
    public ConsultaSalidaTuristica(IControladorConsulta icc) {
        // Se inicializa con el controlador de usuarios
        controlCons = icc;
        
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar una Actividad");
        setBounds(30, 30, 400, 280);

        // En este caso usaremos el Absolute Layout y deberemos indicar
        // la posición absoluta de todos los componentes
        getContentPane().setLayout(null);

        JLabel Departamento = new JLabel("Departamento: ");
        Departamento.setSize(125, 32);
        Departamento.setLocation(40, 12);
		GridBagConstraints gbc_Departamento = new GridBagConstraints();
		gbc_Departamento.anchor = GridBagConstraints.EAST;
		gbc_Departamento.insets = new Insets(2, 2, 5, 5);
		getContentPane().add(Departamento, gbc_Departamento);
        
        jcbDepartamentos = new JComboBox<String>();
        jcbDepartamentos.setBounds(183, 16, 160, 24);
        getContentPane().add(jcbDepartamentos);
        jcbDepartamentos.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		Actividades.setVisible(true);
        		jcbActividades.setVisible(true);
        		cargarSalidas();
        	}
        });
        
        Actividades = new JLabel("Salidas: ");
        Actividades.setSize(125, 32);
        Actividades.setLocation(40, 50);
		GridBagConstraints gbc_Actividades = new GridBagConstraints();
		gbc_Actividades.anchor = GridBagConstraints.EAST;
		gbc_Actividades.insets = new Insets(2, 2, 5, 5);
		getContentPane().add(Actividades, gbc_Actividades);
		Actividades.setVisible(false);
		
        jcbActividades = new JComboBox<DataSalida>();
        jcbActividades.setBounds(183, 54, 160, 24);
        getContentPane().add(jcbActividades);
        jcbActividades.setVisible(false);
        
        // Un botón (JButton) con un evento asociado que permite buscar un usuario.
        // Dado que el código de registro tiene cierta complejidad, conviene delegarlo
        // a otro método en lugar de incluirlo directamente de el método actionPerformed 
        /*
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmdBuscarUsuarioActionPerformed(e);
            }
        });
        btnBuscar.setBounds(160, 187, 95, 30);
        getContentPane().add(btnBuscar);
        */
        // Un botón (JButton) con un evento asociado que permite cerrar el formulario (solo ocultarlo).
        // Dado que antes de cerrar se limpia el formulario, se invoca un método reutilizable para ello. 
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jcbDepartamentos.removeAllItems();
                setVisible(false);
            }
        });
        btnCerrar.setBounds(262, 191, 89, 23);
        getContentPane().add(btnCerrar);
    }

public void cargarDepartamentos(){
    	DefaultComboBoxModel<String> model;
    	try {
    		DD = controlCons.obtenerDataDepartamentos();
    		String[] DepartamentosNombres = new String[DD.length];
    		for (int i = 0; i < DD.length;i++) {
    			DepartamentosNombres[i] = DD[i].getNombre();
    		}
	    	model = new DefaultComboBoxModel<String>(DepartamentosNombres);
	        jcbDepartamentos.setModel(model);
	    } catch (DepartamentoNoExisteException e) {
    	}
    }


public void cargarSalidas(){
	DefaultComboBoxModel<DataSalida> model;
	try {
		String aux = (String) jcbDepartamentos.getSelectedItem();
		int i = 0;
		while (i<DD.length && DD[i].getNombre() != aux) {
			i++;
		}
		DA = null;
		if (DA == null) {
			throw new ActividadNoExisteException("No hay salidas asociadas a dicho Departamento");
		}
    	model = new DefaultComboBoxModel<DataSalida>(DA);
        jcbActividades.setModel(model);
    } catch (ActividadNoExisteException e) {
	}
}

    
    // Este método es invocado al querer buscar un usuario, funcionalidad
    // provista por la operación del sistem verInfoUsuario().
    // En caso de que haya un error de búsqueda se despliega
    // un mensaje utilizando un panel de mensaje (JOptionPane).
    // No es necesario verificar que el campo con la cédula sea un número ya
    // que internamente el sistema almacena la cédula como un string.
    /*
    protected void cmdBuscarUsuarioActionPerformed(ActionEvent e) {
        DataUsuario du;
        try {
            du = controlCons.verInfoUsuario(textFieldCI.getText());
            textFieldNombre.setText(du.getNombre());
            textFieldApellido.setText(du.getApellido());
        } catch (UsuarioNoExisteException e1) {
            // Si el usuario no existe, se muestra mensaje de error y se limpia el
            // formulario.
            JOptionPane.showMessageDialog(this, e1.getMessage(), "Buscar Usuario", JOptionPane.ERROR_MESSAGE);
            limpiarFormulario();
        }

    }
    */

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        //textFieldNombre.setText("");
        //textFieldApellido.setText("");
        //textFieldCI.setText("");
    }
}


//es igual que el consulta actividad nada mas que dentro del DataActividad devovlemos las salidas
