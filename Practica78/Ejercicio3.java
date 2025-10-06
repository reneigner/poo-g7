public class Ejercicio3 {
    public static void main(String[] args) {
        InstrumentoMusical instrumento;

        instrumento = new Guitarra();

        instrumento.tocar();

        System.out.println(instrumento.tipoInstrumento());
    }
}