package LAB2.ap2;


public class Controller {
    Fir f;
    Window w;

    public Controller(Fir t,Window w){
        f.addObserver(w);
        this.f = f;
        this.w = w;
    }
}
