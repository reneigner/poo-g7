package mx.unam.fi.poo;

public class Persona {
    private String nombre, apellido;
    private Fecha fNacimiento;

    public Persona() {
        fNacimiento = new Fecha();
    }

    public Persona(String nombre, String apellido, int fDia, int fMes, int fAnio) {
        setNombre(nombre);
        setApellido(apellido);
        fNacimiento = new Fecha(fDia, fMes, fAnio);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Fecha getFNacimiento() {
        return fNacimiento;
    }

    public void setFNacimiento(int dia, int mes, int anio) {
        fNacimiento.setDia(dia);
        fNacimiento.setMes(mes);
        fNacimiento.setAnio(anio);
    }
}