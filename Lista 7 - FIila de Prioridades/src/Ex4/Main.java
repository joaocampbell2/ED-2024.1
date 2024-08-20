package Ex4;

public class Main {
    public static void main(String[] args) {
        int[] vetor = {9,4,6,5};

        System.out.println(verificaPropriedadeDeHeap(vetor));

    }


    public static boolean verificaPropriedadeDeHeap(int[] vetor){
        int filhoEsq, filhoDir;
        int [] novoVetor = new int[vetor.length + 1];

        for (int i = 0; i < vetor.length; i++){
            novoVetor[i+ 1] = vetor[i];
        }

        for (int i = novoVetor.length/2; i > 0;i--){
            filhoEsq = 2*i;
            filhoDir = 2*i + 1;
            if (novoVetor[i] < novoVetor[filhoEsq] ){
                return false;
            }
            if (filhoDir < novoVetor.length){
                if (novoVetor[i] < novoVetor[filhoDir] ){
                    return false;
                }
            }
        }
        return true;
    }
}
