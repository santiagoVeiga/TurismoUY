package presentacion;

import javax.swing.JInternalFrame;

import excepciones.ActividadRepetidaException;
import logica.Departamento;
import logica.IControladorAlta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

//import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.Box;
import javax.swing.JSplitPane;


@SuppressWarnings("serial")
public class CrearActividad extends JInternalFrame {
	
    private IControladorAlta controlAlta;

	private JTextField nombreTextField;
	private JTextField descripcionTextField;
	private JTextField costoTextField;
	private JTextField duracionTextField;
	private JTextField ciudadTextField;
	private JTextField departamentoTextField;
    private JCalendar calendario;

	public CrearActividad(IControladorAlta ica) {
		
        controlAlta = ica;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta Actividad");
        setBounds(10, 40, 776, 462);
        
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 100, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel Nombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_Nombre = new GridBagConstraints();
		gbc_Nombre.anchor = GridBagConstraints.EAST;
		gbc_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_Nombre.gridx = 1;
		gbc_Nombre.gridy = 1;
		getContentPane().add(Nombre, gbc_Nombre);
		
		nombreTextField = new JTextField();
		GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
		gbc_nombreTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreTextField.gridx = 2;
		gbc_nombreTextField.gridy = 1;
		getContentPane().add(nombreTextField, gbc_nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel costo = new JLabel("Costo: ");
		GridBagConstraints gbc_costo = new GridBagConstraints();
		gbc_costo.anchor = GridBagConstraints.EAST;
		gbc_costo.insets = new Insets(0, 0, 5, 5);
		gbc_costo.gridx = 3;
		gbc_costo.gridy = 1;
		getContentPane().add(costo, gbc_costo);
		
		costoTextField = new JTextField();
		GridBagConstraints gbc_costoTextField = new GridBagConstraints();
		gbc_costoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_costoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_costoTextField.gridx = 4;
		gbc_costoTextField.gridy = 1;
		getContentPane().add(costoTextField, gbc_costoTextField);
		costoTextField.setColumns(10);
		
		JLabel descripcion = new JLabel("Descripcion: ");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_descripcion = new GridBagConstraints();
		gbc_descripcion.anchor = GridBagConstraints.EAST;
		gbc_descripcion.insets = new Insets(0, 0, 5, 5);
		gbc_descripcion.gridx = 1;
		gbc_descripcion.gridy = 2;
		getContentPane().add(descripcion, gbc_descripcion);
		
		descripcionTextField = new JTextField();
		GridBagConstraints gbc_descripcionTextField = new GridBagConstraints();
		gbc_descripcionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionTextField.gridx = 2;
		gbc_descripcionTextField.gridy = 2;
		getContentPane().add(descripcionTextField, gbc_descripcionTextField);
		descripcionTextField.setColumns(10);
		
		JLabel duracion = new JLabel("Duraci\u00F3n: ");
		GridBagConstraints gbc_duracion = new GridBagConstraints();
		gbc_duracion.anchor = GridBagConstraints.EAST;
		gbc_duracion.insets = new Insets(0, 0, 5, 5);
		gbc_duracion.gridx = 3;
		gbc_duracion.gridy = 2;
		getContentPane().add(duracion, gbc_duracion);
		
		duracionTextField = new JTextField();
		GridBagConstraints gbc_duracionTextField = new GridBagConstraints();
		gbc_duracionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_duracionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_duracionTextField.gridx = 4;
		gbc_duracionTextField.gridy = 2;
		getContentPane().add(duracionTextField, gbc_duracionTextField);
		duracionTextField.setColumns(10);
		
		JLabel ciudad = new JLabel("Ciudad: ");
		GridBagConstraints gbc_ciudad = new GridBagConstraints();
		gbc_ciudad.anchor = GridBagConstraints.EAST;
		gbc_ciudad.insets = new Insets(0, 0, 5, 5);
		gbc_ciudad.gridx = 1;
		gbc_ciudad.gridy = 3;
		getContentPane().add(ciudad, gbc_ciudad);
		
		ciudadTextField = new JTextField();
		GridBagConstraints gbc_ciudadTextField = new GridBagConstraints();
		gbc_ciudadTextField.insets = new Insets(0, 0, 5, 5);
		gbc_ciudadTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciudadTextField.gridx = 2;
		gbc_ciudadTextField.gridy = 3;
		getContentPane().add(ciudadTextField, gbc_ciudadTextField);
		ciudadTextField.setColumns(10);
		
		JLabel departamento = new JLabel("Departamento: ");
		GridBagConstraints gbc_departamento = new GridBagConstraints();
		gbc_departamento.anchor = GridBagConstraints.EAST;
		gbc_departamento.insets = new Insets(0, 0, 5, 5);
		gbc_departamento.gridx = 1;
		gbc_departamento.gridy = 4;
		getContentPane().add(departamento, gbc_departamento);
		
		departamentoTextField = new JTextField();
		GridBagConstraints gbc_departamentoTextField = new GridBagConstraints();
		gbc_departamentoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_departamentoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_departamentoTextField.gridx = 2;
		gbc_departamentoTextField.gridy = 4;
		getContentPane().add(departamentoTextField, gbc_departamentoTextField);
		departamentoTextField.setColumns(10);
		
		JLabel fechaAlta = new JLabel("Fecha Alta: ");
		GridBagConstraints gbc_fechaAlta = new GridBagConstraints();
		gbc_fechaAlta.anchor = GridBagConstraints.EAST;
		gbc_fechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_fechaAlta.gridx = 1;
		gbc_fechaAlta.gridy = 5;
		getContentPane().add(fechaAlta, gbc_fechaAlta);
		
		calendario = new JCalendar();
		GridBagConstraints gbc_calendario_1 = new GridBagConstraints();
		gbc_calendario_1.insets = new Insets(0, 0, 5, 5);
		gbc_calendario_1.fill = GridBagConstraints.BOTH;
		gbc_calendario_1.gridx = 2;
		gbc_calendario_1.gridy = 5;
		getContentPane().add(calendario, gbc_calendario_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 6;
		getContentPane().add(panel, gbc_panel);
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JButton cancelarBtn = new JButton("Cancelar");
		splitPane.setRightComponent(cancelarBtn);
		
		JButton aceptarBtn = new JButton("Aceptar");
		splitPane.setLeftComponent(aceptarBtn);
	}
	
	protected void cmdRegistroActividadActionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        // Obtengo datos de los controles Swing
		
        String nombreAct = this.nombreTextField.getText();
        String descripcionAct = this.descripcionTextField.getText();
        String costoAct = this.costoTextField.getText(); //	Ver que se pueda ingresar solo numero
        String duracionAct = this.duracionTextField.getText(); //	Ver que se pueda ingresar solo numero
        Date fechaAct = calendario.getDate();
        String ciudadAct = this.ciudadTextField.getText(); 
        String departamentoAct = this.departamentoTextField.getText(); // Tiene que ser tipo departamento ListarDepto y seleccionar
        
        if (checkFormulario()) {
            try {
                controlAlta.registrarActividad(null, nombreAct, descripcionAct,Integer.parseInt(duracionAct),Integer.parseInt(costoAct),ciudadAct ,fechaAct);
                //Exito
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con exito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (UsuarioRepetidoException e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }

            // Limpio el internal frame antes de cerrar la ventana
            limpiarFormulario();
            setVisible(false);
        }
    }

    // Permite validar la informacion introducida en los campos e indicar
    // a traves de un mensaje de error (JOptionPane) cuando algo sucede.
    // Este tipo de chequeos se puede realizar de otras formas y con otras librerias de Java, 
    // por ejemplo impidiendo que se escriban caracteres no numericos al momento de escribir en
    // en el campo de la cedula, o mostrando un mensaje de error apenas el foco pasa a otro campo.
    private boolean checkFormulario() {
    	String nombreAct = this.nombreTextField.getText();
        String descripcionAct = this.descripcionTextField.getText();
        String costoAct = this.costoTextField.getText(); //	Ver que se pueda ingresar solo numero
        String duracionAct = this.duracionTextField.getText(); //	Ver que se pueda ingresar solo numero
        //String fechaAct = this.fechaTextField.getText(); //	Ver que se pueda ingresar solo fecha JCalendar
        String ciudadAct = this.ciudadTextField.getText();
        String departamentoAct = this.departamentoTextField.getText(); // Tiene que ser tipo departamento ListarDepto y seleccionar

        if (nombreAct.isEmpty() || descripcionAct.isEmpty() || costoAct.isEmpty() || duracionAct.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(costoAct);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Costo debe ser un numero", "Registrar Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(duracionAct);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La Duracion debe ser un numero", "Registrar Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la informacion para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        nombreTextField.setText("");
        descripcionTextField.setText("");
        costoTextField.setText("");
        duracionTextField.setText("");
        ciudadTextField.setText("");
        fechaTextField.setText(""); // Ver como hacer con Fecha JCalendar
        departamentoTextField.setText("");
    }
}
