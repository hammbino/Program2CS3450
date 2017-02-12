/**
 * Program2
 * Created by jeffreyhammond on 2/12/17.
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Selections implements Observer {
    private ArrayList subscribed = new ArrayList();
    private static ArrayList compsFollowing = new ArrayList(Arrays.asList("ALL", "BA", "BC", "GRBL", "KRT", "MCD", "TR", "WAG"));
    Selections(Subject s) {
        subscribed.add(s);
        s.addObserver(this);
    }

    //A report that displays all companies that have had a price change of 10% or more.
    // List the ticker symbol, the price and the percentage change.
    @Override
    public void update(Subject s, Snapshot ss) {
        System.out.println(ss.getLastUpdate());
        if (subscribed.contains(s)) {
            for (Ticker ticker: ss.getTickers()) {
                if (compsFollowing.contains(ticker.getSymbol())) {
                    System.out.println(ticker);
                }
            }
            System.out.println();
        }
    }
}
//A report that displays all fields for the following companies
// (listed here by ticker symbol): ALL, BA, BC, GRBL, KRT, MCD, TR, WAG
