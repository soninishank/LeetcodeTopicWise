package LLD.Java.OverloadingConcepts;

import javax.print.PrintException;

public class AdvancedPrinter extends Printer {
    @Override
    public void print(String content) throws PrintException {
        System.out.println("Printing Content for Advanced Printer");
    }

    public void print(String content, String header, String footer) throws PrintException {
        System.out.println("Printing Header Content and Footer for advanced Printer");
    }
}
