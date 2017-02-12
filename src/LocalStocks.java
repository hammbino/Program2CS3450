/**
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */

import java.util.ArrayList;

public class LocalStocks implements Subject {
    private ArrayList<Observer> observers;
    private Snapshot snapshot;

    public LocalStocks() {
        this.observers = new ArrayList<Observer>();
        this.snapshot = new Snapshot();
    }

    public void updateSnapshot (ArrayList<String> snapshotData) {
        snapshot.update();
        for (String s: snapshotData) {
            if (s.matches("(Last).*")) {
                snapshot.setData(s);
            } else {
                Ticker ticker = new Ticker(s);
                snapshot.addTicker(ticker);
            }
        }
        //To Test print Snapshot
//        snapshot.printSanpshot();
        notifyObservers();
    }


    public Snapshot getSnapshot() {
        return snapshot;
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
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

    @Override
    public String toString() {
        return String.format("LocalStocks");
    }
}
