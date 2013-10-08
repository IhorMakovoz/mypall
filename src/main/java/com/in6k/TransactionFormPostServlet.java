package com.in6k;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TransactionFormPostServlet extends HttpServlet{

    private static Logger logger = Logger.getLogger(TransactionFormPostServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String sender = request.getParameter("sender");
        String receiver = request.getParameter("receiver");
        String amount = request.getParameter("amount");

        logger.warn("Sender name: " + sender);
        logger.warn("Receiver name: " + receiver);
        logger.warn("Amount: " + amount);

        request.getRequestDispatcher("/WEB-INF/transaction-form-success.jsp").include(request, response);

        //RequestDispatcher dispatcher = request.getRequestDispatcher("transaction-form-success.jsp");
        //dispatcher.forward(request, response);
    }
}
