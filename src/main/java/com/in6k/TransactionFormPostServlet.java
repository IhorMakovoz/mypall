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

        Transaction t = new Transaction(new Timestamp(new Date().getTime()), request.getParameter("sender"),
            request.getParameter("receiver"), Integer.parseInt(request.getParameter("amount")));

        TransactionLog tl = new TransactionLog();

        try {
            tl.addTransaction(t);
            TransactionConsoleWriter.print(tl.getTransactions());

        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/transaction-form-success.jsp").include(request, response);
    }

}

