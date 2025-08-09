
package com.javacasestudy1bm;

import java.time.LocalDate;
import java.time.LocalTime;

public class BankAccount {
    private long accountNo;
    private String accountHolderName;
    private double currentBalance;
    private String accountType;
    private int tCount = 3;

    public int gettCount() {
        return tCount;
    }

    public void settCount(int tCount) {
        this.tCount = tCount;
    }


    TransactionHistory[] trr = new TransactionHistory[20];

    public static double getMinBalance() {
        return minBalance;
    }

    public static void setMinBalance(double minBalance) {
        BankAccount.minBalance = minBalance;
    }

    private static double minBalance = 5000;

    public BankAccount(long accountNo, String accountHolderName, double currentBalance, String accountType) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.currentBalance = currentBalance;
        this.accountType = accountType;

        trr[0] = new TransactionHistory(12345, "withdraw", 2500, LocalDate.of(2025, 3, 3), LocalTime.of(15, 20, 24));
        trr[1] = new TransactionHistory(12346, "deposit", 1500, LocalDate.of(2025, 3, 5), LocalTime.of(5, 15, 7));
        trr[2] = new TransactionHistory(12347, "withdraw", 1000, LocalDate.of(2025, 5, 22), LocalTime.of(10, 24, 12));
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void deposit(double depositAmount) {
        setCurrentBalance(this.getCurrentBalance() + depositAmount);
        trr[tCount++] = new TransactionHistory(123457, "deposit", depositAmount, LocalDate.now(), LocalTime.now());
        System.out.println("Deposited ₹" + depositAmount + ". Updated balance: ₹" + this.getCurrentBalance());
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }
        if (currentBalance - withdrawAmount < minBalance) {
            System.out.println("Insufficient funds. Maintain min balance of ₹" + minBalance);
            return;
        }
        setCurrentBalance(getCurrentBalance() - withdrawAmount);
        trr[tCount++] = new TransactionHistory(123458, "withdraw", withdrawAmount, LocalDate.now(), LocalTime.now());
        System.out.println("Deposited ₹" + withdrawAmount + ". Updated balance: ₹" + this.getCurrentBalance());
    }

    public double calTotalWithdraw() {
        double tempTotalWithdrawAmount = 0;
        for (int i = 0; i < tCount; i++) {
            if (trr[i].getType().equals("withdraw")) {
                tempTotalWithdrawAmount += trr[i].getAmount();
            }
        }
        return tempTotalWithdrawAmount;
    }

    public double calTotalDeposit() {
        double tempTotalDepositAmount = 0;
        for (int i = 0; i < tCount; i++) {
            if (trr[i].getType().equals("deposit")) {
                tempTotalDepositAmount += trr[i].getAmount();
            }
        }
        return tempTotalDepositAmount;
    }

    public void displayTransactions() {
        for (int i = 0; i < tCount; i++) {
            System.out.println("Reference Id: " + trr[i].getReferenceId());
            System.out.println("Type of Transaction: " + trr[i].getType());
            System.out.println(("Transaction Amount: ") + trr[i].getAmount());
            System.out.println("Transaction Date: " + trr[i].getTransactionDate());
            System.out.println("Transaction Time: " + trr[i].getTransactionTime());
            System.out.println("------***-----");
        }
    }

    public void transBetweenDates(LocalDate startDate, LocalDate endDate) {
        for (int i = 0; i < tCount; i++) {
            if ((trr[i].getTransactionDate().isAfter(startDate) || trr[i].getTransactionDate().isEqual(startDate)) &&
                    (trr[i].getTransactionDate().isBefore(endDate) || trr[i].getTransactionDate().isEqual(endDate))) {
                trr[i].displatSingleTransaction();
            }
        }
    }
}
