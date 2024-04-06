package Ex7;

import static java.lang.Character.isDigit;

public class Main7 {
    public static void main(String[] args){
        String expressao = "(1+((2+3)*(4*5)))";
        PilhaGenerica<Integer> pilha = new PilhaGenerica(expressao.length());

        calculaExpressao(expressao);




    }

    public static void calculaExpressao(String expressao){
        char elem,operador;
        int  op1, op2;
        PilhaGenerica<Character> operadores = new PilhaGenerica(expressao.length());
        PilhaGenerica<Integer> operando = new PilhaGenerica(expressao.length());

        for (int i = 0;i< expressao.length();i++){
            elem = expressao.charAt(i);
            if (isDigit(elem)){
                operando.push((int) elem - '0');

            }
            if(elem == '*' || elem == '+' || elem == '-'  || elem == '/' ){
                operadores.push(elem);
            }
            else if(elem == ')'){
                operador = operadores.pop();
                op2 =  operando.pop();
                op1 =  operando.pop();
                switch (operador){
                    case '+':
                        operando.push(op1 + op2);
                        break;
                    case '-':
                        operando.push((op1 - op2));
                        break;
                    case '*':
                        operando.push((op1 * op2));
                        break;
                    case '/':
                        operando.push((op1 / op2));
                        break;
                }
            }
        }

        System.out.println("Resultado: " + operando.pop());


    }
}
