import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner fileReader = null;
//        ArrayList<String> snapshotData = new ArrayList<>();
        ArrayList<Snapshot> snapshots = new ArrayList<>();
        Snapshot snapshot = null;
        String fileName;
        LocalStocks localStocks;

	    if(args.length > 0) {
            fileName = args[0];
        } else {
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Please enter the path of the file you wish to use: ");
            fileName = inputScanner.nextLine().trim();
            inputScanner.close();
        }

        try {
            fileReader = new Scanner(new FileInputStream(fileName)).useDelimiter("\\n|\\r|;");
        } catch (FileNotFoundException x) {
            System.out.println("ERROR: Unable to open file " + fileName);
            x.printStackTrace();
            System.exit(7);   // TERMINATE THE PROGRAM
        }

        localStocks = new LocalStocks();

        Average average = null;
        try {
            average = new Average();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Change10 change10 = null;
        try {
            change10 = new Change10();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Selections selections = null;
        try {
            selections = new Selections();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            if (line.equals("")) {
                snapshots.add(snapshot);
            } else {
                if (line.matches("(Last).*")) {
                    snapshot = new Snapshot();
                    snapshot.setDate(line);
                } else {
                    Ticker ticker = new Ticker(line);
                    if (snapshot != null) {
                        snapshot.addTicker(ticker);
                    }
                }
            }
        }
        snapshots.add(snapshot);

        localStocks.addObserver(average);

        if (!snapshots.isEmpty()) {
            localStocks.updateSnapshot(snapshots.remove(0));
        }

        localStocks.addObserver(change10);

        if (!snapshots.isEmpty()) {
            localStocks.updateSnapshot(snapshots.remove(0));
        }

        localStocks.addObserver(selections);

        if (!snapshots.isEmpty()) {
            localStocks.updateSnapshot(snapshots.remove(0));
        }

        localStocks.removeObserver(change10);

        if (!snapshots.isEmpty()) {
            localStocks.updateSnapshot(snapshots.remove(0));
        }

        localStocks.removeObserver(selections);

        if (!snapshots.isEmpty()) {
            localStocks.updateSnapshot(snapshots.remove(0));
        }

        localStocks.addObserver(change10);

        localStocks.addObserver(selections);

        if (!snapshots.isEmpty()) {
            snapshots.forEach(localStocks::updateSnapshot);
        }
    }
}
