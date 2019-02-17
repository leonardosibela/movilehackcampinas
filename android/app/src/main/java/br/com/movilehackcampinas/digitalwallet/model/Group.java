package br.com.movilehackcampinas.digitalwallet.model;

import java.util.List;

public class Group {
    private String id;
    private String name;
    private List<Bill> bills;

    public Group() {}
    public Group(String name, List<Bill> bills) {
        this.name = name;
        this.bills = bills;
    }
}
