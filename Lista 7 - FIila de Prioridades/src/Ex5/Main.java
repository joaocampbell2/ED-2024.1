package Ex5;

import Ex2.HeapBinariaMinima;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {5,9,6,7,1,10};


        Ex5.HeapBinariaMaxima heapMax = new HeapBinariaMaxima(vetor.length,vetor);
        heapMax.imprime();
        heapMax.remove(2);
        heapMax.imprime();


    }





}
