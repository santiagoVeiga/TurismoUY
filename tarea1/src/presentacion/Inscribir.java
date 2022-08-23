package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import logica.IControladorInsc;
import java.awt.Choice;
import java.awt.List;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class Inscribir extends JInternalFrame {
	private IControladorInsc icon;
	public Inscribir(IControladorInsc i) {
		icon = i;
		this.setTitle("Inscribir");
	    setResizable(true);
	    setBounds(57, 25, 731, 400);
	    getContentPane().setLayout(null);
	    
	    JLabel lblSeleccionarDepartamento = new JLabel("Seleccionar Departamento:");
	    lblSeleccionarDepartamento.setBounds(31, 10, 194, 15);
	    getContentPane().add(lblSeleccionarDepartamento);
	    
	    
	    JComboBox comboBox_1 = new JComboBox();
	    comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
	    comboBox_1.setVisible(false);
	    comboBox_1.setBounds(243, 41, 354, 24);
	    getContentPane().add(comboBox_1);
	    
	    
	    JLabel lblSeleccionarActividad = new JLabel("Seleccionar Actividad:");
	    lblSeleccionarActividad.setBounds(31, 41, 176, 24);
	    getContentPane().add(lblSeleccionarActividad);
	    lblSeleccionarActividad.setVisible(false);
	    
	    
	    JComboBox comboBox = new JComboBox();
	    comboBox.setBounds(243, 5, 354, 24);
	    comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboBox_1.setVisible(true);
	    		lblSeleccionarActividad.setVisible(true);
	    	}
	    });
	    comboBox.setMaximumRowCount(1000);
	    comboBox.setModel(new DefaultComboBoxModel(new String[] {"hola", "chau"}));
	    getContentPane().add(comboBox);
	    

	    JLabel lblSeleccionarSalida = new JLabel("Seleccionar Salida:");
	    lblSeleccionarSalida.setBounds(31, 81, 176, 15);
	    getContentPane().add(lblSeleccionarSalida);
	    lblSeleccionarSalida.setVisible(false);
	    
	    JComboBox comboBox_2 = new JComboBox();
	    comboBox_2.setBounds(243, 77, 354, 24);
	    getContentPane().add(comboBox_2);
	    comboBox_2.setVisible(false);
	    
	    comboBox_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboBox_2.setVisible(true);
	    		lblSeleccionarSalida.setVisible(true);
	    	}
	    });
	    
	    
	}
}
