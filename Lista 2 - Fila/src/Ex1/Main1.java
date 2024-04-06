package Ex1;

public class Main1 {

    public static void main(String[] args) {
        Processo p1 = new Processo(1), p2 = new Processo(2);

        SistemaOperacional so = new SistemaOperacional(2);

        so.addProcesso(p1);
        so.addProcesso(p2);

        so.imprimeProcessos();

        so.retiraProcesso();
        so.imprimeProcessos();
    }





}
