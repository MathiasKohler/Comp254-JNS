//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Question 1");
        DoublyLinkedList<String> strings1 = new DoublyLinkedList<>();
        strings1.addLast("First");
        strings1.addLast("Second");
        strings1.addLast("Third");
        strings1.addLast("Fourth");
        System.out.println(strings1);
        DoublyLinkedList<String> strings2 = new DoublyLinkedList<>();
        strings2.addLast("Head");
        strings2.addLast("Fifth");
        strings2.addLast("Sixth");
        strings2.addLast("Seventh");
        System.out.println(strings2);

        strings1.Concatenation(strings2);
        System.out.println(strings1);

        System.out.println("Question 2");
        SinglyLinkedList<String> strings3 = new SinglyLinkedList<>();
        strings3.addLast("SFirst");
        strings3.addLast("SSecond");
        strings3.addLast("SThird");
        strings3.addLast("SFourth");
        strings3.addLast("SFifth");

        System.out.println(strings3);
        strings3.SwapNodes(2,4);
        System.out.println(strings3);

        System.out.println("Question 3");
        CircularlyLinkedList<String> strings4 = new CircularlyLinkedList<>();
        strings4.addLast("CFirst");
        strings4.addLast("CSecond");
        strings4.addLast("CThird");
        strings4.addLast("CFourth");
        strings4.addLast("CFifth");
        System.out.println(strings4);

        CircularlyLinkedList<String> strings5 = strings4.clone();
        //test if cloned
        System.out.println(strings5);
        System.out.println("Verify Cloning");
        //add to string 4 again, to check if new object is independent
        strings4.addLast("CSixth");
        System.out.println(strings4);
        System.out.println(strings5);

    }


}