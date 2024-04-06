package Ex5;


import Ex5.Pilha;

public class Main5 {
    public static void main(String args[]){
        String frase = "[abcd({)e{efg}]";


        Pilha pilha = new Pilha(frase.length());


        for (int i = 0; i< frase.length(); i++){
            pilha.push(frase.charAt(i));
        }
        System.out.println(frase);
        System.out.println(pilha.eBalanceado());

    }



}


