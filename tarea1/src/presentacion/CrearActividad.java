package presentacion;

import javax.swing.JInternalFrame;

import excepciones.ActividadRepetidaException;
import logica.IControladorAlta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

//import com.toedter.calendar.JCalendar;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.Box;
import javax.swing.JSplitPane;


@SuppressWarnings("serial")
public class CrearActividad extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	public CrearActividad(IControladorAlta ica) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 30, 50, 50};
		gridBagLayout.rowHeights = new int[] {0, 30, 30, 30, 30, 0, 0, 30};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel Nombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_Nombre = new GridBagConstraints();
		gbc_Nombre.anchor = GridBagConstraints.EAST;
		gbc_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_Nombre.gridx = 0;
		gbc_Nombre.gridy = 1;
		getContentPane().add(Nombre, gbc_Nombre);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel Desc = new JLabel("Descripci\u00F3n: ");
		Desc.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Desc = new GridBagConstraints();
		gbc_Desc.anchor = GridBagConstraints.EAST;
		gbc_Desc.insets = new Insets(0, 0, 5, 5);
		gbc_Desc.gridx = 0;
		gbc_Desc.gridy = 2;
		getContentPane().add(Desc, gbc_Desc);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		getContentPane().add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel Costo = new JLabel("Costo: ");
		GridBagConstraints gbc_Costo = new GridBagConstraints();
		gbc_Costo.anchor = GridBagConstraints.EAST;
		gbc_Costo.insets = new Insets(0, 0, 5, 5);
		gbc_Costo.gridx = 0;
		gbc_Costo.gridy = 3;
		getContentPane().add(Costo, gbc_Costo);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		getContentPane().add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel Duracion = new JLabel("Duraci\u00F3n");
		GridBagConstraints gbc_Duracion = new GridBagConstraints();
		gbc_Duracion.anchor = GridBagConstraints.EAST;
		gbc_Duracion.insets = new Insets(0, 0, 5, 5);
		gbc_Duracion.gridx = 0;
		gbc_Duracion.gridy = 4;
		getContentPane().add(Duracion, gbc_Duracion);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		getContentPane().add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton Cancelar = new JButton("Cancelar");
		GridBagConstraints gbc_Cancelar = new GridBagConstraints();
		gbc_Cancelar.anchor = GridBagConstraints.EAST;
		gbc_Cancelar.insets = new Insets(0, 0, 0, 5);
		gbc_Cancelar.gridx = 0;
		gbc_Cancelar.gridy = 6;
		getContentPane().add(Cancelar, gbc_Cancelar);
		
		JButton Registrar = new JButton("New button");
		GridBagConstraints gbc_Registrar = new GridBagConstraints();
		gbc_Registrar.fill = GridBagConstraints.HORIZONTAL;
		gbc_Registrar.gridx = 2;
		gbc_Registrar.gridy = 6;
		getContentPane().add(Registrar, gbc_Registrar);
	}
}
