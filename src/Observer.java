/**
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */

interface Observer {
    void update(Subject s, Snapshot ss);
    void addSubject(Subject s);
}
