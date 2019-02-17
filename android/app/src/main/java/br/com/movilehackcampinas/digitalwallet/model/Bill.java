package br.com.movilehackcampinas.digitalwallet.model;

import java.util.Date;
import java.util.List;

import br.com.movilehackcampinas.digitalwallet.util.NumberUtil;

public class Bill {

    private String id;
    private String groupId;
    private String name;
    private Date date;
    private List<ProratedValue> proratedValues;

    public Bill() {
    }

    public Bill(String name, List<ProratedValue> proratedValues) {
        this.name = name;
        this.proratedValues = proratedValues;
    }

    public Bill(String id, String groupId, String name, Date date, List<ProratedValue> proratedValues) {
        this.id = id;
        this.groupId = groupId;
        this.name = name;
        this.date = date;
        this.proratedValues = proratedValues;
    }

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
        double totalAmount = 0, payedAmount = 0;

        for (ProratedValue proratedValue : proratedValues) {
            totalAmount += proratedValue.getValue();
            if (proratedValue.isPayed()) {
                payedAmount += proratedValue.getValue();
            }
        }

        return NumberUtil.round(totalAmount / payedAmount, 4);
    }

    public String getPercentagePayedString() {
        return NumberUtil.toPercentage(getPercentagePayed(), 2);
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (ProratedValue proratedValue : proratedValues) {
            totalAmount += proratedValue.getValue();
        }
        return totalAmount;
    }

    public double getPayedAmount() {
        double payedAmount = 0;

        for (ProratedValue proratedValue : proratedValues) {
            if (proratedValue.isPayed()) {
                payedAmount += proratedValue.getValue();
            }
        }
        return payedAmount;
    }
}