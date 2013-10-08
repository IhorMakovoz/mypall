package com.in6k;

import java.util.Date;

public class Transaction {
    private Date date;
    private String creditor;
    private String debetor;
    private int amount;

    public Transaction(Date date, String creditor, String debetor, int amount) {
        this.date = date;
        this.creditor = creditor;
        this.debetor = debetor;
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

    public String getDebetor() {
        return debetor;
    }

    public void setDebetor(String debetor) {
        this.debetor = debetor;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date=" + date +
                ", creditor='" + creditor + '\'' +
                ", debetor='" + debetor + '\'' +
                ", amount=" + amount +
                '}';
    }
}
