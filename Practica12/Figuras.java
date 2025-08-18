import java.util.Scanner;

public class Figuras {
    final static double PI = 3.1416;
    public static void main(String[] args) {
        int opcion;
        Scanner e = new Scanner(System.in);
        do {
            System.out.println("Elige una opción:");
            System.out.println("1 - Área del círculo");
            System.out.println("2 - Área del triángulo");
            System.out.println("3 - Área del cuadrado");
            System.out.println("4 - Salir");
            opcion = e.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Seleccionaste círculo.");
                    System.out.println("El area del circulo es " + areaCirculo(15.0));
                    break;
                case 2:
                    System.out.println("Seleccionaste triángulo.");
                    System.out.println("El area del triángulo es " + areaTriangulo(8, 5));
                    break;
                case 3:
                    System.out.println("Seleccionaste cuadrado.");
                    System.out.println("El area del cuadrado es " + areaCuadrado(10));
                    break;
                case 4:
                    System.out.println("Hasta luego...");
                    break;
                default:
                    System.out.println("Opción no válida...");
                    continue;
            }
        } while (opcion != 4);
    }

    public static double areaCirculo(double radio) {
        return PI * radio * radio;
    }

    public static double areaTriangulo(double base, double altura) {
        return (base * altura) / 2.0;
    }

    public static double areaCuadrado(double lado) {
        return lado * lado;
    }
}
