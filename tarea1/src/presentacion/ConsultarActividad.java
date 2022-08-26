package presentacion;

import javax.swing.JInternalFrame;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.SalidasNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.IControladorConsulta;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

/**
 * JInternalFrame que permite consultar la información de un usuario del sistema.
 * @author TProg2017
 *
 */
@SuppressWarnings("serial")
public class ConsultarActividad extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorConsulta controlCons;
    private JButton btnBuscar;
    private JButton btnCerrar;
    private JButton btnSeleccionar;
    private JComboBox<String> jcbDepartamentos;
    private JComboBox<String> jcbActividades;
    private JComboBox<String> jcbSalidas;
    private DataDepartamento[] DD;
    private JLabel Actividades;
    private JLabel actNombre;
    private JTextArea actNombreR;
    private JLabel actDesc;
    private JTextArea actDescR;
    private JLabel actCiudad;
    private JTextArea actCiudadR;
    private JLabel actCosto;
    private JLabel actCostoR;
    private JLabel actDuracion;
    private JLabel actDuracionR;
    private JLabel Salidas;
    private Set<DataActividad> auxi;
    private DataActividad actElegida;
    private Set<DataSalida> auxiSal;
    private DataSalida salElegida;
    /**
     * Create the frame.
     */
    public ConsultarActividad(IControladorConsulta icc) {
        // Se inicializa con el controlador de usuarios
        controlCons = icc;
        
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar una Actividad");
        setBounds(30, 30, 578, 438);

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
        jcbDepartamentos.setBounds(253, 16, 276, 24);
        getContentPane().add(jcbDepartamentos);
        jcbDepartamentos.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		btnBuscar.setVisible(true);
        	}
        });
        
        
    	Actividades = new JLabel("Actividades: ");
        Actividades.setSize(125, 32);
        Actividades.setLocation(40, 50);
    	GridBagConstraints gbc_Actividades = new GridBagConstraints();
    	gbc_Actividades.anchor = GridBagConstraints.EAST;
    	gbc_Actividades.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(Actividades, gbc_Actividades);
    	Actividades.setVisible(false);
    	
        jcbActividades = new JComboBox<String>();
        jcbActividades.setBounds(253, 54, 276, 24);
        getContentPane().add(jcbActividades);
        jcbActividades.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		btnSeleccionar.setVisible(true);
        	}
        });
        jcbActividades.setVisible(false);
        
    	Salidas = new JLabel("Salidas: ");
        Salidas.setSize(125, 32);
        Salidas.setLocation(40, 296);
    	GridBagConstraints gbc_Salidas = new GridBagConstraints();
    	gbc_Salidas.anchor = GridBagConstraints.EAST;
    	gbc_Salidas.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(Salidas, gbc_Salidas);
    	Salidas.setVisible(false);
    	
        jcbSalidas = new JComboBox<String>();
        jcbSalidas.setBounds(253, 300, 276, 24);
        getContentPane().add(jcbSalidas);
        jcbSalidas.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        jcbSalidas.setVisible(false);
        
        // Un botón (JButton) con un evento asociado que permite buscar un usuario.
        // Dado que el código de registro tiene cierta complejidad, conviene delegarlo
        // a otro método en lugar de incluirlo directamente de el método actionPerformed 
        
        // Un botón (JButton) con un evento asociado que permite cerrar el formulario (solo ocultarlo).
        // Dado que antes de cerrar se limpia el formulario, se invoca un método reutilizable para ello. 
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	limpiarFormulario();
                setVisible(false);
            }
        });
        btnCerrar.setBounds(440, 351, 89, 23);
        getContentPane().add(btnCerrar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cargarActividades();
            }
        });
        btnBuscar.setBounds(40, 351, 89, 23);
        getContentPane().add(btnBuscar);
        btnBuscar.setVisible(false);
        
        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	mostrarActividad();
            }
        });
        btnSeleccionar.setBounds(159, 351, 116, 23);
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setVisible(false);
        
        actNombre = new JLabel("Nombre de la Actividad:");
        actNombre.setSize(173, 32);
        actNombre.setLocation(40, 88);
    	GridBagConstraints gbc_actNombre = new GridBagConstraints();
    	gbc_actNombre.anchor = GridBagConstraints.EAST;
    	gbc_actNombre.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actNombre, gbc_actNombre);
    	actNombre.setVisible(false);
    	
    	actNombreR = new JTextArea("Aca va la Nombre");
    	actNombreR.setFont(new Font("Dialog", Font.BOLD, 12));
    	actNombreR.setBackground(UIManager.getColor("Menu.background"));
    	actNombreR.setSize(276, 23);
        actNombreR.setLocation(253, 97);
    	GridBagConstraints gbc_actNombreR = new GridBagConstraints();
    	gbc_actNombreR.anchor = GridBagConstraints.EAST;
    	gbc_actNombreR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actNombreR, gbc_actNombreR);
    	actNombreR.setVisible(false);
    
    	actDesc = new JLabel("Descripcion de la Actividad:");
        actDesc.setSize(201, 32);
        actDesc.setLocation(40, 132);
    	GridBagConstraints gbc_actDesc = new GridBagConstraints();
    	gbc_actDesc.anchor = GridBagConstraints.EAST;
    	gbc_actDesc.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDesc, gbc_actDesc);
    	actDesc.setVisible(false);
    	
    	actDescR = new JTextArea("Aca va la Descripcion");
    	actDescR.setFont(new Font("Dialog", Font.BOLD, 12));
    	actDescR.setBackground(UIManager.getColor("Menu.background"));
    	actDescR.setSize(276, 23);
        actDescR.setLocation(253, 141);
    	GridBagConstraints gbc_actDescR = new GridBagConstraints();
    	gbc_actDescR.anchor = GridBagConstraints.EAST;
    	gbc_actDescR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDescR, gbc_actDescR);
    	actDescR.setVisible(false);
    
    	actCiudad = new JLabel("Ciudad de la Actividad:");
        actCiudad.setSize(173, 32);
        actCiudad.setLocation(40, 170);
    	GridBagConstraints gbc_actCiudad = new GridBagConstraints();
    	gbc_actCiudad.anchor = GridBagConstraints.EAST;
    	gbc_actCiudad.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCiudad, gbc_actCiudad);
    	actCiudad.setVisible(false);
    	
    	actCiudadR = new JTextArea("Aca va la Ciudad");
    	actCiudadR.setFont(new Font("Dialog", Font.BOLD, 12));
    	actCiudadR.setBackground(UIManager.getColor("Menu.background"));
    	actCiudadR.setSize(276, 32);
        actCiudadR.setLocation(253, 179);
    	GridBagConstraints gbc_actCiudadR = new GridBagConstraints();
    	gbc_actCiudadR.anchor = GridBagConstraints.EAST;
    	gbc_actCiudadR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCiudadR, gbc_actCiudadR);
    	actCiudadR.setVisible(false);
    
    	actCosto = new JLabel("Costo de la Actividad:");
        actCosto.setSize(173, 32);
        actCosto.setLocation(40, 208);
    	GridBagConstraints gbc_actCosto = new GridBagConstraints();
    	gbc_actCosto.anchor = GridBagConstraints.EAST;
    	gbc_actCosto.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCosto, gbc_actCosto);
    	actCosto.setVisible(false);
    	
    	actCostoR = new JLabel("Aca va el Costo");
    	actCostoR.setSize(125, 32);
        actCostoR.setLocation(253, 208);
    	GridBagConstraints gbc_actCostoR = new GridBagConstraints();
    	gbc_actCostoR.anchor = GridBagConstraints.EAST;
    	gbc_actCostoR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCostoR, gbc_actCostoR);
    	actCostoR.setVisible(false);
    	
    	actDuracion = new JLabel("Duracion de la Actividad:");
        actDuracion.setSize(189, 32);
        actDuracion.setLocation(40, 252);
    	GridBagConstraints gbc_actDuracion = new GridBagConstraints();
    	gbc_actDuracion.anchor = GridBagConstraints.EAST;
    	gbc_actDuracion.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDuracion, gbc_actDuracion);
    	actDuracion.setVisible(false);
    	
    	actDuracionR = new JLabel("Aca va la Duracion");
    	actDuracionR.setSize(276, 32);
        actDuracionR.setLocation(253, 252);
    	GridBagConstraints gbc_actDuracionR = new GridBagConstraints();
    	gbc_actDuracionR.anchor = GridBagConstraints.EAST;
    	gbc_actDuracionR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDuracionR, gbc_actDuracionR);
    	actDuracionR.setVisible(false);
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

