package LAB3.example3;

public class JoinTestThread extends Thread{
    Thread t;

    JoinTestThread(String n, Thread t){

        this.setName(n);

        this.t=t;

    }

    public void run() {

        System.out.println("Thread "+this.getName()+" has entered the run() method");

        try {

            if (t != null) t.join();

            System.out.println("Thread "+this.getName()+" executing operation.");

            Thread.sleep(3000);

            System.out.println("Thread "+this.getName()+" has terminated operation.");

        }

        catch(Exception e){e.printStackTrace();}

    }

    public double dividers(int n, double sum){
        for(int i = 1; i<n; i++) {
            if(n % i == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
