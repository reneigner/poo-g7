package mx.unam.fi.poo;

public class MainApp {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        p1.setNombre("Juan");
        p1.setApellido("Perez");
        p1.setFNacimiento(15, 8, 1960);
        System.out.println("Nombre: " + p1.getNombre());
        System.out.println("Apellido: " + p1.getApellido());
        System.out.println("Fecha de nacimiento: " + p1.getFNacimiento());

        Persona p2 = new Persona("Jose", "Hernandez", 22, 9, 2005);
        System.out.println("Nombre: " + p2.getNombre());
        System.out.println("Apellido: " + p2.getApellido());
        System.out.println("Fecha de nacimiento: " + p2.getFNacimiento());
    }
}