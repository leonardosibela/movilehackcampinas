package br.com.movilehackcampinas.digitalwallet.util;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.movilehackcampinas.digitalwallet.model.Bill;
import br.com.movilehackcampinas.digitalwallet.model.ProratedValue;
import br.com.movilehackcampinas.digitalwallet.model.User;

public class MockUtil {

    public static List<Bill> getSomeBills() {
        List<Bill> bills = new ArrayList<>();

        bills.add(new Bill("1", "1", "Aluguel", new Date(), getProratedValuesA()));
        bills.add(new Bill("2", "1", "Conta Luz", new Date(), getProratedValuesB()));
        bills.add(new Bill("3", "1", "Conta Água", new Date(), getProratedValuesC()));

        return bills;
    }

    public static List<User> getSomeUsers() {
        List<User> users = new ArrayList<>();
        users.add(getUserA());
        users.add(getUserB());
        users.add(getUserC());
        return users;
    }

    public static List<ProratedValue> getProratedValuesA() {
        List<ProratedValue> proratedValues = new ArrayList<>();

        proratedValues.add(new ProratedValue("1", getUserA(), 300, false));
        proratedValues.add(new ProratedValue("2", getUserB(), 500, true));
        proratedValues.add(new ProratedValue("3", getUserC(), 800, false));

        return proratedValues;
    }

    public static List<ProratedValue> getProratedValuesB() {
        List<ProratedValue> proratedValues = new ArrayList<>();

        proratedValues.add(new ProratedValue("1", getUserA(), 25, false));
        proratedValues.add(new ProratedValue("2", getUserB(), 25, true));
        proratedValues.add(new ProratedValue("3", getUserC(), 25, false));

        return proratedValues;
    }

    public static List<ProratedValue> getProratedValuesC() {
        List<ProratedValue> proratedValues = new ArrayList<>();

        proratedValues.add(new ProratedValue("1", getUserA(), 30, false));
        proratedValues.add(new ProratedValue("2", getUserB(), 30, false));
        proratedValues.add(new ProratedValue("3", getUserC(), 30, false));

        return proratedValues;
    }

    @NonNull
    private static User getUserC() {
        return new User("3", "Pedro", "Marcos", "pmarcos@gmail.com", "107.247.888-18");
    }

    @NonNull
    private static User getUserB() {
        return new User("2", "Larissa", "Cunha", "lari.cunha@gmail.com", "803.224.187-23");
    }

    @NonNull
    private static User getUserA() {
        return new User("1", "Fernado", "Soares", "nando.soares@gmail.com", "402.334.891-87");
    }
}