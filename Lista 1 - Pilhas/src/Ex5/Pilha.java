package Ex5;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Pilha {
    private int n;
    private char[] vetor;
    private int topo;

    public Pilha() {
        this.n = 10;
        this.vetor = new char[this.n];
        this.topo = -1;
    }

    public Pilha(int tamanho) {
        this.n = tamanho;
        this.vetor = new char[tamanho];
        this.topo = -1;
    }

    public boolean vazia() {
        return this.topo == -1;
    }

    public boolean cheia() {
        return this.topo == this.n - 1;
    }

    public char pop() {
        char c = 0;
        if (!this.vazia()) {
            c = this.vetor[this.topo];
            --this.topo;
        } else {
            System.out.println("Pilha vazia: pop não funcionou.");
        }

        return c;
    }

    public boolean push(char elemento) {
        if (!this.cheia()) {
            this.vetor[++this.topo] = elemento;
            return true;
        } else {
            System.out.println("Pilha cheia: push não funcionou.\n");
            return false;
        }
    }

    public char retornaTopo() {
        char elemento = 0;
        if (!this.vazia()) {
            elemento = this.vetor[this.topo];
        } else {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }

    public boolean eBalanceado(){

        char letra;
        ArrayList<Character> especiais = new ArrayList<>();
        while(!this.vazia()){
            letra = this.pop();
            if (letra == '{' ||letra == '}' ||letra == '[' ||letra == ']' ||letra == '(' ||letra == ')'){
                especiais.add(letra);
            }
        };

        System.out.println(especiais);

        if(especiais.size() % 2 == 1){
            return false;
        }
        HashMap<Character,Character> dict = new HashMap();
        dict.put('}', '{');
        dict.put(')', '(');
        dict.put(']', '[');

        char x;
        int index = 0;
        while(!especiais.isEmpty()){
            x = especiais.get(index);
            if (x == '}' || x == ']' || x == ')' ){
                for(int i = 1; i<= especiais.size() - 1; i++) {
                    if(especiais.get(i) == dict.get(x)){
                        especiais.remove(i);
                        especiais.remove(index);
                        index = 0;
                        break;
                    }
                    else if((especiais.get(i) == '{' || especiais.get(i) == '[' || especiais.get(i) == '(')){
                        return false;
                    }
                    else{
                        x = especiais.get(i);
                        index = i;
                    }

                }

            }
            else {
                return false;
            }
        }

       return true;
    }

}

