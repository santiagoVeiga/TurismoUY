package presentacion;

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

import excepciones.ActividadNoExisteException;
import excepciones.PaqueteNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.IControladorInsc;
import logica.estadoAct;

/**
 * JInternalFrame que permite consultar la información de un usuario del sistema.
 * @author TProg2017
 *
 */
@SuppressWarnings("serial")
public class AgregarActPaquete extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorInsc controlInsc;
    private JButton btnBuscar;
    private JButton btnCerrar;
    private JButton btnSeleccionar;
    private JComboBox<String> jcbDepartamentos;
    private JComboBox<String> jcbActividades;
    private JComboBox<String> jcbPaquetes;
    private Set<DataDepartamento> dataDepartamentos;
    private String[] paquetes;
    private JLabel actividadesL;
    private JLabel paquetesL;
    private Set<DataActividad> auxi;
    private boolean paqB = false;
    private boolean depB = false;
    /**
     * Create the frame.
     */
    public AgregarActPaquete(IControladorInsc ici) {
        // Se inicializa con el controlador de usuarios
        controlInsc = ici;
        
        // Propiedades del JInternalFrame como dimensión, posición dentro del frame, etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Agregar Actividad a un Paquete");
        setBounds(30, 30, 578, 206);

        // En este caso usaremos el Absolute Layout y deberemos indicar
        // la posición absoluta de todos los componentes
        getContentPane().setLayout(null);

    	paquetesL = new JLabel("Paquetes: ");
        paquetesL.setSize(125, 32);
        paquetesL.setLocation(40, 12);
    	GridBagConstraints gbc_Paquetes = new GridBagConstraints();
    	gbc_Paquetes.anchor = GridBagConstraints.EAST;
    	gbc_Paquetes.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(paquetesL, gbc_Paquetes);
    	
        jcbPaquetes = new JComboBox<String>();
        jcbPaquetes.setBounds(253, 16, 276, 24);
        getContentPane().add(jcbPaquetes);
        jcbPaquetes.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		if (depB) {
        			btnBuscar.setVisible(true);
        			depB = false;
        		} else {
            		paqB = true;
        		}
        	}
        });
        
        JLabel Departamento = new JLabel("Departamento: ");
        Departamento.setSize(125, 32);
        Departamento.setLocation(40, 50);
		GridBagConstraints gbc_Departamento = new GridBagConstraints();
		gbc_Departamento.anchor = GridBagConstraints.EAST;
		gbc_Departamento.insets = new Insets(2, 2, 5, 5);
		getContentPane().add(Departamento, gbc_Departamento);
        
        jcbDepartamentos = new JComboBox<String>();
        jcbDepartamentos.setBounds(253, 54, 276, 24);
        
        jcbDepartamentos.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		if (paqB) {
        			btnBuscar.setVisible(true);
        			paqB = false;
        		} else {
            		depB = true;
        		}
        	}
        });
        getContentPane().add(jcbDepartamentos);
        
        
    	actividadesL = new JLabel("Actividades: ");
        actividadesL.setSize(125, 32);
        actividadesL.setLocation(40, 94);
    	GridBagConstraints gbc_Actividades = new GridBagConstraints();
    	gbc_Actividades.anchor = GridBagConstraints.EAST;
    	gbc_Actividades.insets = new Insets(2, 2, 5, 5);
    	getContentPane().add(actividadesL, gbc_Actividades);
    	actividadesL.setVisible(false);
    	
        jcbActividades = new JComboBox<String>();
        jcbActividades.setBounds(253, 98, 276, 24);
        
        jcbActividades.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent eve) {
        		btnSeleccionar.setVisible(true);
        	}
        });
        jcbActividades.setVisible(false);
        getContentPane().add(jcbActividades);
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
        btnCerrar.setBounds(442, 138, 89, 23);
        getContentPane().add(btnCerrar);
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	cargarActividades();
            }
        });
        btnBuscar.setBounds(40, 138, 89, 23);
        getContentPane().add(btnBuscar);
        btnBuscar.setVisible(false);
        
        btnSeleccionar = new JButton("Agregar");
        btnSeleccionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
            	agregarAct();
            	limpiarFormulario();
            	setVisible(false);
            }
        });
        btnSeleccionar.setBounds(287, 138, 116, 23);
        getContentPane().add(btnSeleccionar);
        btnSeleccionar.setVisible(false);
    }	
    

