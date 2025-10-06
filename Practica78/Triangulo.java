public class Triangulo extends Poligono{
    private double base, altura;

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public double area(){
        return (base*altura) / 2;
    }

    @Override
    public double perimetro(){
        return base + altura;
    }
    @Override
    public String toString() {
        return "Triángulo";
    }
}
