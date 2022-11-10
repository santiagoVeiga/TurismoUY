package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

//import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import excepciones.ActividadRepetidaException;
import excepciones.DepartamentoNoExisteException;
import excepciones.NoExisteCategoriaException;
import excepciones.ProveedorNoNacidoException;
import excepciones.UsuarioNoExisteException;
import logica.DataDepartamento;
import logica.DataProveedor;
import logica.DataUsuario;
import logica.IControladorAlta;


@SuppressWarnings("serial")
public class CrearActividad extends JInternalFrame {
	
    private IControladorAlta controlAlta;
	private JTextField nombreTextField;
	private JTextField descripcionTextField;
	private JTextField costoTextField;
	private JTextField duracionTextField;
	private JTextField ciudadTextField;
    private JDateChooser calendario;
    private JComboBox<String> departamentoComboBox;
    //private JList<String> myList ; 
    private JComboBox<String> proveedoresComboBox;
    private DataDepartamento[] dataDepartamentos;
    private DataUsuario[] dataUsuarios;
    private DataProveedor[] dataProveedorArray;
    //private DataUsuario[] DP;
    private JComboBox<String> categoriasComboBox;
    private JList<String> categoriasList;
    private DefaultListModel<String> modelo;
    private JTextField linkTextField;
    

	public CrearActividad(IControladorAlta ica) {
		
        controlAlta = ica;
        setBounds(10, 40, 541, 601);
        
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 0, 30, 30, 30, 30, 0, 30, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel Nombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_Nombre = new GridBagConstraints();
		gbc_Nombre.anchor = GridBagConstraints.EAST;
		gbc_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_Nombre.gridx = 1;
		gbc_Nombre.gridy = 0;
		getContentPane().add(Nombre, gbc_Nombre);
		
		nombreTextField = new JTextField();
		GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
		gbc_nombreTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreTextField.gridx = 2;
		gbc_nombreTextField.gridy = 0;
		getContentPane().add(nombreTextField, gbc_nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel descripcion = new JLabel("Descripcion: ");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_descripcion = new GridBagConstraints();
		gbc_descripcion.anchor = GridBagConstraints.EAST;
		gbc_descripcion.insets = new Insets(0, 0, 5, 5);
		gbc_descripcion.gridx = 1;
		gbc_descripcion.gridy = 1;
		getContentPane().add(descripcion, gbc_descripcion);
		
		descripcionTextField = new JTextField();
		GridBagConstraints gbc_descripcionTextField = new GridBagConstraints();
		gbc_descripcionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionTextField.gridx = 2;
		gbc_descripcionTextField.gridy = 1;
		getContentPane().add(descripcionTextField, gbc_descripcionTextField);
		descripcionTextField.setColumns(10);
		
		JLabel ciudad = new JLabel("Ciudad: ");
		GridBagConstraints gbc_ciudad = new GridBagConstraints();
		gbc_ciudad.anchor = GridBagConstraints.EAST;
		gbc_ciudad.insets = new Insets(0, 0, 5, 5);
		gbc_ciudad.gridx = 1;
		gbc_ciudad.gridy = 2;
		getContentPane().add(ciudad, gbc_ciudad);
		
		ciudadTextField = new JTextField();
		GridBagConstraints gbc_ciudadTextField = new GridBagConstraints();
		gbc_ciudadTextField.insets = new Insets(0, 0, 5, 5);
		gbc_ciudadTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ciudadTextField.gridx = 2;
		gbc_ciudadTextField.gridy = 2;
		getContentPane().add(ciudadTextField, gbc_ciudadTextField);
		ciudadTextField.setColumns(10);
		
		JLabel departamento = new JLabel("Departamento: ");
		GridBagConstraints gbc_departamento = new GridBagConstraints();
		gbc_departamento.anchor = GridBagConstraints.EAST;
		gbc_departamento.insets = new Insets(0, 0, 5, 5);
		gbc_departamento.gridx = 1;
		gbc_departamento.gridy = 3;
		getContentPane().add(departamento, gbc_departamento);
		
		departamentoComboBox = new JComboBox<String>();
		GridBagConstraints gbc_departamentoComboBox = new GridBagConstraints();
		gbc_departamentoComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_departamentoComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_departamentoComboBox.gridx = 2;
		gbc_departamentoComboBox.gridy = 3;
		getContentPane().add(departamentoComboBox, gbc_departamentoComboBox);
		
		JLabel proveedores = new JLabel("Proveedores");
		GridBagConstraints gbc_proveedores = new GridBagConstraints();
		gbc_proveedores.anchor = GridBagConstraints.EAST;
		gbc_proveedores.insets = new Insets(0, 0, 5, 5);
		gbc_proveedores.gridx = 1;
		gbc_proveedores.gridy = 4;
		getContentPane().add(proveedores, gbc_proveedores);
		
		proveedoresComboBox = new JComboBox<String>();
		GridBagConstraints gbc_proveedoresComboBox = new GridBagConstraints();
		gbc_proveedoresComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_proveedoresComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_proveedoresComboBox.gridx = 2;
		gbc_proveedoresComboBox.gridy = 4;
		getContentPane().add(proveedoresComboBox, gbc_proveedoresComboBox);
		
		JLabel lblCategorias = new JLabel("Categorias");
		GridBagConstraints gbc_lblCategorias = new GridBagConstraints();
		gbc_lblCategorias.anchor = GridBagConstraints.EAST;
		gbc_lblCategorias.insets = new Insets(0, 0, 5, 5);
		gbc_lblCategorias.gridx = 1;
		gbc_lblCategorias.gridy = 5;
		getContentPane().add(lblCategorias, gbc_lblCategorias);
		
		categoriasComboBox = new JComboBox<String>();
		GridBagConstraints gbc_categoriasComboBox = new GridBagConstraints();
		gbc_categoriasComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_categoriasComboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_categoriasComboBox.gridx = 2;
		gbc_categoriasComboBox.gridy = 5;
		getContentPane().add(categoriasComboBox, gbc_categoriasComboBox);
		categoriasComboBox.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		if (modelo.indexOf((String) categoriasComboBox.getSelectedItem()) == -1)
        		modelo.addElement((String) categoriasComboBox.getSelectedItem());
        	}
        });
		
		JLabel categoriasText = new JLabel("Categorias Elegidas:  ");
		GridBagConstraints gbc_categoriasText = new GridBagConstraints();
		gbc_categoriasText.insets = new Insets(0, 0, 5, 5);
		gbc_categoriasText.gridx = 1;
		gbc_categoriasText.gridy = 6;
		getContentPane().add(categoriasText, gbc_categoriasText);
		
		categoriasList = new JList<String>();
		GridBagConstraints gbc_CategoriasList = new GridBagConstraints();
		gbc_CategoriasList.insets = new Insets(0, 0, 5, 5);
		gbc_CategoriasList.fill = GridBagConstraints.BOTH;
		gbc_CategoriasList.gridx = 2;
		gbc_CategoriasList.gridy = 6;
		getContentPane().add(categoriasList, gbc_CategoriasList);
		categoriasList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		modelo = new DefaultListModel<>();
		categoriasList.setModel(modelo);
		categoriasList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent eve) {
				if (!categoriasList.isSelectionEmpty())
					modelo.remove(categoriasList.getSelectedIndex());
			}
		});
		
		
		JLabel fechaAlta = new JLabel("Fecha Alta: ");
		GridBagConstraints gbc_fechaAlta = new GridBagConstraints();
		gbc_fechaAlta.anchor = GridBagConstraints.EAST;
		gbc_fechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_fechaAlta.gridx = 1;
		gbc_fechaAlta.gridy = 7;
		getContentPane().add(fechaAlta, gbc_fechaAlta);


		
		calendario = new JDateChooser();
		GridBagConstraints gbc_calendario_1 = new GridBagConstraints();
		gbc_calendario_1.insets = new Insets(0, 0, 5, 5);
		gbc_calendario_1.fill = GridBagConstraints.BOTH;
		gbc_calendario_1.gridx = 2;
		gbc_calendario_1.gridy = 7;
		getContentPane().add(calendario, gbc_calendario_1);
		((JTextComponent) calendario.getDateEditor()).setEditable(false);

		JLabel costo = new JLabel("Costo: ");
		GridBagConstraints gbc_costo = new GridBagConstraints();
		gbc_costo.anchor = GridBagConstraints.EAST;
		gbc_costo.insets = new Insets(0, 0, 5, 5);
		gbc_costo.gridx = 1;
		gbc_costo.gridy = 8;
		getContentPane().add(costo, gbc_costo);
		
		costoTextField = new JTextField();
		GridBagConstraints gbc_costoTextField = new GridBagConstraints();
		gbc_costoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_costoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_costoTextField.gridx = 2;
		gbc_costoTextField.gridy = 8;
		getContentPane().add(costoTextField, gbc_costoTextField);
		costoTextField.setColumns(10);
		
		JLabel duracion = new JLabel("Duraci\u00F3n: ");
		GridBagConstraints gbc_duracion = new GridBagConstraints();
		gbc_duracion.anchor = GridBagConstraints.EAST;
		gbc_duracion.insets = new Insets(0, 0, 5, 5);
		gbc_duracion.gridx = 1;
		gbc_duracion.gridy = 9;
		getContentPane().add(duracion, gbc_duracion);
		
		duracionTextField = new JTextField();
		GridBagConstraints gbc_duracionTextField = new GridBagConstraints();
		gbc_duracionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_duracionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_duracionTextField.gridx = 2;
		gbc_duracionTextField.gridy = 9;
		getContentPane().add(duracionTextField, gbc_duracionTextField);
		duracionTextField.setColumns(10);
		
		JLabel link = new JLabel("Link video:");
		GridBagConstraints gbc_link = new GridBagConstraints();
		gbc_link.insets = new Insets(0, 0, 5, 5);
		gbc_link.anchor = GridBagConstraints.EAST;
		gbc_link.gridx = 1;
		gbc_link.gridy = 10;
		getContentPane().add(link, gbc_link);
		
		linkTextField = new JTextField();
		linkTextField.setColumns(10);
		GridBagConstraints gbc_linkTextField = new GridBagConstraints();
		gbc_linkTextField.insets = new Insets(0, 0, 5, 5);
		gbc_linkTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_linkTextField.gridx = 2;
		gbc_linkTextField.gridy = 10;
		getContentPane().add(linkTextField, gbc_linkTextField);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 11;
		getContentPane().add(panel, gbc_panel);
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		JButton cancelarBtn = new JButton("Cancelar");
		cancelarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
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
        String linkVideo = this.linkTextField.getText();
        boolean hayVideo = false;
        Date fechaAct = calendario.getDate();
        String ciudadAct = this.ciudadTextField.getText();
        String departamentoAct = (String) departamentoComboBox.getSelectedItem();
        String proveedorAct = dataProveedorArray[proveedoresComboBox.getSelectedIndex()].getNick();
        Set<String> setCat = new HashSet<String>(); 
        Object[] elementos = modelo.toArray();
        for (int i = 0 ; i < elementos.length; i++) { 
        	setCat.add((String) elementos[i]);
        }
        if(linkVideo != "") {
        	hayVideo = true;
        }
        if (checkFormulario()) {
            try {
                controlAlta.registrarActividad(departamentoAct, nombreAct, descripcionAct, Integer.parseInt(duracionAct), Integer.parseInt(costoAct), ciudadAct, fechaAct, proveedorAct, setCat, linkVideo, hayVideo);
                JOptionPane.showMessageDialog(this, "La actividad ha sido registrada exitosamente.", "Registrar Actividad",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (ActividadRepetidaException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Actividad", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException e) {
            	JOptionPane.showMessageDialog(this, "Formato numerico no aceptado", "Registrar Actividad", JOptionPane.ERROR_MESSAGE);
			} catch (UsuarioNoExisteException e) {
				JOptionPane.showMessageDialog(this, "El usuario no existe en el Sistema", "Registrar Actividad", JOptionPane.ERROR_MESSAGE);
			} catch (ProveedorNoNacidoException e) {
				JOptionPane.showMessageDialog(this, "El proveedor debe haber nacido antes de la fecha de alta de la actividad", "Registrar Actividad", JOptionPane.ERROR_MESSAGE);
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
        Date nacimientoU = calendario.getDate();
        String ciudadAct = this.ciudadTextField.getText();
        String departamentoAct = (String) departamentoComboBox.getSelectedItem();
        String proveedorAct = (String) proveedoresComboBox.getSelectedItem();

        if (nombreAct.isEmpty() || descripcionAct.isEmpty() || costoAct.isEmpty() || duracionAct.isEmpty() || ciudadAct.isEmpty() || departamentoAct == null || proveedorAct == null || nacimientoU == null || modelo.isEmpty()) {
            if (nacimientoU == null) {
            	JOptionPane.showMessageDialog(this, "Fecha erronea o vac�a", "Registrar Actividad",
                        JOptionPane.ERROR_MESSAGE);
            }else {
            	JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Actividad",
                    JOptionPane.ERROR_MESSAGE);
            }
            	return false;
        }

        try {
            int aux = Integer.parseInt(costoAct);
            if (aux < 1) {
            	JOptionPane.showMessageDialog(this, "El Costo debe ser un numero positivo", "Registrar Actividad",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El Costo debe ser un numero", "Registrar Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            int aux2 = Integer.parseInt(duracionAct);
            if (aux2 < 1) {
            	JOptionPane.showMessageDialog(this, "La duracion debe ser un numero positivo", "Registrar Actividad",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La Duracion debe ser un numero", "Registrar Actividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public void cargarDepartamentos(){
    	DefaultComboBoxModel<String> model;
    	try {
    		dataDepartamentos = controlAlta.obtenerDataDepartamentos();
    		String[] DepartamentosNombres = new String[dataDepartamentos.length];
    		for (int i = 0; i < dataDepartamentos.length; i++) {
    			DepartamentosNombres[i] = dataDepartamentos[i].getNombre();
    		}
	    	model = new DefaultComboBoxModel<String>(DepartamentosNombres);
	    	departamentoComboBox.setModel(model);
	    } catch (DepartamentoNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Departamentos", JOptionPane.ERROR_MESSAGE);
	    	this.setVisible(false);
    	}
    }
    
    
    
    
    public void cargarProveedores(){
    	DefaultComboBoxModel<String> model;
    	try {
    		dataUsuarios = controlAlta.getUsuarios();
    		//Cantidad de proveedores
    		int cant = 0;
    		for (int i = 0; i < dataUsuarios.length; i++) {
    			if (dataUsuarios[i] instanceof DataProveedor) {
        			cant++;
    			}
    		}
    		String[] dataProv = new String[cant];
    		dataProveedorArray = new DataProveedor[cant];
    		int ctr = 0;
    		for (int i = 0; i < dataUsuarios.length; i++) {
    			if (dataUsuarios[i] instanceof DataProveedor) {
    				dataProveedorArray[ctr] = (DataProveedor) dataUsuarios[i];
        			dataProv[ctr] = dataUsuarios[i].getNombre();
        			ctr++;
    			}
    		}
	    	model = new DefaultComboBoxModel<String>(dataProv);
	    	proveedoresComboBox.setModel(model);
	    } catch (UsuarioNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Proveedores", JOptionPane.ERROR_MESSAGE);
	    	this.setVisible(false);
    	}
    }
    
	public void cargarCategorias(){
    	DefaultComboBoxModel<String> model;
    	try {
    		Set<String> nombresCategorias = controlAlta.obtenerNombreCategorias();
     		String[] NombresAlta = nombresCategorias.toArray(new String[0]);
	    	model = new DefaultComboBoxModel<String>(NombresAlta);
	    	categoriasComboBox.setModel(model);
	    } catch (NoExisteCategoriaException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Categorias", JOptionPane.ERROR_MESSAGE);
	    	this.setVisible(false);
    	}
    }
    
    private void limpiarFormulario() {
        nombreTextField.setText("");
        descripcionTextField.setText("");
        costoTextField.setText("");
        duracionTextField.setText("");
        ciudadTextField.setText("");
        departamentoComboBox.setSelectedItem(null);
        categoriasComboBox.removeAllItems();
        modelo.removeAllElements();
        //fechaTextField.setText(""); // Ver como hacer con Fecha JCalendar
        //departamentoTextField.setText("");
    }
}
