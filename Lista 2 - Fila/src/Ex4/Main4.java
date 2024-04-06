package Ex4;

public class Main4 {
    public static void main(String[] args) {
        Fila fila = new Fila(3);

        fila.insere(1);
        fila.insere(2);
        fila.insere(3);

        FilaDupla filaDupla = Fila.simplesPraDupla(fila);
        System.out.println("Fila: ");

        while(!filaDupla.vazia()){
            System.out.println(filaDupla.remove());
        }

        filaDupla.insere(1);
        filaDupla.insereInicio(3);
        filaDupla.insere(2);
        System.out.println("Fila: ");

        while(!filaDupla.vazia()){
            System.out.println(filaDupla.remove());
        }


    }








}
