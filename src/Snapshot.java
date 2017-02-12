/**
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */
import java.util.ArrayList;

public class Snapshot {

    private String date;
    private ArrayList<Ticker> tickers;

    Snapshot() {
        tickers = new ArrayList<>();
    }

    void setData(String s) {
        date = s;
    }

    String getDate() {
        return date.replace("Last updated ", "");
    }

    String getLastUpdate() {
        return date;
    }

    void addTicker (Ticker t) {
        tickers.add(t);
    }


    public ArrayList<Ticker> getTickers() {
        return tickers;
    }

    public void update() {
        date = "";
        tickers.clear();
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
