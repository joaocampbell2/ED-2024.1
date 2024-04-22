package Ex4;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Pilha {
    private int n;
    private int[] vetor;
    private int topo;

    private int pares;
    public Pilha() {
        this.n = 10;
        this.vetor = new int[this.n];
        this.topo = -1;
        pares = 0;
    }

    public Pilha(int tamanho) {
        this.n = tamanho;
        this.vetor = new int[tamanho];
        this.topo = -1;
        pares= 0;
    }

    public boolean vazia() {
        return this.topo == -1;
    }

    public boolean cheia() {
        return this.topo == this.n - 1;
    }

    public int pop() {
        int c = 0;
        if (!this.vazia()) {
            c = this.vetor[this.topo];
            --this.topo;
        } else {
            System.out.println("Pilha vazia: pop não funcionou.");
        }
        if(c % 2 ==0){
            pares--;
        }
        return c;
    }

    public boolean push(int elemento) {
        if (!this.cheia()) {
            this.vetor[++this.topo] = elemento;
            if(elemento % 2 == 0){
                pares++;
            }

            return true;

        } else {
            System.out.println("Pilha cheia: push não funcionou.\n");
            return false;
        }
    }

    public int retornaTopo() {
        int elemento = 0;
        if (!this.vazia()) {
            elemento = this.vetor[this.topo];
        } else {
            System.out.println("Pilha vazia.");
        }

        return elemento;
    }
    
    public int quantNumerosPares(){
        return this.pares;
    }
    







}

