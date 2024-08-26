package Ex3;

public class Main {
    public static void main(String[] args) {
        RedBlackBST<Integer,Integer> arvore = new RedBlackBST<Integer,Integer>();

        arvore.put(5,5);
        arvore.put(8,8);
        arvore.put(6,6);
        arvore.put(12,12);
        arvore.put(1,1);

        System.out.println(arvore.alturaNegra());
        arvore.mostra();


    }
}
