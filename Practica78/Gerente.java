public class Gerente extends Empleado {
    private int presupuesto;

    public Gerente(String nombre, int numEmpleado, int sueldo, int presupuesto) {
        super(nombre, numEmpleado, sueldo);
        setPresupuesto(presupuesto);
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(int presupuesto) {
        this.presupuesto = presupuesto;
    }

    void asignarPresupuesto(int p) {
        presupuesto = p;
    }

    @Override
    public String toString() {
        return super.toString() +
            "\nPresupuesto: " + getPresupuesto();
    }
}