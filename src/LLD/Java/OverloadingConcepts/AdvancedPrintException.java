package LLD.Java.OverloadingConcepts;

import javax.print.PrintException;

public class AdvancedPrintException extends PrintException {
    public AdvancedPrintException(String s) {
        super(s);
    }
}