public void cargarActividades(){
	DefaultComboBoxModel<String> model;
	try {
		String aux = (String) jcbDepartamentos.getSelectedItem();
		int i = 0;
		while (i<DD.length && DD[i].getNombre() != aux) {
			i++;
		}
		if (DD[i].getColAct().size() == 0) {
			throw new ActividadNoExisteException("No hay actividades asociadas a dicho Departamento");
		}
    	Actividades.setVisible(true);
		jcbActividades.setVisible(true);
		auxi = DD[i].getColAct();
		Iterator<DataActividad> it = auxi.iterator();
		int j = 0;
		String[] ActividadesNombres = new String[auxi.size()];
		while(it.hasNext()) {
			ActividadesNombres[j] = it.next().getNombre();
			j++;
		}
    	model = new DefaultComboBoxModel<String>(ActividadesNombres);
        jcbActividades.setModel(model);
    } catch (ActividadNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay actividades", JOptionPane.ERROR_MESSAGE);
	}
}

public void cargarSalidas(){
	DefaultComboBoxModel<String> model;
	try {
		String aux = (String) jcbActividades.getSelectedItem();
		boolean bandera = false;
		Iterator<DataActividad> it = auxi.iterator();
		while(it.hasNext() && !bandera) {
			actElegida = it.next();
			bandera = actElegida.getNombre() ==aux;
		}
		auxiSal = actElegida.getSalidas();
		if (auxiSal.size() == 0) {
			throw new SalidasNoExisteException("No hay salidas asociadas a dicho Actividad");
		}
    	Salidas.setVisible(true);
		jcbSalidas.setVisible(true);
		Iterator<DataSalida> iter = auxiSal.iterator();
		int j = 0;
		String[] SalidasNombres = new String[auxiSal.size()];
		while(iter.hasNext()) {
			SalidasNombres[j] = iter.next().getNombre();
			j++;
		}
    	model = new DefaultComboBoxModel<String>(SalidasNombres);
        jcbSalidas.setModel(model);
    } catch (SalidasNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Salidas", JOptionPane.ERROR_MESSAGE);
	}
}

