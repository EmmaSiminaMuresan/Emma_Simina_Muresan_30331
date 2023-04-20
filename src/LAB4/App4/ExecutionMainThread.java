package LAB4.App4;

class ExecutionMainThread extends Thread {
    Integer monitor, monitor2;
    int sleep_min, sleep_max, activity_min, activity_max;

    public ExecutionMainThread(String name, Integer monitor,Integer monitor2, int sleep_min, int sleep_max, int activity_min, int activity_max) {

        super(name);
        this.monitor = monitor;
        this.monitor2 = monitor2;
        this.sleep_min = sleep_min;
        this.sleep_max = sleep_max;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
    }

    public void run() {
        System.out.println(this.getName() + " -STATE 1");
        try {
            Thread.sleep(Math.round(Math.random() * (sleep_max - sleep_min) + sleep_min) * 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this.getName() + " - STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        synchronized (monitor) {
            monitor.notifyAll();
        }
        synchronized (monitor2) {
            monitor2.notifyAll();
        }
        System.out.println(this.getName() + " -STATE 3");
    }
}
