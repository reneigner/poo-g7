public class Articulo {
    String nombre;
    double precio;

    public Articulo(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String toItemString() {
        long cents = Math.round(precio * 100);
        String entero = String.valueOf(cents/100);
        int dec = (int)(cents % 100);
        String decStr = dec < 10 ? ("0" + dec) : String.valueOf(dec);
        return nombre + " - $" + entero + "." + decStr;
    }
}