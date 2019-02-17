package br.com.movilehackcampinas.digitalwallet.model;

public class ProratedValue {

    private String id;
    private User user;
    private double value;
    private boolean payed;

    public ProratedValue() {
    }

    public ProratedValue(String id, User user, double value, boolean payed) {
        this.id = id;
        this.user = user;
        this.value = value;
        this.payed = payed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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