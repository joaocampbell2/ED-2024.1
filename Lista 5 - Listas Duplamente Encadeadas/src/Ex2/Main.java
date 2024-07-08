package Ex2;

public class Main {
    public static void main(String[] args) {
        ListaCircular lista1 = new ListaCircular();
        ListaCircular lista2 = new ListaCircular();

        lista1.insere(1);
        lista2.insere(2);
        lista1.insere(3);
        lista2.insere(4);
        lista1.insere(5);
        lista2.insere(6);
        lista2.insere(7);

        ListaCircular lista3 = lista1.merge(lista2);

        lista3.imprimeRecursivo();
    }



}
