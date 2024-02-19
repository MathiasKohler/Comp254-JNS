import java.util.Scanner;

public class RecPalin {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter String to Check for Palindrome");
        String string = scanner.nextLine();
        if(PalinRec(string)) {
            System.out.println(string+" is a palindrome");
        }else {
            System.out.println(string + " absolutely not a palindrome!!!!");
        }

    }
    public static boolean PalinRec(String string)
    {
        int n = string.length();
        if (n == 0)
        {
            return true;
        }
        return isPalinRec(string.toLowerCase(),0,n-1);
    }
    public static boolean isPalinRec(String string,int start, int end)
    {
        if( start == end)
        {
            return true;
        }
        if(string.charAt(start)!= string.charAt(end))
        {
            return false;
        }
        if(start < end +1)
        {
            return isPalinRec(string,start+1,end -1);
        }
        return true;
    }
}
