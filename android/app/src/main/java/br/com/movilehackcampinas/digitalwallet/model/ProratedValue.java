package br.com.movilehackcampinas.digitalwallet.model;

import com.google.gson.annotations.SerializedName;

public class ProratedValue {

    @SerializedName("id")
    private String id;

    @SerializedName("user")
    private User user;

    @SerializedName("value")
    private double value;

    @SerializedName("payed")
    private boolean payed;

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