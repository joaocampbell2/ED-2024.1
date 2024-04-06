package Ex1;
public class Fila
{
	/* Atributos protected para serem usados na subclasse. */
	protected int tamanho;	/* Tamanho do vetor */
	protected Processo[] vetor;	/* Vetor de elementos */
	protected int ini;	/* Posicao do proximo elemento a ser retirado */
	protected int n;	/* Numero de elementos na fila */
	
	public Fila(int tam)
	{
		tamanho = tam;
		vetor = new Processo[tamanho];
		ini = 0;
		n = 0;
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
	public Processo remove()
	{
		Processo processo = null;
		
		if (!this.vazia())
		{
			processo = vetor[ini];
			ini = (ini + 1) % tamanho;
			n--;
		} 

		return processo;
	}
	
	//Inserimos o elemento no final da fila
	public boolean insere(Processo processo)
	{
	  int fim;
	  
	  if ( !cheia() ) {
	    fim = (ini + n) % tamanho;
	    vetor[fim] = processo;
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
}