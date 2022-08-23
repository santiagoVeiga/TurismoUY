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
import javax.swing.JComboBox;


@SuppressWarnings("serial")
public class CrearActividad extends JInternalFrame {
	
    private IControladorAlta controlAlta;

	private JTextField nombreTextField;
	private JTextField descripcionTextField;
	private JTextField costoTextField;
	private JTextField duracionTextField;
	private JTextField ciudadTextField;
    private JCalendar calendario;
    private JComboBox departamentoComboBox;

	public CrearActividad(IControladorAlta ica) {
		
        controlAlta = ica;

        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta Actividad");
        setBounds(10, 40, 579, 462);
        
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
		
		departamentoComboBox = new JComboBox<Departamento>();
		GridBagConstraints gbc_departamentoComboBox = new GridBagConstraints();
		gbc_departamentoComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_departamentoComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_departamentoComboBox.gridx = 2;
		gbc_departamentoComboBox.gridy = 4;
		getContentPane().add(departamentoComboBox, gbc_departamentoComboBox);
		
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
		gbc_panel.gridheight = 3;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 6;
		getContentPane().add(panel, gbc_panel);
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JButton cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarFormulario();
                setVisible(false);
            }
        });
		splitPane.setRightComponent(cancelarBtn);
		
		JButton aceptarBtn = new JButton("Aceptar");
		aceptarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	cmdRegistroActividadActionPerformed(arg0);
            }
        });
		splitPane.setLeftComponent(aceptarBtn);
	}
	
	protected void cmdRegistroActividadActionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        // Obtengo datos de los controles Swing
		
        String nombreAct = this.nombreTextField.getText();
        String descripcionAct = this.descripcionTextField.getText();
        String costoAct = this.costoTextField.getText(); 
        String duracionAct = this.duracionTextField.getText();
        Date fechaAct = calendario.getDate();
        String ciudadAct = this.ciudadTextField.getText();
        Departamento departamentoAct = (Departamento)departamentoComboBox.getSelectedItem();
        
        if (checkFormulario()) {
            try {
                controlAlta.registrarActividad(departamentoAct, nombreAct, descripcionAct,Integer.parseInt(duracionAct),Integer.parseInt(costoAct),ciudadAct ,fechaAct);
                JOptionPane.showMessageDialog(this, "La actividad ha sido registrada exitosamente.", "Registrar Actividad",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (ActividadRepetidaException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }
            limpiarFormulario();
            setVisible(false);
        }
    }

    private boolean checkFormulario() {
    	String nombreAct = this.nombreTextField.getText();
        String descripcionAct = this.descripcionTextField.getText();
        String costoAct = this.costoTextField.getText(); 
        String duracionAct = this.duracionTextField.getText();
        //Date nacimientoU = calendario.getDate();
        String ciudadAct = this.ciudadTextField.getText();

        if (nombreAct.isEmpty() || descripcionAct.isEmpty() || costoAct.isEmpty() || duracionAct.isEmpty() || ciudadAct.isEmpty()) {
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

    private void limpiarFormulario() {
        nombreTextField.setText("");
        descripcionTextField.setText("");
        costoTextField.setText("");
        duracionTextField.setText("");
        ciudadTextField.setText("");
        //fechaTextField.setText(""); // Ver como hacer con Fecha JCalendar
        //departamentoTextField.setText("");
    }
}
