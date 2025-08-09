package com.javacasestudy1bm;
import java.time.LocalDate;

public class SalaryAccount extends BankAccount {
	 private LocalDate lastTransactionDate;
	    private boolean isFrozen;

	    public SalaryAccount(long accountNo, String accountHolderName, double currentBalance) {
	        super(accountNo, accountHolderName, currentBalance, "Salary");
	        this.lastTransactionDate = LocalDate.now();
	        this.isFrozen = false;
	    }

	    public void checkAccountStatus() {
	        if (lastTransactionDate.plusMonths(2).isBefore(LocalDate.now())) {
	            isFrozen = true;
	            System.out.println("Salary Account is frozen due to inactivity.");
	        } else {
	            System.out.println("Salary Account is active.");
	        }
	    }

	    @Override
	    public void deposit(double amount) {
	        super.deposit(amount);
	        lastTransactionDate = LocalDate.now();
	        isFrozen = false;
	    }

	    @Override
	    public void withdraw(double amount) {
	        if (isFrozen) {
	            System.out.println("Account is frozen. Cannot withdraw.");
	        } else {
	            super.withdraw(amount);
	            lastTransactionDate = LocalDate.now();
	        }
	    }
}
