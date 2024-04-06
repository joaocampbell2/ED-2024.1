package Ex3;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.HashMap;

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

    public int getN() {
        return n;
    }
}

