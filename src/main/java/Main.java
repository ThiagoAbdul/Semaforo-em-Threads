import core.Semaforo;
import core.ThreadSemaforo;

public class Main {

    public static void main(String[] args) {
        ThreadSemaforo thread = new ThreadSemaforo();
        thread.start();
        for(int i = 0; i < 10; i++){
            try {
                thread.esperarMudarDeCor();
                System.out.println(Semaforo.getCorSemaforo());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        thread.finalizar();
    }
}
