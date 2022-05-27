package vista.reservas;

import javax.swing.*;

public class InterfazReserva {
    private JFrame ventanaReservas;
    private JPanel panelPrincipal;
    private JPanel panelInferior;
    private JButton botonSalir;
    private JButton botonCerrarSesion;
    private JPanel panelSuperior;
    private JLabel nombreUsuario;
    private JPanel panelCentral;
    private JTextField textoFecha;
    private JTextField textoDuracion;
    private JTextField textoTipoReserva;
    private JPanel panelDerecho;
    private JButton botonCrear;
    private JLabel labelFecha;
    private JButton botonBorrar;
    private JLabel labelDuracion;
    private JLabel labelHoraEntrada;
    private JTextField textoHoraEntrada;
    private JButton botonAtras;
    private JButton botonAlante;
    private JLabel labelNombreUsuario;
    private JRadioButton radioBotonTipoReserva;
    private JLabel labelError;

    public InterfazReserva() {
        ventanaReservas = new JFrame("Aplicación reservas");
        ventanaReservas.setContentPane(panelPrincipal);
        ventanaReservas.setSize(500,400);
        ventanaReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaReservas.setLocationRelativeTo(null);
        //ventanaLogin.pack();
        ventanaReservas.setVisible(true);
        labelError.setVisible(false);
    }

    public JFrame getVentanaReservas() {
        return ventanaReservas;
    }

    public JButton getBotonCrear() {
        return botonCrear;
    }

    public JTextField getTextoFecha() {
        return textoFecha;
    }

    public JTextField getTextoDuracion() {
        return textoDuracion;
    }

    public JTextField getTextoTipoReserva() {
        return textoTipoReserva;
    }

    public JTextField getTextoHoraEntrada() {
        return textoHoraEntrada;
    }

    public JLabel getLabelNombreUsuario() {
        return labelNombreUsuario;
    }

    public JRadioButton getRadioBotonTipoReserva() {
        return radioBotonTipoReserva;
    }

    public JLabel getLabelError() {
        return labelError;
    }

    public JButton getBotonSalir() {
        return botonSalir;
    }

    public JButton getBotonCerrarSesion() {
        return botonCerrarSesion;
    }

    public static void main(String[] args) {
        new InterfazReserva();
    }
}
