/**
 * Program2
 * Created by jeffrey hammond on 2/12/17.
 */
import java.util.ArrayList;

public class Average implements Observer {
    private ArrayList subscribed = new ArrayList();

    Average(Subject s) {
        subscribed.add(s);
        s.addObserver(this);
    }

    @Override
    public void update(Subject s, Snapshot ss) {
        if (subscribed.contains(s)) {
            double avg = 0;
            int count = 0;
            for (Ticker ticker: ss.getTickers()) {
                avg += ticker.getPrice();
                count++;
            }
            avg = avg/count;
            System.out.print(ss.getDate());
            System.out.println(", Average price: " + avg);
        }
    }
}
