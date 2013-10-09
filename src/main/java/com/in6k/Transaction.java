package com.in6k;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Transaction {
    private Date date;
    private String creditor;
    private String debitor;
    private int amount;

    public Transaction(Date date, String creditor, String debitor, int amount) {
        this.date = date;
        this.creditor = creditor;
        this.debitor = debitor;
        this.amount = amount;
    }

    public Transaction(ResultSet rs){
        try {
            this.date = rs.getTimestamp("date_at");
            this.creditor = rs.getString("credit_account");
            this.debitor = rs.getString("debit_account");
            this.amount = rs.getInt("amount");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Transaction init failed.");
        }
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

    public String getDebitor() {
        return debitor;
    }

    public void setDebitor(String debitor) {
        this.debitor = debitor;
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
                ", debitor='" + debitor + '\'' +
                ", amount=" + amount +
                '}';
    }

    public void print(){
        System.out.println(this);
    }
}
