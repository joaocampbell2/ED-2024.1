package Ex3;

public class Main3 {
    public static void main(String[] args) {
        Pilha pilha1 = new Pilha(2);
        Pilha pilha2 = new Pilha(3);

        pilha1.push('a');
        pilha1.push('b');
        pilha2.push('c');
        pilha2.push('d');
        pilha2.push('e');

        char[] vetor = juntar(pilha1,pilha2);

    }

    static char[] juntar(Pilha pilha1, Pilha pilha2){
        int tamanho = pilha1.getN() + pilha2.getN();
        char[] vetor = new char[tamanho];
        int i = 0;
        while(!pilha1.vazia()){
            vetor[i] = pilha1.pop();
            i++;
        }
        i = tamanho - 1;
        while(!pilha2.vazia()){
            vetor[i] = pilha2.pop();
            i--;
        }

        return vetor;
    }
}

