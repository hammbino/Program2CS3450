/*
 * Program2
 * Created by jeffrey hammond on 2/11/17.
 */

import java.util.*;

class Ticker {

    private String company;
    private String symbol;
    private double price;
    private double amountChanged;
    private double percentChanged;
    private double ytdChange;
    private double yrHigh;
    private double yrLow;
    private double ratio;

    Ticker (String s) {
        Scanner sc = new Scanner(s);
        company = sc.findInLine("^\\D+(?=\\s\\w+\\s\\d)");
        symbol = sc.next();
        price = sc.nextDouble();
        amountChanged = sc.nextDouble();
        percentChanged = sc.nextDouble();
        ytdChange = sc.nextDouble();
        yrHigh = sc.nextDouble();
        yrLow = sc.nextDouble();
        ratio = sc.hasNextDouble() ? sc.nextDouble() : 0;
        sc.close();
    }

    double getPrice() {
        return price;
    }

    double getPercentChanged() {
        return percentChanged;
    }

    String getSymbol() {
        return symbol;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %.2f %.2f %.2f %.2f %.2f %.2f", company, symbol, price, amountChanged, percentChanged, ytdChange, yrHigh, yrLow, ratio);
    }
}
