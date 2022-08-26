package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import excepciones.ActividadNoExisteException;
import excepciones.DepartamentoNoExisteException;
import excepciones.SalidaYaExisteExeption;
import excepciones.UsuarioNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataUsuario;
import logica.IControladorAlta;
import logica.IControladorConsulta;
//import logica.SalidaYaExisteExeption;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ActionEvent;

public class AltaSalida extends JInternalFrame {
	
	private JTextField NombreSalidaCAMPO;
	private JTextField LugarSalidaCAMPO;
	private JTextField MaximaCantTuristasCAMPO;
	private JDateChooser FechaSalidaCAMPO;
	private JDateChooser FechaAltaDatePickerCAMPO;
	private JComboBox horaCAMPO;
	private JComboBox minutosCAMPO;
	private Button aceptarCAMPO;
	private Button cancelarCAMPO;
	private JComboBox SeleccionarDptoCAMPO;
	private JComboBox SeleccionarActividadCAMPO;
	private IControladorAlta controlAlta;
    private DataDepartamento[] DD;
    private IControladorConsulta controlCons;
    private Set<DataActividad> auxi;



	
	
	@SuppressWarnings("unchecked")
	public AltaSalida(IControladorConsulta icu)  {
        controlCons = icu;

        
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
		SeleccionarDptoCAMPO = new JComboBox<String>(); //creo el combobox de strings
		SeleccionarDptoCAMPO.setBounds(218, 31, 162, 21);
		//try {
			//ArrDpto = icu.obtenerDataDepartamentos();
			//for (int i = 0; i < ArrDpto.length; i++){ //AGREGO LOS NOMBRES DE DEPARTAMENTOS AL CAMPO
			//	SeleccionarDptoCAMPO.addItem(ArrDpto[i].getNombre());
			//}
		//} catch (DepartamentoNoExisteException e2) {
		//} 
		getContentPane().add(SeleccionarDptoCAMPO);//agrego el combobox al panel
		
		
		
		
		SeleccionarDptoCAMPO.addActionListener(new ActionListener() { //action listener para cuando se selecciona el dpto
	    	public void actionPerformed(ActionEvent e) {
	    		SeleccionarActividadCAMPO = new JComboBox<String>(); //va a ser un combobox de strings 
				SeleccionarActividadCAMPO.setBounds(218, 68, 162, 21);
			    getContentPane().add(SeleccionarActividadCAMPO);
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
		NombreSalidaCAMPO = new JTextField();
		NombreSalidaCAMPO.setBounds(218, 115, 162, 19);
		getContentPane().add(NombreSalidaCAMPO);
		NombreSalidaCAMPO.setColumns(10);
		//------------------------------------------------------

		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre Salida");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1.setBounds(46, 117, 162, 13);
		getContentPane().add(lblNewLabel_1_1);
		
	
		FechaSalidaCAMPO = new JDateChooser();
		FechaSalidaCAMPO.setBounds(135, 173, 73, 19);
		getContentPane().add(FechaSalidaCAMPO);
		
		JLabel lblNewLabel_1 = new JLabel("hora");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(244, 179, 45, 13);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Lugar De Salida");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1.setBounds(46, 227, 162, 13);
		getContentPane().add(lblNewLabel_1_1_1);
		
		LugarSalidaCAMPO = new JTextField();
		LugarSalidaCAMPO.setColumns(10);
		LugarSalidaCAMPO.setBounds(218, 225, 96, 19);
		getContentPane().add(LugarSalidaCAMPO);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Maxima Cantidad Turistas");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_1_1_1.setBounds(46, 265, 162, 13);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		MaximaCantTuristasCAMPO = new JTextField();
		MaximaCantTuristasCAMPO.setColumns(10);
		MaximaCantTuristasCAMPO.setBounds(218, 263, 96, 19);
		getContentPane().add(MaximaCantTuristasCAMPO);
		
		JLabel lblNewLabel_1_2 = new JLabel("Fecha Salida");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2.setBounds(46, 179, 89, 13);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Fecha Alta");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_2_1.setBounds(46, 297, 89, 13);
		getContentPane().add(lblNewLabel_1_2_1);
		
		FechaAltaDatePickerCAMPO = new JDateChooser();
		FechaAltaDatePickerCAMPO.setBounds(145, 297, 73, 19);
		getContentPane().add(FechaAltaDatePickerCAMPO);
		
		horaCAMPO = new JComboBox();
		horaCAMPO.setBounds(298, 171, 29, 21);
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


		getContentPane().add(horaCAMPO);
		
		minutosCAMPO = new JComboBox();
		minutosCAMPO.setBounds(351, 171, 29, 21);
		minutosCAMPO.addItem(0);
		minutosCAMPO.addItem(2);
		minutosCAMPO.addItem(3);
		minutosCAMPO.addItem(4);
		minutosCAMPO.addItem(5);
		minutosCAMPO.addItem(6);
		minutosCAMPO.addItem(7);

		getContentPane().add(minutosCAMPO);
		
		JLabel lblNewLabel_1_3 = new JLabel(":");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(337, 179, 14, 13);
		getContentPane().add(lblNewLabel_1_3);
		
		SeleccionarActividadCAMPO = new JComboBox<String>();
		SeleccionarActividadCAMPO.setBounds(218, 67, 162, 21);
		getContentPane().add(SeleccionarActividadCAMPO);
		
		aceptarCAMPO = new Button("Aceptar");
		aceptarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   
	
				String NombreActividad = (String)SeleccionarActividadCAMPO.getSelectedItem();
				String NombreSalida = NombreSalidaCAMPO.getText();
				Date Fecha = FechaSalidaCAMPO.getDate();
				Date Hora = new Date();//Date(0,0,0,(Integer)horaCAMPO.getSelectedItem(), (Integer)minutosCAMPO.getSelectedItem());
				String Lugar = LugarSalidaCAMPO.getText();
				Integer maxCantTuristas = Integer.parseInt(MaximaCantTuristasCAMPO.getText());
				Date fechaAlta = FechaAltaDatePickerCAMPO.getDate(); 
		        setVisible(false);
				
		        
		        
			
				try {
					controlAlta.confirmarAltaSalida(NombreActividad, NombreSalida, Fecha, Hora, Lugar, maxCantTuristas, fechaAlta);
				} catch (SalidaYaExisteExeption e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		aceptarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		aceptarCAMPO.setBounds(310, 348, 89, 22);
		getContentPane().add(aceptarCAMPO);
		
		cancelarCAMPO = new Button("Cancelar");
		cancelarCAMPO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent p) {
			   //borrar info y cerrar ventana
			}
		});
		cancelarCAMPO.setFont(new Font("Dialog", Font.BOLD, 12));
		cancelarCAMPO.setBounds(34, 348, 101, 22);
		getContentPane().add(cancelarCAMPO);
		

	}
	@SuppressWarnings("unchecked")
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
}
