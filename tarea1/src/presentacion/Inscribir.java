package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import com.toedter.calendar.JCalendar;

import logica.DataDepartamento;
import logica.IControladorInsc;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("serial")
public class Inscribir extends JInternalFrame {
	private IControladorInsc icon;
	private JCalendar calendario;
	private int seleccion1 = 0;
	private Set<DataDepartamento> deps;
	private JComboBox comboBox;
	
	public Inscribir(IControladorInsc i) {
		setMaximizable(true);
		setIconifiable(true);
		setClosable(true);
		icon = i;
		this.setTitle("Inscribir");
	    setResizable(true);
	    setBounds(57, 25, 731, 400);
	    getContentPane().setLayout(null);
	    
	    JLabel lblSeleccionarDepartamento = new JLabel("Departamento");
	    lblSeleccionarDepartamento.setBounds(120, 10, 103, 15);
	    getContentPane().add(lblSeleccionarDepartamento);
	    
	    
	    JComboBox comboBox_1 = new JComboBox();
	    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
	    comboBox_1.setVisible(false);
	    comboBox_1.setBounds(243, 41, 354, 24);
	    getContentPane().add(comboBox_1);
	    
	    
	    JLabel lblSeleccionarActividad = new JLabel("Actividad");
	    lblSeleccionarActividad.setBounds(155, 41, 70, 24);
	    getContentPane().add(lblSeleccionarActividad);
	    lblSeleccionarActividad.setVisible(false);
	    
	    
	    comboBox = new JComboBox();
	    comboBox.setBounds(243, 5, 354, 24);
	    comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboBox_1.setVisible(true);
	    		lblSeleccionarActividad.setVisible(true);
	    	}
	    });
	    comboBox.setMaximumRowCount(1000);
	    
	    getContentPane().add(comboBox);
	    

	    JLabel lblSeleccionarSalida = new JLabel("Salida");
	    lblSeleccionarSalida.setBounds(179, 82, 44, 15);
	    getContentPane().add(lblSeleccionarSalida);
	    lblSeleccionarSalida.setVisible(false);
	    
	    JComboBox comboBox_2 = new JComboBox();
	    comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"8", "7"}));
	    comboBox_2.setBounds(243, 77, 354, 24);
	    getContentPane().add(comboBox_2);
	    
	    JLabel lblTurista = new JLabel("Turista");
	    lblTurista.setBounds(173, 121, 50, 15);
	    getContentPane().add(lblTurista);
	    lblTurista.setVisible(false);
	    
	    JComboBox comboBox_3 = new JComboBox();
	    comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"r", "t"}));
	    comboBox_3.setBounds(243, 116, 354, 24);
	    getContentPane().add(comboBox_3);
	    
	    JLabel lblCantidadDeTuristas = new JLabel("Cantidad de Turistas");
	    lblCantidadDeTuristas.setBounds(75, 163, 154, 15);
	    getContentPane().add(lblCantidadDeTuristas);
	    lblCantidadDeTuristas.setVisible(false);
	    
	    JLabel lblFecha = new JLabel("Fecha");
	    lblFecha.setBounds(179, 201, 44, 15);
	    getContentPane().add(lblFecha);
	    lblFecha.setVisible(false);
	    
	    comboBox_3.setVisible(false);
	    
	    comboBox_2.setVisible(false);
	    
	    comboBox_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboBox_2.setVisible(true);
	    		lblSeleccionarSalida.setVisible(true);
	    		comboBox_3.setVisible(true);
	    		lblTurista.setVisible(true);
	    	}
	    });
	    
	    calendario = new JCalendar();	
	    calendario.setBounds(243, 201, 354, 117);
        getContentPane().add(calendario);
        calendario.setVisible(false);
        
        JButton btnInscribir = new JButton("Inscribir");
        btnInscribir.setBounds(480, 331, 117, 25);
        getContentPane().add(btnInscribir);
        
        JComboBox comboBox_4 = new JComboBox();
        comboBox_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		btnInscribir.setVisible(true);
        	}
        });
        comboBox_4.setVisible(false);
        comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35"}));
        comboBox_4.setBounds(243, 158, 354, 24);
        getContentPane().add(comboBox_4);
        btnInscribir.setVisible(false);
        
        comboBox_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(seleccion1==1) {
	    			lblCantidadDeTuristas.setVisible(true);
	    			lblFecha.setVisible(true);
	    			calendario.setVisible(true);
	    			comboBox_4.setVisible(true);
	    		}
	    		else {
	    			seleccion1++;
	    		}
	    	}
	    });
        
        comboBox_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(seleccion1==1) {
	    			lblCantidadDeTuristas.setVisible(true);
	    			lblFecha.setVisible(true);
	    			calendario.setVisible(true);
	    			comboBox_4.setVisible(true);
	    		}
	    		else {
	    			seleccion1++;
	    		}
	    	}
	    });
	    
	}
	
	public void actualizarDptos() {
		/*tabla de deptos*/
	    deps = icon.listarDepartamentos();
	    String[] aux = new String[deps.size()];
	    int cont = 0;
	    for(DataDepartamento iter:deps) {
	    	aux[cont] = iter.getNombre();
	    	cont++;
	    }
	    comboBox.setModel(new DefaultComboBoxModel(aux));
	    /*fin de tabla*/
	}
}
