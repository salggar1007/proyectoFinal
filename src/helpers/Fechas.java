package helpers;

import vista.reservas.InterfazReserva;

import java.time.*;
import java.util.Date;
import java.util.Objects;

public class Fechas {
    public static Date convertirFormatoFechas(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay(
                ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return date;
    }
    /*public static boolean convertirFechasReservas(String fechaTexto){
        if (fechaTexto.matches("[a-zA-Z]") || fechaTexto == null){
            return false;
        }
        return true;
    }*/
    public static LocalDate fechaCorrecta(String fechaTexto) {
        if (Objects.equals(fechaTexto, "")){
            return null;
        }
        String fechaNueva = fechaTexto.replaceAll("/" , "-");
        String[]tokken = fechaNueva.split("-");
        int dia = Integer.parseInt(tokken[0]);
        int mes = Integer.parseInt(tokken[1]);
        int anno = Integer.parseInt(tokken[2]);
        LocalDate fechaCorrecta = LocalDate.of(anno , mes , dia);
        if (fechaCorrecta.isBefore(LocalDate.now()))
            return null;
        return LocalDate.of(anno , mes , dia);
    }
}
