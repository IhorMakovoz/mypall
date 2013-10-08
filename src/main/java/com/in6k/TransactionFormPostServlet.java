package com.in6k;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class TransactionFormPostServlet extends HttpServlet{

    private static Logger logger = Logger.getLogger(TransactionFormPostServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        String amount = request.getParameter("amount");
        int amountInt= Integer.parseInt(amount);
        Timestamp date = new Timestamp(new Date().getTime());

        Transaction t = new Transaction(date, sender, receiver, amountInt);

        TransactionLog tl = new TransactionLog();

        /*for (Transaction transaction: tl.getTransactions()) {
            logger.warn("Date = " + transaction.getDate());
            logger.warn("Creditor_account = " + transaction.getCreditor());
            logger.warn("Debitor_account = : " + transaction.getDebetor());
            logger.warn("Amount = " + transaction.getAmount());
        }*/
        try {
            tl.addTransaction(t);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            tl.addTransactionLog(t);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        /*logger.info("Sender  sender" + sender);
        logger.info("Sender receiver " + receiver);
        logger.info("Sender amount " + amount);*/

        request.getRequestDispatcher("/WEB-INF/transaction-form-success.jsp").include(request, response);
    }
}

