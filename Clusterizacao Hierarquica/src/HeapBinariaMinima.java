import java.util.ArrayList;

public class HeapBinariaMinima
{
	private int n;               /* Numero de elementos no heap. */   
	private int tam;             /* Tamanho máximo do heap. */
	private Distancia[] vetor;          /* Vetor com elementos. */

	private ArrayList<Cluster> listaClusters;
	/* Constrói heap vazio. */

	/* Constrói heap a partir de vetor v. */
	public HeapBinariaMinima(int tamanho, Distancia[] v, ArrayList<Cluster> listaClusters)
	{
		tam = tamanho;
		vetor = new Distancia[tamanho+1];
		n = tamanho;
		this.listaClusters = listaClusters;
		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}

	/* Testa se a fila de prioridade está logicamente vazia.
	   Retorna true se vazia, false, caso contrário. */
	public boolean vazia()
	{
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia()
	{
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime()
	{
		System.out.print("Conteúdo da heap: ");
		
		for(int i = 1; i <= n; i++)
			System.out.print(vetor[i] + " ");

		System.out.println();
	}

	/* Busca o menor item na fila de prioridades.
	   Retorna o menor item em itemMin e true, ou falso se a heap estiver vazia. */
	public Distancia min()
	{
		if (this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return null;
		}

		return vetor[1];
	}

	/* Remove o menor item da lista de prioridades e coloca ele em itemMin. */
	public Distancia removeMin()
	{
		Distancia itemMin;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return null;
		}

		itemMin = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);
		
		return itemMin;
	}
	public void removeDistancias(Cluster cluster1, Cluster cluster2){
		for (int i = 1; i<= n;i++){
			if (vetor[i].cluster1 == cluster1 || vetor[i].cluster1 == cluster2 || vetor[i].cluster2 == cluster2 || vetor[i].cluster2 == cluster1){
				vetor[i] = vetor[n];
				n--;
				i = 0;
			}

		}
		constroiHeap();

		listaClusters.remove(cluster1);
		listaClusters.remove(cluster2);

	}


	/* Método auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitrário dos itens. */
	private void constroiHeap()
	{
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* Método auxiliar para restaurar a propriedade de heap que
	 * não está sendo respeitada pelo nó i. */
	private void refaz(int i)
	{
		Distancia x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, menorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o menor filho é o da esquerda. */
			menorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se é menor que o filho esquerdo. */
				if(vetor[ filhoDir ].valDistancia < vetor[ filhoEsq ].valDistancia)
					menorFilho = filhoDir;
			}

			/* Compara o valor do menor dos filhos com x. */
			if(vetor[ menorFilho ].valDistancia < x.valDistancia)
				vetor [ i ] = vetor[ menorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posição "i" desceu para o nível de baixo, a próxima
			 * iteração vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posição "menorFilho") com um de seus novos filhos. */
			i = menorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * São permitidas duplicatas. */
	public void insere(Distancia x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento é inicialmente inserido na primeira posição disponível
		 * na árvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do nó raiz (de índice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x.valDistancia < vetor[pos/2].valDistancia)
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	public int getN() {
		return n;
	}

	private void incluiDistancias(Cluster novoCluster){
		Distancia novaDistancia;
		for (Cluster cluster: listaClusters){
			novaDistancia = new Distancia(novoCluster, cluster);
			insere(novaDistancia);
		}
		listaClusters.add(novoCluster);
	}

	public void criaCluster(){
		Distancia menorDistancia = removeMin();
		Cluster novoCluster = new Cluster(menorDistancia.cluster1, menorDistancia.cluster2);
		removeDistancias(menorDistancia.cluster1,menorDistancia.cluster2);
		incluiDistancias(novoCluster);

	}

	public ArrayList<Cluster> getListaClusters() {
		return listaClusters;
	}
}