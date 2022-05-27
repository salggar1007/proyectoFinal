package controlador.reservas;

import modelo.dao.reserva.Reserva;
import modelo.dao.reserva.ReservaDAO;
import modelo.dao.reserva.ReservaDAOImpl;
import modelo.dao.reserva.TipoReserva;
import modelo.dao.usuario.Usuario;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import vista.logueo.Login;
import vista.reservas.InterfazReserva;

import javax.naming.spi.ResolveResult;
import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class ControladorReservas{
    private ReservaDAO modelo;
    private InterfazReserva vista;
    private Usuario usuario;

    public ControladorReservas(Usuario usuario) {
        this.modelo = new ReservaDAOImpl();
        this.vista = new InterfazReserva();
        this.usuario = usuario;
        inicializarVista();
    }

    private void inicializarVista() {
        vista.getVentanaReservas().setVisible(true);
        vista.getLabelNombreUsuario().setText(usuario.getNombre());
    }

    public void inicializarControlador() {
        vista.getBotonCrear().addActionListener(actionEvent -> crearReserva());
        vista.getBotonSalir().addActionListener(actionEvent -> salirApp());
        vista.getBotonCerrarSesion().addActionListener(actionEvent -> cerrarSesion());
    }

    private void crearReserva() {
        try {
            String fecha = vista.getTextoFecha().getText().trim();
            //helpers.Fechas.convertirFechasReservas(fecha);
            LocalDate fechaNueva = helpers.Fechas.fechaCorrecta(fecha);
            if (fechaNueva == null){
                vista.getLabelError().setVisible(true);
                return;
            }
            vista.getLabelError().setVisible(false);
            String duracion = vista.getTextoDuracion().getText();
            String horaEntrada = vista.getTextoHoraEntrada().getText();
            Reserva reserva = new Reserva(fechaNueva,
                    Integer.parseInt(duracion), Integer.parseInt(horaEntrada), usuario.getDni());
            if (vista.getRadioBotonTipoReserva().isSelected())
                reserva.setTipoReserva(TipoReserva.NO_GUIADA);
            modelo.crearReserva(reserva);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cerrarSesion() {
    }

    private void salirApp() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de salir?",
                "SALIR", JOptionPane.YES_NO_OPTION);
        if (opcion == 0)
            System.exit(0);
    }
}
