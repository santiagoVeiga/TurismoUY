package presentacion;

import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.SalidaNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.IControladorAlta;
import logica.IControladorConsulta;

import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class ConsultaSalidaTuristica extends JInternalFrame {
	
	private IControladorConsulta controlCons ; 
	private Button aceptarCAMPO;
	private Button cancelarCAMPO;
	private JComboBox SeleccionarDptoCAMPO;
	private JComboBox SeleccionarActividadCAMPO;
	private IControladorAlta controlAlta;
    private DataDepartamento[] DD;
    private Set<DataActividad> auxi;
    private JComboBox SeleccionarSalidasCAMPO;
    private Set<DataSalida> Salidas;


	public ConsultaSalidaTuristica(IControladorConsulta icu)  {
		controlCons = icu;

        
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Consulta Salida Turistica");
        setBounds(100, 100, 456, 423);
		getContentPane().setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("Seleccionar Departamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(46, 34, 162, 13);
		getContentPane().add(lblNewLabel);
		
		
		
		
		//--------------------departamentos--------------------
	
		//DataDepartamento[] ArrDpto = null;
		SeleccionarDptoCAMPO = new JComboBox<String>(); 
		SeleccionarDptoCAMPO.setBounds(218, 31, 162, 21);
		getContentPane().add(SeleccionarDptoCAMPO);

		SeleccionarDptoCAMPO.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
            	cargarActividades();				
	    	}
	    });

		/*	**** Actividades *****	*/ 
		
		JLabel lblSeleccionarActividad = new JLabel("Seleccionar Actividad");
		lblSeleccionarActividad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccionarActividad.setBounds(46, 71, 162, 13);
		getContentPane().add(lblSeleccionarActividad); //
		
		SeleccionarActividadCAMPO = new JComboBox<String>();
		SeleccionarActividadCAMPO.setBounds(218, 67, 162, 21);
		SeleccionarActividadCAMPO.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) {
            	cargarSalidas();				
	    	}
	    });
		getContentPane().add(SeleccionarActividadCAMPO);
		
		/*	**** Salidas *****	*/ 
		
		JLabel salidas = new JLabel("Nombre Salida");
		salidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		salidas.setBounds(46, 117, 162, 13);
		getContentPane().add(salidas);
		
		SeleccionarSalidasCAMPO = new JComboBox();
		SeleccionarSalidasCAMPO.setBounds(218, 113, 162, 22);
		SeleccionarSalidasCAMPO.addActionListener(new ActionListener() { //action listener para cuando se selecciona el dpto
	    	public void actionPerformed(ActionEvent e) {
	    		//mostrar datos de actividad;				
	    	}
	    });
		getContentPane().add(SeleccionarSalidasCAMPO);
		
		JLabel lblNewLabel_1 = new JLabel("hora");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(244, 179, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lugar De Salida");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(46, 227, 162, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Maxima Cantidad Turistas");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(46, 265, 162, 13);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha Salida");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(46, 179, 89, 13);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fecha Alta");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(46, 297, 89, 13);
		getContentPane().add(lblNewLabel_1_2_1);
		
		
		
		aceptarCAMPO = new Button("Aceptar");
		aceptarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//chequeoAlta();
			}
		});
		aceptarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		aceptarCAMPO.setBounds(310, 348, 89, 22);
		getContentPane().add(aceptarCAMPO);
		
		cancelarCAMPO = new Button("Cancelar");
		cancelarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent p) {
			   //limpiarFormulario();
			   setVisible(false);
			}
		});
		cancelarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		cancelarCAMPO.setBounds(34, 348, 101, 22);
		getContentPane().add(cancelarCAMPO);
		
		

	}
	
	/* ************** */
	/* *** Cargas *** */
	/* ************** */
	
	public void cargarDepartamentos(){
    	DefaultComboBoxModel<String> model;
    	try {
    		DD = controlCons.obtenerDataDepartamentos();
    		String[] DepartamentosNombres = new String[DD.length];
    		for (int i = 0; i < DD.length;i++) {
    			DepartamentosNombres[i] = DD[i].getNombre();
    		}
	    	model = new DefaultComboBoxModel<String>(DepartamentosNombres);
	    	SeleccionarDptoCAMPO.setModel(model);
	    } catch (DepartamentoNoExisteException e) {
    	}
    }
	
	@SuppressWarnings("unchecked")
	public void cargarActividades(){
		DefaultComboBoxModel<String> model;
		try {
			String aux = (String) SeleccionarDptoCAMPO.getSelectedItem();
			int i = 0;
			while (i<DD.length && DD[i].getNombre() != aux) {
				i++;
			}
			if (DD[i].getColAct().size() == 0) {
				throw new ActividadNoExisteException("No hay actividades asociadas a dicho Departamento");
			}
			auxi = DD[i].getColAct();
			Iterator<DataActividad> it = auxi.iterator();
			int j = 0;
			String[] ActividadesNombres = new String[auxi.size()];
			while(it.hasNext()) {
				ActividadesNombres[j] = it.next().getNombre();
				j++;
			}
	    	model = new DefaultComboBoxModel<String>(ActividadesNombres);
	    	SeleccionarActividadCAMPO.setModel(model);
	    } catch (ActividadNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay actividades", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//@SuppressWarnings("unchecked")
	public void cargarSalidas(){
		DefaultComboBoxModel<String> model;
		String actSeleccionada = (String) SeleccionarActividadCAMPO.getSelectedItem();
        Object[] arr = auxi.toArray();
        int j=0;
		//Iterator<DataActividad> it = auxi.iterator();
		boolean encontrada = false;
		while(j<arr.length && !encontrada) {
			if(((DataActividad) arr[j]).getNombre() == actSeleccionada) {
				encontrada = true;
				//Salidas = new HashSet<DataSalida> ();
				Salidas = ((DataActividad) arr[j]).getSalidas();
			}
		}
		
		Iterator<DataSalida> iter = Salidas.iterator();
		int i = 0;
		String[] SalidasNombres = new String[Salidas.size()];
		while(iter.hasNext()) {
			SalidasNombres[i] = iter.next().getNombre();
			i++;
		}
		
		model = new DefaultComboBoxModel<String>(SalidasNombres);
		SeleccionarSalidasCAMPO.setModel(model);
	}
}
