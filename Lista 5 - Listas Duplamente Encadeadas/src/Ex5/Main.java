package Ex5;

public class Main {
    public static void main(String[] args) {
        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();

        lista1.insere(1);
        lista2.insere(1);
        lista1.insere(1);
        lista2.insere(1);
        lista1.insere(1);
        lista2.insere(1);


        System.out.println(lista1.verificaIgualdade(lista2));
    }
}
