/**
 * Program2
 * Created by jeffreyhammond on 2/12/17.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Change10 implements Observer {
    private ArrayList subscribed = new ArrayList();
    File selectionsFile = new File("change10.txt");
    FileWriter writer;

    Change10(Subject s) throws IOException {
        subscribed.add(s);
        selectionsFile.createNewFile();
    }

    //A report that displays all companies that have had a price change of 10% or more.
    // List the ticker symbol, the price and the percentage change.
    @Override
    public void update(Subject s, Snapshot ss) {
        try {
            writer = new FileWriter(selectionsFile, true);
            writer.write(ss.getDate() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ss.getDate());
        if (subscribed.contains(s)) {
            try {
                writer = new FileWriter(selectionsFile, true);
                for (Ticker ticker: ss.getTickers()) {
                    if (ticker.getPercentChanged() >= 10 || ticker.getPercentChanged() <= -10) {
                        writer.write(ticker.getSymbol() + " " + ticker.getPrice() + " " + ticker.getPercentChanged() + "\n");
                        System.out.printf("%s %.2f %.2f\n", ticker.getSymbol(), ticker.getPrice(), ticker.getPercentChanged());
                    }
                }
                System.out.println();
                writer.write("\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
