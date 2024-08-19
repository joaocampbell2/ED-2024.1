package Ex2;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {5,9,6,7};

        HeapBinariaMinima heapMin = new HeapBinariaMinima(vetor.length,vetor);

        HeapBinariaMaxima heapMax = new HeapBinariaMaxima(heapMin);
        heapMax.imprime();


        heapMin = new HeapBinariaMinima(heapMax);
        heapMin.imprime();



    }





}
