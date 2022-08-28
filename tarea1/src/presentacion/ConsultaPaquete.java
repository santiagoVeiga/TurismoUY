package presentacion;

import javax.swing.JInternalFrame;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.PaqueteNoExisteException;
import excepciones.SalidasNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataPaquete;
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
public class ConsultaPaquete extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorConsulta controlCons;
    private JButton btnBuscar;
    private JButton btnCerrar;
    private JButton btnInfoActividad;
    private JComboBox<String> jcbPaquete;
    private JComboBox<String> jcbActividades;
    private String[] paquetes;
    private JLabel Actividades;
    private JLabel paqNombre;
    private JTextArea paqNombreR;
    private JLabel paqDesc;
    private JTextArea paqDescR;
    private JLabel paqValidez;
    private JLabel paqValidezR;
    private JLabel paqDescuento;
    private JLabel paqDescuentoR;
    private JLabel paqFecha;
    private JLabel paqFechaR;
    private DataActividad[] auxi;
    private DataPaquete paqElegido;
    private DataActividad actElegida;
    /**
     * Create the frame.
     */
    public ConsultaPaquete(IControladorConsulta icc) {
        // Se inicializa con el controlador de usuarios
        controlCons = icc;
        
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta Paquete");
        setBounds(30, 30, 578, 334);

        // En este caso usaremos el Absolute Layout y deberemos indicar
        // la posición absoluta de todos los componentes
        getContentPane().setLayout(null);

        JLabel Paquete = new JLabel("Paquete:");
        Paquete.setSize(125, 32);
        Paquete.setLocation(40, 12);
		GridBagConstraints gbc_Paquete = new GridBagConstraints();
		gbc_Paquete.anchor = GridBagConstraints.EAST;
		gbc_Paquete.insets = new Insets(2, 2, 5, 5);
		getContentPane().add(Paquete, gbc_Paquete);
        
        jcbPaquete = new JComboBox<String>();
        jcbPaquete.setBounds(253, 16, 276, 24);
        getContentPane().add(jcbPaquete);
        jcbPaquete.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		btnBuscar.setVisible(true);
        	}
        });
        
        
    	Actividades = new JLabel("Actividades del Paquete: ");
        Actividades.setSize(195, 32);
        Actividades.setLocation(40, 228);
    	GridBagConstraints gbc_Actividades = new GridBagConstraints();
    	gbc_Actividades.anchor = GridBagConstraints.EAST;
    	gbc_Actividades.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(Actividades, gbc_Actividades);
    	Actividades.setVisible(false);
    	
        jcbActividades = new JComboBox<String>();
        jcbActividades.setBounds(253, 232, 276, 24);
        getContentPane().add(jcbActividades);
        jcbActividades.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		btnInfoActividad.setVisible(true);
        	}
        });
        jcbActividades.setVisible(false);
        
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
        btnCerrar.setBounds(440, 272, 89, 23);
        getContentPane().add(btnCerrar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	limpiarFormularioPaquete();
            	mostrarPaquete();
            	cargarActividades();
            }
        });
        btnBuscar.setBounds(36, 272, 89, 23);
        getContentPane().add(btnBuscar);
        btnBuscar.setVisible(false);
        
        btnInfoActividad = new JButton("Info Actividad");
        btnInfoActividad.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnInfoActividad.setBounds(281, 272, 129, 23);
        getContentPane().add(btnInfoActividad);
        btnInfoActividad.setVisible(false);
        
        paqNombre = new JLabel("Nombre del Paquete:");
        paqNombre.setSize(173, 32);
        paqNombre.setLocation(40, 56);
    	GridBagConstraints gbc_paqNombre = new GridBagConstraints();
    	gbc_paqNombre.anchor = GridBagConstraints.EAST;
    	gbc_paqNombre.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqNombre, gbc_paqNombre);
    	paqNombre.setVisible(false);
    	
    	paqNombreR = new JTextArea("Aca va el Nombre");
    	paqNombreR.setFont(new Font("Dialog", Font.BOLD, 12));
    	paqNombreR.setBackground(UIManager.getColor("Menu.background"));
    	paqNombreR.setSize(276, 23);
        paqNombreR.setLocation(253, 65);
    	GridBagConstraints gbc_paqNombreR = new GridBagConstraints();
    	gbc_paqNombreR.anchor = GridBagConstraints.EAST;
    	gbc_paqNombreR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqNombreR, gbc_paqNombreR);
    	paqNombreR.setVisible(false);
    
    	paqDesc = new JLabel("Descripcion del Paquete:");
        paqDesc.setSize(201, 32);
        paqDesc.setLocation(40, 91);
    	GridBagConstraints gbc_paqDesc = new GridBagConstraints();
    	gbc_paqDesc.anchor = GridBagConstraints.EAST;
    	gbc_paqDesc.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqDesc, gbc_paqDesc);
    	paqDesc.setVisible(false);
    	
    	paqDescR = new JTextArea("Aca va la Descripcion");
    	paqDescR.setFont(new Font("Dialog", Font.BOLD, 12));
    	paqDescR.setBackground(UIManager.getColor("Menu.background"));
    	paqDescR.setSize(276, 23);
        paqDescR.setLocation(253, 100);
    	GridBagConstraints gbc_paqDescR = new GridBagConstraints();
    	gbc_paqDescR.anchor = GridBagConstraints.EAST;
    	gbc_paqDescR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqDescR, gbc_paqDescR);
    	paqDescR.setVisible(false);
    
    	paqValidez = new JLabel("Validez del Paquete:");
        paqValidez.setSize(173, 32);
        paqValidez.setLocation(40, 124);
    	GridBagConstraints gbc_paqValidez = new GridBagConstraints();
    	gbc_paqValidez.anchor = GridBagConstraints.EAST;
    	gbc_paqValidez.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqValidez, gbc_paqValidez);
    	paqValidez.setVisible(false);
    	
    	paqValidezR = new JLabel("Aca va la Validez");
    	paqValidezR.setSize(125, 32);
        paqValidezR.setLocation(253, 124);
    	GridBagConstraints gbc_paqValidezR = new GridBagConstraints();
    	gbc_paqValidezR.anchor = GridBagConstraints.EAST;
    	gbc_paqValidezR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqValidezR, gbc_paqValidezR);
    	paqValidezR.setVisible(false);
    	
    	paqDescuento = new JLabel("Descuento del Paquete:");
        paqDescuento.setSize(189, 32);
        paqDescuento.setLocation(40, 158);
    	GridBagConstraints gbc_paqDescuento = new GridBagConstraints();
    	gbc_paqDescuento.anchor = GridBagConstraints.EAST;
    	gbc_paqDescuento.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqDescuento, gbc_paqDescuento);
    	paqDescuento.setVisible(false);
    	
    	paqDescuentoR = new JLabel("Aca va el Descuento");
    	paqDescuentoR.setSize(276, 32);
        paqDescuentoR.setLocation(253, 158);
    	GridBagConstraints gbc_paqDescuentoR = new GridBagConstraints();
    	gbc_paqDescuentoR.anchor = GridBagConstraints.EAST;
    	gbc_paqDescuentoR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqDescuentoR, gbc_paqDescuentoR);
    	paqDescuentoR.setVisible(false);
    	
    	paqFecha = new JLabel("Fecha Alta del Paquete:");
        paqFecha.setSize(189, 32);
        paqFecha.setLocation(40, 188);
    	GridBagConstraints gbc_paqFecha = new GridBagConstraints();
    	gbc_paqFecha.anchor = GridBagConstraints.EAST;
    	gbc_paqFecha.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqFecha, gbc_paqFecha);
    	paqFecha.setVisible(false);
    	
    	paqFechaR = new JLabel("Aca va la Fecha");
    	paqFechaR.setSize(276, 32);
        paqFechaR.setLocation(253, 188);
    	GridBagConstraints gbc_paqFechaR = new GridBagConstraints();
    	gbc_paqFechaR.anchor = GridBagConstraints.EAST;
    	gbc_paqFechaR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paqFechaR, gbc_paqFechaR);
    	paqFechaR.setVisible(false);
    }	
    