public void mostrarActividad() {
	Iterator<DataActividad> it = auxi.iterator();
	actElegida = it.next();
	while(it.hasNext() && (actElegida.getNombre() != (String) jcbActividades.getSelectedItem())) {
		actElegida = it.next();
	}
	actNombre.setVisible(true);
	actNombreR.setText(actElegida.getNombre());
	actNombreR.setVisible(true);
	actDesc.setVisible(true);
	actDescR.setText(actElegida.getDescripcion());
	actDescR.setVisible(true);
	actCiudad.setVisible(true);
	actCiudadR.setText(actElegida.getCiudad());
	actCiudadR.setVisible(true);
	actCosto.setVisible(true);
	actCostoR.setText("$" + Integer.toString(actElegida.getCosto()));
	actCostoR.setVisible(true);
	actDuracion.setVisible(true);
	actDuracionR.setText(Integer.toString(actElegida.getDuracion()) + " horas");
	actDuracionR.setVisible(true);
	cargarSalidas();
}

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        jcbDepartamentos.removeAllItems();
        jcbActividades.removeAllItems();
        jcbSalidas.removeAllItems();
        btnBuscar.setVisible(false);
        btnSeleccionar.setVisible(false);
    	jcbActividades.setVisible(false);
    	jcbSalidas.setVisible(false);
        limpiarFormularioActividad();
        jcbSalidas.setVisible(false);
    }

    private void limpiarFormularioActividad() {
    	actNombre.setVisible(true);
    	actNombreR.setVisible(true);
    	actDesc.setVisible(true);
    	actDescR.setVisible(true);
    	actCiudad.setVisible(true);
    	actCiudadR.setVisible(true);
    	actCosto.setVisible(true);
    	actCostoR.setVisible(true);
    	actDuracion.setVisible(true);
    	actDuracionR.setVisible(true);
    }
}

	