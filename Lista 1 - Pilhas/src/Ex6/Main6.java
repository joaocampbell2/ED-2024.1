package Ex6;

import java.util.Scanner;

public class Main6 {
    public static void main(String[] args){

        Scanner ent = new Scanner(System.in);

        String frase = ent.nextLine();

        Pilha pilha = new Pilha(frase.length());

        for (int i = 0; i< frase.length(); i++){
            pilha.push(frase.charAt(i));
        }

        String fraseInvertida = pilha.inverteFrase();

        System.out.println(fraseInvertida);

    }




}
