package LAB4.App4;
class ExecutionSecondaryThread extends Thread{
    Integer monitor;
    int activity_min, activity_max;
    Thread T;

    public ExecutionSecondaryThread(String name, Integer monitor, int activity_min, int activity_max, Thread T) {
        super(name);
        this.monitor = monitor;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.T = T;
    }
    public void run(){
        System.out.println(this.getName()+" -STATE 1");
        synchronized (monitor){
            try {
                monitor.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.getName()+" -STATE 2");
        int k = (int) Math.round(Math.random() * (activity_max - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        System.out.println(this.getName()+" -STATE 3");
        try {
            if (T != null) T.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}