/**
 * Program2
 * Created by jeffreyhammond on 2/12/17.
 */
import java.util.ArrayList;

public class Change10 implements Observer {
    private ArrayList subscribed = new ArrayList();

    Change10(Subject s) {
        subscribed.add(s);
        s.addObserver(this);
    }

    //A report that displays all companies that have had a price change of 10% or more.
    // List the ticker symbol, the price and the percentage change.
    @Override
    public void update(Subject s, Snapshot ss) {
        System.out.println(ss.getDate());
        if (subscribed.contains(s)) {
            for (Ticker ticker: ss.getTickers()) {
                if (ticker.getPercentChanged() >= 10 || ticker.getPercentChanged() <= -10) {
                    System.out.printf("%s %.2f %.2f\n", ticker.getSymbol(), ticker.getPrice(), ticker.getPercentChanged());
                }
            }
            System.out.println();
        }
    }
}
