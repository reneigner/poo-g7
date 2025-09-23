package mx.unam.fi.poo;
public class Fecha {
    private int dia, mes, anio;

    public Fecha() {}

    public Fecha(int dia, int mes, int anio){
        setDia(dia);
        setMes(mes);
        setAnio(anio);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (dia > 0 && dia < 32) {
            this.dia = dia;
        } else {
            System.out.println("Día no válido...");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (mes > 0 && mes < 13) {
            this.mes = mes;
        } else {
            System.out.println("Mes no válido...");
        }
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio > 0) {
            this.anio = anio;
        } else {
            System.out.println("Año no válido...");
        }
    }
    
    public String toString() {
        return dia + "/" + mes + "/" + anio;
    }
}