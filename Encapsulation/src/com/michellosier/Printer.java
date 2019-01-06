package com.michellosier;

public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
        this.duplex = duplex;

        if (tonerLevel <= 100 && tonerLevel >= 0) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
    }

    public int getTonerLevel() {
        System.out.println("Toner level is currently at " + tonerLevel);
        return this.tonerLevel;
    }

    public int getPagesPrinted() {
        return this.pagesPrinted;
    }

    public boolean isDuplex() {
        return this.duplex;
    }

    public int printPages(int pages){
        if (this.duplex){
            this.pagesPrinted += (pages /2);
            return this.pagesPrinted;
        }
        this.pagesPrinted += pages;
        return pagesPrinted;
    }

    public int fillToner(int percentage) {
        if (percentage < 0) {
            if ((percentage + tonerLevel) <= 100) {
                tonerLevel = tonerLevel + percentage;
                return this.tonerLevel;
            }
            System.out.println("Too much toner!");
        }
        System.out.println("No toner added");
        return -1;
    }


}
