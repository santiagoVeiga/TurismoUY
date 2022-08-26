package presentacion;

import java.awt.EventQueue;




import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import excepciones.DepartamentoNoExisteException;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.IControladorConsulta;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.ItemEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultaSalidaTuristica extends JInternalFrame {
	
	private IControladorConsulta controlCons ; 
    private DataDepartamento[] DD;
    JComboBox<String> SeleccionarDptoCOMBOBOX ; 


	public ConsultaSalidaTuristica(IControladorConsulta icu)  {
		
		controlCons = icu ;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JButton cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                setVisible(false);
			}
		});
		cancelar.setBounds(176, 224, 89, 23);
		getContentPane().add(cancelar);
		
		
		JLabel SeleccionarDpto = new JLabel("Seleccionar Departamento");
		SeleccionarDpto.setBounds(70, 122, 126, 14);
		getContentPane().add(SeleccionarDpto);
		
		SeleccionarDptoCOMBOBOX = new JComboBox<String>();

//		DataDepartamento[] ArrDpto = null;
//		try {
//			ArrDpto = icu.obtenerDataDepartamentos();
//			for (int i = 0; i < ArrDpto.length; i++){ //AGREGO LOS NOMBRES DE DEPARTAMENTOS AL CAMPO
//				SeleccionarDptoCOMBOBOX.addItem(ArrDpto[i]);
//			}
//			
//		} catch (DepartamentoNoExisteException e1) {
//		} 
	
		
		
		SeleccionarDptoCOMBOBOX.setBounds(222, 118, 134, 22);
		getContentPane().add(SeleccionarDptoCOMBOBOX);
		
		
		//------------------------------------listener-dpto-------------------------------------------
				SeleccionarDptoCOMBOBOX.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						
						SeleccionarDpto.setVisible(false);
						SeleccionarDptoCOMBOBOX.setVisible(false);
					
						//DataDepartamento dtd = (DataDepartamento) SeleccionarDptoCOMBOBOX.getSelectedItem(); //tengo el data departamento seleccionado
						//Set<DataActividad> colDTAct = dtd.getColAct();
						
						
						JLabel seleccionarAct = new JLabel("Seleccionar Actividad");
						seleccionarAct.setBounds(70, 122, 126, 14);
						getContentPane().add(seleccionarAct);
						seleccionarAct.setVisible(true);

						
						//JComboBox<DataActividad> SelccionarActividadCOMBOBOX = new JComboBox<DataActividad>();
						
						//agregar las actividades al combobox 
						Iterator<DataActividad> iterator = colDTAct.iterator();
						while(iterator.hasNext()) {
							DataActividad setElement = iterator.next(); 
							SelccionarActividadCOMBOBOX.addItem(setElement);
						}

					
						SelccionarActividadCOMBOBOX.setBounds(222, 118, 134, 22);
						getContentPane().add(SelccionarActividadCOMBOBOX);
//						seleccionarAct.setVisible(true);
//						SelccionarActividadCOMBOBOX.setVisible(true);
						//------------------------------------listener-actividad------------------------------
						SelccionarActividadCOMBOBOX.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent e) {
								
								seleccionarAct.setVisible(false);
								SelccionarActividadCOMBOBOX.setVisible(false);
								
								JLabel lblNewLabel = new JLabel("Seleccionar Salida");
								lblNewLabel.setBounds(70, 122, 126, 14);
								getContentPane().add(lblNewLabel);
								
								DataActividad dta = (DataActividad) SelccionarActividadCOMBOBOX.getSelectedItem();
								Set<DataSalida> salidas = dta.getSalidas() ; 
								
								JComboBox<DataSalida> SeleccionarSalidaCOMBOBOX = new JComboBox<DataSalida>();
								
								Iterator<DataSalida> iterator = salidas.iterator();
								while(iterator.hasNext()) {
									DataSalida setElement = iterator.next(); 
									SeleccionarSalidaCOMBOBOX.addItem(setElement);
								}
								
								SeleccionarSalidaCOMBOBOX.setBounds(222, 118, 134, 22);
					
								
								getContentPane().add(SeleccionarSalidaCOMBOBOX);
								//-------------------------------------listener-salida---------------------------------
								SeleccionarSalidaCOMBOBOX.addItemListener(new ItemListener() {
									public void itemStateChanged(ItemEvent e) {
										
									
										SeleccionarSalidaCOMBOBOX.setVisible(false);
										lblNewLabel.setVisible(false);
						                setVisible(false);

										DataSalida dts = (DataSalida) SeleccionarSalidaCOMBOBOX.getSelectedItem();
										
										
										//llamar a la clase de franco
										InfoSalida mostrarDatos = new InfoSalida(dts) ; 
										mostrarDatos.setVisible(true);

									}
								});
								//--------------------------------------------------------------------------------------
							}
						});
						//------------------------------------------------------------------------------------
					}
				});
		//-----------------------------------------------------------------------------------------
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
		    	SeleccionarDptoCOMBOBOX.setModel(model);
			} catch (DepartamentoNoExisteException e) {
		
			}
    		
	  
    }
}
