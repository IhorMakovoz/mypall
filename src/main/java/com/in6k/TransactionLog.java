package com.in6k;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionLog {

    public void addTransaction(Transaction transaction) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        PreparedStatement statement= null;
        Connection conection = null;
        conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypal", "root", "masterkey");

        String insertTableSQL = "INSERT INTO transactions"
                + "(date_at, debit_account, credit_account, amount) VALUES"
                + "(?,?,?,?)";
        statement = conection.prepareStatement(insertTableSQL);
        Timestamp ts = new Timestamp(new Date().getTime());
        statement.setTimestamp(1, ts);
        statement.setString(2, transaction.getDebetor());
        statement.setString(3, transaction.getCreditor());
        statement.setInt(4, transaction.getAmount());
        statement.executeUpdate();

        statement.close();


        conection.close();
    }

    public void addTransactionLog(Transaction transaction) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conection = null;
        conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypal", "root", "masterkey");

        Statement statement = conection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * from transactions ORDER BY id DESC LIMIT 1\n");
        while(rs.next()) {
            System.out.print("id = " + rs.getInt("id") + "  ");
            System.out.print("date_at = " + rs.getTimestamp("date_at") + "  ");
            System.out.print("credit_account = " + rs.getString("credit_account") + "  ");
            System.out.print("debit_account = " + rs.getString("debit_account") + "  ");
            System.out.print("amount = " + rs.getString("amount") + "  ");
        }
        statement.close();
        conection.close();

    }
}
