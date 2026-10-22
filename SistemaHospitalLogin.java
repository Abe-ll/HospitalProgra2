package sistemahospitallogin;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class LoginFrame extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    public LoginFrame() {
        setTitle("Sistema Integrado de Gestion - Hospital");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel principal = new JPanel(new BorderLayout(10, 20));
        principal.setBorder(new EmptyBorder(25, 30, 25, 30));
        setContentPane(principal);

        JPanel panelTitulo = new JPanel(new GridLayout(2, 1, 0, 5));
        JLabel lblTitulo = new JLabel("SISTEMA INTEGRADO DE GESTION", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 18));
        JLabel lblSubtitulo = new JLabel("Inicio de sesion", SwingConstants.CENTER);
        panelTitulo.add(lblTitulo);
        panelTitulo.add(lblSubtitulo);
        principal.add(panelTitulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridLayout(2, 2, 12, 15));
        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();
        JLabel lblContrasena = new JLabel("Contrasena:");
        txtContrasena = new JPasswordField();
        formulario.add(lblUsuario);
        formulario.add(txtUsuario);
        formulario.add(lblContrasena);
        formulario.add(txtContrasena);
        principal.add(formulario, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        JButton btnIngresar = new JButton("Ingresar");
        JButton btnLimpiar = new JButton("Limpiar");
        JButton btnSalir = new JButton("Salir");
        panelBotones.add(btnIngresar);
        panelBotones.add(btnLimpiar);
        panelBotones.add(btnSalir);
        principal.add(panelBotones, BorderLayout.SOUTH);

        btnIngresar.addActionListener(e -> iniciarSesion());
        btnLimpiar.addActionListener(e -> limpiarCampos());
        btnSalir.addActionListener(e -> dispose());
    }

    private void iniciarSesion() {
        String usuario = txtUsuario.getText().trim();
        char[] contrasena = txtContrasena.getPassword();

        if (usuario.isEmpty() || contrasena.length == 0) {
            JOptionPane.showMessageDialog(this, "Debes ingresar el usuario y la contrasena.", "Campos incompletos", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "La interfaz funciona correctamente", "Inicio de sesion", JOptionPane.INFORMATION_MESSAGE);
        }
        java.util.Arrays.fill(contrasena, '\0');
    }

    private void limpiarCampos() {
        txtUsuario.setText("");
        txtContrasena.setText("");
        txtUsuario.requestFocusInWindow();
    }
}