package Ex4;

import Ex1.Processo;

public class Fila
{
	/* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected int[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */
	
	public Fila(int tam)
	{
		tamanho = tam;
		vetor = new int[tamanho];
		ini = 0;
		n = 0;
	}

	public Fila(){

	}

	public boolean vazia()
	{
		return (n == 0);
	}
	
	public boolean cheia()
	{
		return (n == tamanho);
	}
	
	//Retiramos o elemento do in�cio da fila
	public int remove()
	{
		int elem = Integer.MIN_VALUE;
		
		if (!this.vazia())
		{
			elem = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return elem;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(int elem)
	{
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = elem;
	    n++;
	    return true;
	  } 
	  else
	    return false;
	}

	public int getTamanho() {
		return tamanho;
	}

	public int getN() {
		return n;
	}


	static FilaDupla simplesPraDupla(Fila fila){
		FilaDupla filaDupla = new FilaDupla(fila);
		return filaDupla;
	}
}