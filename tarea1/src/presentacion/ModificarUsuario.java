package presentacion;

import javax.swing.JInternalFrame;

import logica.DataProveedor;
import logica.DataTurista;
import logica.DataUsuario;
import logica.IControladorAlta;
import logica.IControladorConsulta;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JTextField;

import excepciones.UsuarioNoExisteException;
import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ModificarUsuario extends JInternalFrame {

	private IControladorAlta controlUsr;
	private JComboBox<String> comboUsuarios;
    //private JLabel lblUsuarios;
    //private JButton btnCerrar;
    private DataUsuario[] DU;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField nacionalidadField;
    private JTextField descripcionField;
    private JTextField linkField;
    //labels
    private JLabel usuariosLabel;
    private JLabel apellidoLabel;
    private JLabel nombreLabel;
    private JLabel fechaLabel;
    private JLabel nacionalidadLabel;
    private JLabel linkLabel;
    private JLabel descripcionLabel;
    private JButton aplicarBtn;
    private JButton cancelarBtn;
	private DataUsuario usuarioSeleccionado;
	private JDateChooser fechaField;
	public ModificarUsuario(IControladorAlta ICA)  {
		
		controlUsr = ICA;
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
        setTitle("Modificar Datos de Usuario");
        setBounds(30, 30, 499, 389);
        
        // En este caso se utiliza un BorderLayout en donde los componentes se ubican según una orientación.
        //getContentPane().setLayout(new BorderLayout(0, 0));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 0, 30, 30, 30, 150, 30, 30, 30, 30, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		usuariosLabel = new JLabel("Usuarios: ");
		GridBagConstraints gbc_usuariosLabel = new GridBagConstraints();
		gbc_usuariosLabel.anchor = GridBagConstraints.WEST;
		gbc_usuariosLabel.insets = new Insets(0, 0, 5, 5);
		gbc_usuariosLabel.gridx = 4;
		gbc_usuariosLabel.gridy = 1;
		getContentPane().add(usuariosLabel, gbc_usuariosLabel);
		
		comboUsuarios = new JComboBox();
		GridBagConstraints gbc_comboUsuarios = new GridBagConstraints();
		gbc_comboUsuarios.gridwidth = 3;
		gbc_comboUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_comboUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboUsuarios.gridx = 5;
		gbc_comboUsuarios.gridy = 1;
		comboUsuarios.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		datosUsuarioSeleccionado();
	    	}	    	
	    });
		getContentPane().add(comboUsuarios, gbc_comboUsuarios);
        comboUsuarios.setVisible(false);

		nombreLabel = new JLabel("Nombre:");
		GridBagConstraints gbc_nombreLabel = new GridBagConstraints();
		gbc_nombreLabel.anchor = GridBagConstraints.WEST;
		gbc_nombreLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nombreLabel.gridx = 4;
		gbc_nombreLabel.gridy = 3;
		getContentPane().add(nombreLabel, gbc_nombreLabel);
		
		nombreField = new JTextField();
		GridBagConstraints gbc_nombreField = new GridBagConstraints();
		gbc_nombreField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreField.gridx = 5;
		gbc_nombreField.gridy = 3;
		getContentPane().add(nombreField, gbc_nombreField);
		nombreField.setColumns(10);

		apellidoLabel = new JLabel("Apellido:");
		GridBagConstraints gbc_apellidoLabel = new GridBagConstraints();
		gbc_apellidoLabel.anchor = GridBagConstraints.WEST;
		gbc_apellidoLabel.insets = new Insets(0, 0, 5, 5);
		gbc_apellidoLabel.gridx = 4;
		gbc_apellidoLabel.gridy = 4;
		getContentPane().add(apellidoLabel, gbc_apellidoLabel);
		
		apellidoField = new JTextField();
		GridBagConstraints gbc_apellidoField = new GridBagConstraints();
		gbc_apellidoField.insets = new Insets(0, 0, 5, 5);
		gbc_apellidoField.fill = GridBagConstraints.HORIZONTAL;
		gbc_apellidoField.gridx = 5;
		gbc_apellidoField.gridy = 4;
		getContentPane().add(apellidoField, gbc_apellidoField);
		apellidoField.setColumns(10);
		
		fechaLabel = new JLabel("Fecha Nacimiento:");
		GridBagConstraints gbc_fechaLabel = new GridBagConstraints();
		gbc_fechaLabel.anchor = GridBagConstraints.WEST;
		gbc_fechaLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fechaLabel.gridx = 4;
		gbc_fechaLabel.gridy = 5;
		getContentPane().add(fechaLabel, gbc_fechaLabel);
		
		fechaField = new JDateChooser();
		//fechaField.getDateEditor().setEnabled(false);
		fechaField.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_fechaField = new GridBagConstraints();
		gbc_fechaField.insets = new Insets(0, 0, 5, 5);
		gbc_fechaField.fill = GridBagConstraints.BOTH;
		gbc_fechaField.gridx = 5;
		gbc_fechaField.gridy = 5;
		getContentPane().add(fechaField, gbc_fechaField);
		
		nacionalidadLabel = new JLabel("Nacionalidad:");
		GridBagConstraints gbc_nacionalidadLabel = new GridBagConstraints();
		gbc_nacionalidadLabel.anchor = GridBagConstraints.WEST;
		gbc_nacionalidadLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nacionalidadLabel.gridx = 4;
		gbc_nacionalidadLabel.gridy = 6;
		getContentPane().add(nacionalidadLabel, gbc_nacionalidadLabel);
		
		nacionalidadField = new JTextField();
		GridBagConstraints gbc_nacionalidadField = new GridBagConstraints();
		gbc_nacionalidadField.insets = new Insets(0, 0, 5, 5);
		gbc_nacionalidadField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nacionalidadField.gridx = 5;
		gbc_nacionalidadField.gridy = 6;
		getContentPane().add(nacionalidadField, gbc_nacionalidadField);
		nacionalidadField.setColumns(10);
		
		descripcionLabel = new JLabel("Descripcion:");
		GridBagConstraints gbc_descripcionLabel = new GridBagConstraints();
		gbc_descripcionLabel.anchor = GridBagConstraints.WEST;
		gbc_descripcionLabel.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionLabel.gridx = 4;
		gbc_descripcionLabel.gridy = 7;
		getContentPane().add(descripcionLabel, gbc_descripcionLabel);
		
		descripcionField = new JTextField();
		GridBagConstraints gbc_descripcionField = new GridBagConstraints();
		gbc_descripcionField.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionField.gridx = 5;
		gbc_descripcionField.gridy = 7;
		getContentPane().add(descripcionField, gbc_descripcionField);
		descripcionField.setColumns(10);
		
		linkLabel = new JLabel("Link:");
		GridBagConstraints gbc_linkLabel = new GridBagConstraints();
		gbc_linkLabel.anchor = GridBagConstraints.WEST;
		gbc_linkLabel.insets = new Insets(0, 0, 5, 5);
		gbc_linkLabel.gridx = 4;
		gbc_linkLabel.gridy = 8;
		getContentPane().add(linkLabel, gbc_linkLabel);
		
		linkField = new JTextField();
		GridBagConstraints gbc_linkField = new GridBagConstraints();
		gbc_linkField.insets = new Insets(0, 0, 5, 5);
		gbc_linkField.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkField.gridx = 5;
		gbc_linkField.gridy = 8;
		getContentPane().add(linkField, gbc_linkField);
		linkField.setColumns(10);
		
		/* *** Botones ****/
		
		cancelarBtn = new JButton("Cancelar");
		GridBagConstraints gbc_cancelarBtn = new GridBagConstraints();
		gbc_cancelarBtn.insets = new Insets(0, 0, 0, 5);
		gbc_cancelarBtn.gridx = 4;
		gbc_cancelarBtn.gridy = 10;
		cancelarBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
				   setVisible(false);
	    	}	    	
	    });
		getContentPane().add(cancelarBtn, gbc_cancelarBtn);
		
		aplicarBtn = new JButton("Aplicar");
		GridBagConstraints gbc_aplicarBtn = new GridBagConstraints();
		gbc_aplicarBtn.fill = GridBagConstraints.HORIZONTAL;
		gbc_aplicarBtn.insets = new Insets(0, 0, 0, 5);
		gbc_aplicarBtn.gridx = 5;
		gbc_aplicarBtn.gridy = 10;
		aplicarBtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(chequearFormulario()) {
		    		actualizarDatosUsuario();
	    		}
	    	}	    	
	    });
		getContentPane().add(aplicarBtn, gbc_aplicarBtn);
		aplicarBtn.setVisible(false);
	}
	
	public void datosUsuarioSeleccionado() {
		//reseteamos los campos a vacio
		limpiarFormulario();
		
		String nickSeleccionado = (String)comboUsuarios.getSelectedItem();
		boolean encontrado = false;
		int i = 0;
		while(i<DU.length && !encontrado) {
			if(DU[i].getNick() == nickSeleccionado) {
				encontrado=true;
			}
			i++;
		}
		i--;
		
		nombreField.setVisible(true);
		apellidoField.setVisible(true);
		fechaField.setVisible(true);
		apellidoField.setVisible(true);
		nacionalidadField.setVisible(true);
		linkField.setVisible(true);
		descripcionField.setVisible(true);

		nombreLabel.setVisible(true);
		apellidoLabel.setVisible(true);
		fechaLabel.setVisible(true);
		apellidoLabel.setVisible(true);
		nacionalidadLabel.setVisible(true);
		linkLabel.setVisible(true);
		descripcionLabel.setVisible(true);
		
		aplicarBtn.setVisible(true);
		
		usuarioSeleccionado = DU[i];
		nombreField.setText(DU[i].getNombre());
		apellidoField.setText(DU[i].getApellido());
		fechaField.setDate(DU[i].getNacimiento());
		apellidoField.setText(DU[i].getApellido());
		if(DU[i] instanceof DataTurista) {
			nacionalidadField.setText(((DataTurista) DU[i]).getNacionalidad());
			setTurista();
		}
		if(DU[i] instanceof DataProveedor) {
			linkField.setText(((DataProveedor) DU[i]).getLink());
			descripcionField.setText(((DataProveedor) DU[i]).getDescripcion());
			setProveedor();
		}
	}

	public void actualizarDatosUsuario(){
		if(usuarioSeleccionado instanceof DataTurista) {
			controlUsr.actualizarDatosTurista(usuarioSeleccionado.getNick(),usuarioSeleccionado.getMail(), nombreField.getText(),apellidoField.getText(),fechaField.getDate(),nacionalidadField.getText());
			
		}else if(usuarioSeleccionado instanceof DataProveedor)
			controlUsr.actualizarDatosProveedor(usuarioSeleccionado.getNick(),usuarioSeleccionado.getMail(),nombreField.getText() ,apellidoField.getText(),fechaField.getDate() ,descripcionField.getText(),linkField.getText(),!(linkField.getText().isEmpty()));
		
		JOptionPane.showMessageDialog(this, "Datos actualizados!", "Modificar Usuario",
        JOptionPane.INFORMATION_MESSAGE);
		limpiarFormulario();
        setVisible(false);
	}
	
	private boolean chequearFormulario() {
        String nombreU = nombreField.getText();
        String apellidoU = apellidoField.getText();
        Date fechaN = fechaField.getDate();
        if(usuarioSeleccionado instanceof DataTurista) {
        	String nacionalidadU = nacionalidadField.getText();
        	if ((nombreU.isEmpty() || apellidoU.isEmpty() || nacionalidadU.isEmpty()) || (fechaN==null)) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Usuario",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }			
		}else if(usuarioSeleccionado instanceof DataProveedor) {
			String descripcionU = descripcionField.getText();
			//String linkU = linkField.getText();
			if (nombreU.isEmpty() || apellidoU.isEmpty() || descripcionU.isEmpty() || (fechaN==null)) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Usuario",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
		}
        return true;
	}
	
	private void setTurista() {
		linkField.setEditable(false);
		descripcionField.setEditable(false);
		nacionalidadField.setEditable(true);
    }
	
	private void setProveedor() {
		nacionalidadField.setEditable(false);
		linkField.setEditable(true);
		descripcionField.setEditable(true);
    	}
	
	public void limpiarFormulario() {
		nombreField.setText("");
		apellidoField.setText("");
		//fechaField.setText("");
		apellidoField.setText("");
		nacionalidadField.setText("");
		linkField.setText("");
		descripcionField.setText("");
		
		nombreField.setVisible(false);
		apellidoField.setVisible(false);
		fechaField.setVisible(false);
		apellidoField.setVisible(false);
		nacionalidadField.setVisible(false);
		linkField.setVisible(false);
		descripcionField.setVisible(false);
		
		nombreLabel.setVisible(false);
		apellidoLabel.setVisible(false);
		fechaLabel.setVisible(false);
		apellidoLabel.setVisible(false);
		nacionalidadLabel.setVisible(false);
		linkLabel.setVisible(false);
		descripcionLabel.setVisible(false);
	}
	
	public void cargarUsuarios() throws UsuarioNoExisteException{
        setVisible(false);
        try {
        	DefaultComboBoxModel<String> model;
        	DU = controlUsr.getUsuarios();
        	String[] nomUsuarios = new String[DU.length]; 
        	int i=0;
        	while(i<DU.length) {
        		nomUsuarios[i]=((DU[i].getNick()));
        		i++;
        	}
        	//DU2 = DU;
            model = new DefaultComboBoxModel<String>(nomUsuarios);
            comboUsuarios.setModel(model);
            comboUsuarios.setVisible(true);
            setVisible(true);
        } catch (UsuarioNoExisteException e) {
        	JOptionPane.showMessageDialog(this, e.getMessage(), "Modificar Usuario", JOptionPane.ERROR_MESSAGE);
        }

    }
}
