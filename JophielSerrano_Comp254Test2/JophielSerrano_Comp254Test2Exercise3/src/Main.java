import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        LinkedQueue<Account> accountQueue = new LinkedQueue<>();

        accountQueue.enqueue(new Account(10001,"Jasper",101.20));
        accountQueue.enqueue(new Account(10007,"Manu",1010.20));
        accountQueue.enqueue(new Account(10004,"Jophiel",1201.20));
        accountQueue.enqueue(new Account(10002,"Reynaldo",1091.20));
        accountQueue.enqueue(new Account(10008,"Aleli",1011.20));
        accountQueue.enqueue(new Account(10009,"Donalda",1401.20));
        accountQueue.enqueue(new Account(10010,"Daking",1021.20));

        QuickSort.quickSort(accountQueue, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                if(o1.accountNumber > o2.accountNumber)
                {
                    return 1;
                }else {return 0;}
            }
        });



    }
}
