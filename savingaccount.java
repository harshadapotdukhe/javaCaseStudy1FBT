package com.javacasestudy1bm;

public class LoanAccount extends BankAccount {
	private double interestRate;
    private int tenureMonths;
    private double emiPayment;
    private int transactionCount;
    private double totalRepaid;

    public LoanAccount(long accountNo, String accountHolderName, double loanAmount, double interestRate, int tenureMonths) {
        super(accountNo, accountHolderName, -loanAmount, "Loan");
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;

        this.emiPayment = calculateEMI();        // Calculate initial EMI
        this.emiPayment = Math.round(emiPayment * 100.0) / 100.0; // Round and store

        this.transactionCount = 0;
        this.totalRepaid = 0;
    }

    private double calculateEMI() {
        double monthlyInterestRate = (interestRate / 100) / 12;
        double loanAmount = Math.abs(getCurrentBalance());
        return (loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenureMonths)) /
               (Math.pow(1 + monthlyInterestRate, tenureMonths) - 1);
    }

    public double calculateInterest() {
        double loanAmount = Math.abs(getCurrentBalance());
        return loanAmount * (interestRate / 100) * (tenureMonths / 12.0);
    }

    public boolean payEMI(double amount) {
        if (amount < emiPayment) { // Use the ROUNDED emiPayment here
            System.out.println("Error: Minimum EMI payment required: ₹" + emiPayment); // Display rounded value
            return false;
        }

        double remainingBalance = getCurrentBalance() + amount;
        if (remainingBalance > 0) {  // Prevent overpayment
            System.out.println("You are paying extra. Adjusting to final EMI payment.");
            amount = -getCurrentBalance();  // Final payment clears the loan
        }

        setCurrentBalance(getCurrentBalance() + amount); // Update balance
        transactionCount++;
        totalRepaid += amount;

        System.out.println("Payment of ₹" + amount + " received. Remaining Loan Balance: ₹" + getRemainingLoanAmount()); // Use getRemainingLoanAmount()

        if (getCurrentBalance() == 0) {
            System.out.println("Congratulations! Your loan is fully repaid.");
        }
        return true;
    }


    public boolean applyLateFee() {
        if (isLoanOverdue()) {
            double lateFee = Math.abs(getCurrentBalance()) * 0.02;
            setCurrentBalance(getCurrentBalance() - lateFee);
            System.out.println("Late fee of ₹" + lateFee + " applied. New Loan Balance: ₹" + getRemainingLoanAmount()); // Use getRemainingLoanAmount()
            return true;
        }
        return false;
    }

    private boolean isLoanOverdue() {
       // return transactionCount < tenureMonths; // Original logic (simple but might not be accurate enough)
        // Improved overdue check (needs loan start date):
        //  (You'll need to add a loanStartDate field to LoanAccount and initialize it)
        //  LocalDate dueDate = loanStartDate.plusMonths(transactionCount);
        //  return LocalDate.now().isAfter(dueDate);

        // Simpler Overdue Check (For testing)
        return transactionCount < tenureMonths;
    }

    public double getAmountRepaid() {
        return totalRepaid;
    }

    public double getRemainingLoanAmount() {
        return Math.abs(getCurrentBalance());
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawals are not allowed from Loan Accounts.");
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        totalRepaid += amount;
        if (getCurrentBalance() == 0) {
            System.out.println("Loan fully repaid.");
        }
    }
}
