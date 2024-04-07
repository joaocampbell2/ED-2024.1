package Ex5;

public class Main5 {
    public static void main(String[] args) {

        representaBinario(16);
    }

    public static void representaBinario(int n){
        FilaDupla fila = new FilaDupla(100);
        int j;
        for(int i = 1; i<=n;i++){
            j = i;
            while(j != 0){
                fila.insereInicio(j % 2);
                j /= 2;
            }
            System.out.print("Numero " + i + ": ");
            while (!fila.vazia()){
                System.out.print(fila.remove());
            }
            System.out.println(" ");

        }
    }
}
