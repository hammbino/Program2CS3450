/**
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */

public interface Observer {
    public void update(Subject s, Snapshot ss);
    public void addSubject(Subject s);
}
