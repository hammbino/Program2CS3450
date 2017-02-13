/*
 * Program2
 * Created by jeffrey hammond on 2/12/17.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Change10 implements Observer {
    private ArrayList subscribed = new ArrayList();
    private File selectionsFile = new File("change10.txt");

    Change10() throws IOException {
        if(selectionsFile.exists()) {
            selectionsFile.delete();
        }
        selectionsFile.createNewFile();
    }

    public void addSubject(Subject s) {
        subscribed.add(s);
    }

    //A report that displays all companies that have had a price change of 10% or more.
    // List the ticker symbol, the price and the percentage change.
    @Override
    public void update(Subject s, Snapshot ss) {
        FileWriter writer;
        try {
            writer = new FileWriter(selectionsFile, true);
            writer.write(ss.getDate() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (subscribed.contains(s)) {
            try {
                writer = new FileWriter(selectionsFile, true);
                for (Ticker ticker: ss.getTickers()) {
                    if (ticker.getPercentChanged() >= 10 || ticker.getPercentChanged() <= -10) {
                        writer.write(ticker.getSymbol() + " " + ticker.getPrice() + " " + ticker.getPercentChanged() + "\n");
                    }
                }
                writer.write("\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
