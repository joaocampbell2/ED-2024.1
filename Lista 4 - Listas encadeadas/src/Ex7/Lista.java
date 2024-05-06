package Ex7;

public class Lista
{
	/* Refer�ncia para primeiro elemento */
	protected Elo prim;
	
	protected class Elo
	{
		protected Inimigo dado;
		protected Elo prox;
		
		public Elo()
		{
			prox = null;
		}
		
		public Elo(Inimigo elem)
		{
			dado = elem;
			prox = null;
		}
		
		public Elo(Inimigo elem, Elo proxElem)
		{
			dado = elem;
			prox = proxElem;
		}
	}
	
	public Lista()
	{
		prim = null;
	}
	
	/* Testa se a lista est� vazia. */
	public boolean vazia()
	{
		return prim == null;
	}
	
	/* Complexidade O(1) */
	public void insere(Inimigo inimigo)
	{
		Elo p = new Elo(inimigo);
		p.prox = prim;
		prim = p;
	}
	
	/* Complexidade O(n) */

	public Inimigo localizar(Inimigo inimigo)
	{
		Elo p;
		
		for(p = prim; p != null; p = p.prox)
		{
			if(p.dado == inimigo)
				return p.dado;
		}
		System.out.println("Inimigo não encontrado");
		return null;
	}


	public int efetuarDano(Inimigo inimigo, double dano){
		Inimigo localizado = localizar(inimigo);

		int vidaAtual = (int) (inimigo.getVida() - dano);

		localizado.setVida(vidaAtual);

		if (localizado.getVida() <= 0){

		}

		return vidaAtual;
	}



}