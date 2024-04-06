package Ex1;

import Ex1.Fila;

public class SistemaOperacional
{
	private Fila processos;

	public SistemaOperacional(int tamanho){
		processos = new Fila(tamanho);
	}

	public void addProcesso(Processo processo){
		processos.insere(processo);
	}

	public Processo retiraProcesso(){
		return processos.remove();
	}

	public void imprimeProcessos(){
		Processo processo;
		System.out.println("Processos na Fila: ");

		for (int i = 0; i < processos.getN(); i++){
			processo = processos.remove();
			System.out.println("Processo nº: " + processo.getNumeroIdentificador());
			processos.insere(processo);

		}

	}

}