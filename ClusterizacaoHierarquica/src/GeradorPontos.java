import java.util.ArrayList;
import java.util.Random;

public class  GeradorPontos {

    private Random gerador;

    public GeradorPontos(){
        this.gerador = new Random();

    }

    public ArrayList<Cluster> gerarPontos(int n){
        ArrayList<Cluster> listaClusters = new ArrayList<Cluster>();

        for (int i = 0; i<n; i++){
            double x, y;

            x = gerador.nextDouble(n-1)+ 1;
            y = gerador.nextDouble(n-1)+ 1;

            x = i + 1;
            y = i+ 1;

            Cluster cluster = new Cluster(x,y);
            listaClusters.add(cluster);
        }
        return listaClusters;
    }

}
