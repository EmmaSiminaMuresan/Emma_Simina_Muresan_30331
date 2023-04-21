package LAB4.App2;

public class Main {
    public static void main(String[] args) {
        Integer monitor = 1;
        Integer monitor2 = 1;
        new ExecutionThread(monitor, monitor2, 0, 4, 2, 4, 4, 6).start();
        new ExecutionThread(monitor2, monitor, 3, 5, 3, 5, 5, 7).start();
    }
}