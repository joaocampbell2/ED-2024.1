package Ex3;

public class Main {
    public static void main(String[] args) {
        PilhaGenerica p1 = new PilhaGenerica<>(2), p2 = new PilhaGenerica<>(3);
        PilhaGenerica pilhaGenerica;
        FilaGenerica filaGenerica = new FilaGenerica(2),  filaGenerica2 = new FilaGenerica<>(2);
        FilaGenerica f1 = new FilaGenerica(2),f2 = new FilaGenerica<>(2);

        p1.push(1);
        p1.push(2);
        p2.push(3);
        p2.push(4);

        filaGenerica.insere(p1);
        filaGenerica.insere(p2);

        while (!filaGenerica.vazia()){
            pilhaGenerica = (PilhaGenerica) filaGenerica.remove();

            while (!pilhaGenerica.vazia()){
                System.out.println(pilhaGenerica.pop());
            }
        }


        f1.insere(1);
        f1.insere(2);
        f2.insere(3);
        f2.insere(4);

        pilhaGenerica = new PilhaGenerica<>(2);

        pilhaGenerica.push(f1);
        pilhaGenerica.push(f2);

        while (!pilhaGenerica.vazia()){
            filaGenerica = (FilaGenerica) pilhaGenerica.pop();

            while (!filaGenerica.vazia()){
                System.out.println(filaGenerica.remove());
            }
        }

        f1.insere(1);
        f1.insere(2);
        f2.insere(3);
        f2.insere(4);

        filaGenerica = new FilaGenerica<>(2);

        filaGenerica.insere(f1);
        filaGenerica.insere(f2);




        while (!filaGenerica.vazia()){
            filaGenerica2 = (FilaGenerica) filaGenerica.remove();

            while (!filaGenerica2.vazia()){
                System.out.println(filaGenerica2.remove());
            }
        }


    }
}