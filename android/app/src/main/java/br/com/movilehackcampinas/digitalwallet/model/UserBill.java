package br.com.movilehackcampinas.digitalwallet.model;

public class UserBill {

    private String name;
    private double value;
    private boolean payed;

    public UserBill(String name, double value, boolean payed) {
        this.name = name;
        this.value = value;
        this.payed = payed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }
}
