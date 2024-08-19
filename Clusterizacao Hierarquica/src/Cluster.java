public class Cluster {
    private double pontoX;
    private double pontoY;

    public Cluster (double pontoX, double pontoY){
        this.pontoX = pontoX;
        this.pontoY = pontoY;
    }

    public double calculaDistancia(Cluster outroCluster){
        return Math.sqrt(Math.pow(this.pontoX - outroCluster.getPontoX(),2) +  Math.pow(this.pontoY - outroCluster.getPontoY(),2));
    }

    public Cluster criaCluster(Cluster outroCluster){
        double x = (this.pontoX + outroCluster.getPontoX())/2;
        double y = (this.pontoY + outroCluster.getPontoY())/2;
        return new Cluster(x,y);
    }

    @Override
    public String toString() {
        return
                "pontoX= " + pontoX +
                " pontoY= " + pontoY;
    }

    public double getPontoX() {
        return pontoX;
    }

    public double getPontoY() {
        return pontoY;
    }
}
