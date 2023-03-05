package LAB2.ap2;

import java.util.Observable;

public class Model extends Observable {
    public void updateModel() {
        setChanged();
        notifyObservers();
    }
}
