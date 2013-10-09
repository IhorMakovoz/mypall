package com.in6k;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionLog {
    private  List<Transaction> transactions = new ArrayList<Transaction>();

    public void addTransaction (Transaction transaction) throws ClassNotFoundException, SQLException {
        Connection connection = DatabaseHelper.getConnection();

        String insertTableSQL = "INSERT INTO transactions"
                + "(date_at, debit_account, credit_account, amount) VALUES"
                + "(?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement("INSERT INTO transactions (date_at, debit_account, credit_account, amount)"
                + " VALUES (?,?,?,?)");

        Timestamp ts = new Timestamp(new Date().getTime());
        statement.setTimestamp(1, ts);
        statement.setString(2, transaction.getDebtor());
        statement.setString(3, transaction.getCreditor());
        statement.setInt(4, transaction.getAmount());
        statement.executeUpdate();

        statement.close();
        //connection.close();
    }

    public List<Transaction> getTransactions() throws ClassNotFoundException, SQLException {
        List<Transaction> result = new ArrayList<Transaction>();

        Connection connection = DatabaseHelper.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from transactions");

        while(rs.next()) {
            result.add(createTransaction(rs));
        }

        rs.close();
        statement.close();
        connection.close();

        return result;
    }

    private Transaction createTransaction(ResultSet rs) throws SQLException {
        return new Transaction(rs.getTimestamp("date_at"), rs.getString("credit_account"), rs.getString("debit_account"), rs.getInt("amount"));
    }
}
