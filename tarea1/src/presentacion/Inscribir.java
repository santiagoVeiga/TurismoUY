package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.toedter.calendar.JCalendar;

import excepciones.ExcedeTuristas;
import excepciones.NumeroNegativoException;
import excepciones.TuristaConSalida;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.IControladorInsc;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Inscribir extends JInternalFrame {
	private IControladorInsc icon;
	private JCalendar calendario;
	private Set<DataDepartamento> deps;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JComboBox comboBox_3;
	private JTextField textField;
	protected boolean selecciont = false;
	protected boolean seleccions = false;
	
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
	    
	    
	    comboBox_1 = new JComboBox();
	    comboBox_1.setVisible(false);
	    comboBox_1.setBounds(243, 41, 354, 24);
	    getContentPane().add(comboBox_1);
	    
	    
	    JLabel lblSeleccionarActividad = new JLabel("Actividad");
	    lblSeleccionarActividad.setBounds(155, 41, 70, 24);
	    getContentPane().add(lblSeleccionarActividad);
	    lblSeleccionarActividad.setVisible(false);
	    
	    JLabel lblSeleccionarSalida = new JLabel("Salida");
        JButton btnInscribir = new JButton("Inscribir");
	    
	    comboBox = new JComboBox();
	    comboBox.setBounds(243, 5, 354, 24);
	    comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboBox_1.setVisible(true);
	    		lblSeleccionarActividad.setVisible(true);
	    		obtAct((String) comboBox.getSelectedItem());
	    		if(lblSeleccionarSalida.isVisible()) {
	    			lblSeleccionarSalida.setVisible(false);
	    		}
	    		if(comboBox_2.isVisible()) {
	    			comboBox_2.setVisible(false);
	    		}
	    		if(btnInscribir.isVisible()) {
	    			btnInscribir.setVisible(false);
	    		}
	    	}
	    });
	    comboBox.setMaximumRowCount(1000);
	    
	    getContentPane().add(comboBox);
	    

	    
	    lblSeleccionarSalida.setBounds(179, 82, 44, 15);
	    getContentPane().add(lblSeleccionarSalida);
	    lblSeleccionarSalida.setVisible(false);
	    
	    comboBox_2 = new JComboBox();
	    comboBox_2.setBounds(243, 77, 354, 24);
	    getContentPane().add(comboBox_2);
	    
	    JLabel lblTurista = new JLabel("Turista");
	    lblTurista.setBounds(173, 121, 50, 15);
	    getContentPane().add(lblTurista);
	    lblTurista.setVisible(false);
	    
	    comboBox_3 = new JComboBox();
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
	    		obtSal((String) comboBox_1.getSelectedItem());
	    		obtTur();
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
        

        btnInscribir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		inscri();
        	}
        });
        btnInscribir.setBounds(480, 331, 117, 25);
        getContentPane().add(btnInscribir);
        
        textField = new JTextField();
        textField.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyPressed(KeyEvent e) {
        		btnInscribir.setVisible(true);
        	}
        });
        textField.setBounds(243, 161, 354, 19);
        getContentPane().add(textField);
        textField.setColumns(10);
        textField.setVisible(false);
        btnInscribir.setVisible(false);
        
        comboBox_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!btnInscribir.isVisible()&&lblCantidadDeTuristas.isVisible()) {
	    			btnInscribir.setVisible(true);
	    		}
	    		if(seleccions==true) {
	    			lblCantidadDeTuristas.setVisible(true);
	    			lblFecha.setVisible(true);
	    			calendario.setVisible(true);
	    			textField.setVisible(true);
	    		}
	    		else {
	    			selecciont=true;
	    		}
	    	}
	    });
        
        comboBox_3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(selecciont==true) {
	    			lblCantidadDeTuristas.setVisible(true);
	    			lblFecha.setVisible(true);
	    			calendario.setVisible(true);
	    			textField.setVisible(true);
	    		}
	    		else {
	    			seleccions=true;;
	    		}
	    	}
	    });
	    
	}
	
	public void obtTur() {
		DataUsuario[] array = icon.listarUsuarios();
		int i = 0;
		Set<String> aux = new HashSet<String>();
 		while(i<array.length) {
			if(array[i] instanceof DataTurista) {
				DataTurista dt = (DataTurista) array[i];
				aux.add(dt.getNick());
			}
			i++;
		}
		String[] model = new String[aux.size()];
		i=0;
		for(String iter:aux) {
			model[i] = iter;
			i++;
		}
		comboBox_3.setModel(new DefaultComboBoxModel(model));
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
	
	public void obtAct(String dpto) {
		Set<DataActividad> auxi = icon.selecDepartamento(dpto);
		String[] aux = new String[auxi.size()];
	    int cont = 0;
	    for(DataActividad iter:auxi) {
	    	aux[cont] = iter.getNombre();
	    	cont++;
	    }
	    comboBox_1.setModel(new DefaultComboBoxModel(aux));
	}
	
	public void obtSal(String act) {
		Set<DataSalida> auxi = icon.salidas(act);
		String[] aux = new String[auxi.size()];
	    int cont = 0;
	    for(DataSalida iter:auxi) {
	    	aux[cont] = iter.getNombre();
	    	cont++;
	    }
		comboBox_2.setModel(new DefaultComboBoxModel(aux));
	}
	
	public void inscri() {
		try {
            Integer.parseInt(textField.getText());
            if(Integer.parseInt(textField.getText()) < 0) {
            	throw new NumeroNegativoException();
            }
            icon.inscribir((String) comboBox_3.getSelectedItem(), (String) comboBox_2.getSelectedItem(),Integer.parseInt(textField.getText()) , null,(String) comboBox_1.getSelectedItem());
            JOptionPane.showMessageDialog(this, "Inscripcion existosa", "Inscribir",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad de turistas debe ser un numero", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
        }
		catch (NumeroNegativoException e) {
            JOptionPane.showMessageDialog(this, "La cantidad de turistas debe ser un numero no negativo", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
        }
		catch (TuristaConSalida e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "El turista ya pertenece a la salida", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} catch (ExcedeTuristas e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "La cantidad de turistas excede los cupos disponibles para la salida", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} 
	}
}
