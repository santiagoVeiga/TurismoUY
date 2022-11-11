package presentacion;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.PaqueteNoExisteException;
import excepciones.SalidasNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.IControladorConsulta;
import logica.estadoAct;

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
    private JButton btnInfoSalida;
    private JButton btnInfoPaquete;
    private JComboBox<String> jcbDepartamentos;
    private JComboBox<String> jcbActividades;
    private JComboBox<String> jcbSalidas;
    private JComboBox<String> jcbPaquetes;
    private JComboBox<String> jcbCategorias;
    private DataDepartamento[] dataDepartamentos;
    private JLabel departamentoL;
    private JLabel actividadesL;
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
    private JLabel actFecha;
    private JLabel actFechaR;
    private JLabel actLink;
    private JLabel actLinkR;
    private JLabel salidasL;
    private JLabel paquetesL;
    private JLabel categoriasL;
    private Set<DataActividad> auxi;
    private DataActividad actElegida;
    private Set<DataSalida> auxiSal;
    private String[] nombresPaq;
    private String[] nombresCat;
    private ConsultaPaquete conPaquete;
    private ConsultaSalidaTuristica salida;
    /**
     * Create the frame.
     */
    public ConsultarActividad(IControladorConsulta icc) {
    	setResizable(true);
        // Se inicializa con el controlador de usuarios
        controlCons = icc;
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consultar una Actividad");
        setBounds(30, 30, 618, 567);

        // En este caso usaremos el Absolute Layout y deberemos indicar
        // la posición absoluta de todos los componentes
        getContentPane().setLayout(null);

        departamentoL = new JLabel("Departamento: ");
        departamentoL.setSize(125, 32);
        departamentoL.setLocation(40, 12);
		GridBagConstraints gbc_Departamento = new GridBagConstraints();
		gbc_Departamento.anchor = GridBagConstraints.EAST;
		gbc_Departamento.insets = new Insets(2, 2, 5, 5);
		getContentPane().add(departamentoL, gbc_Departamento);
		departamentoL.setVisible(false);
        
        jcbDepartamentos = new JComboBox<String>();
        jcbDepartamentos.setBounds(253, 16, 320, 24);
        getContentPane().add(jcbDepartamentos);
        jcbDepartamentos.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		btnBuscar.setVisible(true);
        	}
        });
        jcbDepartamentos.setVisible(false);
        
        
    	actividadesL = new JLabel("Actividades: ");
        actividadesL.setSize(125, 32);
        actividadesL.setLocation(40, 50);
    	GridBagConstraints gbc_Actividades = new GridBagConstraints();
    	gbc_Actividades.anchor = GridBagConstraints.EAST;
    	gbc_Actividades.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actividadesL, gbc_Actividades);
    	actividadesL.setVisible(false);
    	
        jcbActividades = new JComboBox<String>();
        jcbActividades.setBounds(253, 54, 320, 24);
        getContentPane().add(jcbActividades);
        jcbActividades.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		btnSeleccionar.setVisible(true);
        	}
        });
        jcbActividades.setVisible(false);
        
        categoriasL = new JLabel("Categorias: ");
        categoriasL.setSize(125, 32);
        categoriasL.setLocation(40, 317);
    	GridBagConstraints gbc_Categorias = new GridBagConstraints();
    	gbc_Categorias.anchor = GridBagConstraints.EAST;
    	gbc_Categorias.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(categoriasL, gbc_Categorias);
    	categoriasL.setVisible(false);
    	
        jcbCategorias = new JComboBox<String>();
        jcbCategorias.setBounds(253, 321, 320, 24);
        getContentPane().add(jcbCategorias);
        jcbCategorias.setVisible(false);
        
    	salidasL = new JLabel("Salidas: ");
        salidasL.setSize(125, 32);
        salidasL.setLocation(40, 353);
    	GridBagConstraints gbc_Salidas = new GridBagConstraints();
    	gbc_Salidas.anchor = GridBagConstraints.EAST;
    	gbc_Salidas.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(salidasL, gbc_Salidas);
    	salidasL.setVisible(false);
    	
        jcbSalidas = new JComboBox<String>();
        jcbSalidas.setBounds(253, 357, 320, 24);
        getContentPane().add(jcbSalidas);
        jcbSalidas.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		btnInfoSalida.setVisible(true);
        	}
        });
        jcbSalidas.setVisible(false);
        
    	paquetesL = new JLabel("Paquetes: ");
        paquetesL.setSize(125, 32);
        paquetesL.setLocation(40, 389);
    	GridBagConstraints gbc_Paquetes = new GridBagConstraints();
    	gbc_Paquetes.anchor = GridBagConstraints.EAST;
    	gbc_Paquetes.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paquetesL, gbc_Paquetes);
    	paquetesL.setVisible(false);
        
        jcbPaquetes = new JComboBox<String>();
        jcbPaquetes.setBounds(253, 393, 320, 24);
        getContentPane().add(jcbPaquetes);
        jcbPaquetes.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		btnInfoPaquete.setVisible(true);
        	}
        });
        jcbPaquetes.setVisible(false);
        
        // Un botón (JButton) con un evento asociado que permite buscar un usuario.
        // Dado que el código de registro tiene cierta complejidad, conviene delegarlo
        // a otro método en lugar de incluirlo directamente de el método actionPerformed 
        
        // Un botón (JButton) con un evento asociado que permite cerrar el formulario (solo ocultarlo).
        // Dado que antes de cerrar se limpia el formulario, se invoca un método reutilizable para ello. 
        btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	limpiarFormulario();
                setVisible(false);
            }
        });
        btnCerrar.setBounds(507, 433, 89, 23);
        getContentPane().add(btnCerrar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	limpiarFormularioActividad();
            	cargarActividades();
            }
        });
        btnBuscar.setBounds(15, 433, 89, 23);
        getContentPane().add(btnBuscar);
        btnBuscar.setVisible(false);
        
        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	Iterator<DataActividad> iter = auxi.iterator();
            	actElegida = iter.next();
            	while (iter.hasNext() && actElegida.getNombre() != (String) jcbActividades.getSelectedItem()) {
            		actElegida = iter.next();
            	}
            	mostrarActividad();
            }
        });
        btnSeleccionar.setBounds(113, 433, 116, 23);
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setVisible(false);
        
        btnInfoSalida = new JButton("Info Salida");
        btnInfoSalida.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	DataSalida[] dtSalidas = auxiSal.toArray(new DataSalida[0]);
            	salida.cargarDatosSalidaPorDataSalida(dtSalidas[jcbSalidas.getSelectedIndex()]);
            	salida.setVisible(true);
            }
        });
        btnInfoSalida.setBounds(241, 433, 116, 23);
        getContentPane().add(btnInfoSalida);
        btnInfoSalida.setVisible(false);
        
        btnInfoPaquete = new JButton("Info Paquete");
        btnInfoPaquete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	conPaquete.seleccionarPaquete((String) jcbPaquetes.getSelectedItem());
            	conPaquete.setVisible(true);
            }
        });
        btnInfoPaquete.setBounds(369, 433, 126, 23);
        getContentPane().add(btnInfoPaquete);
        btnInfoPaquete.setVisible(false);
        
        actNombre = new JLabel("Nombre Actividad y Estado:");
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
    	actNombreR.setSize(320, 23);
        actNombreR.setLocation(253, 97);
    	GridBagConstraints gbc_actNombreR = new GridBagConstraints();
    	gbc_actNombreR.anchor = GridBagConstraints.EAST;
    	gbc_actNombreR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actNombreR, gbc_actNombreR);
    	actNombreR.setVisible(false);
    
    	actDesc = new JLabel("Descripcion de la Actividad:");
        actDesc.setSize(201, 32);
        actDesc.setLocation(40, 120);
    	GridBagConstraints gbc_actDesc = new GridBagConstraints();
    	gbc_actDesc.anchor = GridBagConstraints.EAST;
    	gbc_actDesc.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDesc, gbc_actDesc);
    	actDesc.setVisible(false);
    	
    	actDescR = new JTextArea("Aca va la Descripcion");
    	actDescR.setFont(new Font("Dialog", Font.BOLD, 12));
    	actDescR.setBackground(UIManager.getColor("Menu.background"));
    	actDescR.setSize(320, 23);
        actDescR.setLocation(253, 129);
    	GridBagConstraints gbc_actDescR = new GridBagConstraints();
    	gbc_actDescR.anchor = GridBagConstraints.EAST;
    	gbc_actDescR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDescR, gbc_actDescR);
    	actDescR.setVisible(false);
    
    	actCiudad = new JLabel("Ciudad de la Actividad:");
        actCiudad.setSize(173, 32);
        actCiudad.setLocation(40, 150);
    	GridBagConstraints gbc_actCiudad = new GridBagConstraints();
    	gbc_actCiudad.anchor = GridBagConstraints.EAST;
    	gbc_actCiudad.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCiudad, gbc_actCiudad);
    	actCiudad.setVisible(false);
    	
    	actCiudadR = new JTextArea("Aca va la Ciudad");
    	actCiudadR.setFont(new Font("Dialog", Font.BOLD, 12));
    	actCiudadR.setBackground(UIManager.getColor("Menu.background"));
    	actCiudadR.setSize(320, 32);
        actCiudadR.setLocation(253, 159);
    	GridBagConstraints gbc_actCiudadR = new GridBagConstraints();
    	gbc_actCiudadR.anchor = GridBagConstraints.EAST;
    	gbc_actCiudadR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCiudadR, gbc_actCiudadR);
    	actCiudadR.setVisible(false);
    
    	actCosto = new JLabel("Costo de la Actividad:");
        actCosto.setSize(173, 32);
        actCosto.setLocation(40, 180);
    	GridBagConstraints gbc_actCosto = new GridBagConstraints();
    	gbc_actCosto.anchor = GridBagConstraints.EAST;
    	gbc_actCosto.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCosto, gbc_actCosto);
    	actCosto.setVisible(false);
    	
    	actCostoR = new JLabel("Aca va el Costo");
    	actCostoR.setSize(125, 32);
        actCostoR.setLocation(251, 180);
    	GridBagConstraints gbc_actCostoR = new GridBagConstraints();
    	gbc_actCostoR.anchor = GridBagConstraints.EAST;
    	gbc_actCostoR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actCostoR, gbc_actCostoR);
    	actCostoR.setVisible(false);
    	
    	actDuracion = new JLabel("Duracion de la Actividad:");
        actDuracion.setSize(189, 32);
        actDuracion.setLocation(40, 210);
    	GridBagConstraints gbc_actDuracion = new GridBagConstraints();
    	gbc_actDuracion.anchor = GridBagConstraints.EAST;
    	gbc_actDuracion.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDuracion, gbc_actDuracion);
    	actDuracion.setVisible(false);
    	
    	actDuracionR = new JLabel("Aca va la Duracion");
    	actDuracionR.setSize(276, 32);
        actDuracionR.setLocation(253, 210);
    	GridBagConstraints gbc_actDuracionR = new GridBagConstraints();
    	gbc_actDuracionR.anchor = GridBagConstraints.EAST;
    	gbc_actDuracionR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actDuracionR, gbc_actDuracionR);
    	actDuracionR.setVisible(false);
    	
    	actFecha = new JLabel("Fecha de Alta de la Actividad:");
        actFecha.setSize(189, 32);
        actFecha.setLocation(40, 242);
    	GridBagConstraints gbc_actFecha = new GridBagConstraints();
    	gbc_actFecha.anchor = GridBagConstraints.EAST;
    	gbc_actFecha.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actFecha, gbc_actFecha);
    	actFecha.setVisible(false);
    	
    	actFechaR = new JLabel("Aca va la Fecha");
    	actFechaR.setSize(276, 32);
        actFechaR.setLocation(253, 242);
    	GridBagConstraints gbc_actFechaR = new GridBagConstraints();
    	gbc_actFechaR.anchor = GridBagConstraints.EAST;
    	gbc_actFechaR.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actFechaR, gbc_actFechaR);
    	actFechaR.setVisible(false);
    	
    	actLink = new JLabel("Link de Video:");
    	actLink.setBounds(40, 286, 189, 15);
    	getContentPane().add(actLink);
    	actLink.setVisible(false);
    	
    	actLinkR = new JLabel("Aca va el Link");
    	actLinkR.setBounds(253, 286, 320, 15);
    	getContentPane().add(actLinkR);
    	actLinkR.setVisible(false);
    }	
    

