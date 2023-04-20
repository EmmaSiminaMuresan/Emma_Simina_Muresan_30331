package LAB4.App1;


public class Main {
    public static void main(String[] args) {
        Integer monitor = 1;
        Integer monitor2 = 1;
        new ExecutionThread("Thread-0", monitor, 0, 0, 4, 2, 4).start();
        new ExecutionThread("Thread-2", monitor, monitor2, 0, 3, 3, 6).start();
        new ExecutionThread("Thread-1", monitor2, 0, 0, 5, 2, 5).start();
    }
}