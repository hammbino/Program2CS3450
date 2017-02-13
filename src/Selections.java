/*
 * Program2
 * Created by jeffrey hammond on 2/12/17.
 */
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileWriter;

class Selections implements Observer {
    private ArrayList<Subject> subscribed = new ArrayList<>();
    private static ArrayList<String> compsFollowing = new ArrayList<>(Arrays.asList("ALL", "BA", "BC", "GRBL", "KRT", "MCD", "TR", "WAG"));
    private File selectionsFile = new File("selections.txt");

    Selections() throws IOException {
        if(selectionsFile.exists()) {
            selectionsFile.delete();
        }
        selectionsFile.createNewFile();
    }

    public void addSubject(Subject s) {
        subscribed.add(s);
    }

    //A report that displays all fields for the following companies: ALL, BA, BC, GRBL, KRT, MCD, TR, WAG
    @Override
    public void update(Subject s, Snapshot ss) {
        FileWriter writer;
        try {
            writer = new FileWriter(selectionsFile, true);
            writer.write(ss.getLastUpdate() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (subscribed.contains(s)) {
            try {
                writer = new FileWriter(selectionsFile, true);
                for (Ticker ticker: ss.getTickers()) {
                    if (compsFollowing.contains(ticker.getSymbol())) {
                        writer.write(ticker + "\n");
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

