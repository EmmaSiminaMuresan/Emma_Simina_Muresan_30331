package LAB4.App3;

public class Main {
    public static void main(String[] args) {
        Integer monitor = 1;
        new ExecutionThread("Thread-0", monitor, 0, 3, 4, 7).start();
        new ExecutionThread("Thread-1", monitor, 0, 6, 5, 7).start();
        new ExecutionThread("Thread-2", monitor, 0, 5, 3, 6).start();
    }
}
