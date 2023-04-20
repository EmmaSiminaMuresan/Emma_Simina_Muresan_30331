package LAB4.App4;

public class Main {
    public static void main(String[] args) {
        Integer monitor = 1;
        Integer monitor2 = 1;

        ExecutionMainThread T1 = new ExecutionMainThread("Thread-0-Principal", monitor, monitor2, 0, 7, 2, 3);
        ExecutionSecondaryThread T2 = new ExecutionSecondaryThread("Thread-1-Secondary", monitor, 3, 5, T1);
        ExecutionSecondaryThread T3 = new ExecutionSecondaryThread("Thread-2-Secondary", monitor, 4, 6, T1);
        T1.start();
        T2.start();
        T3.start();
    }
}
