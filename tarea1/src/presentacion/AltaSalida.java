package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import excepciones.DepartamentoNoExisteException;
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
	//private JComboBox FechaAltaCAMPO;
	private JComboBox SeleccionarDptoCAMPO;
	private JComboBox SeleccionarActividadCAMPO;
	private IControladorAlta controlAlta;
	
	
	@SuppressWarnings("unchecked")
	public AltaSalida(IControladorConsulta icu) throws DepartamentoNoExisteException {
		
        //controlConsulta = icu;
        
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
		
		DataDepartamento[] ArrDpto = icu.obtenerDataDepartamentos() ; 
		
		SeleccionarDptoCAMPO = new JComboBox<String>(); //va a ser un combobox de strings
		SeleccionarDptoCAMPO.setBounds(218, 31, 162, 21);
		for (int i = 0; i < ArrDpto.length; i++){ //AGREGO LOS NOMBRES DE DEPARTAMENTOS AL CAMPO
			SeleccionarDptoCAMPO.addItem(ArrDpto[i].getNombre());
		}
		getContentPane().add(SeleccionarDptoCAMPO);
		String NombreDpto = (String)SeleccionarDptoCAMPO.getSelectedItem();
		 
		SeleccionarActividadCAMPO = new JComboBox<String>(); //va a ser un combobox de strings 
		SeleccionarActividadCAMPO.setBounds(218, 68, 162, 21);
		
		ItemListener itemListener = new ItemListener() {
		      public void itemStateChanged(ItemEvent itemEvent) {
		        int state = itemEvent.getStateChange();
		        
		        
				DataActividad[] ArrAct = icu.listaActividadesEnDepartamento(NombreDpto);
				for (int i = 0; i < ArrAct.length; i++){ //AGREGO LOS NOMBRES DE DEPARTAMENTOS AL CAMPO
					SeleccionarActividadCAMPO.addItem(ArrAct[i].getNombre());
				}
				getContentPane().add(SeleccionarActividadCAMPO);
		        

		        
		   		       
		      }
		    };
		    SeleccionarDptoCAMPO.addItemListener(itemListener);
		
	
		//--------------------actividades-----------------------
//		SeleccionarActividadCAMPO = new JComboBox<String>(); //va a ser un combobox de strings 
//		SeleccionarActividadCAMPO.setBounds(218, 68, 162, 21);
//		
//		DataActividad[] ArrAct = icu.listaActividadesEnDepartamento(NombreDpto);
//	
//		for (int i = 0; i < ArrAct.length; i++){ //AGREGO LOS NOMBRES DE DEPARTAMENTOS AL CAMPO
//			SeleccionarActividadCAMPO.addItem(ArrAct[i].getNombre());
//		}
//		getContentPane().add(SeleccionarActividadCAMPO);
		//------------------------------------------------------
		
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
		getContentPane().add(horaCAMPO);
		
		minutosCAMPO = new JComboBox();
		minutosCAMPO.setBounds(351, 171, 29, 21);
		getContentPane().add(minutosCAMPO);
		
		JLabel lblNewLabel_1_3 = new JLabel(":");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1_3.setBounds(337, 179, 14, 13);
		getContentPane().add(lblNewLabel_1_3);
		
		SeleccionarActividadCAMPO = new JComboBox();
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
				
			
				controlAlta.confirmarAltaSalida(NombreActividad, NombreSalida, Fecha, Hora, Lugar, maxCantTuristas, fechaAlta);
			
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
}
