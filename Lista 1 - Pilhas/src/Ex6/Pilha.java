package Ex6;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

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

    public String inverteFrase(){

        ArrayList<String> vetorInvertido = new ArrayList<>();
        String palavra = "";
        char letra;

        do{
            letra = this.pop();

            if (letra != ' '){
                palavra += Character.toString(letra);

            }
            else{

                vetorInvertido.add(palavra);

                palavra = "";

            }
        }while (!this.vazia());

        vetorInvertido.add(palavra);
        String  fraseInvertida = "";


        for(int i = vetorInvertido.size() - 1; i>= 0; i--){
            fraseInvertida += vetorInvertido.get(i);
            if (i!= 0){
                fraseInvertida += " ";
            }
        }

        return fraseInvertida;
    }

}

