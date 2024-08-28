import java.util.ArrayList;

public class Main{
    public static void main(String[] args) {
        // GERADOR DE PONTOS




        int n =1000;

        GeradorPontos geradorPontos = new GeradorPontos();

        ArrayList<Cluster> listaClusters = geradorPontos.gerarPontos(n);

        ArrayList<Cluster> listaClustersHeap = new ArrayList<>(listaClusters);
        ArrayList<Cluster> listaClustersNaive = new ArrayList<>(listaClusters) ;
        //NAIVE
        long tempoIni = System.currentTimeMillis();

        while (listaClustersNaive.size() != 1){

            clusterizar(listaClustersNaive);

        }

        listaClustersNaive.getFirst().mostra();
        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoIni;

        System.out.println("\nTempo total de execucao: " + duracao + " milissegundos");
        System.out.println("AGORA O HEAP");

        //////HEAP

        ArrayList<Distancia> listaDistancias = new ArrayList<Distancia>();

        Distancia distanciaAtual;


        System.out.println(listaClustersHeap.size());
        for(int i = 0; i< listaClustersHeap.size() ;i++){
            Cluster clusterI = listaClustersHeap.get(i);
            for (int j = i + 1; j < listaClustersHeap.size(); j++){
                Cluster clusterJ = listaClustersHeap.get(j);
                distanciaAtual = new Distancia(clusterI,clusterJ);
                listaDistancias.add(distanciaAtual);
            }
        }


        Distancia[] vetorDistancias = new Distancia[listaDistancias.size()];

        for (int i = 0; i <listaDistancias.size();i++){
            vetorDistancias[i] = listaDistancias.get(i);
        }
        tempoIni = System.currentTimeMillis();

        HeapBinariaMinima heapDistancias = new HeapBinariaMinima( vetorDistancias.length ,listaClustersHeap);
        for(int i = 0; i< listaClustersHeap.size() ;i++){
            Cluster clusterI = listaClustersHeap.get(i);
            for (int j = i + 1; j < listaClustersHeap.size(); j++){
                Cluster clusterJ = listaClustersHeap.get(j);
                distanciaAtual = new Distancia(clusterI,clusterJ);
                heapDistancias.insere(distanciaAtual);
            }
        }

        while (heapDistancias.getListaClusters().size() != 1){

                heapDistancias.novoCluster();
        }

        tempoFim = System.currentTimeMillis();
        duracao = tempoFim - tempoIni;
        System.out.println(heapDistancias.getListaClusters());
        heapDistancias.getListaClusters().getFirst().mostra();

        System.out.println("\nTempo total de execucao: " + duracao + " milissegundos");
        System.out.println("\nTempo total de execucao: " + heapDistancias.duracaoApaga + " milissegundos");
        System.out.println("\nTempo total de execucao: " + heapDistancias.duracaoConstroi + " milissegundos");



    }

    public static void clusterizar(ArrayList<Cluster> listaClusters){
        Distancia menorDistancia = new Distancia(Double.MAX_VALUE);

        Cluster novoCluster;
        Distancia distanciaAtual;

        for(int i = 0; i< listaClusters.size() ;i++){
            Cluster clusterI = listaClusters.get(i);
            for (int j = i + 1; j < listaClusters.size(); j++){
                Cluster clusterJ = listaClusters.get(j);
                distanciaAtual = new Distancia(clusterI,clusterJ);
                if (distanciaAtual.valDistancia < menorDistancia.valDistancia){
                    menorDistancia = distanciaAtual;;

                }
            }
        }

        listaClusters.remove(menorDistancia.cluster1);
        listaClusters.remove(menorDistancia.cluster2);
        novoCluster= new Cluster(menorDistancia.cluster1, menorDistancia.cluster2);
        listaClusters.add(novoCluster);
    }
}
