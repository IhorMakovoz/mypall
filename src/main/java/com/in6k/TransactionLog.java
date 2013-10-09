package com.in6k;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionLog {
    private  List<Transaction> transactions = new ArrayList<Transaction>();

    public void addTransaction (Transaction transaction) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypal", "root", "masterkey");
        String insertTableSQL = "INSERT INTO transactions"
                + "(date_at, debit_account, credit_account, amount) VALUES"
                + "(?,?,?,?)";

        PreparedStatement statement = connection.prepareStatement(insertTableSQL);
        Timestamp ts = new Timestamp(new Date().getTime());
        statement.setTimestamp(1, ts);
        statement.setString(2, transaction.getDebitor());
        statement.setString(3, transaction.getCreditor());
        statement.setInt(4, transaction.getAmount());
        statement.executeUpdate();

        statement.close();
        connection.close();
        //transactions.add(transaction);
    }

    public List<Transaction> getAllTransactions() throws ClassNotFoundException, SQLException {
        List<Transaction> result = new ArrayList<Transaction>();
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypal", "root", "masterkey");
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from transactions");

        while(rs.next()) {
            result.add(new Transaction(rs));
        }

        statement.close();
        connection.close();

        return result;
    }

    public void printAllTransactions() throws SQLException, ClassNotFoundException {
         System.out.println("All transactions: ");
         List<Transaction> transactions = getAllTransactions();
         for(Transaction transaction : transactions){
             transaction.print();
         }
    }
    /*public List<Transaction> getTransactions() {
        return transactions;
    }*/
}
