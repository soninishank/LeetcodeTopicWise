package LLD.Java.OverloadingConcepts;

import javax.print.PrintException;

public class Main {
    public static void main(String[] args) throws PrintException {
        Printer printer = new AdvancedPrinter();
        printer.print("blablabla");

        AdvancedPrinter advPrinter = new AdvancedPrinter();
        advPrinter.print("blablabla", "header", "footer");
    }
}
