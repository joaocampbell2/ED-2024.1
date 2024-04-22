package Ex4;

public class Main {
    public static void main(String[] args) {
        Pilha pilha = new Pilha(10);

        for(int i = 1; i < 10; i++){
            pilha.push(i);
        }

        System.out.println(pilha.quantNumerosPares());

        pilha.pop();
        pilha.pop();

        System.out.println(pilha.quantNumerosPares());

    }
}
