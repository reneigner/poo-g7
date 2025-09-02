import java.util.Enumeration;
import java.util.Hashtable;

public class Ejemplo3 {
    public static void main(String[] args) {
        Hashtable<String, Integer> tabla = new Hashtable<String, Integer>();
        tabla.put("diez", 10);
        tabla.put("veinte", 20);
        tabla.put("treinta", 30);

        String llave;
        Integer valor;

        Enumeration<String> llaves = tabla.keys();
        while (llaves.hasMoreElements()) {
            llave = llaves.nextElement();
            valor = tabla.get(llave);
            System.out.println("Llave: " + llave + "\tValor: " + valor);
        }
    }   
}