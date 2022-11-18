import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Parking coche1 = new Parking("Coche 1");
        Parking coche2 = new Parking("Coche 2");
        Parking coche3 = new Parking("Coche 3");
        Parking coche4 = new Parking("Coche 4");
        Parking coche5 = new Parking("Coche 5");


        coche1.entrar();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        coche2.entrar();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        coche3.entrar();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        coche4.entrar();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        coche5.entrar();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        coche1.salir();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        coche2.salir();

    }
}