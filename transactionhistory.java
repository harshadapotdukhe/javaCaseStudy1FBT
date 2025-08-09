package com.javacasestudy1bm;
import java.time.LocalDate;
import java.time.LocalTime;
//import java.time.temporal.ChronoUnit;

public class TransactionHistory {
	private int referenceId;
    private String type;
    private double amount;
    private LocalDate transactionDate;
    private LocalTime transactionTime;

    public TransactionHistory(int referenceId, String type, double amount, LocalDate transactionDate, LocalTime transactionTime) {
        this.referenceId = referenceId;
        this.type = type;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public LocalTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalTime transactionTime) {
        this.transactionTime = transactionTime;
    }

    public int getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(int referenceId) {
        this.referenceId = referenceId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void displatSingleTransaction(){
        System.out.println("Reference Id: " + this.getReferenceId());
        System.out.println("Type of Transaction: " + this.getType());
        System.out.println(("Transaction Amount: ") + this.getAmount());
        System.out.println("Transaction Date: " + this.getTransactionDate());
        System.out.println("Transaction Time: " + this.getTransactionTime());
        System.out.println("------***-----");
    }
}

