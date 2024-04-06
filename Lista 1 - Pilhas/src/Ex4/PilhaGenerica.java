package Ex4;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Vector;

public class PilhaGenerica<T> {
    private int n;
    private Vector<T> vetor;
    private int topo;

    public PilhaGenerica(int tamanho) {
        this.n = tamanho;
        this.vetor = new Vector(tamanho);
        this.topo = -1;
    }

    public boolean vazia() {
        return this.topo == -1;
    }

    public boolean cheia() {
        return this.topo == this.n - 1;
    }

    public T pop() {
        if (!this.vazia()) {
            T elemento = this.vetor.get(this.topo--);
            return elemento;
        } else {
            System.out.println("Pilha vazia: pop nao funcionou.");
            return null;
        }
    }

    public boolean push(T elemento) {
        if (!this.cheia()) {
            this.vetor.add(++this.topo, elemento);
            return true;
        } else {
            System.out.println("Pilha cheia: push nao funcionou.\n");
            return false;
        }
    }

    public boolean retornaTopo(T elemento) {
        if (!this.vazia()) {
            elemento = this.vetor.get(this.topo);
            return true;
        } else {
            return false;
        }
    }

    public void removerElemento(T elemento){
        PilhaGenerica<T> aux = new PilhaGenerica<>(this.n);
        T elem;
        do {
            elem = this.pop();
            if (elemento.equals(elem)){
                break;
            }
            aux.push(elem);

        }  while (!this.vazia());
        do{
            this.push(aux.pop());
        }while(!aux.vazia());

    }
}

