import java.util.Stack;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class StackTransfer {
    public static <E> void transfer(Stack<E> S, Stack<E> T) {
        while (!S.isEmpty()) {
            E element = S.pop();
            T.push(element);
        }
    }
    public static void main(String[] args) {

        Stack<Integer> StackFirst = new Stack<>();
        Stack<Integer> StackDos = new Stack<>();

        for (int i = 1; i <= 5; i++) {
            StackFirst.push(i);
        }
        System.out.println("Before transfer - Stack S: " + StackFirst);
        System.out.println("Before transfer - Stack T: " + StackDos);
        transfer(StackFirst,StackDos);


        System.out.println("After transfer - Stack S: " + StackFirst);
        System.out.println("After transfer - Stack T: " + StackDos);
    }
}