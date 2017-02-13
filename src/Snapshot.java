/*
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */
import java.util.ArrayList;

class Snapshot {

    private String date;
    private ArrayList<Ticker> tickers;

    Snapshot() {
        tickers = new ArrayList<>();
    }

    void setDate(String s) {
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

    ArrayList<Ticker> getTickers() {
        return tickers;
    }
}
