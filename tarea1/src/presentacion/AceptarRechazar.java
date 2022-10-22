package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import excepciones.ActividadNoExisteException;
import excepciones.estadoActividadIncorrecto;
import logica.IControladorInsc;
import logica.estadoAct;

@SuppressWarnings("serial")
public class AceptarRechazar extends JInternalFrame {
	
	private IControladorInsc ici;
	private JComboBox comboBox;

	public AceptarRechazar(IControladorInsc i) {
		ici = i;
		
		setResizable(true);
        setClosable(true);
        setTitle("Aceptar / Rechazar");
        setBounds(30, 30, 618, 324);
        getContentPane().setLayout(null);
        
        JLabel lblActividades = new JLabel("Actividades");
        lblActividades.setBounds(64, 67, 106, 15);
        getContentPane().add(lblActividades);
        
        comboBox = new JComboBox();
        comboBox.setBounds(169, 62, 352, 24);
        getContentPane().add(comboBox);
        
        JRadioButton rdbtnRechazar = new JRadioButton("Rechazar");
        JRadioButton rdbtnConfirmar = new JRadioButton("Aceptar");
        rdbtnConfirmar.setSelected(true);
        rdbtnRechazar.setSelected(false);
        rdbtnConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnConfirmar.setSelected(true);
                rdbtnRechazar.setSelected(false);
        	}
        });
        rdbtnConfirmar.setBounds(320, 143, 106, 23);
        getContentPane().add(rdbtnConfirmar);
        
        rdbtnRechazar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		rdbtnConfirmar.setSelected(false);
                rdbtnRechazar.setSelected(true);
        	}
        });
        rdbtnRechazar.setBounds(430, 143, 91, 23);
        getContentPane().add(rdbtnRechazar);
        
        JButton btnConfirmar = new JButton("Confirmar");
        btnConfirmar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (rdbtnConfirmar.isSelected()) {
        			enviarDatos(comboBox.getSelectedItem(), estadoAct.confirmada);
        		}
        		else {
        			enviarDatos(comboBox.getSelectedItem(), estadoAct.rechazada);
        		}
        		setVisible(false);
        	}
        });
        btnConfirmar.setBounds(404, 236, 117, 25);
        getContentPane().add(btnConfirmar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
        btnCancelar.setBounds(249, 236, 117, 25);
        getContentPane().add(btnCancelar);
	}

	protected void enviarDatos(Object selectedItem, estadoAct estado) {
		String nomAct = selectedItem.toString();
		try {
			ici.aceptarRechazarAct(nomAct, estado);
			JOptionPane.showMessageDialog(this, "Operacion exitosa", "Aceptar / Rechazar Actividad",
                    JOptionPane.INFORMATION_MESSAGE);
		} catch (estadoActividadIncorrecto e) {
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error", "Estado de la actividad incorrecto",
                    JOptionPane.INFORMATION_MESSAGE);
		} catch (ActividadNoExisteException e) {
			JOptionPane.showMessageDialog(this, "Ha ocurrido un error", e.getMessage(),
                    JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void actCategorias() {
		Set<String> listCat = ici.listarActividadesAgregadas();
		String[] model = listCat.toArray(new String[listCat.size()]);
		comboBox.setModel(new DefaultComboBoxModel(model));
	}
}
