package com.in6k;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Date;
import java.util.List;

public class TransactionFormPostServlet extends HttpServlet{

    private static Logger logger = Logger.getLogger(TransactionFormPostServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        String amount = request.getParameter("amount");
        int amountInt = Integer.parseInt(amount);
        Timestamp date = new Timestamp(new Date().getTime());

        Transaction t = new Transaction(date, sender, receiver, amountInt);
        TransactionLog tl = new TransactionLog();

        try {
            tl.addTransaction(t);
            /*List <Transaction> transactions = tl.getTransactions();

            for (Transaction transaction: transactions) {
                transaction.print();
            }*/
            tl.printAllTransactions();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/transaction-form-success.jsp").include(request, response);
    }
}

