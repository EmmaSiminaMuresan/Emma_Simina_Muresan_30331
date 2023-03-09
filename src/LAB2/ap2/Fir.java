package LAB2.ap2;

import java.util.Observable;

public class Fir extends Observable implements Runnable {
    Thread t;
    int id;
    Window win;
    int processorLoad;
    int priority;

    public void start(){
        if(t==null){
            t = new Thread(this);
            t.start();
        }
    }


    Fir(int id,int priority,Window win, int procLoad){
        this.id=id;
        this.win=win;
        this.processorLoad=procLoad;
        this.setPriority(priority);

    }

    private void setPriority(int priority) {
        priority = this.priority;
    }

    public void run(){
        int c=0;
        while(c<1000){
            for(int j=0;j<this.processorLoad;j++){
                j++;j--;
            }
            c++;
            this.win.setProgressValue(id, c);
        }
    }
}