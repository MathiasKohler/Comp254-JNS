//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class RecursiveMultiplication {
    public static void main(String[] args) {
        System.out.println("Question 1:");
        System.out.println("Test Product of 20 and 10");

        System.out.println("Product is: "+ RecursiveProduct(20,10));
        System.out.println("Product is: "+ RecursiveProduct(10,20));

    }

    public static int RecursiveProduct(int m, int n)
    {
        if(m < 0 || n <0) {
            return 0;
        }
        if(m == 0 || n==0)
        {
            return 0;
        }
        return m + RecursiveProduct(m,n-1);
    }
}