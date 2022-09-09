package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import excepciones.ActividadRepetidaException;
import excepciones.CategoriaYaExiste;
import excepciones.ProveedorNoNacidoException;
import excepciones.UsuarioNoExisteException;
import logica.ControladorAlta;
import logica.IControladorAlta;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AltaCategoria extends JInternalFrame {
	private JTextField campoCategoria;
	private JButton botoncancelar ; 
	private JButton botonaceptar ; 
	private JLabel NombreCategoria ; 
    private IControladorAlta controlAlta;



	public AltaCategoria() {
		controlAlta = new ControladorAlta() ; 
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //setIconifiable(true);
        //setClosable(true);
       // setMaximizable(true);
		getContentPane().setLayout(null);
		//setTitle("Alta Categoria");
        setBounds(10, 40, 541, 537);


		NombreCategoria = new JLabel("NombreCategoria");
		NombreCategoria.setBounds(71, 117, 86, 16);
		getContentPane().add(NombreCategoria);
		
		campoCategoria = new JTextField();
		campoCategoria.setBounds(215, 116, 96, 19);
		getContentPane().add(campoCategoria);
		campoCategoria.setColumns(10);
		
		botoncancelar = new JButton("cancelar");
		botoncancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		botoncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botoncancelar.setBounds(71, 218, 85, 21);
		getContentPane().add(botoncancelar);
		
		botonaceptar = new JButton("aceptar");
		botonaceptar.setBounds(290, 218, 85, 21);
		getContentPane().add(botonaceptar);
		botonaceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	cmdRegistroCategoriaActionPerformed(arg0);
            }
        });

	}
	
	
	
	protected void cmdRegistroCategoriaActionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        // Obtengo datos de los controles Swing
		
		 String nomCat = this.campoCategoria.getText();	        
  

        if (checkFormulario()) {
            try {
                controlAlta.registrarCategoria(nomCat) ; 
                JOptionPane.showMessageDialog(this, "La categoria ha sido registrada exitosamente.", "Registrar Categoria",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (CategoriaYaExiste e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Categoria", JOptionPane.ERROR_MESSAGE);
            }
            //limpiarFormulario();
            setVisible(false);
        }
    }

	
	
	
	 private boolean checkFormulario() {
		 String nomCat = this.campoCategoria.getText();	        
		 if (nomCat.isEmpty()) { 
			 JOptionPane.showMessageDialog(this, "campo vacio", "Registrar Categoria",
			 JOptionPane.ERROR_MESSAGE);
			 return false;
		 }
		 else return true;
	 }

}
