package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.toedter.calendar.JCalendar;

import excepciones.ActividadNoExisteException;
import excepciones.ExcedeTuristas;
import excepciones.InscFechaDespSalida;
import excepciones.InscFechaInconsistente;
import excepciones.NumeroNegativoException;
import excepciones.TuristaConSalida;
import excepciones.TuristaNoHaNacido;
import logica.DataActividad;
import logica.DataDepartamento;
import logica.DataSalida;
import logica.DataTurista;
import logica.DataUsuario;
import logica.IControladorInsc;

@SuppressWarnings("serial")
public class Inscribir extends JInternalFrame {
	private IControladorInsc icon;
	private JCalendar calendario;
	private Set<DataDepartamento> deps;
	private JComboBox comboBox;
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JComboBox comboBox3;
	private JTextField textField;
	private boolean selecciont = false;
	private boolean seleccions = false;
	private Date fechaInsc;
	private JLabel lblSeleccionarActividad;
	private JLabel lblSeleccionarSalida;
	private JButton btnInscribir;
	private JLabel lblTurista;
	private JLabel lblCantidadDeTuristas;
	private JLabel lblFecha;
	
	public Inscribir(IControladorInsc i) {
		setMaximizable(true);
		icon = i;
		this.setTitle("Inscribir");
	    setResizable(true);
	    setBounds(57, 25, 731, 400);
	    getContentPane().setLayout(null);
	    
	    JLabel lblSeleccionarDepartamento = new JLabel("Departamento");
	    lblSeleccionarDepartamento.setBounds(120, 10, 103, 15);
	    getContentPane().add(lblSeleccionarDepartamento);
	    
	    
	    comboBox1 = new JComboBox();
	    comboBox1.setVisible(false);
	    comboBox1.setBounds(243, 41, 354, 24);
	    getContentPane().add(comboBox1);
	    
	    
	    lblSeleccionarActividad = new JLabel("Actividad");
	    lblSeleccionarActividad.setBounds(155, 41, 70, 24);
	    getContentPane().add(lblSeleccionarActividad);
	    lblSeleccionarActividad.setVisible(false);
	    
	    lblSeleccionarSalida = new JLabel("Salida");
        btnInscribir = new JButton("Inscribir");
	    
	    comboBox = new JComboBox();
	    comboBox.setBounds(243, 5, 354, 24);
	    comboBox.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		comboBox1.setVisible(true);
	    		lblSeleccionarActividad.setVisible(true);
	    		obtAct((String) comboBox.getSelectedItem());
	    		if (lblSeleccionarSalida.isVisible()) {
	    			lblSeleccionarSalida.setVisible(false);
	    		}
	    		if (comboBox2.isVisible()) {
	    			comboBox2.setVisible(false);
	    		}
	    		if (btnInscribir.isVisible()) {
	    			btnInscribir.setVisible(false);
	    		}
	    	}
	    });
	    comboBox.setMaximumRowCount(1000);
	    
	    getContentPane().add(comboBox);
	    

	    
	    lblSeleccionarSalida.setBounds(179, 82, 44, 15);
	    getContentPane().add(lblSeleccionarSalida);
	    lblSeleccionarSalida.setVisible(false);
	    
	    comboBox2 = new JComboBox();
	    comboBox2.setBounds(243, 77, 354, 24);
	    getContentPane().add(comboBox2);
	    
	    lblTurista = new JLabel("Turista");
	    lblTurista.setBounds(173, 121, 50, 15);
	    getContentPane().add(lblTurista);
	    lblTurista.setVisible(false);
	    
	    comboBox3 = new JComboBox();
	    comboBox3.setBounds(243, 116, 354, 24);
	    getContentPane().add(comboBox3);
	    
	    lblCantidadDeTuristas = new JLabel("Cantidad de Turistas");
	    lblCantidadDeTuristas.setBounds(75, 163, 154, 15);
	    getContentPane().add(lblCantidadDeTuristas);
	    lblCantidadDeTuristas.setVisible(false);
	    
	    lblFecha = new JLabel("Fecha");
	    lblFecha.setBounds(179, 201, 44, 15);
	    getContentPane().add(lblFecha);
	    lblFecha.setVisible(false);
	    
	    comboBox3.setVisible(false);
	    
	    comboBox2.setVisible(false);
	    
	    comboBox1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		obtSal((String) comboBox1.getSelectedItem());
	    		obtTur();
	    		comboBox2.setVisible(true);
	    		lblSeleccionarSalida.setVisible(true);
	    		comboBox3.setVisible(true);
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
        
        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		limpiar();
        		setVisible(false);
        	}
        });
        btnCerrar.setBounds(351, 331, 117, 25);
        getContentPane().add(btnCerrar);
        textField.setVisible(false);
        btnInscribir.setVisible(false);
        
        comboBox2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (!btnInscribir.isVisible()&&lblCantidadDeTuristas.isVisible()) {
	    			btnInscribir.setVisible(true);
	    		}
	    		if (seleccions==true) {
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
        
        comboBox3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if (selecciont==true) {
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
	
	protected void limpiar() {
		// TODO Auto-generated method stub
		this.lblCantidadDeTuristas.setVisible(false);
		this.lblFecha.setVisible(false);
		this.lblSeleccionarActividad.setVisible(false);
		this.lblSeleccionarSalida.setVisible(false);
		this.lblTurista.setVisible(false);
		this.comboBox1.setVisible(false);
		this.comboBox2.setVisible(false);
		this.comboBox3.setVisible(false);
		this.btnInscribir.setVisible(false);
		this.calendario.setVisible(false);
		this.textField.setVisible(false);
	}

	public void obtTur() {
		DataUsuario[] array = icon.listarUsuarios();
		int i = 0;
		Set<String> aux = new HashSet<String>();
 		while (i<array.length) {
			if (array[i] instanceof DataTurista) {
				DataTurista dt = (DataTurista) array[i];
				aux.add(dt.getNick());
			}
			i++;
		}
		String[] model = new String[aux.size()];
		i=0;
		for (String iter:aux) {
			model[i] = iter;
			i++;
		}
		comboBox3.setModel(new DefaultComboBoxModel(model));
	}

	public void actualizarDptos() {
		/*tabla de deptos*/
	    deps = icon.listarDepartamentos();
	    String[] aux = new String[deps.size()];
	    int cont = 0;
	    for (DataDepartamento iter:deps) {
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
	    for (DataActividad iter:auxi) {
	    	aux[cont] = iter.getNombre();
	    	cont++;
	    }
	    comboBox1.setModel(new DefaultComboBoxModel(aux));
	}
	
	public void obtSal(String act) {
		Set<DataSalida> auxi;
		try {
			auxi = icon.salidas(act);
			String[] aux = new String[auxi.size()];
		    int cont = 0;
		    for (DataSalida iter:auxi) {
		    	aux[cont] = iter.getNombre();
		    	cont++;
		    }
			comboBox2.setModel(new DefaultComboBoxModel(aux));
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void inscri() {
		try {
            Integer.parseInt(textField.getText());
            if (Integer.parseInt(textField.getText()) <= 0) {
            	throw new NumeroNegativoException();
            }
            fechaInsc = calendario.getDate();
            icon.inscribir((String) comboBox3.getSelectedItem(), (String) comboBox2.getSelectedItem(), Integer.parseInt(textField.getText()) , fechaInsc, (String) comboBox1.getSelectedItem());
            JOptionPane.showMessageDialog(this, "Inscripcion existosa", "Inscribir",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiar();
            this.dispose();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad de turistas debe ser un numero", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
        }
		catch (NumeroNegativoException e) {
            JOptionPane.showMessageDialog(this, "La cantidad de turistas debe ser un numero positivo (>0)", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
        }
		catch (TuristaConSalida e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "El turista ya pertenece a la salida", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
			//e1.printStackTrace();
		} catch (ExcedeTuristas e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "La cantidad de turistas excede los cupos disponibles para la salida", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
			//e1.printStackTrace();
		} catch (InscFechaInconsistente e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "La fecha de inscripcion debe ser igual o posterior a la fecha de alta de la salida", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (ActividadNoExisteException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (InscFechaDespSalida e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "La fecha de inscripcion no debe ser posterior a la fecha de realizacion de la salida", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
			//e.printStackTrace();
		} catch (TuristaNoHaNacido e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, "El turista debe haber nacido al momento de realizar la salida", "Inscribir",
                    JOptionPane.ERROR_MESSAGE);
		} 
	}
}
