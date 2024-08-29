import java.security.Key;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main{
    public static void main(String[] args) {
        // GERADOR DE PONTOS

        int n =100;
        long  tempoMedio = 0;


        //NAIVE
        for(int i = 0; i < 10; i++) //executa a clusteriza??o 10 vezes para 10 entradas diferentes
        {

            GeradorPontos geradorPontos = new GeradorPontos();

            ArrayList<Cluster> listaClusters = geradorPontos.gerarPontos(n);

            long t0 = System.currentTimeMillis();

            while (listaClusters.size() != 1){

                clusterizarNaive(listaClusters);

            }

            listaClusters.getFirst().mostra();
            long t1 = System.currentTimeMillis();

            long tempoProcessamento = t1 - t0;
            tempoMedio += tempoProcessamento;
            System.out.println("\nTempo linear: " + tempoProcessamento);
        }
        tempoMedio = tempoMedio / 10;
        System.out.println("\nTempo medio Naive: " + tempoMedio);

        //HEAP

        tempoMedio = 0;
        for(int i = 0; i < 10; i++) //executa a clusteriza??o 10 vezes para 10 entradas diferentes
        {
            GeradorPontos geradorPontos = new GeradorPontos();

            ArrayList<Cluster> listaClusters = geradorPontos.gerarPontos(n);
            ArrayList<Distancia> listaDistancias = new ArrayList<Distancia>();

            Distancia distanciaAtual;


            for (int j = 0; j < listaClusters.size(); j++) {
                Cluster clusterJ = listaClusters.get(j);
                for (int k = j + 1; k < listaClusters.size(); k++) {
                    Cluster clusterK = listaClusters.get(k);
                    distanciaAtual = new Distancia(clusterJ, clusterK);
                    listaDistancias.add(distanciaAtual);
                }
            }
            Distancia[] vetorDistancias = new Distancia[listaDistancias.size()];

            for (int j = 0; j < listaDistancias.size(); j++) {
                vetorDistancias[j] = listaDistancias.get(j);
            }
            long t0 = System.currentTimeMillis();

            HeapBinariaMinima heapDistancias = new HeapBinariaMinima(vetorDistancias.length, listaClusters);

            for (int j = 0; j < listaClusters.size(); j++) {
                Cluster clusterJ = listaClusters.get(j);
                for (int k = j + 1; k < listaClusters.size(); k++) {
                    Cluster clusterK = listaClusters.get(k);
                    distanciaAtual = new Distancia(clusterJ, clusterK);
                    heapDistancias.insere(distanciaAtual);
                }
            }
            while (listaClusters.size() != 1) {

                heapDistancias.novoCluster();

            }

            long t1 = System.currentTimeMillis();

            long tempoProcessamento = t1 - t0;
            tempoMedio += tempoProcessamento;
            listaClusters.getFirst().mostra();
            System.out.println("\nTempo linear: " + tempoProcessamento);
        }
        tempoMedio = tempoMedio / 10;
        System.out.println("\nTempo medio Naive: " + tempoMedio);

    }

    public static void clusterizarNaive(ArrayList<Cluster> listaClusters){
        Distancia menorDistancia = new Distancia(Double.MAX_VALUE);

        Cluster novoCluster;
        Distancia distanciaAtual;

        for(int i = 0; i< listaClusters.size() ;i++){
            Cluster clusterI = listaClusters.get(i);
            for (int j = i + 1; j < listaClusters.size(); j++){
                Cluster clusterJ = listaClusters.get(j);
                distanciaAtual = new Distancia(clusterI,clusterJ);
                if (distanciaAtual.valDistancia < menorDistancia.valDistancia){
                    menorDistancia = distanciaAtual;
                }
            }
        }

        listaClusters.remove(menorDistancia.cluster1);
        listaClusters.remove(menorDistancia.cluster2);
        novoCluster= new Cluster(menorDistancia.cluster1, menorDistancia.cluster2);
        listaClusters.add(novoCluster);
    }


}
