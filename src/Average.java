/**
 * Program2
 * Created by jeffrey hammond on 2/12/17.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Average implements Observer {
    private ArrayList subscribed = new ArrayList();
    File selectionsFile = new File("average.txt");
    FileWriter writer;

    Average(Subject s) throws IOException {
        subscribed.add(s);
        if(selectionsFile.exists()) {
            selectionsFile.delete();
        }
        selectionsFile.createNewFile();
    }

    //A report that displays the average of all local stock prices of each snapshot,
    // along with the time the snapshot was taken.
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
            try {
                writer = new FileWriter(selectionsFile, true);
                writer.write(ss.getDate() + ", Average price: " + avg + "\n\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(ss.getDate() + ", Average price: " + avg + "\n");
        }
    }
}
