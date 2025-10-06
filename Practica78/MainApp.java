public class MainApp {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Don Cangrejo", 1001, 50000, 100000);
        gerente.aumentarSueldo(20);
        System.out.println(gerente);
    }
}