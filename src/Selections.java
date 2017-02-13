/**
 * Program2
 * Created by jeffreyhammond on 2/12/17.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;

public class Selections implements Observer {
    private ArrayList subscribed = new ArrayList();
    private static ArrayList compsFollowing = new ArrayList(Arrays.asList("ALL", "BA", "BC", "GRBL", "KRT", "MCD", "TR", "WAG"));
    File selectionsFile = new File("selections.txt");
    FileWriter writer;

    Selections(Subject s) throws IOException {
        subscribed.add(s);
        selectionsFile.createNewFile();
    }

    //A report that displays all fields for the following companies: ALL, BA, BC, GRBL, KRT, MCD, TR, WAG
    @Override
    public void update(Subject s, Snapshot ss) {
        try {
            writer = new FileWriter(selectionsFile, true);
            writer.write(ss.getLastUpdate() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(ss.getLastUpdate());
        if (subscribed.contains(s)) {
            try {
                writer = new FileWriter(selectionsFile, true);
                for (Ticker ticker: ss.getTickers()) {
                    if (compsFollowing.contains(ticker.getSymbol())) {
                        writer.write(ticker + "\n");
                        System.out.println(ticker);
                    }
                }
                writer.write("\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}

