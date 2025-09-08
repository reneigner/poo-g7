public class Practica4 {
    public static void main(String[] args) {
        Mensajes controlador = new Mensajes();

        Ventana ventana = new Ventana(controlador);
        ventana.setVisible(true);
    }
}