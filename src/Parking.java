import java.util.Arrays;

public class Parking extends Thread {
    static int[] plazas = new int[6];
    static int plazasOcupadas = 0;
    static boolean ocupado = false;
    static int random;

    public Parking(String nombre) {
        super(nombre);
    }

    public synchronized void run() {
        entrar();
        salir();
    }

    public synchronized void entrar() {
        try {
            while (ocupado || plazasOcupadas >= 5) {
                System.out.println("Entro en la cola aparcar");
                wait();
            }
            ocupado = true;
            System.out.println("Entra en el parking " + getName());

            plazasOcupadas++;
            System.out.println("Plazas ocupadas = " + plazasOcupadas);
            for (int i = 0; i < plazas.length; i++) {
                if (plazas[i] == 0) {
                    plazas[i] = 1;
                    break;
                }
            }
            random = (int) (Math.random() * 5);
            ocupado = false;
            System.out.println(Arrays.toString(plazas));
            notify();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public synchronized void salir() {
        while (ocupado || plazasOcupadas <= 0) {
            try {
                System.out.println("Entro en la cola salir");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ocupado = true;
        System.out.println("Sale del parking " + getName());

        plazasOcupadas--;
        System.out.println("Plazas libres = " + plazasOcupadas);
        random = (int) (Math.random() * 5);
        for (int i = 0; i < plazas.length; i++) {
            if (plazas[i] == 1) {
                plazas[i] = 0;
                break;
            }
        }
        ocupado = false;
        System.out.println(Arrays.toString(plazas));

        notify();

    }

}
