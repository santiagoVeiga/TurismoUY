package presentacion;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import logica.DataSalida;
import logica.DataTurista;

public class InfoTurista extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JComboBox<String> comboUsu;
	private JButton boton;
	private JLabel label;
	private DataTurista dataTur;
	private ConsultaSalidaTuristica salida;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * @param sal 
	 */

	@SuppressWarnings("deprecation")
	public InfoTurista(DataTurista DT, ConsultaSalidaTuristica sal) {
		dataTur = DT;
		salida = sal;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Informacion Turista");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 5;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NickName :");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField = new JTextField(DT.getNick());
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
		
		textField1 = new JTextField(DT.getNombre());
		textField1.setEditable(false);
		textField1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.gridwidth = 4;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 4;
		gbc_textField_1.gridy = 2;
		contentPane.add(textField1, gbc_textField_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellido :");
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 1;
		gbc_lblNewLabel_1_2.gridy = 3;
		contentPane.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		textField2 = new JTextField(DT.getApellido());
		textField2.setEditable(false);
		textField2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.gridwidth = 4;
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 4;
		gbc_textField_2.gridy = 3;
		contentPane.add(textField2, gbc_textField_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email :");
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 1;
		gbc_lblNewLabel_1_3.gridy = 4;
		contentPane.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		textField3 = new JTextField(DT.getMail());
		textField3.setEditable(false);
		textField3.setColumns(10);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.gridwidth = 4;
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 4;
		gbc_textField_3.gridy = 4;
		contentPane.add(textField3, gbc_textField_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("FechaDeNacimiento :");
		GridBagConstraints gbc_lblNewLabel_1_3_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_1.gridx = 1;
		gbc_lblNewLabel_1_3_1.gridy = 5;
		contentPane.add(lblNewLabel_1_3_1, gbc_lblNewLabel_1_3_1);

		textField4 = new JTextField(DT.getNacimiento().getDate() +"/" + (DT.getNacimiento().getMonth()+1)+ "/"+(DT.getNacimiento().getYear()+1900));
		textField4.setColumns(10);
		textField4.setEditable(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.gridwidth = 4;
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 4;
		gbc_textField_4.gridy = 5;
		contentPane.add(textField4, gbc_textField_4);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Nacionalidad :");
		GridBagConstraints gbc_lblNewLabel_1_3_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_2.gridx = 1;
		gbc_lblNewLabel_1_3_2.gridy = 6;
		contentPane.add(lblNewLabel_1_3_2, gbc_lblNewLabel_1_3_2);
		
		textField5 = new JTextField(DT.getNacionalidad());
		textField5.setColumns(10);
		textField5.setEditable(false);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.gridwidth = 4;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.gridx = 4;
		gbc_textField_5.gridy = 6;
		contentPane.add(textField5, gbc_textField_5);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("Salidas :");
		GridBagConstraints gbc_lblNewLabel_1_3_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_3_2_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1_3_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3_2_1.gridx = 1;
		gbc_lblNewLabel_1_3_2_1.gridy = 7;
		contentPane.add(lblNewLabel_1_3_2_1, gbc_lblNewLabel_1_3_2_1);
		
		label=lblNewLabel_1_3_2_1;
		Object[] o = DT.getDataSalidas().toArray();
        DataSalida[] usuarios2 = new DataSalida[o.length];
        String[] usuarios = new String[o.length];
        for (int i = 0; i < o.length; i++) {
        	usuarios2[i] = (DataSalida) o[i];
        	usuarios[i] = ((DataSalida) o[i]).getNombre();   
        }
        
		JComboBox<String> comboBox = new JComboBox<String>();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 4;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 5;
		gbc_comboBox.gridy = 7;
		contentPane.add(comboBox, gbc_comboBox);
		
		comboUsu = comboBox;
		
		JButton btnNewButton = new JButton("Info. Salida");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 8;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		boton=btnNewButton;
		btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int i = comboBox.getSelectedIndex();
            	salida.cargarDatosSalidaPorDataSalida(usuarios2[i]);
            	salida.setVisible(true);
            	setVisible(false);
            }
        });
		
		if (o.length>0) {
			DefaultComboBoxModel<String> model;
	        model = new DefaultComboBoxModel<String>(usuarios);
	        comboBox.setModel(model);
		}else {
			comboBox.setVisible(false);
			lblNewLabel_1_3_2_1.setVisible(false);
			btnNewButton.setVisible(false);
		}	
		
		JButton btnNewButton_1 = new JButton("Salir");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 9;
		gbc_btnNewButton_1.gridy = 9;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	setVisible(false);
            }
        });
	}

	public void cargar() {
		// TODO Auto-generated method stub
		
		Object[] o = dataTur.getDataSalidas().toArray();
        DataSalida[] usuarios2 = new DataSalida[o.length];
        String[] usuarios = new String[o.length];
        for (int i = 0; i < o.length; i++) {
        	usuarios2[i] = (DataSalida) o[i];
        	usuarios[i] = ((DataSalida) o[i]).getNombre();   
        }
		
		if (o.length>0) {
			DefaultComboBoxModel<String> model;
	        model = new DefaultComboBoxModel<String>(usuarios);
	        comboUsu.setModel(model);
	        comboUsu.setVisible(true);
			label.setVisible(true);
			boton.setVisible(true);
		}
	}

}
