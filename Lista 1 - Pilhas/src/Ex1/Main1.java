package Ex1;



import Ex1.Pilha;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args){
        String a, b;

        Scanner ent = new Scanner(System.in);


        a = "BABABA C ABABAB";

        Pilha pilha = new Pilha(a.length());

        for (int i = 0; i< a.length(); i++){
            pilha.push(a.charAt(i));
        }


        System.out.println(pilha.verificarPilha(a));


    }



}
