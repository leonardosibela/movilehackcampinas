package br.com.movilehackcampinas.digitalwallet.util;

public class StringUtil {

    public static String doubleToCurrency(double value) {
        float epsilon = 0.004f; // 4 tenths of a cent
        if (Math.abs(Math.round(value) - value) < epsilon) {
            return String.format("%10.0f", value); // sdb
        } else {
            return String.format("%10.2f", value); // dj_segfault
        }
    }
}
