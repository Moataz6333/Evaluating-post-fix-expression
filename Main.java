import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the postfix expression :");

Stack<String> a = new Stack<>(); //23+45+*  = (2+3)*(4+5) =45
        a.push("2");
        a.push("3");
        a.push("+");
        a.push("4");
        a.push("5");
        a.push("+");
        a.push("*");

        evaluate(a);





    }
    public static void evaluate(Stack<String> s){
        reverse(s);
        Stack<Double> valu = new Stack<>();
        double c1 =0;
        double c2 = 0;
        double res =0;
        while(!s.isEmpty()){
            char c = s.peek().charAt(0);
            if(Character.isDigit(c)){
                double n = Integer.parseInt(s.pop());
                valu.push(n);
            }else {

                switch (s.pop()) {
                    case "+":
                         c2 = valu.pop();
                         c1 = valu.pop();
                        res = c1 +c2 ;
                        valu.push(res);
                        break;

                    case "-":
                         c2 = valu.pop();
                         c1 = valu.pop();
                        res= c1-c2;
                        valu.push(res);
                        break;
                    case "*":
                         c2 = valu.pop();
                         c1 = valu.pop();
                        res= c1*c2;
                        valu.push(res);
                        break;
                    case "/":
                         c2 = valu.pop();
                         c1 = valu.pop();
                        res = c1/c2;
                        valu.push(res);
                        break;
                    case "^":
                         c2 = valu.pop();
                         c1 = valu.pop();
                        res = Math.pow(c1,c2);
                        valu.push(res);
                        break;

                    default:

                        break;
                }
            }
        }
        System.out.println(valu.peek());
    }


    public static <T> void reverse(Stack<T>  s){   // a method for reversing a stack

        Stack<T> tmp1 = new Stack<>();
        Stack<T> tmp2 = new Stack<>();
        while(!s.isEmpty()){
            tmp1.push(s.pop());
        }
        while (!tmp1.isEmpty()){
            tmp2.push(tmp1.pop());
        }
        while(!tmp2.isEmpty()){
            s.push(tmp2.pop());
        }
    }



}