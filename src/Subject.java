/*
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
