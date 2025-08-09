package com.javacasestudy1bm;

public class SavingsAccount extends BankAccount{
	 private static final double MIN_BALANCE = 10000.0;

	    // ✅ Constructor calls BankAccount's constructor
	    public SavingsAccount(long accountNo, String accountHolderName, double currentBalance) {
	        super(accountNo, accountHolderName, currentBalance, "Savings");
	    }

	    @Override  // ✅ Explicitly overriding withdraw() method
	    public void withdraw(double amount) {
	        if ((getCurrentBalance() - amount) >= MIN_BALANCE) {
	            setCurrentBalance(getCurrentBalance() - amount);
	            System.out.println("Withdrawn: ₹" + amount + ". New Balance: ₹" + getCurrentBalance());
	        } else {
	            System.out.println("Cannot withdraw. Minimum balance of ₹" + MIN_BALANCE + " must be maintained.");
	        }
	    }

	
}
