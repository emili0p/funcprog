public class Main {

    public static double calcularTotal(double precio) {
        double impuesto = precio * 0.16;
        double descuento = 0.0;

        if (precio > 1000) {
            descuento = precio * 0.10;
        }

        return precio + impuesto - descuento;
    }

    public static void main(String[] args) {
        System.out.println(calcularTotal(1200));
    }
}

