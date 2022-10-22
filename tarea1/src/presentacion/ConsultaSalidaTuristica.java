package presentacion;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.IControladorConsulta;

public class ConsultaSalidaTuristica extends JInternalFrame {
	
	private IControladorConsulta controlCons ; 
	private Button aceptarCAMPO;
	private Button cancelarCAMPO;
	private JComboBox seleccionarDepartamentoCAMPO;
	private JComboBox seleccionarActividadCAMPO;
    private DataDepartamento[] dataDepartamentos;
    private Set<DataActividad> auxi;
    private JComboBox seleccionarSalidaCAMPO;
    private Set<DataSalida> salidas;
    private JTextField horaSalida;
    private JTextField fechaSalida;
    private JTextField lugarSalida;
    private JTextField cantidadMaxima;
    private JTextField fechaAlta;
    private JLabel departamentoL;
    private JLabel horaLabel;
    private JLabel lugarSalidaLabel;
	private JLabel cantidadMaximaLabel;
	private JLabel fechaSalidaLabel;
	private JLabel fechaAltaLabel;
	private JLabel actividadesLabel;
	private JLabel salidasLabel;
    private DataSalida salidaSeleccionada;


	public ConsultaSalidaTuristica(IControladorConsulta icu)  {
		controlCons = icu;
        setIconifiable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Consulta Salida Turistica");
        setBounds(100, 100, 517, 423);
		getContentPane().setLayout(null);
		
		
		departamentoL = new JLabel("Seleccionar Departamento");
		departamentoL.setFont(new Font("Tahoma", Font.BOLD, 12));
		departamentoL.setBounds(46, 34, 162, 18);
		getContentPane().add(departamentoL);
		departamentoL.setVisible(false);
		
		
		/*	**** Departamentos *****	*/ 
	
		seleccionarDepartamentoCAMPO = new JComboBox<String>(); 
		seleccionarDepartamentoCAMPO.setBounds(218, 31, 219, 21);
		getContentPane().add(seleccionarDepartamentoCAMPO);
		seleccionarDepartamentoCAMPO.setVisible(false);

		seleccionarDepartamentoCAMPO.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
            	cargarActividades();				
        	    ocultarTextAndLabel();
        		salidasLabel.setVisible(false);
        		seleccionarSalidaCAMPO.setVisible(false);
	    	}	    	
	    });

		/*	**** Actividades *****	*/ 
		
		actividadesLabel = new JLabel("Seleccionar Actividad");
		actividadesLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		actividadesLabel.setBounds(46, 67, 162, 18);
		getContentPane().add(actividadesLabel);
		actividadesLabel.setVisible(false);
		
		seleccionarActividadCAMPO = new JComboBox<String>();
		seleccionarActividadCAMPO.setBounds(218, 63, 219, 21);
		seleccionarActividadCAMPO.addActionListener(new ActionListener() { 
	    	public void actionPerformed(ActionEvent e) {
            	cargarSalidas();
        	    ocultarTextAndLabel();
	    	}
	    });
		getContentPane().add(seleccionarActividadCAMPO);
		seleccionarActividadCAMPO.setVisible(false);

		
		/*	**** Salidas *****	*/ 
		
		salidasLabel = new JLabel("Nombre Salida:");
		salidasLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		salidasLabel.setBounds(46, 96, 162, 17);
		getContentPane().add(salidasLabel);
		salidasLabel.setVisible(false);

		
		seleccionarSalidaCAMPO = new JComboBox();
		seleccionarSalidaCAMPO.setBounds(218, 91, 219, 22);
		seleccionarSalidaCAMPO.addActionListener(new ActionListener() { //action listener para cuando se selecciona el dpto
	    	public void actionPerformed(ActionEvent e) {
	    		cargarDatosSalidaPorListado();				
	    	}
	    });
		getContentPane().add(seleccionarSalidaCAMPO);
		seleccionarSalidaCAMPO.setVisible(false);

		horaLabel = new JLabel("Hora: ");
		horaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		horaLabel.setBounds(46, 173, 162, 25);
		getContentPane().add(horaLabel);
		horaLabel.setVisible(false);
		
		
		
		lugarSalidaLabel = new JLabel("Lugar de Salida:");
		lugarSalidaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lugarSalidaLabel.setBounds(46, 209, 162, 16);
		getContentPane().add(lugarSalidaLabel);
		lugarSalidaLabel.setVisible(false);

		cantidadMaximaLabel = new JLabel("Cantidad max. de Turistas:");
		cantidadMaximaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		cantidadMaximaLabel.setBounds(46, 268, 184, 13);
		getContentPane().add(cantidadMaximaLabel);
		cantidadMaximaLabel.setVisible(false);

		
		fechaSalidaLabel = new JLabel("Fecha Salida");
		fechaSalidaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		fechaSalidaLabel.setBounds(46, 149, 162, 13);
		getContentPane().add(fechaSalidaLabel);
		fechaSalidaLabel.setVisible(false);

		fechaAltaLabel = new JLabel("Fecha Alta");
		fechaAltaLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		fechaAltaLabel.setBounds(46, 236, 162, 21);
		getContentPane().add(fechaAltaLabel);
		fechaAltaLabel.setVisible(false);

		
		
		aceptarCAMPO = new Button("Cerrar");
		aceptarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		aceptarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		aceptarCAMPO.setBounds(348, 333, 89, 22);
		getContentPane().add(aceptarCAMPO);
		
		cancelarCAMPO = new Button("Cancelar");
		cancelarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent p) {
			   limpiarFormulario();
			   setVisible(false);
			}
		});
		cancelarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		cancelarCAMPO.setBounds(218, 333, 101, 22);
		getContentPane().add(cancelarCAMPO);
		
		horaSalida = new JTextField();
		horaSalida.setEditable(false);
		horaSalida.setBounds(218, 177, 219, 20);
		getContentPane().add(horaSalida);
		horaSalida.setColumns(10);
		horaSalida.setVisible(false);
		
		fechaSalida = new JTextField();
		fechaSalida.setEditable(false);
		fechaSalida.setColumns(10);
		fechaSalida.setBounds(218, 146, 219, 20);
		getContentPane().add(fechaSalida);
		fechaSalida.setVisible(false);

		lugarSalida = new JTextField();
		lugarSalida.setEditable(false);
		lugarSalida.setColumns(10);
		lugarSalida.setBounds(218, 206, 219, 20);
		getContentPane().add(lugarSalida);
		lugarSalida.setVisible(false);

		cantidadMaxima = new JTextField();
		cantidadMaxima.setEditable(false);
		cantidadMaxima.setColumns(10);
		cantidadMaxima.setBounds(218, 265, 219, 20);
		getContentPane().add(cantidadMaxima);
		cantidadMaxima.setVisible(false);

		fechaAlta = new JTextField();
		fechaAlta.setEditable(false);
		fechaAlta.setColumns(10);
		fechaAlta.setBounds(218, 237, 219, 20);
		getContentPane().add(fechaAlta);
		fechaAlta.setVisible(false);

	}
	
	/* ***** Cargas ****** */
	
	public void cargarDepartamentos(){
    	DefaultComboBoxModel<String> model;
    	try {
    		dataDepartamentos = controlCons.obtenerDataDepartamentos();
    		String[] DepartamentosNombres = new String[dataDepartamentos.length];
    		for (int i = 0; i < dataDepartamentos.length; i++) {
    			DepartamentosNombres[i] = dataDepartamentos[i].getNombre();
    		}
	    	model = new DefaultComboBoxModel<String>(DepartamentosNombres);
	    	seleccionarDepartamentoCAMPO.setModel(model);
	    	departamentoL.setVisible(true);
	    	seleccionarDepartamentoCAMPO.setVisible(true);
	    } catch (DepartamentoNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
    	}
    }
	
	//@SuppressWarnings("unchecked")
	public void cargarActividades(){
		DefaultComboBoxModel<String> model;
		actividadesLabel.setVisible(true);
		seleccionarActividadCAMPO.setVisible(true);
		try {
			String aux = (String) seleccionarDepartamentoCAMPO.getSelectedItem();
			int i = 0;
			while (i<dataDepartamentos.length && dataDepartamentos[i].getNombre() != aux) {
				i++;
			}
			if (dataDepartamentos[i].getColAct().size() == 0) {
				throw new ActividadNoExisteException("No hay actividades asociadas a dicho Departamento");
			}
			auxi = dataDepartamentos[i].getColAct();
			Iterator<DataActividad> it = auxi.iterator();
			int j = 0;
			String[] ActividadesNombres = new String[auxi.size()];
			while (it.hasNext()) {
				ActividadesNombres[j] = it.next().getNombre();
				j++;
			}
	    	model = new DefaultComboBoxModel<String>(ActividadesNombres);
	    	seleccionarActividadCAMPO.setModel(model);
	    } catch (ActividadNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), "No hay actividades", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//@SuppressWarnings("unchecked")
	public void cargarSalidas(){
		DefaultComboBoxModel<String> model;
		salidasLabel.setVisible(true);
		seleccionarSalidaCAMPO.setVisible(true);
		String actSeleccionada = (String) seleccionarActividadCAMPO.getSelectedItem();
        Object[] arr = auxi.toArray();
        int j=0;
		//Iterator<DataActividad> it = auxi.iterator();
		boolean encontrada = false;
		while (j<arr.length && !encontrada) {
			if (((DataActividad) arr[j]).getNombre() == actSeleccionada) {
				encontrada = true;
				//Salidas = new HashSet<DataSalida> ();
				salidas = ((DataActividad) arr[j]).getSalidas();
			}else
				j++;
		}
		
		Iterator<DataSalida> iter = salidas.iterator();
		int i = 0;
		String[] SalidasNombres = new String[salidas.size()];
		while (iter.hasNext()) {
			SalidasNombres[i] = iter.next().getNombre();
			i++;
		}
		
		model = new DefaultComboBoxModel<String>(SalidasNombres);
		seleccionarSalidaCAMPO.setModel(model);
	}
	
	public void cargarDatosSalidaPorListado() {
		String salSeleccionada = (String) seleccionarSalidaCAMPO.getSelectedItem();
		Object[] arraySalidas = salidas.toArray();
		int i=0;
		//Iterator<DataActividad> it = auxi.iterator();
		boolean encontrada = false;
		while (i<arraySalidas.length && !encontrada) {
			if (((DataSalida) arraySalidas[i]).getNombre() == salSeleccionada) {
				encontrada = true;
				salidaSeleccionada = (DataSalida) arraySalidas[i];
			}else
				i++;
		}
		cargarDatosSalida();
	}
	
	public void cargarDatosSalidaPorDataSalida(DataSalida aux) {
		salidaSeleccionada = aux;
    	limpiarFormulario();
		cargarDatosSalida();
	}
	
	public void cargarDatosSalida(){
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
		
		horaSalida.setText(Integer.toString(salidaSeleccionada.gethora().getHours()));
	    fechaSalida.setText(salidaSeleccionada.getFecha().getDate() + "/" + (salidaSeleccionada.getFecha().getMonth()+1) + "/"  + (salidaSeleccionada.getFecha().getYear()+1900));
	    lugarSalida.setText(salidaSeleccionada.getLugar());
	    cantidadMaxima.setText(String.valueOf(salidaSeleccionada.getCant()));
	    fechaAlta.setText(salidaSeleccionada.getFechaAlta().getDate() + "/" + (salidaSeleccionada.getFechaAlta().getMonth()+1) + "/"  + (salidaSeleccionada.getFechaAlta().getYear()+1900));
		
	}

	
	/* ***** Limpiar datos visibles ***** */
	
	public void ocultarTextAndLabel() {
		lugarSalidaLabel.setVisible(false);
		cantidadMaximaLabel.setVisible(false);
		fechaSalidaLabel.setVisible(false);
		fechaAltaLabel.setVisible(false);
		horaLabel.setVisible(false);
		cantidadMaxima.setVisible(false);
		fechaAlta.setVisible(false);
		lugarSalida.setVisible(false);
		fechaSalida.setVisible(false);
		horaSalida.setVisible(false);
	}
	
	public void limpiarFormulario() {
		horaSalida.setText("");
	    fechaSalida.setText("");
	    lugarSalida.setText("");
	    cantidadMaxima.setText("");
	    fechaAlta.setText("");
	    
	    seleccionarActividadCAMPO.setVisible(false);
	    seleccionarSalidaCAMPO.setVisible(false);
	    
	    actividadesLabel.setVisible(false);
	    salidasLabel.setVisible(false);
	    
	    departamentoL.setVisible(false);
    	seleccionarDepartamentoCAMPO.setVisible(false);
	    
	    ocultarTextAndLabel();
		
		//if(SeleccionarSalidaCAMPO.getSelectedItem() != null)
			//SeleccionarSalidaCAMPO.setSelectedItem(null);
		//SeleccionarActividadCAMPO.removeAllItems();
		//SeleccionarDepartamentoCAMPO.setSelectedIndex(0);

	}
	
	
	
	
}
