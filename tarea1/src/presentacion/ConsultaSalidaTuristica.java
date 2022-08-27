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
    private JComboBox SeleccionarSalidaCAMPO;
    private Set<DataSalida> Salidas;
    private JTextField horaSalida;
    private JTextField fechaSalida;
    private JTextField lugarSalida;
    private JTextField cantidadMaxima;
    private JTextField fechaAlta;
    private JLabel horaLabel;
    private JLabel lugarSalidaLabel;
	private JLabel cantidadMaximaLabel;
	private JLabel fechaSalidaLabel;
	private JLabel fechaAltaLabel;
    private DataSalida salidaSeleccionada;


	public ConsultaSalidaTuristica(IControladorConsulta icu)  {
		controlCons = icu;
        
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Consulta Salida Turistica");
        setBounds(100, 100, 540, 423);
		getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Seleccionar Departamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(46, 34, 162, 13);
		getContentPane().add(lblNewLabel);
		
		
		/*	**** Departamentos *****	*/ 
	
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
		
		SeleccionarSalidaCAMPO = new JComboBox();
		SeleccionarSalidaCAMPO.setBounds(218, 113, 162, 22);
		SeleccionarSalidaCAMPO.addActionListener(new ActionListener() { //action listener para cuando se selecciona el dpto
	    	public void actionPerformed(ActionEvent e) {
	    		cargarDatosSalida();				
	    	}
	    });
		getContentPane().add(SeleccionarSalidaCAMPO);
		
		horaLabel = new JLabel("hora");
		horaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		horaLabel.setBounds(335, 227, 45, 13);
		getContentPane().add(horaLabel);
		horaLabel.setVisible(false);
		
		
		
		lugarSalidaLabel = new JLabel("Lugar De Salida");
		lugarSalidaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lugarSalidaLabel.setBounds(264, 179, 116, 13);
		getContentPane().add(lugarSalidaLabel);
		lugarSalidaLabel.setVisible(false);

		cantidadMaximaLabel = new JLabel("Maxima Cantidad Turistas");
		cantidadMaximaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cantidadMaximaLabel.setBounds(46, 227, 162, 13);
		getContentPane().add(cantidadMaximaLabel);
		cantidadMaximaLabel.setVisible(false);

		
		fechaSalidaLabel = new JLabel("Fecha Salida");
		fechaSalidaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		fechaSalidaLabel.setBounds(46, 179, 89, 13);
		getContentPane().add(fechaSalidaLabel);
		fechaSalidaLabel.setVisible(false);

		fechaAltaLabel = new JLabel("Fecha Alta");
		fechaAltaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		fechaAltaLabel.setBounds(46, 269, 89, 13);
		getContentPane().add(fechaAltaLabel);
		fechaAltaLabel.setVisible(false);

		
		
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
		cancelarCAMPO.setBounds(146, 348, 101, 22);
		getContentPane().add(cancelarCAMPO);
		
		horaSalida = new JTextField();
		horaSalida.setBounds(378, 224, 86, 20);
		getContentPane().add(horaSalida);
		horaSalida.setColumns(10);
		horaSalida.setVisible(false);
		
		fechaSalida = new JTextField();
		fechaSalida.setColumns(10);
		fechaSalida.setBounds(148, 176, 86, 20);
		getContentPane().add(fechaSalida);
		fechaSalida.setVisible(false);

		lugarSalida = new JTextField();
		lugarSalida.setColumns(10);
		lugarSalida.setBounds(378, 176, 86, 20);
		getContentPane().add(lugarSalida);
		lugarSalida.setVisible(false);

		cantidadMaxima = new JTextField();
		cantidadMaxima.setColumns(10);
		cantidadMaxima.setBounds(219, 224, 86, 20);
		getContentPane().add(cantidadMaxima);
		cantidadMaxima.setVisible(false);

		fechaAlta = new JTextField();
		fechaAlta.setColumns(10);
		fechaAlta.setBounds(148, 266, 86, 20);
		getContentPane().add(fechaAlta);
		fechaAlta.setVisible(false);

		

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
			}else
				j++;
		}
		
		Iterator<DataSalida> iter = Salidas.iterator();
		int i = 0;
		String[] SalidasNombres = new String[Salidas.size()];
		while(iter.hasNext()) {
			SalidasNombres[i] = iter.next().getNombre();
			i++;
		}
		
		model = new DefaultComboBoxModel<String>(SalidasNombres);
		SeleccionarSalidaCAMPO.setModel(model);
	}
	
	public void cargarDatosSalida(){
		String salSeleccionada = (String) SeleccionarSalidaCAMPO.getSelectedItem();
		Object[] arraySalidas = Salidas.toArray();
		int i=0;
		//Iterator<DataActividad> it = auxi.iterator();
		boolean encontrada = false;
		while(i<arraySalidas.length && !encontrada) {
			if(((DataSalida) arraySalidas[i]).getNombre() == salSeleccionada) {
				encontrada = true;
				salidaSeleccionada = (DataSalida) arraySalidas[i];
			}else
				i++;
		}
		lugarSalidaLabel.setVisible(true);
		cantidadMaximaLabel.setVisible(true);
		fechaSalidaLabel.setVisible(true);
		fechaAltaLabel.setVisible(true);
		horaLabel.setVisible(true);
		
		cantidadMaxima.setVisible(true);
		fechaAlta.setVisible(true);
		lugarSalida.setVisible(true);
		fechaSalida.setVisible(true);
		horaSalida.setVisible(true);
		
		//horaSalida.setText(salidaSeleccionada.gethora().getHours());
	    fechaSalida.setText(salidaSeleccionada.getFecha().getDay() + "/" + salidaSeleccionada.getFecha().getMonth() + "/"  + salidaSeleccionada.getFecha().getYear());
	    lugarSalida.setText(salidaSeleccionada.getLugar());
	    cantidadMaxima.setText(String.valueOf(salidaSeleccionada.getCant()));
	    fechaAlta.setText(salidaSeleccionada.getFechaAlta().getDay() + "/" + salidaSeleccionada.getFechaAlta().getMonth() + "/"  + salidaSeleccionada.getFechaAlta().getYear());
		
	}
}
