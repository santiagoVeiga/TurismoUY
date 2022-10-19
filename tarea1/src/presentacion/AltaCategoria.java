package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import excepciones.CategoriaYaExiste;
import logica.ControladorAlta;
import logica.IControladorAlta;

@SuppressWarnings("serial")
public class AltaCategoria extends JInternalFrame {
	private JTextField campoCategoria;
	private JButton botoncancelar ; 
	private JButton botonaceptar ; 
    private IControladorAlta controlAlta;



	public AltaCategoria() {
		controlAlta = new ControladorAlta() ; 
        //setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        //setIconifiable(true);
        //setClosable(true);
       // setMaximizable(true);
		getContentPane().setLayout(null);
		//setTitle("Alta Categoria");
        setBounds(10, 40, 477, 356);
		
		campoCategoria = new JTextField();
		campoCategoria.setBounds(225, 116, 150, 19);
		getContentPane().add(campoCategoria);
		campoCategoria.setColumns(10);
		
		botoncancelar = new JButton("cancelar");
		botoncancelar.setVerticalAlignment(SwingConstants.BOTTOM);
		botoncancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	            setVisible(false);
	            limpiarFormulario();
				
				
				
			}
		});
		botoncancelar.setBounds(78, 218, 101, 21);
		getContentPane().add(botoncancelar);
		
		botonaceptar = new JButton("aceptar");
		botonaceptar.setBounds(262, 216, 113, 21);
		getContentPane().add(botonaceptar);
		
		JLabel lblNombr = new JLabel("Nombre de Categoria");
		lblNombr.setBounds(34, 118, 173, 15);
		getContentPane().add(lblNombr);
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
            limpiarFormulario();
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
	 
	 
	 private void limpiarFormulario() {
		 campoCategoria.setText("");
	 }
}
