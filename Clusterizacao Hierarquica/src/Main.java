import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random gerador = new Random();

        ArrayList<Cluster> listaClusters = new ArrayList<Cluster>();
        int n = 10;
        for (int i = 0; i<n; i++){
            double x, y;
            x = gerador.nextDouble(n-1)+ 1;
            y = gerador.nextDouble(n-1)+ 1;
            Cluster cluster = new Cluster(x,y);
            listaClusters.add(cluster);
        }




        while (listaClusters.size() != 1){

            double menorDistancia = Integer.MAX_VALUE;
            Cluster menorCluster1 = listaClusters.getFirst();
            Cluster menorCluster2 = listaClusters.getFirst();
            Cluster novoCluster;
            double distanciaAtual;

            for(int i = 0; i< listaClusters.size() ;i++){
                Cluster clusterI = listaClusters.get(i);
                for (int j = 0; j < listaClusters.size(); j++){
                    Cluster clusterJ = listaClusters.get(j);
                    if (clusterI != clusterJ){
                         distanciaAtual = clusterI.calculaDistancia(clusterJ);
                        if (distanciaAtual < menorDistancia){
                            menorDistancia = clusterI.calculaDistancia(clusterJ);
                            menorCluster1 = clusterI;
                            menorCluster2 = clusterJ;
                        }
                    }
                }
            }
            listaClusters.remove(menorCluster1);
            listaClusters.remove(menorCluster2);
            novoCluster= menorCluster1.criaCluster(menorCluster2);
            listaClusters.add(novoCluster);

            System.out.println(listaClusters);
        }















    }
}