public void cargarDepartamentos(){
    		DefaultComboBoxModel<String> model;
    		dataDepartamentos = controlInsc.listarDepartamentos();
    		String[] DepartamentosNombres = new String[dataDepartamentos.size()];
    		int cont = 0;
    		for (DataDepartamento iter:dataDepartamentos) {
    			DepartamentosNombres[cont] = iter.getNombre();
    			cont++;
    		}
	    	model = new DefaultComboBoxModel<String>(DepartamentosNombres);
	        jcbDepartamentos.setModel(model);
    }

public void cargarActividades(){
	DefaultComboBoxModel<String> model;
	try {
		String depa = (String) jcbDepartamentos.getSelectedItem();
		String paqu = (String) jcbPaquetes.getSelectedItem();
		auxi = controlInsc.actividadesPorDepartamentoNoEnPaquete(depa, paqu);
		if (auxi.size() == 0) {
			throw new ActividadNoExisteException("No hay actividades de dicho Departamento disponibles para agregar");
		}
		Iterator<DataActividad> iter = auxi.iterator();
		int cont = 0;
		while (iter.hasNext()) {
			DataActividad aux = iter.next();
			if (aux.getEstado() == estadoAct.confirmada) {
				cont++;
			}
		}
		iter = auxi.iterator();
		String[] ActividadesNombres = new String[cont];
		cont = 0;
		while (iter.hasNext()) {
			DataActividad aux = iter.next();
			if (aux.getEstado() == estadoAct.confirmada) {
				ActividadesNombres[cont] = aux.getNombre();
				cont++;
			}
		}
		if (cont == 0) {
			throw new ActividadNoExisteException("No hay actividades disponibles para agregar");
		}
    	model = new DefaultComboBoxModel<String>(ActividadesNombres);
        jcbActividades.setModel(model);
    	actividadesL.setVisible(true);
		jcbActividades.setVisible(true);
		jcbDepartamentos.setEditable(false);
		jcbPaquetes.setEditable(false);
    } catch (ActividadNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay actividades", JOptionPane.ERROR_MESSAGE);
	}
}

public void cargarPaquetes(){
	DefaultComboBoxModel<String> model; 
	try {
		paquetes = controlInsc.listarPaquetesNoComprados();
		if (paquetes.length ==0) {
			throw new PaqueteNoExisteException("No hay paquetes en el sistema");
		}
    	model = new DefaultComboBoxModel<String>(paquetes);
        jcbPaquetes.setModel(model);
    } catch (PaqueteNoExisteException e) {
    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay Paquetes", JOptionPane.ERROR_MESSAGE);
	}
}

	private void agregarAct() {
    	controlInsc.confirmar((String) jcbPaquetes.getSelectedItem(), (String) jcbActividades.getSelectedItem());
    	JOptionPane.showMessageDialog(this, "La actividad se ha agregado con exito", "Agregar Actividad", JOptionPane.INFORMATION_MESSAGE);
	}

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
        jcbDepartamentos.removeAllItems();
        jcbActividades.removeAllItems();
        jcbPaquetes.removeAllItems();
        btnBuscar.setVisible(false);
        btnSeleccionar.setVisible(false);
    	jcbActividades.setVisible(false);
		jcbDepartamentos.setEditable(true);
		jcbPaquetes.setEditable(true);
		actividadesL.setVisible(false);
    }

}

	