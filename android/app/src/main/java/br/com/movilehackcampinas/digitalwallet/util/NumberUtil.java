package br.com.movilehackcampinas.digitalwallet.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberUtil {

    public static double round(double value, int digits) {
        if (digits < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(digits, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static String toPercentage(double number, int digits){
        return String.format("%."+digits+"f",number*100)+"%";
    }
}
