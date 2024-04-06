package Ex4;


public class Main4 {
    public static void main(String [] args){
        String frase = "joao campbell";

        PilhaGenerica pilha = new PilhaGenerica(frase.length());



        pilha.push(1);
        pilha.push(2);
        pilha.push(3);

        pilha.removerElemento(2);


        while(!pilha.vazia()){
            System.out.println(pilha.pop());
        }


    }
}
