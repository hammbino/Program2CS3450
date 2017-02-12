/**
 * Program2
 * Created by jeffreyhammond on 2/11/17.
 */
public interface Subject {
    public void addObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
