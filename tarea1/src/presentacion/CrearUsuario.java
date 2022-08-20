package presentacion;

import javax.swing.JInternalFrame;

import excepciones.UsuarioRepetidoException;
import logica.IControladorAlta;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

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
    private JTextField textFieldNacimiento;
    private JLabel lblIngreseNick;
    private JLabel lblIngreseNombre;
    private JLabel lblIngreseApellido;
    private JLabel lblIngreseMail;
    private JLabel lblIngreseNacimiento;
    private JButton btnAceptar;
    private JButton btnCancelar;

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
        setBounds(10, 40, 360, 150);

        // En este caso utilizaremos el GridBagLayout que permite armar una grilla
        // en donde las filas y columnas no son uniformes.
        // Conviene trabajar este componente desde la vista de diseño gráfico y sólo
        // manipular los valores para ajustar alguna cosa.
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 100, 120, 120, 0 };
        gridBagLayout.rowHeights = new int[] { 30, 30, 30, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        getContentPane().setLayout(gridBagLayout);

     // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
        // el nickname del usuario. El texto está alineado horizontalmente a la derecha para
        // que quede casi pegado al campo de texto.
        lblIngreseNick = new JLabel("Nickname:");
        lblIngreseNick.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNick = new GridBagConstraints();
        gbc_lblIngreseNick.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseNick.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNick.gridx = 0;
        gbc_lblIngreseNick.gridy = 0;
        getContentPane().add(lblIngreseNick, gbc_lblIngreseNick);
        
        // Una campo de texto (JTextField) para ingresar el nickname del usuario. 
        // Por defecto es posible ingresar cualquier string.
        textFieldNick = new JTextField();
        GridBagConstraints gbc_textFieldNick = new GridBagConstraints();
        gbc_textFieldNick.gridwidth = 2;
        gbc_textFieldNick.fill = GridBagConstraints.BOTH;
        gbc_textFieldNick.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNick.gridx = 1;
        gbc_textFieldNick.gridy = 0;
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
        gbc_lblIngreseNombre.gridx = 0;
        gbc_lblIngreseNombre.gridy = 0;
        getContentPane().add(lblIngreseNombre, gbc_lblIngreseNombre);
        
        // Una campo de texto (JTextField) para ingresar el nombre del usuario. 
        // Por defecto es posible ingresar cualquier string.
        textFieldNombre = new JTextField();
        GridBagConstraints gbc_textFieldNombre = new GridBagConstraints();
        gbc_textFieldNombre.gridwidth = 2;
        gbc_textFieldNombre.fill = GridBagConstraints.BOTH;
        gbc_textFieldNombre.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNombre.gridx = 1;
        gbc_textFieldNombre.gridy = 0;
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
        gbc_lblIngreseApellido.gridx = 0;
        gbc_lblIngreseApellido.gridy = 1;
        getContentPane().add(lblIngreseApellido, gbc_lblIngreseApellido);

        // Una campo de texto (JTextField) para ingresar el apellido del usuario. 
        // Por defecto es posible ingresar cualquier string.
        textFieldApellido = new JTextField();
        GridBagConstraints gbc_textFieldApellido = new GridBagConstraints();
        gbc_textFieldApellido.gridwidth = 2;
        gbc_textFieldApellido.fill = GridBagConstraints.BOTH;
        gbc_textFieldApellido.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldApellido.gridx = 1;
        gbc_textFieldApellido.gridy = 1;
        getContentPane().add(textFieldApellido, gbc_textFieldApellido);
        textFieldApellido.setColumns(10);

        // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
        // el mail del usuario. El texto está alineado horizontalmente a la derecha para
        // que quede casi pegado al campo de texto.
        lblIngreseMail = new JLabel("Mail:");
        lblIngreseMail.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseMail = new GridBagConstraints();
        gbc_lblIngreseMail.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseMail.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseMail.gridx = 0;
        gbc_lblIngreseMail.gridy = 0;
        getContentPane().add(lblIngreseMail, gbc_lblIngreseMail);
        
        // Una campo de texto (JTextField) para ingresar el Mail del usuario. 
        // Por defecto es posible ingresar cualquier string.
        textFieldMail = new JTextField();
        GridBagConstraints gbc_textFieldMail = new GridBagConstraints();
        gbc_textFieldMail.gridwidth = 2;
        gbc_textFieldMail.fill = GridBagConstraints.BOTH;
        gbc_textFieldMail.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldMail.gridx = 1;
        gbc_textFieldMail.gridy = 0;
        getContentPane().add(textFieldMail, gbc_textFieldMail);
        textFieldMail.setColumns(10);

        // Una etiqueta (JLabel) indicandp que en el siguiente campo debe ingresarse 
        // el Nacimiento del usuario. El texto está alineado horizontalmente a la derecha para
        // que quede casi pegado al campo de texto.
        lblIngreseNacimiento = new JLabel("Nacimiento:");
        lblIngreseNacimiento.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_lblIngreseNacimiento = new GridBagConstraints();
        gbc_lblIngreseNacimiento.fill = GridBagConstraints.BOTH;
        gbc_lblIngreseNacimiento.insets = new Insets(0, 0, 5, 5);
        gbc_lblIngreseNacimiento.gridx = 0;
        gbc_lblIngreseNacimiento.gridy = 0;
        getContentPane().add(lblIngreseNacimiento, gbc_lblIngreseNacimiento);
        
        // Una campo de texto (JTextField) para ingresar el Nacimiento del usuario. 
        // Por defecto es posible ingresar cualquier string.
        textFieldNacimiento = new JTextField();
        GridBagConstraints gbc_textFieldNacimiento = new GridBagConstraints();
        gbc_textFieldNacimiento.gridwidth = 2;
        gbc_textFieldNacimiento.fill = GridBagConstraints.BOTH;
        gbc_textFieldNacimiento.insets = new Insets(0, 0, 5, 0);
        gbc_textFieldNacimiento.gridx = 1;
        gbc_textFieldNacimiento.gridy = 0;
        getContentPane().add(textFieldNacimiento, gbc_textFieldNacimiento);
        textFieldNacimiento.setColumns(10);
        
        
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
        gbc_btnAceptar.fill = GridBagConstraints.BOTH;
        gbc_btnAceptar.insets = new Insets(0, 0, 0, 5);
        gbc_btnAceptar.gridx = 1;
        gbc_btnAceptar.gridy = 3;
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
        gbc_btnCancelar.fill = GridBagConstraints.BOTH;
        gbc_btnCancelar.gridx = 2;
        gbc_btnCancelar.gridy = 3;
        getContentPane().add(btnCancelar, gbc_btnCancelar);
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
        Date nacimientoU = null;
        String nacionalidadU = "Uruguay";

        if (checkFormulario()) {
            try {
                controlAlta.confirmarAltaTurista(nickU,nombreU, apellidoU, mailU,nacimientoU,nacionalidadU);

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
        String nombreU = this.textFieldNombre.getText();
        String apellidoU = this.textFieldApellido.getText();
        String ciU = this.textFieldNick.getText();

        if (nombreU.isEmpty() || apellidoU.isEmpty() || ciU.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            Integer.parseInt(ciU);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La CI debe ser un numero", "Registrar Usuario",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    // Permite borrar el contenido de un formulario antes de cerrarlo.
    // Recordar que las ventanas no se destruyen, sino que simplemente 
    // se ocultan, por lo que conviene borrar la información para que 
    // no aparezca al mostrarlas nuevamente.
    private void limpiarFormulario() {
    	textFieldNick.setText("");
        textFieldNombre.setText("");
        textFieldApellido.setText("");
    }
}
