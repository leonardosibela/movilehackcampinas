package br.com.movilehackcampinas.digitalwallet.util;

import java.text.NumberFormat;
import java.util.Locale;

public class StringUtil {

    public static String doubleToCurrency(double value) {
        Locale locale = Locale.getDefault();
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(value);
    }
}
