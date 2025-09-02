import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ejemplo4 { 
    public static void main(String[] args) {
        Date fecha = new Date();
        System.out.println(fecha.toString());
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println(formato.format(fecha));

        Calendar calendario = Calendar.getInstance();
        String fechaHoy = "Hoy es el día ";
        fechaHoy += calendario.get(Calendar.DAY_OF_MONTH) + " del mes ";
        fechaHoy += calendario.get(Calendar.MONTH) + 1 + " de ";
        fechaHoy += calendario.get(Calendar.YEAR);
        System.out.println(fechaHoy);
    }  
}