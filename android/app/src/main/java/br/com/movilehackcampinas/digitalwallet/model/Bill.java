package br.com.movilehackcampinas.digitalwallet.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Bill {

    @SerializedName("id")
    private String id;

    @SerializedName("groupId")
    private String groupId;

    @SerializedName("name")
    private String name;

    @SerializedName("date")
    private Date date;

    @SerializedName("proratedvalues")
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