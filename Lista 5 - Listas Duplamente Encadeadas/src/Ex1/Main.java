package Ex1;

public class Main {
    public static void main(String[] args) {

        ListaDuplamente lista1 = new ListaDuplamente();
        ListaDuplamente lista2 = new ListaDuplamente();
        lista1.insere(2);
        lista1.insere(3);
        lista1.insere(26);
        lista2.insere(2);
        lista2.insere(1);
        lista2.insere(26);

        ListaDuplamente lista3 = criarInterseccao(lista1,lista2);

        lista3.imprime();


    }

    //COMPLEXIDADE 0(n²), uso de dois loops um dentro do outro
    public static ListaDuplamente criarInterseccao(ListaDuplamente lista1, ListaDuplamente lista2){
        ListaDuplamente listaInterseccao = new ListaDuplamente();

        ListaDuplamente.Elo p1, p2;
        for(p1 = lista1.prim;p1 != null; p1 = p1.prox ){
            for(p2 = lista2.prim;p2!= null;p2=p2.prox){
                if (p1.dado == p2.dado){
                    listaInterseccao.insere(p1.dado);
                    break;
                }
            }
        }

        return  listaInterseccao;
    }
}
