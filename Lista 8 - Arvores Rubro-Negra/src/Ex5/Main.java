package Ex5;

import Ex3.RedBlackBST;

public class Main {
    public static void main(String[] args) {
        Ex3.RedBlackBST<Integer,Integer> arvore = new RedBlackBST<Integer,Integer>();

        arvore.put(5,5);
        arvore.put(8,8);
        arvore.put(6,6);
        arvore.put(12,12);
        arvore.put(1,1);


        arvore.mostra();

    }
}
