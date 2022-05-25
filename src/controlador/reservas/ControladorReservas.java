package controlador.reservas;

import modelo.dao.reserva.Reserva;
import modelo.dao.reserva.ReservaDAO;
import modelo.dao.reserva.ReservaDAOImpl;
import modelo.dao.reserva.TipoReserva;
import modelo.dao.usuario.Usuario;
import modelo.dao.usuario.UsuarioDAO;
import modelo.dao.usuario.UsuarioDAOImpl;
import vista.reservas.InterfazReserva;

import javax.naming.spi.ResolveResult;
import java.sql.SQLException;
import java.time.LocalDate;

public class ControladorReservas{
    private ReservaDAO modelo;
    private InterfazReserva vista;
    private Usuario usuario;
    private UsuarioDAO usuarioDAO;

    public ControladorReservas(Usuario usuario) {
        this.modelo = new ReservaDAOImpl();
        this.vista = new InterfazReserva();
        this.usuario = usuario;
        this.usuarioDAO = new UsuarioDAOImpl();
        inicializarVista();
    }

    private void inicializarVista() {
        vista.getVentanaReservas().setVisible(true);
        vista.getLabelNombreUsuario().setText(usuario.getNombre());
    }

    public void inicializarControlador() {
        vista.getBotonCrear().addActionListener(actionEvent -> crearReserva());
    }

    private void crearReserva() {
        try {
            String fecha = vista.getTextoFecha().getText().trim();
            String duracion = vista.getTextoDuracion().getText();
            String horaEntrada = vista.getTextoHoraEntrada().getText();
            Reserva reserva = new Reserva(LocalDate.parse(fecha),
                    Integer.parseInt(duracion), Integer.parseInt(horaEntrada), usuario.getDni());
            if (vista.getRadioBotonTipoReserva().isSelected())
                reserva.setTipoReserva(TipoReserva.NO_GUIADA);
            modelo.crearReserva(reserva);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
