package core;

public class Semaforo {

    enum CorSemaforo {

        VERDE("\u001B[32m"){
            @Override
            public CorSemaforo getProximaCor(){
                return AMARELO;
            }
        },
        AMARELO("\u001B[33m"){
            @Override
            public CorSemaforo getProximaCor(){
                return VERMELHO;
            }
        },
        VERMELHO("\u001B[31m"){
            @Override
            public CorSemaforo getProximaCor(){
                return VERDE;
            }
        };

        private final String codigoCor;
        private static final String CODIGO_RESET_COR = "\u001B[0m";

        private CorSemaforo(String codigoCor){
            this.codigoCor = codigoCor;
        }

        public abstract CorSemaforo getProximaCor();

        @Override
        public String toString(){
            return codigoCor + super.toString() + CODIGO_RESET_COR;
        }
    }

    private static CorSemaforo corSemaforo = CorSemaforo.VERMELHO;

    public static CorSemaforo getCorSemaforo() {
        return corSemaforo;
    }

    static void setCorSemaforo(CorSemaforo corSemaforo){
        Semaforo.corSemaforo = corSemaforo;
    }

    public static void mudarCorDoSemaforo(){
        CorSemaforo proximaCor = corSemaforo.getProximaCor();
        setCorSemaforo(proximaCor);
    }
}
