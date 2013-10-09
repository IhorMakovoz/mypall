package com.in6k;

import java.util.List;

public class TransactionConsoleWriter {
    public static void print(List<Transaction> transactions) {
        System.out.println("All transactions: ");
        for(Transaction transaction : transactions){
            System.out.println(transaction);
        }
    }
}

