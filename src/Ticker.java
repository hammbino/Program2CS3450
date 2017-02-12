/**
 * Program2
 * Created by jeffreyhammond on 2/11/17.
 */

import java.util.*;

public class Ticker {

    private String company;
    private String symbol;
    private float price;
    private float amountChanged;
    private float percentChanged;
    private float ytdChange;
    private float yrHigh;
    private float yrLow;
    private float ratio;

    Ticker (String s) {
        Scanner sc = new Scanner(s);
        company = sc.findInLine("^\\D+(?=\\s\\w+\\s\\d)");
        symbol = sc.next();
        price = sc.nextFloat();
        amountChanged = sc.nextFloat();
        percentChanged = sc.nextFloat();
        ytdChange = sc.nextFloat();
        yrHigh = sc.nextFloat();
        yrLow = sc.nextFloat();
        ratio = sc.hasNextFloat() ? sc.nextFloat() : 0;
        sc.close();
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %.2f %.2f %.2f %.2f %.2f %.2f", company, symbol, price, amountChanged, percentChanged, ytdChange, yrHigh, yrLow, ratio);
    }
}
