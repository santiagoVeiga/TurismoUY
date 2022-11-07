package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JCalendar;

import excepciones.NumeroNegativoException;
import excepciones.PaqueteRepetidoException;
import logica.IControladorAlta;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class CrearPaquete extends JInternalFrame {
	
    private IControladorAlta controlAlta;
	private JTextField nombreTextField;
	private JTextField descripcionTextField;
	private JTextField validezTextField;
	private JTextField descuentoTextField;
    private JCalendar calendario;
    private File fileImgPaq = null;

	public CrearPaquete(IControladorAlta ica) {
		
        controlAlta = ica;
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Crear Paquete");
        setBounds(10, 40, 541, 413);
        
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {30, 30, 30, 30, 30, 30, 30};
		gridBagLayout.rowHeights = new int[] {30, 30, 30, 30, 30, 0, 20};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel Nombre = new JLabel("Nombre: ");
		GridBagConstraints gbc_Nombre = new GridBagConstraints();
		gbc_Nombre.anchor = GridBagConstraints.EAST;
		gbc_Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_Nombre.gridx = 1;
		gbc_Nombre.gridy = 1;
		getContentPane().add(Nombre, gbc_Nombre);
		
		nombreTextField = new JTextField();
		GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
		gbc_nombreTextField.insets = new Insets(0, 0, 5, 5);
		gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nombreTextField.gridx = 2;
		gbc_nombreTextField.gridy = 1;
		getContentPane().add(nombreTextField, gbc_nombreTextField);
		nombreTextField.setColumns(10);
		
		JLabel descripcion = new JLabel("Descripcion: ");
		descripcion.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_descripcion = new GridBagConstraints();
		gbc_descripcion.anchor = GridBagConstraints.EAST;
		gbc_descripcion.insets = new Insets(0, 0, 5, 5);
		gbc_descripcion.gridx = 1;
		gbc_descripcion.gridy = 2;
		getContentPane().add(descripcion, gbc_descripcion);
		
		descripcionTextField = new JTextField();
		GridBagConstraints gbc_descripcionTextField = new GridBagConstraints();
		gbc_descripcionTextField.insets = new Insets(0, 0, 5, 5);
		gbc_descripcionTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descripcionTextField.gridx = 2;
		gbc_descripcionTextField.gridy = 2;
		getContentPane().add(descripcionTextField, gbc_descripcionTextField);
		descripcionTextField.setColumns(10);
		
		JLabel validez = new JLabel("Validez: ");
		GridBagConstraints gbc_validez = new GridBagConstraints();
		gbc_validez.anchor = GridBagConstraints.EAST;
		gbc_validez.insets = new Insets(0, 0, 5, 5);
		gbc_validez.gridx = 1;
		gbc_validez.gridy = 3;
		getContentPane().add(validez, gbc_validez);
		
		validezTextField = new JTextField();
		GridBagConstraints gbc_validezTextField = new GridBagConstraints();
		gbc_validezTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_validezTextField.insets = new Insets(0, 0, 5, 5);
		gbc_validezTextField.gridx = 2;
		gbc_validezTextField.gridy = 3;
		getContentPane().add(validezTextField, gbc_validezTextField);
		validezTextField.setColumns(10);
		
		JLabel descuento = new JLabel("Descuento: ");
		GridBagConstraints gbc_descuento = new GridBagConstraints();
		gbc_descuento.anchor = GridBagConstraints.EAST;
		gbc_descuento.insets = new Insets(0, 0, 5, 5);
		gbc_descuento.gridx = 1;
		gbc_descuento.gridy = 4;
		getContentPane().add(descuento, gbc_descuento);
		
		descuentoTextField = new JTextField();
		GridBagConstraints gbc_descuentoTextField = new GridBagConstraints();
		gbc_descuentoTextField.insets = new Insets(0, 0, 5, 5);
		gbc_descuentoTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_descuentoTextField.gridx = 2;
		gbc_descuentoTextField.gridy = 4;
		getContentPane().add(descuentoTextField, gbc_descuentoTextField);
		descuentoTextField.setColumns(10);
		
		JLabel fechaAlta = new JLabel("Fecha Alta: ");
		GridBagConstraints gbc_fechaAlta = new GridBagConstraints();
		gbc_fechaAlta.anchor = GridBagConstraints.EAST;
		gbc_fechaAlta.insets = new Insets(0, 0, 5, 5);
		gbc_fechaAlta.gridx = 1;
		gbc_fechaAlta.gridy = 5;
		getContentPane().add(fechaAlta, gbc_fechaAlta);
		
		calendario = new JCalendar();
		GridBagConstraints gbc_calendario_1 = new GridBagConstraints();
		gbc_calendario_1.insets = new Insets(0, 0, 5, 5);
		gbc_calendario_1.fill = GridBagConstraints.BOTH;
		gbc_calendario_1.gridx = 2;
		gbc_calendario_1.gridy = 5;
		getContentPane().add(calendario, gbc_calendario_1);
		
		JLabel lblImagen = DefaultComponentFactory.getInstance().createLabel("Imagen");
		GridBagConstraints gbc_lblImagen = new GridBagConstraints();
		gbc_lblImagen.insets = new Insets(0, 0, 5, 5);
		gbc_lblImagen.gridx = 1;
		gbc_lblImagen.gridy = 6;
		getContentPane().add(lblImagen, gbc_lblImagen);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
			    FileNameExtensionFilter filter = new FileNameExtensionFilter(
			        "JPG Images", "jpg");
			    chooser.setFileFilter(filter);
			    int returnVal = chooser.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       btnAadir.setText("Añadida");
			       fileImgPaq = chooser.getSelectedFile();
			    }
			}
		});
		GridBagConstraints gbc_btnAadir = new GridBagConstraints();
		gbc_btnAadir.insets = new Insets(0, 0, 5, 5);
		gbc_btnAadir.gridx = 2;
		gbc_btnAadir.gridy = 6;
		getContentPane().add(btnAadir, gbc_btnAadir);
		
		JSplitPane splitPane = new JSplitPane();
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.insets = new Insets(0, 0, 0, 5);
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 2;
		gbc_splitPane.gridy = 7;
		getContentPane().add(splitPane, gbc_splitPane);
		
		JButton cancelarBtn = new JButton("Cancelar");
		splitPane.setLeftComponent(cancelarBtn);
		
		JButton aceptarBtn = new JButton("Aceptar");
		splitPane.setRightComponent(aceptarBtn);
		aceptarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	cmdCrearPaqueteActionPerformed(arg0);
            }
        });
		cancelarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent eve) {
                limpiarFormulario();
                setVisible(false);
            }
        });
	}
	
	protected void cmdCrearPaqueteActionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        // Obtengo datos de los controles Swing
		
        String nombrePaq = this.nombreTextField.getText();
        String descripcionPaq = this.descripcionTextField.getText();
        String validezPaq = this.validezTextField.getText(); 
        String descuentoPaq = this.descuentoTextField.getText();
        Date fechaPaq = calendario.getDate();

        if (checkFormulario()) {
            try {
            	byte[] imgBytes = null;
            	if (fileImgPaq != null) {
            		imgBytes = Files.readAllBytes(fileImgPaq.toPath());
            	}else {
            		 try {
	       	    	      BufferedImage img;
	       	    	      img = ImageIO.read(new File("./src/data/default_imagen.jpg"));
	       	    	      ByteArrayOutputStream baos = new ByteArrayOutputStream();
	       	    	      ImageIO.write(img, "jpg", baos);
	       	    	      imgBytes = baos.toByteArray();
	       	  		} catch (IOException e) {
	       	  			// TODO Auto-generated catch block
	       	  			e.printStackTrace();
	       	  		}  
            	}
        		FileOutputStream output = null;
                InputStream inputStream = null;
        		try {
            	    File nuevaImg = new File("./src/data/Paqs/" + nombrePaq + ".jpg");
        	    	nuevaImg.createNewFile();
                    output = new FileOutputStream(nuevaImg);
                    inputStream = new ByteArrayInputStream(imgBytes); 
                    int leido = 0;
                    leido = inputStream.read();
                    while (leido != -1) {
                        output.write(leido);
                        leido = inputStream.read();
                    }
                } catch (IOException ioe) {
                  ioe.printStackTrace();
                } finally {
                  try {
                      output.flush();
                      output.close();
                      inputStream.close();
                  } catch (IOException ex) {
                      ex.printStackTrace();
                  }
                }
                controlAlta.altaPaquete(nombrePaq, descripcionPaq, Integer.parseInt(descuentoPaq), Integer.parseInt(validezPaq), fechaPaq);
                JOptionPane.showMessageDialog(this, "El paquete ha sido registrado exitosamente.", "Registrar Paquete",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (PaqueteRepetidoException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Paquete", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            limpiarFormulario();
            setVisible(false);
        }
    }

    private boolean checkFormulario() {
    	String nombrePaq = this.nombreTextField.getText();
        String descripcionPaq = this.descripcionTextField.getText();
        String validezPaq = this.validezTextField.getText(); 
        String descuentoPaq = this.descuentoTextField.getText();

        if (nombrePaq.isEmpty() || descripcionPaq.isEmpty() || validezPaq.isEmpty() || descuentoPaq.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Registrar Paqividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(validezPaq);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La validez debe ser un numero entero", "Registrar Paqividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
            Integer.parseInt(descuentoPaq);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El descuento debe ser un numero entero", "Registrar Paqividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
	        if (Integer.parseInt(validezPaq)<0) {
	        	throw new NumeroNegativoException();
	        }
        } catch (NumeroNegativoException e) {
        	JOptionPane.showMessageDialog(this, "La validez debe ser un numero entero positivo", "Registrar Paqividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        try {
	        if (Integer.parseInt(descuentoPaq)<0 || Integer.parseInt(descuentoPaq)>100) {
	        	throw new NumeroNegativoException();
	        }
        } catch (NumeroNegativoException e) {
        	JOptionPane.showMessageDialog(this, "El descuento debe ser un numero positivo entre 0 y 100", "Registrar Paqividad",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }    
    
    private void limpiarFormulario() {
        nombreTextField.setText("");
        descripcionTextField.setText("");
        validezTextField.setText("");
        descuentoTextField.setText("");
    }
}
