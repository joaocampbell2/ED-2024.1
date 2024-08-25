public class Cluster {
    private double pontoX;
    private double pontoY;

    private Cluster filhoEsq;
    private Cluster filhoDir;

    public Cluster (double pontoX, double pontoY){
        this.pontoX = pontoX;
        this.pontoY = pontoY;
        this.filhoEsq = null;
        this.filhoDir = null;
    }
    public Cluster(Cluster cluster1, Cluster cluster2){
        this.pontoX = (cluster1.getPontoX() + cluster2.getPontoX())/2;
        this.pontoY = (cluster1.getPontoY() + cluster2.getPontoY())/2;
        this.filhoEsq = cluster1;
        this.filhoDir = cluster2;
    }

    public double calculaDistancia(Cluster outroCluster){
        return Math.sqrt(Math.pow(this.pontoX - outroCluster.getPontoX(),2) +  Math.pow(this.pontoY - outroCluster.getPontoY(),2));
    }

    @Override
    public String toString() {
        return
                "pontoX= " + pontoX +
                        " pontoY= " + pontoY;
    }

    public void mostra()
    {
        System.out.print(" < X= " + pontoX + " Y= " + pontoY);
        if (filhoEsq != null)
            filhoEsq.mostra();
        if (filhoDir != null)
            filhoDir.mostra();
        System.out.print(" >");
    }

    public double getPontoX() {
        return pontoX;
    }

    public double getPontoY() {
        return pontoY;
    }
}
