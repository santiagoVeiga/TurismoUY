package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logica.DataActividad;
import logica.DataPaquete;
import logica.DataSalida;
import logica.DataTurista;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class InfoActividades extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public InfoActividades(DataActividad DT) {
		
		if(DT!=null)
			setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Informacion Actividad");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Costo :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField(DT.getCosto());
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 4;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 4;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nombre :");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 2;
		contentPane.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		textField_1 = new JTextField(DT.getNombre());
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Duracion :");
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 3;
		contentPane.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		textField_2 = new JTextField(DT.getDuracion());
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		contentPane.add(textField_2, gbc_textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("FechaAlta :");
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 1;
		gbc_lblNewLabel_1_3.gridy = 4;
		contentPane.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		textField_3 = new JTextField(DT.getFechaAlta().getDay() +"/"+ DT.getFechaAlta().getMonth() + "/"+DT.getFechaAlta().getYear());
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 4;
		contentPane.add(textField_3, gbc_textField_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Ciudad :");
		GridBagConstraints gbc_lblNewLabel_1_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_1.gridx = 1;
		gbc_lblNewLabel_1_3_1.gridy = 5;
		contentPane.add(lblNewLabel_1_3_1, gbc_lblNewLabel_1_3_1);
		
		textField_4 = new JTextField(DT.getCiudad());
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 5;
		contentPane.add(textField_4, gbc_textField_4);
		
		JLabel lblNewLabel_1_3_1_1 = new JLabel("Descripcion :");
		GridBagConstraints gbc_lblNewLabel_1_3_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_1_1.gridx = 1;
		gbc_lblNewLabel_1_3_1_1.gridy = 6;
		contentPane.add(lblNewLabel_1_3_1_1, gbc_lblNewLabel_1_3_1_1);
		
		textField_5 = new JTextField(DT.getDescripcion());
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 6;
		contentPane.add(textField_5, gbc_textField_5);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Salidas :");
		GridBagConstraints gbc_lblNewLabel_1_3_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_2_1.gridx = 1;
		gbc_lblNewLabel_1_3_2_1.gridy = 7;
		contentPane.add(lblNewLabel_1_3_2_1, gbc_lblNewLabel_1_3_2_1);
		
		Object[] o = DT.getSalidas().toArray();
        DataSalida[] usuarios = new DataSalida[o.length];
        for (int i = 0; i < o.length; i++) {
        	usuarios[i] = (DataSalida) o[i];
        }
        
        Object[] o1 = DT.getPaquete().toArray();
        DataPaquete[] DP = new DataPaquete[o1.length];
        for (int i = 0; i < o1.length; i++) {
        	DP[i] = (DataPaquete) o1[i];
        }
		
		JComboBox<DataSalida> comboBox = new JComboBox<DataSalida>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 7;
		contentPane.add(comboBox, gbc_comboBox);
		
		ComboBoxModel<DataSalida> model;
        model = new DefaultComboBoxModel<DataSalida>(usuarios);
        comboBox.setModel(model);
		
		JLabel lblNewLabel_1_3_2_1_1 = new JLabel("Paquetes :");
		GridBagConstraints gbc_lblNewLabel_1_3_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_2_1_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_2_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_2_1_1.gridx = 1;
		gbc_lblNewLabel_1_3_2_1_1.gridy = 8;
		contentPane.add(lblNewLabel_1_3_2_1_1, gbc_lblNewLabel_1_3_2_1_1);
		
		
		
		JComboBox<DataPaquete> comboBox_1 = new JComboBox<DataPaquete>();
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.gridwidth = 4;
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 5;
		gbc_comboBox_1.gridy = 8;
		contentPane.add(comboBox_1, gbc_comboBox_1);
		
		ComboBoxModel<DataPaquete> model2;
        model2 = new DefaultComboBoxModel<DataPaquete>(DP);
        comboBox_1.setModel(model2);
		
		JButton btnNewButton = new JButton("Info. Salida");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 9;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int i = comboBox.getSelectedIndex();
            	InfoSalida is = new InfoSalida(usuarios[i]);
            	is.setVisible(true);
            }
        });
		
		JButton btnInfoPaquete = new JButton("Info. Paquete");
		GridBagConstraints gbc_btnInfoPaquete = new GridBagConstraints();
		gbc_btnInfoPaquete.insets = new Insets(0, 0, 0, 5);
		gbc_btnInfoPaquete.gridx = 8;
		gbc_btnInfoPaquete.gridy = 9;
		contentPane.add(btnInfoPaquete, gbc_btnInfoPaquete);
		
		btnInfoPaquete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int i = comboBox_1.getSelectedIndex();
            	InfoPaquete is = new InfoPaquete(DP[i]);
            	is.setVisible(true);
            }
        });
		
		
		JButton btnNewButton_1 = new JButton("Salir");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 9;
		gbc_btnNewButton_1.gridy = 9;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		
	}
}
