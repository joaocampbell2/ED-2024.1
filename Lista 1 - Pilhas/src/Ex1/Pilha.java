package Ex1;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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

    public boolean verificarPilha(String a){


        int j = 0;
        int tamanho = a.length() - 3;
        char[] letras = new char[tamanho];
        String b = "", c = "";
        char letra;


        for (int i = 0;i < tamanho; i++) {
            letra = this.pop();
            System.out.println(letra);
            if (letra == 'A' || letra == 'B') {
                letras[i] = letra;
            }
            else if(letra == ' ' && a.charAt(i+1) == 'C' && a.charAt(i+2) == ' ' ){
                this.pop();
                this.pop();
                letras[i] = this.pop();
            }
            else{
                return false;
            }
        }

        for (int i = 0;i < tamanho/2; i++){
            b+= letras[i];
        }

        for(int i = tamanho - 1; i>= tamanho/2 ;i--){
            c+= letras[i];
        }

        if(c.equals(b)) {
            return true;
        }
        return false;

    }





}