public void cargarDepartamentos(){
    	DefaultComboBoxModel<String> model;
    	try {
    		dataDepartamentos = controlCons.obtenerDataDepartamentos();
    		String[] DepartamentosNombres = new String[dataDepartamentos.length];
    		for (int i = 0; i < dataDepartamentos.length; i++) {
    			DepartamentosNombres[i] = dataDepartamentos[i].getNombre();
    		}
	    	model = new DefaultComboBoxModel<String>(DepartamentosNombres);
	        jcbDepartamentos.setModel(model);
	        jcbDepartamentos.setVisible(true);
	        departamentoL.setVisible(true);
	    } catch (DepartamentoNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
    	}
    }

public void cargarActividades(){
	DefaultComboBoxModel<String> model;
	try {
		int iCont = jcbDepartamentos.getSelectedIndex();
		if (dataDepartamentos[iCont].getColAct().size() == 0) {
			throw new ActividadNoExisteException("No hay actividades asociadas a dicho Departamento");
		}
    	actividadesL.setVisible(true);
		jcbActividades.setVisible(true);
		auxi = dataDepartamentos[iCont].getColAct();
		Iterator<DataActividad> iter = auxi.iterator();
		int jCont = 0;
		String[] ActividadesNombres = new String[auxi.size()];
		while (iter.hasNext()) {
			ActividadesNombres[jCont] = iter.next().getNombre();
			jCont++;
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
		auxiSal = actElegida.getSalidas();
		if (auxiSal.size() == 0) {
			throw new SalidasNoExisteException("No hay salidas asociadas a dicha Actividad");
		}
    	salidasL.setVisible(true);
		jcbSalidas.setVisible(true);
		Iterator<DataSalida> iter = auxiSal.iterator();
		int jCont = 0;
		String[] SalidasNombres = new String[auxiSal.size()];
		while (iter.hasNext()) {
			SalidasNombres[jCont] = iter.next().getNombre();
			jCont++;
		}
    	model = new DefaultComboBoxModel<String>(SalidasNombres);
        jcbSalidas.setModel(model);
    } catch (SalidasNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Salidas", JOptionPane.ERROR_MESSAGE);
	}
}

public void cargarPaquetes() {
	DefaultComboBoxModel<String> model;
	try {
		if (actElegida.getEstado() == estadoAct.finalizada || actElegida.getPaquetes().size() == 0) {
			throw new PaqueteNoExisteException("No hay paquetes asociadas a dicha Actividad");
		}
		nombresPaq = actElegida.getPaquetes().toArray(new String[0]);
    	paquetesL.setVisible(true);
		jcbPaquetes.setVisible(true);
    	model = new DefaultComboBoxModel<String>(nombresPaq);
        jcbPaquetes.setModel(model);
    } catch (PaqueteNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Paquetes", JOptionPane.ERROR_MESSAGE);
	}
}

public void cargarCategorias() {
	DefaultComboBoxModel<String> model;
	if (actElegida.getEstado() != estadoAct.finalizada)
		nombresCat = actElegida.getCategorias().toArray(new String[0]);
	else {
		nombresCat = new String[1];
		nombresCat[0] = "No hay categorias debido a que es una actividad finalizada";
	}
	categoriasL.setVisible(true);
	jcbCategorias.setVisible(true);
	model = new DefaultComboBoxModel<String>(nombresCat);
    jcbCategorias.setModel(model);
}

public void seleccionarActvidad(DataActividad act) {
	limpiarFormulario();
	actElegida = act;
	mostrarActividad();
}

public void mostrarActividad() {
	actNombre.setVisible(true);
	actNombreR.setText(actElegida.getNombre() + " - " + actElegida.getEstado());
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
	actFecha.setVisible(true);
	actFechaR.setText(actElegida.getFechaAlta().getDate() + "/" + (actElegida.getFechaAlta().getMonth() + 1) + "/" + (actElegida.getFechaAlta().getYear() +1900));
	actFechaR.setVisible(true);
	actLink.setVisible(true);
	actLinkR.setText(actElegida.getLink());
	actLinkR.setVisible(true);
	cargarCategorias();
	cargarSalidas();
	cargarPaquetes();
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
        btnInfoSalida.setVisible(false);
        btnInfoPaquete.setVisible(false);
    	jcbActividades.setVisible(false);
    	jcbSalidas.setVisible(false);
        limpiarFormularioActividad();
        actividadesL.setVisible(false);
        jcbDepartamentos.setVisible(false);
        departamentoL.setVisible(false);
    }

    private void limpiarFormularioActividad() {
    	actNombre.setVisible(false);
    	actNombreR.setVisible(false);
    	actDesc.setVisible(false);
    	actDescR.setVisible(false);
    	actCiudad.setVisible(false);
    	actCiudadR.setVisible(false);
    	actCosto.setVisible(false);
    	actCostoR.setVisible(false);
    	actDuracion.setVisible(false);
    	actDuracionR.setVisible(false);
    	actFecha.setVisible(false);
    	actFechaR.setVisible(false);
    	actLink.setVisible(false);
    	actLinkR.setVisible(false);
    	salidasL.setVisible(false);
    	jcbSalidas.setVisible(false);
    	paquetesL.setVisible(false);
    	jcbPaquetes.setVisible(false);
    	categoriasL.setVisible(false);
    	jcbCategorias.setVisible(false);
    }


	public void setConPaquete(ConsultaPaquete conPaquete) {
		this.conPaquete = conPaquete;
	}


	public void setSalida(ConsultaSalidaTuristica salida) {
		this.salida = salida;
	}
}

	