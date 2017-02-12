import java.util.ArrayList;
import java.util.Scanner;

/**
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */

public class Snapshot {
    private String date;
    private ArrayList<Ticker> tickers;

    Snapshot() {
        tickers = new ArrayList<>();
    }

    void setData(String s) {
        date = s;
    }

    void addTicker (Ticker t) {
        tickers.add(t);
    }

    void printSanpshot () {
        System.out.println(date);
        for (Ticker ticker: tickers) {
            System.out.println(ticker);
        }
        tickers.clear();
        System.out.println();
    }
}