public void cargarPaquetes(){
	DefaultComboBoxModel<String> model;
	try {
		paquetes = controlCons.listarPaquetes();
		if(paquetes.length ==0) {
			throw new PaqueteNoExisteException("No hay paquetes en el sistema");
		}
    	model = new DefaultComboBoxModel<String>(paquetes);
        jcbPaquete.setModel(model);
    } catch (PaqueteNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Paquetes", JOptionPane.ERROR_MESSAGE);
	}
}

public void mostrarPaquete() {
	String paq = (String) jcbPaquete.getSelectedItem();
	paqElegido = controlCons.obtenerDataPaquete(paq);
	paqNombre.setVisible(true);
	paqNombreR.setText(paqElegido.getNombre());
	paqNombreR.setVisible(true);
	paqDesc.setVisible(true);
	paqDescR.setText(paqElegido.getDescripcion());
	paqDescR.setVisible(true);
	paqValidez.setVisible(true);
	paqValidezR.setText(Integer.toString(paqElegido.getValidez()) + " dias");
	paqValidezR.setVisible(true);
	paqDescuento.setVisible(true);
	paqDescuentoR.setText(Integer.toString(paqElegido.getDescuento()) + "%");
	paqDescuentoR.setVisible(true);
	paqFecha.setVisible(true);
	paqFechaR.setText(paqElegido.getFechaAlta().getDate() + "/" + (paqElegido.getFechaAlta().getMonth() + 1) + "/" + (paqElegido.getFechaAlta().getYear() +1900));
	paqFechaR.setVisible(true);
	cargarActividades();
}

public void cargarActividades(){
	DefaultComboBoxModel<String> model;
	try {
		auxi = paqElegido.getDtAct();
		if (auxi.length == 0) {
			throw new ActividadNoExisteException("No hay actividades asociadas a dicho Paquete");
		}
    	Actividades.setVisible(true);
		jcbActividades.setVisible(true);
		int j = 0;
		String[] ActividadesNombres = new String[auxi.length];
		while(j<auxi.length) {
			ActividadesNombres[j] = auxi[j].getNombre();
			j++;
		}
    	model = new DefaultComboBoxModel<String>(ActividadesNombres);
        jcbActividades.setModel(model);
    } catch (ActividadNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay actividades", JOptionPane.ERROR_MESSAGE);
	}
}

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        jcbPaquete.removeAllItems();
        btnBuscar.setVisible(false);
        btnInfoActividad.setVisible(false);
        limpiarFormularioPaquete();
    }

    private void limpiarFormularioPaquete() {
    	paqNombre.setVisible(false);
    	paqNombreR.setVisible(false);
    	paqDesc.setVisible(false);
    	paqDescR.setVisible(false);
    	paqValidez.setVisible(false);
    	paqValidezR.setVisible(false);
    	paqDescuento.setVisible(false);
    	paqDescuentoR.setVisible(false);
    	paqFecha.setVisible(false);
    	paqFechaR.setVisible(false);
    	Actividades.setVisible(false);
        jcbActividades.removeAllItems();
    	jcbActividades.setVisible(false);
    }
}

	