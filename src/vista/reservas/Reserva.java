package vista.reservas;

import javax.swing.*;

public class Reserva {
    private JFrame ventanaReservas;
    private JPanel panelPrincipal;
    private JLabel labelPrueba;
    private JPanel panelInferior;
    private JButton botonSalir;
    private JButton botonCerrarSesion;
    private JPanel panelSuperior;
    private JLabel nombreUsuario;
    private JPanel panelCentral;
    private JTextField textoFecha;
    private JTextField textoDuracion;
    private JTextField textTipoReserva;
    private JPanel panelDerecho;
    private JButton botonCrear;
    private JLabel labelFecha;
    private JButton botonBorrar;
    private JLabel labelDuracion;
    private JLabel labelHoraEntrada;
    private JLabel labelTipoReserva;
    private JTextField textoHoraEntrada;
    private JButton botonAtras;
    private JButton botonAlante;

    public Reserva () {
        ventanaReservas = new JFrame("Aplicación reservas");
        ventanaReservas.setContentPane(panelPrincipal);
        ventanaReservas.setSize(500,400);
        ventanaReservas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaReservas.setLocationRelativeTo(null);
        //ventanaLogin.pack();
        ventanaReservas.setVisible(true);
    }

    public JFrame getVentanaReservas() {
        return ventanaReservas;
    }

    public JLabel getLabelPrueba() {
        return labelPrueba;
    }

    public static void main(String[] args) {
        new Reserva();
    }
}
