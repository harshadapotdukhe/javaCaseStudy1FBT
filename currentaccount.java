package com.javacasestudy1bm;

public class CurrentAccount extends BankAccount{
	private double overdraftLimit;

    public CurrentAccount(long accountNo, String accountHolderName, double currentBalance, double overdraftLimit) {
        super(accountNo, accountHolderName, currentBalance, "Current");
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if ((getCurrentBalance() - amount) >= -overdraftLimit) { 
            setCurrentBalance(getCurrentBalance() - amount);
            System.out.println("Withdrawn ₹" + amount + ". New Balance: ₹" + getCurrentBalance());
        } else {
            System.out.println("Overdraft limit exceeded! Cannot withdraw ₹" + amount);
        }
    }

}
