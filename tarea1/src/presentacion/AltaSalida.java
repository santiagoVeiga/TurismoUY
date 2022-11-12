package presentacion;

import java.awt.Button;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

import com.toedter.calendar.JDateChooser;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.FechaAltaSalidaAnteriorActividad;
import excepciones.FechaAltaSalidaInvalida;
import excepciones.SalidaYaExisteExeption;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.IControladorAlta;
import logica.estadoAct;

public class AltaSalida extends JInternalFrame {
	
	private JTextField nombreSalidaCAMPO;
	private JTextField lugarSalidaCAMPO;
	private JTextField maximaCantTuristasCAMPO;
	private JDateChooser fechaSalidaCAMPO;
	private JDateChooser fechaAltaDatePickerCAMPO;
	private JComboBox horaCAMPO;
	private JComboBox minutosCAMPO;
	private Button aceptarCAMPO;
	private Button cancelarCAMPO;
	private JComboBox seleccionarDptoCAMPO;
	private JComboBox seleccionarActividadCAMPO;
	private IControladorAlta controlAlta;
    private DataDepartamento[] dataDepartamentos;
    private Set<DataActividad> auxi;


    
	
	
	@SuppressWarnings("unchecked")
	public AltaSalida(IControladorAlta ica)  {
        controlAlta = ica;

        
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta Salida Turistica");
        setBounds(100, 100, 456, 423);
		getContentPane().setLayout(null);
		
	
		
		JLabel lblNewLabel = new JLabel("Seleccionar Departamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(46, 34, 162, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSeleccionarActividad = new JLabel("Seleccionar Actividad");
		lblSeleccionarActividad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSeleccionarActividad.setBounds(46, 71, 162, 13);
		getContentPane().add(lblSeleccionarActividad); //
		
		//--------------------departamentos--------------------
	
		//DataDepartamento[] ArrDpto = null;
		seleccionarDptoCAMPO = new JComboBox<String>(); //creo el combobox de strings
		seleccionarDptoCAMPO.setBounds(218, 31, 162, 21);
		//try {
			//ArrDpto = icu.obtenerDataDepartamentos();
			//for (int i = 0; i < ArrDpto.length; i++){ //AGREGO LOS NOMBRES DE DEPARTAMENTOS AL CAMPO
			//	SeleccionarDptoCAMPO.addItem(ArrDpto[i].getNombre());
			//}
		//} catch (DepartamentoNoExisteException e2) {
		//} 
		getContentPane().add(seleccionarDptoCAMPO); //agrego el combobox al panel
		seleccionarDptoCAMPO.addActionListener(new ActionListener() { //action listener para cuando se selecciona el dpto
	    	public void actionPerformed(ActionEvent eve) {
            	cargarActividades();
//	    		String nombreDpto = (String)SeleccionarDptoCAMPO.getSelectedItem(); 
//	    		DataDepartamento dtd = null ; 
//	    		for (int i = 0; i < ArrDpto.length; i++){ //AGREGO LOS NOMBRES DE DEPARTAMENTOS AL CAMPO
//					if (ArrDpto[i].getNombre()==nombreDpto)
//						dtd = ArrDpto[i] ; 
//				}
//	    		
//	 			Set<DataActividad> colDTAct = dtd.getColAct();
//				
//				SeleccionarActividadCAMPO = new JComboBox<String>(); //va a ser un combobox de strings 
//				SeleccionarActividadCAMPO.setBounds(218, 68, 162, 21);
//				Iterator<DataActividad> iterator = colDTAct.iterator();
//				while(iterator.hasNext()) {
//					DataActividad setElement = iterator.next(); 
//					SeleccionarActividadCAMPO.addItem(setElement.getNombre());
//				}
//			    getContentPane().add(SeleccionarActividadCAMPO);

				
	    	}
	    });
		
		

		
		//----------------------salida-------------------------
		nombreSalidaCAMPO = new JTextField();
		nombreSalidaCAMPO.setBounds(218, 115, 162, 19);
		getContentPane().add(nombreSalidaCAMPO);
		nombreSalidaCAMPO.setColumns(10);
		//------------------------------------------------------

		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre Salida");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(46, 117, 162, 13);
		getContentPane().add(lblNewLabel_1_1);
		
	
		fechaSalidaCAMPO = new JDateChooser();
		fechaSalidaCAMPO.setBounds(135, 173, 73, 19);
		getContentPane().add(fechaSalidaCAMPO);
		((JTextComponent) fechaSalidaCAMPO.getDateEditor()).setEditable(false);

		JLabel lblNewLabel_1 = new JLabel("hora");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(244, 179, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lugar De Salida");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(46, 227, 162, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		lugarSalidaCAMPO = new JTextField();
		lugarSalidaCAMPO.setColumns(10);
		lugarSalidaCAMPO.setBounds(218, 225, 96, 19);
		getContentPane().add(lugarSalidaCAMPO);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Maxima Cantidad Turistas");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(46, 265, 162, 13);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		maximaCantTuristasCAMPO = new JTextField();
		maximaCantTuristasCAMPO.setColumns(10);
		maximaCantTuristasCAMPO.setBounds(218, 263, 96, 19);
		getContentPane().add(maximaCantTuristasCAMPO);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha Salida");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(46, 179, 89, 13);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fecha Alta");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(46, 297, 89, 13);
		getContentPane().add(lblNewLabel_1_2_1);
		
		fechaAltaDatePickerCAMPO = new JDateChooser();
		fechaAltaDatePickerCAMPO.setBounds(145, 297, 73, 19);
		getContentPane().add(fechaAltaDatePickerCAMPO);
		((JTextComponent) fechaAltaDatePickerCAMPO.getDateEditor()).setEditable(false);

		horaCAMPO = new JComboBox();
		horaCAMPO.setBounds(289, 173, 45, 19);
		horaCAMPO.addItem(0); 
		horaCAMPO.addItem(1); 
		horaCAMPO.addItem(2); 
		horaCAMPO.addItem(3); 
		horaCAMPO.addItem(4); 
		horaCAMPO.addItem(5); 
		horaCAMPO.addItem(6); 
		horaCAMPO.addItem(7); 
		horaCAMPO.addItem(8); 
		horaCAMPO.addItem(9); 
		horaCAMPO.addItem(10); 
		horaCAMPO.addItem(11); 
		horaCAMPO.addItem(12); 
		horaCAMPO.addItem(13); 
		horaCAMPO.addItem(14); 
		horaCAMPO.addItem(15); 
		horaCAMPO.addItem(16); 
		horaCAMPO.addItem(17); 
		horaCAMPO.addItem(18); 
		horaCAMPO.addItem(19); 
		horaCAMPO.addItem(20); 
		horaCAMPO.addItem(21); 
		horaCAMPO.addItem(22); 
		horaCAMPO.addItem(23); 

		getContentPane().add(horaCAMPO);
		
		minutosCAMPO = new JComboBox();
		minutosCAMPO.setBounds(351, 173, 45, 19);
		minutosCAMPO.addItem(0);
		minutosCAMPO.addItem(1);
		minutosCAMPO.addItem(2);
		minutosCAMPO.addItem(3);
		minutosCAMPO.addItem(4);
		minutosCAMPO.addItem(5);
		minutosCAMPO.addItem(6);
		minutosCAMPO.addItem(7);
		minutosCAMPO.addItem(8);
		minutosCAMPO.addItem(9);
		minutosCAMPO.addItem(10);
		minutosCAMPO.addItem(11);
		minutosCAMPO.addItem(12);
		minutosCAMPO.addItem(13);
		minutosCAMPO.addItem(14);
		minutosCAMPO.addItem(15);
		minutosCAMPO.addItem(16);
		minutosCAMPO.addItem(17);
		minutosCAMPO.addItem(18);
		minutosCAMPO.addItem(19);
		minutosCAMPO.addItem(20);
		minutosCAMPO.addItem(21);
		minutosCAMPO.addItem(22);
		minutosCAMPO.addItem(23);
		minutosCAMPO.addItem(24);
		minutosCAMPO.addItem(25);
		minutosCAMPO.addItem(26);
		minutosCAMPO.addItem(27);
		minutosCAMPO.addItem(28);
		minutosCAMPO.addItem(29);
		minutosCAMPO.addItem(30);
		minutosCAMPO.addItem(31);
		minutosCAMPO.addItem(32);
		minutosCAMPO.addItem(33);
		minutosCAMPO.addItem(34);
		minutosCAMPO.addItem(35);
		minutosCAMPO.addItem(36);
		minutosCAMPO.addItem(37);
		minutosCAMPO.addItem(38);
		minutosCAMPO.addItem(39);
		minutosCAMPO.addItem(40);
		minutosCAMPO.addItem(41);
		minutosCAMPO.addItem(42);
		minutosCAMPO.addItem(43);
		minutosCAMPO.addItem(44);
		minutosCAMPO.addItem(45);
		minutosCAMPO.addItem(46);
		minutosCAMPO.addItem(47);
		minutosCAMPO.addItem(48);
		minutosCAMPO.addItem(49);
		minutosCAMPO.addItem(50);
		minutosCAMPO.addItem(51);
		minutosCAMPO.addItem(52);
		minutosCAMPO.addItem(53);
		minutosCAMPO.addItem(54);
		minutosCAMPO.addItem(55);
		minutosCAMPO.addItem(56);
		minutosCAMPO.addItem(57);
		minutosCAMPO.addItem(58);
		minutosCAMPO.addItem(59);


		getContentPane().add(minutosCAMPO);
		
		JLabel lblNewLabel_1_3 = new JLabel(":");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(337, 179, 14, 13);
		getContentPane().add(lblNewLabel_1_3);
		
		seleccionarActividadCAMPO = new JComboBox<String>();
		seleccionarActividadCAMPO.setBounds(218, 67, 162, 21);
		getContentPane().add(seleccionarActividadCAMPO);
		
		aceptarCAMPO = new Button("Aceptar");
		aceptarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
				chequeoAlta();
				limpiarFormulario();
			}
		});
		aceptarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		aceptarCAMPO.setBounds(310, 348, 89, 22);
		getContentPane().add(aceptarCAMPO);
		
		cancelarCAMPO = new Button("Cancelar");
		cancelarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eve) {
			   limpiarFormulario();
			   setVisible(false);
			}
		});
		cancelarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		cancelarCAMPO.setBounds(34, 348, 101, 22);
		getContentPane().add(cancelarCAMPO);
		

	}//----------------------------------------------------------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	public void cargarDepartamentos(){
    	DefaultComboBoxModel<String> model;
    	try {
    		dataDepartamentos = controlAlta.obtenerDataDepartamentos();
    		String[] DepartamentosNombres = new String[dataDepartamentos.length];
    		for (int i = 0; i < dataDepartamentos.length; i++) {
    			DepartamentosNombres[i] = dataDepartamentos[i].getNombre();
    		}
	    	model = new DefaultComboBoxModel<String>(DepartamentosNombres);
	    	seleccionarDptoCAMPO.setModel(model);
	    } catch (DepartamentoNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
    	}
    }
	
	@SuppressWarnings("unchecked")
	public void cargarActividades(){
		DefaultComboBoxModel<String> model;
		try {
			String aux = (String) seleccionarDptoCAMPO.getSelectedItem();
			int iCont = 0;
			while (iCont<dataDepartamentos.length && dataDepartamentos[iCont].getNombre() != aux) {
				iCont++;
			}
			if (dataDepartamentos[iCont].getColAct().size() == 0) {
				throw new ActividadNoExisteException("No hay actividades asociadas a dicho Departamento");
			}
			auxi = dataDepartamentos[iCont].getColAct();
			Iterator<DataActividad> iter = auxi.iterator();
			int jCont = 0;
			while (iter.hasNext()) {
				if (iter.next().getEstado() == estadoAct.confirmada) {
					jCont++;
				}
			}
			String[] ActividadesNombres = new String[jCont];
			jCont = 0;
			iter = auxi.iterator();
			while (iter.hasNext()) {
				DataActividad act = iter.next();
				if (act.getEstado() == estadoAct.confirmada) {
					ActividadesNombres[jCont] = act.getNombre();
					jCont++;
				}
			}
	    	model = new DefaultComboBoxModel<String>(ActividadesNombres);
	    	seleccionarActividadCAMPO.setModel(model);
	    } catch (ActividadNoExisteException e) {
	    	JOptionPane.showMessageDialog(this, e.getMessage(), e.getMessage(), JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void limpiarFormulario() {
		seleccionarActividadCAMPO.setModel(new DefaultComboBoxModel<String>(new String[0]));
	}
	
	//--------------------------------------------------------------------------------------------------
	


public void chequeoAlta() {
	
	String NombreActividad = (String) seleccionarActividadCAMPO.getSelectedItem();
	String NombreSalida = nombreSalidaCAMPO.getText();
	Date Fecha = fechaSalidaCAMPO.getDate();
	Date Hora = new Date(0, 0, 0, (Integer) horaCAMPO.getSelectedItem(), (Integer) minutosCAMPO.getSelectedItem());
	String Lugar = lugarSalidaCAMPO.getText();
	String maxCantTuristas = maximaCantTuristasCAMPO.getText();
	Date fechaAlta = fechaAltaDatePickerCAMPO.getDate();
	if (checkFormulario()) {
		try {
			controlAlta.confirmarAltaSalida(NombreActividad, NombreSalida, Fecha, Hora, Lugar, Integer.parseInt(maxCantTuristas), fechaAlta, null);
			JOptionPane.showMessageDialog(this, "Alta exitosa", "Salida", JOptionPane.INFORMATION_MESSAGE);
		} catch (SalidaYaExisteExeption e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Salida ya existe", JOptionPane.ERROR_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Formato de entrada invalido", "Dato Invalido", JOptionPane.ERROR_MESSAGE);
		} catch (FechaAltaSalidaInvalida e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "La fecha de alta no debe ser posterior a la fecha de la salida", "Fecha Invalida", JOptionPane.ERROR_MESSAGE);
		} catch (FechaAltaSalidaAnteriorActividad e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "La fecha de alta de la salida no debe ser anterior a la fecha de alta de la actividad", "Fecha Invalida", JOptionPane.ERROR_MESSAGE);
		}
	    setVisible(false);
	}
}
	
	//--------------------------------------------------------------------------------------------------
	
	
	private boolean checkFormulario() {
		String NombreActividad = (String) seleccionarActividadCAMPO.getSelectedItem();
		String NombreSalida = nombreSalidaCAMPO.getText();
		Date Fecha = fechaSalidaCAMPO.getDate();
		Date Hora = new Date(0, 0, 0, (Integer) horaCAMPO.getSelectedItem(), (Integer) minutosCAMPO.getSelectedItem());
		String Lugar = lugarSalidaCAMPO.getText();
		String maxCantTuristas = maximaCantTuristasCAMPO.getText();
		Date fechaAlta = fechaAltaDatePickerCAMPO.getDate();
		
		
	    if (NombreActividad == null || NombreSalida == null || Lugar.isEmpty() || Hora==null || Fecha==null || fechaAlta==null) {
	        JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Salida",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	
	    try {
	        Integer.parseInt(maxCantTuristas);
	        if (Integer.parseInt(maxCantTuristas)<0) {
		        JOptionPane.showMessageDialog(this, "La cantidad maxima debe ser un valor no negativo", "Registrar Salida",
		                JOptionPane.ERROR_MESSAGE);
		        return false;
		    }
	    } catch (NumberFormatException e) {
	        JOptionPane.showMessageDialog(this, "La cantidad maxima debe ser un numero", "Registrar Salida",
	                JOptionPane.ERROR_MESSAGE);
	        return false;
	    }
	    
	    return true;
}
	
	
}
