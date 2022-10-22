package presentacion;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import excepciones.UsuarioRepetidoException;
import logica.IControladorAlta;

/**
 * JInternalFrame que permite registrar un nuevo usuario al sistema.
 * 
 * @author TProg2017
 *
 */
@SuppressWarnings("serial")
public class CrearUsuario extends JInternalFrame {

    // Controlador de usuarios que se utilizará para las acciones del JFrame
    private IControladorAlta controlAlta;
    
    // Los componentes gráficos se agregan como atributos de la clase
    // para facilitar su acceso desde diferentes métodos de la misma.
    private JTextField textFieldNick;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldMail;
    private JCalendar calendario;
    private JTextField textFieldNacimiento;
    private JTextField textFieldNacionalidad;
    private JTextField textFieldDescripcion;
    private JTextField textFieldLink;
    private JLabel lblIngreseNick;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseMail;
    private JLabel lblIngreseNacimiento;
    private JLabel lblIngreseNacionalidad;
    private JLabel lblIngreseDescripcion;
    private JLabel lblIngreseLink;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JRadioButton rdbtnTurista;
    private JRadioButton rdbtnProveedor;
    private JLabel lblContrasea;
    private JLabel lblConfirmarContrasea;
    private JTextField textField;
    private JTextField textField1;

    /**
     * Create the frame.
     */
    public CrearUsuario(IControladorAlta ica) {
        // Se inicializa con el controlador de usuarios
        controlAlta = ica;

        // Propiedades del JInternalFrame como dimensión, posición dentro del frame,
        // etc.
        setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Dar de Alta un Usuario");
        setBounds(10, 40, 844, 462);

        // En este caso utilizaremos el GridBagLayout que permite armar una grilla
        // en donde las filas y columnas no son uniformes.
        // Conviene trabajar este componente desde la vista de diseño gráfico y sólo
        // manipular los valores para ajustar alguna cosa.
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 100, 120, 120, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 30, 30, 30, 0, 0, 0, 0, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);
                                                                
                                                                     // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
                                                                        // el nickname del usuario. El texto está alineado horizontalmente a la derecha para
                                                                        // que quede casi pegado al campo de texto.
                                                                        lblIngreseNick = new JLabel("Nickname:");
                                                                        lblIngreseNick.setHorizontalAlignment(SwingConstants.RIGHT);
                                                                        GridBagConstraints gbc_lblIngreseNick = new GridBagConstraints();
                                                                        gbc_lblIngreseNick.fill = GridBagConstraints.BOTH;
                                                                        gbc_lblIngreseNick.insets = new Insets(0, 0, 5, 5);
                                                                        gbc_lblIngreseNick.gridx = 1;
                                                                        gbc_lblIngreseNick.gridy = 1;
                                                                        getContentPane().add(lblIngreseNick, gbc_lblIngreseNick);
                                                                
