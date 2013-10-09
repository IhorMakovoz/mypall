package com.in6k;

import java.util.Date;

public class Transaction {
    private Date date;
    private String creditor;
    private String debtor;
    private int amount;

    public Transaction(Date date, String creditor, String debtor, int amount) {
        this.date = date;
        this.creditor = creditor;
        this.debtor = debtor;
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCreditor() {
        return creditor;
    }

    public void setCreditor(String creditor) {
        this.creditor = creditor;
    }

    public String getDebtor() {
        return debtor;
    }

    public void setDebtor(String debtor) {
        this.debtor = debtor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Transaction{ %s, %s, %s, %s }", date, creditor, debtor, amount);
    }
}
