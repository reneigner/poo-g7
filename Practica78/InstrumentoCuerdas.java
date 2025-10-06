public class InstrumentoCuerdas implements InstrumentoMusical {
    public void tocar() {
        System.out.println("Estoy tocando el instrumento de cuerdas.");
    }

    public void afinar() {
        System.out.println("Estoy afinando las cuerdas del instrumento.");
    }

    public String tipoInstrumento() {
        return "Es una instrumento de cuerdas.";
    }
}