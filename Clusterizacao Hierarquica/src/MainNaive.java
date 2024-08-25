import java.util.ArrayList;

public class MainNaive {
    public static void main(String[] args) {


        // GERADOR DE PONTOS

        int n = 5;

        GeradorPontos geradorPontos = new GeradorPontos();

        ArrayList<Cluster> listaClusters = geradorPontos.gerarPontos(n);
        System.out.println(listaClusters.size());
        // METODO NAIVE
        long tempoIni = System.currentTimeMillis();


        while (listaClusters.size() != 1){

            clusterizar(listaClusters);

        }


        long tempoFim = System.currentTimeMillis();
        long duracao = tempoFim - tempoIni;
        System.out.println("\nTempo total de execucao: " + duracao + " milissegundos");

        listaClusters.getFirst().mostra();


        // METODO HEAP


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
