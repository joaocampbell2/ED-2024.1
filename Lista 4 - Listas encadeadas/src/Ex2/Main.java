package Ex2;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        ListaOrdenada listaA = new ListaOrdenada();
        ListaOrdenada listaB = new ListaOrdenada();

        listaA.insere(7);
        listaA.insere(5);
        listaA.insere(9);
        listaA.insere(2);
        listaA.insere(4);

        listaB.insere(1);
        listaB.insere(3);
        listaB.insere(8);
        listaB.insere(12);

        listaB.imprime();

        Lista listaC = intercalarListasOrdenadas(listaA,listaB);

        listaC.imprime();


    }

    public static Lista intercalarListasOrdenadas(Lista listaA, Lista listaB){
        Lista c = new Lista();

        Lista.Elo a = listaA.prim;

        Lista.Elo b = listaB.prim;


        while (a!= null && b!=null){

            if(a.dado < b.dado){
                c.insere(a.dado);
                a = a.prox;
            }
            else if(b.dado < a.dado){
                c.insere(b.dado);
                b = b.prox;
            }
            else{
                c.insere(a.dado);
                c.insere(b.dado);
                a = a.prox;
                b = b.prox;
            }
        }




        return c;
    }

}
