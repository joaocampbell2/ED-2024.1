public class Distancia {
    public double valDistancia;

    public Cluster cluster1;
    public Cluster cluster2;


    public Distancia(Distancia distancia){
        this.valDistancia = distancia.valDistancia;
        this.cluster1 = distancia.cluster1;
        this.cluster2 = distancia.cluster2;
    }

    public Distancia(double valDistancia) {
        this.valDistancia = valDistancia;
        this.cluster1 = null;
        this.cluster2 = null;
    }

    public Distancia(Cluster cluster1, Cluster cluster2){
        this.cluster1 = cluster1;
        this.cluster2 = cluster2;
        this.valDistancia = calculaDistancia();

    }

    private double calculaDistancia(){


        return Math.sqrt(Math.pow(this.cluster1.getPontoX() - this.cluster2.getPontoX(),2) +  Math.pow(this.cluster1.getPontoY() - this.cluster2.getPontoY(),2));

    }

}
