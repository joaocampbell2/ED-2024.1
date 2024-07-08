package Ex4;

public class Main {
    public static void main(String[] args) {
        ListaDuplamente lista = new ListaDuplamente();


        lista.insere(1);
        lista.insere(2);
        lista.insere(3);
        lista.insere(4);
        lista.insere(5);

        lista.trocaElos(1,3);
        lista.imprime();
    }
}
