package br.com.movilehackcampinas.digitalwallet.model;

import java.util.Date;
import java.util.List;

public class Bill {

    private String id;
    private String groupId;
    private String name;
    private double valor;
    private Date date;
    private List<ProratedValue> proratedValues;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<ProratedValue> getProratedValues() {
        return proratedValues;
    }

    public void setProratedValues(List<ProratedValue> proratedValues) {
        this.proratedValues = proratedValues;
    }

    public double getPercentagePayed() {
        double totalAmount, payedAmount = 0;

       /* for (ProratedValue proratedValue : proratedValues) {
            if (proratedValue)
        }*/
        return 1;
    }
}