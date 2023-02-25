package core;

public class ThreadSemaforo extends Thread{

    private boolean finalizada, mudouDeCor;
    public ThreadSemaforo(){
        super();
    }

    @Override
    public void run(){
        while (emExecucao()){
            synchronized (Semaforo.class) {
                try {
                    manterCorDoSemaforo();
                    mudarCorDoSemaforo();
                } catch (InterruptedException e) {
                    // TODO
                    return;
                }
            }
        }
    }

    private boolean emExecucao(){
        return !finalizada;
    }

    private void manterCorDoSemaforo() throws InterruptedException{
        switch (Semaforo.getCorSemaforo()) {
            case VERDE:
                Thread.sleep(Segundos.emMilis(4));
                break;
            case AMARELO:
                Thread.sleep(Segundos.emMilis(2));
                break;
            case VERMELHO:
                Thread.sleep(Segundos.emMilis(2));
        }
    }

    public synchronized void esperarMudarDeCor() throws InterruptedException {
            while(!mudouDeCor){
                wait();
            }
            mudouDeCor = false;
    }

    private synchronized void mudarCorDoSemaforo(){
        Semaforo.mudarCorDoSemaforo();
        mudouDeCor = true;
        notify();
    }

    public void finalizar() {
        finalizada = true;
    }
}