                                                                // Una campo de texto (JTextField) para ingresar el nickname del usuario. 
                                                                // Por defecto es posible ingresar cualquier string.
                                                                textFieldNick = new JTextField();
                                                                GridBagConstraints gbc_textFieldNick = new GridBagConstraints();
                                                                gbc_textFieldNick.gridwidth = 2;
                                                                gbc_textFieldNick.fill = GridBagConstraints.BOTH;
                                                                gbc_textFieldNick.insets = new Insets(0, 0, 5, 5);
                                                                gbc_textFieldNick.gridx = 2;
                                                                gbc_textFieldNick.gridy = 1;
                                                                getContentPane().add(textFieldNick, gbc_textFieldNick);
                                                                textFieldNick.setColumns(10);
                                                                
                                                                
                                                                // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
                                                                // el nombre del usuario. El texto está alineado horizontalmente a la derecha para
                                                                // que quede casi pegado al campo de texto.
                                                                lblIngreseNombre = new JLabel("Nombre:");
                                                                lblIngreseNombre.setHorizontalAlignment(SwingConstants.RIGHT);
                                                                GridBagConstraints gbc_lblIngreseNombre = new GridBagConstraints();
                                                                gbc_lblIngreseNombre.fill = GridBagConstraints.BOTH;
                                                                gbc_lblIngreseNombre.insets = new Insets(0, 0, 5, 5);
                                                                gbc_lblIngreseNombre.gridx = 1;
                                                                gbc_lblIngreseNombre.gridy = 2;
                                                                getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);
                                                                        
                                                                        // Una campo de texto (JTextField) para ingresar el nombre del usuario. 
                                                                        // Por defecto es posible ingresar cualquier string.
                                                                        textFieldNombre = new JTextField();
                                                                        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
                                                                        gbc_textFieldNombre.gridwidth = 2;
                                                                        gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
                                                                        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 5);
                                                                        gbc_textFieldNombre.gridx = 2;
                                                                        gbc_textFieldNombre.gridy = 2;
                                                                        getContentPane().add(textFieldNombre, gbc_textFieldNombre);
                                                                        textFieldNombre.setColumns(10);
                                                                        
                                                                
                                                                        // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
                                                                        // el apellido del usuario. El texto está alineado horizontalmente a la derecha para
                                                                        // que quede casi pegado al campo de texto.
                                                                        lblIngreseApellido = new JLabel("Apellido:");
                                                                        lblIngreseApellido.setHorizontalAlignment(SwingConstants.RIGHT);
                                                                        GridBagConstraints gbc_lblIngreseApellido = new GridBagConstraints();
                                                                        gbc_lblIngreseApellido.fill = GridBagConstraints.BOTH;
                                                                        gbc_lblIngreseApellido.insets = new Insets(0, 0, 5, 5);
                                                                        gbc_lblIngreseApellido.gridx = 1;
                                                                        gbc_lblIngreseApellido.gridy = 3;
                                                                        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);
                                                                        
                                                                                // Una campo de texto (JTextField) para ingresar el apellido del usuario. 
                                                                                // Por defecto es posible ingresar cualquier string.
                                                                                textFieldApellido = new JTextField();
                                                                                GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
                                                                                gbc_textFieldApellido.gridwidth = 2;
                                                                                gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
                                                                                gbc_textFieldApellido.insets = new Insets(0, 0, 5, 5);
                                                                                gbc_textFieldApellido.gridx = 2;
                                                                                gbc_textFieldApellido.gridy = 3;
                                                                                getContentPane().add(textFieldApellido, gbc_textFieldApellido);
                                                                                textFieldApellido.setColumns(10);
                                                                        
                                                                        lblContrasea = new JLabel("Contraseña");
                                                                        GridBagConstraints gbc_lblContrasea = new GridBagConstraints();
                                                                        gbc_lblContrasea.anchor = GridBagConstraints.EAST;
                                                                        gbc_lblContrasea.insets = new Insets(0, 0, 5, 5);
                                                                        gbc_lblContrasea.gridx = 5;
                                                                        gbc_lblContrasea.gridy = 3;
                                                                        getContentPane().add(lblContrasea, gbc_lblContrasea);
                                                                        
                                                                        textField = new JTextField();
                                                                        GridBagConstraints gbc_textField = new GridBagConstraints();
                                                                        gbc_textField.gridwidth = 3;
                                                                        gbc_textField.fill = GridBagConstraints.HORIZONTAL;
                                                                        gbc_textField.insets = new Insets(0, 0, 5, 5);
                                                                        gbc_textField.gridx = 6;
                                                                        gbc_textField.gridy = 3;
                                                                        getContentPane().add(textField, gbc_textField);
                                                                        textField.setColumns(10);
                                                                
                                                                        // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
                                                                        // el mail del usuario. El texto está alineado horizontalmente a la derecha para
                                                                        // que quede casi pegado al campo de texto.
                                                                        lblIngreseMail = new JLabel("Mail:");
                                                                        lblIngreseMail.setHorizontalAlignment(SwingConstants.RIGHT);
                                                                        GridBagConstraints gbc_lblIngreseMail = new GridBagConstraints();
                                                                        gbc_lblIngreseMail.fill = GridBagConstraints.BOTH;
                                                                        gbc_lblIngreseMail.insets = new Insets(0, 0, 5, 5);
                                                                        gbc_lblIngreseMail.gridx = 1;
                                                                        gbc_lblIngreseMail.gridy = 4;
                                                                        getContentPane().add(lblIngreseMail, gbc_lblIngreseMail);
                                                                
                                                                // Una campo de texto (JTextField) para ingresar el Mail del usuario. 
                                                                // Por defecto es posible ingresar cualquier string.
                                                                textFieldMail = new JTextField();
                                                                GridBagConstraints gbc_textFieldMail = new GridBagConstraints();
                                                                gbc_textFieldMail.gridwidth = 2;
                                                                gbc_textFieldMail.fill = GridBagConstraints.BOTH;
                                                                gbc_textFieldMail.insets = new Insets(0, 0, 5, 5);
                                                                gbc_textFieldMail.gridx = 2;
                                                                gbc_textFieldMail.gridy = 4;
                                                                getContentPane().add(textFieldMail, gbc_textFieldMail);
                                                                textFieldMail.setColumns(10);
                                                
                                                lblConfirmarContrasea = new JLabel("Confirmar Contraseña");
                                                GridBagConstraints gbc_lblConfirmarContrasea = new GridBagConstraints();
                                                gbc_lblConfirmarContrasea.anchor = GridBagConstraints.EAST;
                                                gbc_lblConfirmarContrasea.insets = new Insets(0, 0, 5, 5);
                                                gbc_lblConfirmarContrasea.gridx = 5;
                                                gbc_lblConfirmarContrasea.gridy = 4;
                                                getContentPane().add(lblConfirmarContrasea, gbc_lblConfirmarContrasea);
                                                
                                                textField1 = new JTextField();
                                                GridBagConstraints gbc_textField_1 = new GridBagConstraints();
                                                gbc_textField_1.gridwidth = 3;
                                                gbc_textField_1.insets = new Insets(0, 0, 5, 5);
                                                gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
                                                gbc_textField_1.gridx = 6;
                                                gbc_textField_1.gridy = 4;
                                                getContentPane().add(textField1, gbc_textField_1);
                                                textField1.setColumns(10);
                                                
                                                // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
                                                // el Nacimiento del usuario. El texto está alineado horizontalmente a la derecha para
                                                // que quede casi pegado al campo de texto.
                                                lblIngreseNacimiento = new JLabel("Nacimiento:");
                                                lblIngreseNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
                                                GridBagConstraints gbc_lblIngreseNacimiento = new GridBagConstraints();
                                                gbc_lblIngreseNacimiento.fill = GridBagConstraints.BOTH;
                                                gbc_lblIngreseNacimiento.insets = new Insets(0, 0, 5, 5);
                                                gbc_lblIngreseNacimiento.gridx = 1;
                                                gbc_lblIngreseNacimiento.gridy = 5;
                                                getContentPane().add(lblIngreseNacimiento, gbc_lblIngreseNacimiento);
				                                // Un calendario para seleccionar una fecha (JCalendar) para ingresar el Nacimiento del usuario. 
                                                // Por defecto es posible ingresar cualquier fecha.   
				                                calendario = new JCalendar();				                                
				                                GridBagConstraints gbc_textFieldNacimiento = new GridBagConstraints();
                                                gbc_textFieldNacimiento.gridwidth = 2;
                                                gbc_textFieldNacimiento.fill = GridBagConstraints.BOTH;
                                                gbc_textFieldNacimiento.insets = new Insets(0, 0, 5, 5);
                                                gbc_textFieldNacimiento.gridx = 2;
                                                gbc_textFieldNacimiento.gridy = 5;
                                                getContentPane().add(calendario, gbc_textFieldNacimiento);
				                                                
				                                                // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
				                                                // la Nacionalidad del usuario. El texto está alineado horizontalmente a la derecha para
				                                                // que quede casi pegado al campo de texto.
				                                                lblIngreseNacionalidad = new JLabel("Nacionalidad:");
				                                                lblIngreseNacionalidad.setHorizontalAlignment(SwingConstants.RIGHT);
				                                                GridBagConstraints gbc_lblIngreseNacionalidad = new GridBagConstraints();
				                                                gbc_lblIngreseNacionalidad.fill = GridBagConstraints.BOTH;
				                                                gbc_lblIngreseNacionalidad.insets = new Insets(0, 0, 5, 5);
				                                                gbc_lblIngreseNacionalidad.gridx = 1;
				                                                gbc_lblIngreseNacionalidad.gridy = 6;
				                                                getContentPane().add(lblIngreseNacionalidad, gbc_lblIngreseNacionalidad);
				                                                
				                                                
				                                                // Una campo de texto (JTextField) para ingresar el Nacionalidad del usuario. 
				                                                // Por defecto es posible ingresar cualquier string.
				                                                textFieldNacionalidad = new JTextField();
				                                                GridBagConstraints gbc_textFieldNacionalidad = new GridBagConstraints();
				                                                gbc_textFieldNacionalidad.gridwidth = 2;
				                                                gbc_textFieldNacionalidad.fill = GridBagConstraints.BOTH;
				                                                gbc_textFieldNacionalidad.insets = new Insets(0, 0, 5, 5);
				                                                gbc_textFieldNacionalidad.gridx = 2;
				                                                gbc_textFieldNacionalidad.gridy = 6;
				                                                getContentPane().add(textFieldNacionalidad, gbc_textFieldNacionalidad);
				                                                
				                                                     // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
				                                                // el Descripcion del usuario. El texto está alineado horizontalmente a la derecha para
				                                                // que quede casi pegado al campo de texto.
				                                                lblIngreseDescripcion = new JLabel("Descripcion:");
				                                                lblIngreseDescripcion.setHorizontalAlignment(SwingConstants.RIGHT);
				                                                GridBagConstraints gbc_lblIngreseDescripcion = new GridBagConstraints();
				                                                gbc_lblIngreseDescripcion.fill = GridBagConstraints.BOTH;
				                                                gbc_lblIngreseDescripcion.insets = new Insets(0, 0, 5, 5);
				                                                gbc_lblIngreseDescripcion.gridx = 1;
				                                                gbc_lblIngreseDescripcion.gridy = 7;
				                                                getContentPane().add(lblIngreseDescripcion, gbc_lblIngreseDescripcion);
				                                                
				                                                // Una campo de texto (JTextField) para ingresar el Descripcion del usuario. 
				                                                // Por defecto es posible ingresar cualquier string.
				                                                textFieldDescripcion = new JTextField();
				                                                GridBagConstraints gbc_textFieldDescripcion = new GridBagConstraints();
				                                                gbc_textFieldDescripcion.gridwidth = 2;
				                                                gbc_textFieldDescripcion.fill = GridBagConstraints.BOTH;
				                                                gbc_textFieldDescripcion.insets = new Insets(0, 0, 5, 5);
				                                                gbc_textFieldDescripcion.gridx = 2;
				                                                gbc_textFieldDescripcion.gridy = 7;
				                                                getContentPane().add(textFieldDescripcion, gbc_textFieldDescripcion);
				                                                textFieldDescripcion.setColumns(10);

                                                                
                                                                
                                                // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
                                                // el Link del usuario. El texto está alineado horizontalmente a la derecha para
                                                // que quede casi pegado al campo de texto.
                                                lblIngreseLink = new JLabel("Link:");
                                                lblIngreseLink.setHorizontalAlignment(SwingConstants.RIGHT);
                                                GridBagConstraints gbc_lblIngreseLink = new GridBagConstraints();
                                                gbc_lblIngreseLink.fill = GridBagConstraints.BOTH;
                                                gbc_lblIngreseLink.insets = new Insets(0, 0, 5, 5);
                                                gbc_lblIngreseLink.gridx = 1;
                                                gbc_lblIngreseLink.gridy = 8;
                                                getContentPane().add(lblIngreseLink, gbc_lblIngreseLink);
                                                
                                                // Una campo de texto (JTextField) para ingresar el Link del usuario. 
                                                // Por defecto es posible ingresar cualquier string.
                                                textFieldLink = new JTextField();
                                                GridBagConstraints gbc_textFieldLink = new GridBagConstraints();
                                                gbc_textFieldLink.gridwidth = 2;
                                                gbc_textFieldLink.fill = GridBagConstraints.BOTH;
                                                gbc_textFieldLink.insets = new Insets(0, 0, 5, 5);
                                                gbc_textFieldLink.gridx = 2;
                                                gbc_textFieldLink.gridy = 8;
                                                getContentPane().add(textFieldLink, gbc_textFieldLink);
                                                textFieldLink.setColumns(10);
                                                
				                                                // Un botón (JButton) con un evento asociado que permite registrar el usuario.
				                                                // Dado que el código de registro tiene cierta complejidad, conviene delegarlo
				                                                // a otro método en lugar de incluirlo directamente de el método actionPerformed 
				                                                btnAceptar = new JButton("Aceptar");
				                                                btnAceptar.addActionListener(new ActionListener() {
				                                                    public void actionPerformed(ActionEvent arg0) {
				                                                        cmdRegistroUsuarioActionPerformed(arg0);
				                                                    }
				                                                });
				                                                
				                                                GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
				                                                gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
				                                                gbc_btnAceptar.fill = GridBagConstraints.BOTH;
				                                                gbc_btnAceptar.gridx = 5;
				                                                gbc_btnAceptar.gridy = 8;
				                                                getContentPane().add(btnAceptar, gbc_btnAceptar);
				                                                
                                                                // Un botón (JButton) con un evento asociado que permite cerrar el formulario (solo ocultarlo).
                                                                // Dado que antes de cerrar se limpia el formulario, se invoca un método reutilizable para ello. 
                                                                btnCancelar = new JButton("Cancelar");
                                                                btnCancelar.addActionListener(new ActionListener() {
                                                                    public void actionPerformed(ActionEvent e) {
                                                                        limpiarFormulario();
                                                                        setVisible(false);
                                                                    }
                                                                });
                                                                GridBagConstraints gbc_btnCancelar = new GridBagConstraints();
                                                                gbc_btnCancelar.insets = new Insets(0, 0, 5, 5);
                                                                gbc_btnCancelar.fill = GridBagConstraints.BOTH;
                                                                gbc_btnCancelar.gridx = 6;
                                                                gbc_btnCancelar.gridy = 8;
                                                                getContentPane().add(btnCancelar, gbc_btnCancelar);
                                                                
                                                                rdbtnTurista = new JRadioButton("Turista");
                                                                rdbtnTurista.addActionListener(new ActionListener() {
                                                                    public void actionPerformed(ActionEvent t) {
                                                                        setTurista();
                                                                    }
                                                                });
                                                                GridBagConstraints gbc_rdbtnTurista = new GridBagConstraints();
                                                                gbc_rdbtnTurista.insets = new Insets(0, 0, 5, 5);
                                                                gbc_rdbtnTurista.gridx = 5;
                                                                gbc_rdbtnTurista.gridy = 1;
                                                                getContentPane().add(rdbtnTurista, gbc_rdbtnTurista);
                                                                rdbtnTurista.setSelected(true);
                                                                textFieldDescripcion.setEditable(false);
                                                                textFieldLink.setEditable(false);
                                                                
                                                                rdbtnProveedor = new JRadioButton("Proveedor");
                                                                rdbtnProveedor.addActionListener(new ActionListener() {
                                                                    public void actionPerformed(ActionEvent p) {
                                                                        setProveedor();
                                                                    }
                                                                });
                                                                GridBagConstraints gbc_rdbtnProveedor = new GridBagConstraints();
                                                                gbc_rdbtnProveedor.insets = new Insets(0, 0, 5, 5);
                                                                gbc_rdbtnProveedor.gridx = 5;
                                                                gbc_rdbtnProveedor.gridy = 2;
                                                                getContentPane().add(rdbtnProveedor, gbc_rdbtnProveedor);
    }

    // Este método es invocado al querer registrar un usuario, funcionalidad
    // provista por la operación del sistem registrarUsuario().
    // Previamente se hace una verificación de los campos, particularmente que no sean vacíos
    // y que la cédula sea un número. 
    // Tanto en caso de que haya un error (de verificación o de registro) o no, se despliega
    // un mensaje utilizando un panel de mensaje (JOptionPane).
    protected void cmdRegistroUsuarioActionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

        // Obtengo datos de los controles Swing
    	String nickU = this.textFieldNick.getText();
        String nombreU = this.textFieldNombre.getText();
        String apellidoU = this.textFieldApellido.getText();
        String mailU = this.textFieldMail.getText();
        Date nacimientoU = calendario.getDate();
        if (checkFormulario()) {
            try {
            	if (rdbtnTurista.isSelected()) {
            		String nacionalidadU = this.textFieldNacionalidad.getText();
            		controlAlta.confirmarAltaTurista(nickU, nombreU, apellidoU, mailU, nacimientoU, nacionalidadU, textField.getText());
            	} else {
            		String descripcionU = this.textFieldDescripcion.getText();
            		String linkU = this.textFieldLink.getText();
            		controlAlta.confirmarAltaProveedor(nickU, nombreU, apellidoU, mailU, nacimientoU, descripcionU, linkU, linkU.isEmpty(), textField.getText());
            	}
                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "El Usuario se ha creado con éxito", "Registrar Usuario",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (UsuarioRepetidoException e) {
                // Muestro error de registro
                JOptionPane.showMessageDialog(this, e.getMessage(), "Registrar Usuario", JOptionPane.ERROR_MESSAGE);
            }

            // Limpio el internal frame antes de cerrar la ventana
            limpiarFormulario();
            setVisible(false);
        }
    }

    // Permite validar la información introducida en los campos e indicar
    // a través de un mensaje de error (JOptionPane) cuando algo sucede.
    // Este tipo de chequeos se puede realizar de otras formas y con otras librerías de Java, 
    // por ejemplo impidiendo que se escriban caracteres no numéricos al momento de escribir en
    // en el campo de la cédula, o mostrando un mensaje de error apenas el foco pasa a otro campo.
    private boolean checkFormulario() {
        String nickU = this.textFieldNick.getText();
        String nombreU = this.textFieldNombre.getText();
        String apellidoU = this.textFieldApellido.getText();
        String mailU = this.textFieldMail.getText();
        String nacionalidadU = this.textFieldNacionalidad.getText();
        String descripcionU = this.textFieldDescripcion.getText();

        if (rdbtnTurista.isSelected() && (nombreU.isEmpty() || apellidoU.isEmpty() || nickU.isEmpty() || mailU.isEmpty()|| nacionalidadU.isEmpty())) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (rdbtnProveedor.isSelected() && (nombreU.isEmpty() || apellidoU.isEmpty() || nickU.isEmpty() || mailU.isEmpty() || descripcionU.isEmpty())) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        if (!textField.getText().equals(textField1.getText())) {
        	JOptionPane.showMessageDialog(this, "Confirmacion de contraseña incorrecta", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }
    
    private void setTurista() {
    	rdbtnProveedor.setSelected(false);
    	textFieldDescripcion.setEditable(false);
    	textFieldDescripcion.setText("");
    	textFieldLink.setEditable(false);
    	textFieldLink.setText("");
    	textFieldNacionalidad.setEditable(true);
    }
    
    private void setProveedor() {
    	rdbtnTurista.setSelected(false);
    	textFieldNacionalidad.setEditable(false);
    	textFieldNacionalidad.setText("");
    	textFieldDescripcion.setEditable(true);
    	textFieldLink.setEditable(true);
    	}

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
    	textFieldNick.setText("");
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldMail.setText("");
        textFieldNacionalidad.setText("");
        textFieldDescripcion.setText("");
    	textFieldLink.setText("");
    }
}
