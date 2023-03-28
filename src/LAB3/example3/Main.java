package LAB3.example3;
import java.util.Scanner;

public class Main {
    static double sum = 0;
    public static void main(String[] args){

        JoinTestThread w1 = new JoinTestThread("Thread 1",null);
        JoinTestThread w2 = new JoinTestThread("Thread 2",w1);

        w1.start();
        w2.start();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number greater than 50 000:");
        int num = sc.nextInt();

        sum = w1.dividers(num,sum);
        System.out.println("For n =  "+num+", the sum is: "+sum);

        System.out.println("Enter a number greater than 20 000:");
        num = sc.nextInt();
        sum =  w2.dividers(num,sum);
        System.out.println("For n =  "+num+", the sum is: "+sum);

    }
}
