package helpers;

import vista.reservas.InterfazReserva;

import java.time.*;
import java.util.Date;

public class Fechas {
    public static Date convertirFormatoFechas(LocalDate localDate) {
        Instant instant = localDate.atStartOfDay(
                ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);

        return date;
    }
    public static boolean convertirFechasReservas(String fechaTexto){
        fechaTexto.replace("/" , "-");
        return fechaTexto.matches("[1-9]{1,2}-[1-9]{1,2}-[1-9]{1,4}]");
    }
    public static LocalDate fechaCorrecta(String fechaTexto) {
        String[]tokken = fechaTexto.split("-");
        int dia = Integer.parseInt(tokken[0]);
        int mes = Integer.parseInt(tokken[1]);
        int anno = Integer.parseInt(tokken[2]);
        LocalDate fechaCorrecta = LocalDate.of(anno , mes , dia);
        if (fechaCorrecta.isBefore(LocalDate.now()))
            return null;
        return LocalDate.of(anno , mes , dia);
    }
}
