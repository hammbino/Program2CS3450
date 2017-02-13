/*
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */
import java.util.ArrayList;

class LocalStocks implements Subject {
    private ArrayList<Observer> observers;
    private Snapshot snapshot;

    LocalStocks() {
        this.observers = new ArrayList<>();
        this.snapshot = new Snapshot();
    }

    void updateSnapshot(Snapshot snapshot) {
        this.snapshot = snapshot;
        notifyObservers();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
        o.addSubject(this);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if(i >= 0) {
            observers.remove(i);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this, snapshot);
        }
    }
}
