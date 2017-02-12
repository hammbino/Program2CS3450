import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.String;

public class Main {
    public static void main(String[] args) {
        Scanner fileReader = null;
        ArrayList<String> snapshotData = new ArrayList<>();
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
//TODO figure out how to run the last update Snapshot in the loop without having to call it again.
        while (fileReader.hasNextLine()) {
            String line = fileReader.nextLine();
            if (line.equals("")) {
                localStocks.updateSnapshot(snapshotData);
                snapshotData.clear();
            } else {
                snapshotData.add(line);
            }
        }
        localStocks.updateSnapshot(snapshotData);
        snapshotData.clear();
    }
}
