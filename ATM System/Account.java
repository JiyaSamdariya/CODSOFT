import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
    private int AccountNo;
    private int Pin;
    private double currentBalance = 0;
    private double savingBalance = 0;

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.0");

    public void setAccountNo(int AccountNo) {
        this.AccountNo = AccountNo;
    }

    public int getAccountNo() {
        return AccountNo;
    }

    public void setPin(int Pin) {
        this.Pin = Pin;
    }

    public int getPin() {
        return Pin;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

    public double calculateCurrentWithdraw(double amount) {
        currentBalance = (currentBalance - amount);
        return currentBalance;
    }

    public double calculateSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }

    public double calculateCurrentDeposit(double amount) {
        currentBalance = (currentBalance + amount);
        return currentBalance;
    }

    public double calculateSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }

    public void getCurrentWithdrawAmount() {
        System.out.println("Current Account Balance : " + moneyFormat.format(currentBalance));
        System.out.println("Enter Withdraw Amount: ");
        double amount = input.nextDouble();
        if ((currentBalance - amount) >= 0) {
            calculateCurrentWithdraw(amount);
            System.out.println("Current Balance in Account : " + moneyFormat.format(currentBalance));
        } else {
            System.out.println("Invalid Amount " + "\n");
        }
    }

    public void getSavingWithdrawAmount() {
        System.out.println("Saving Account Balance : " + moneyFormat.format(savingBalance));
        System.out.println("Enter Withdraw Amount: ");
        double amount = input.nextDouble();
        if ((savingBalance - amount) >= 0) {
            calculateSavingWithdraw(amount);
            System.out.println("Current Balance in Account : " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Invalid Amount " + "\n");
        }
    }

    public void getCurrentDepositAmount() {
        System.out.println("Current Account Balance : " + moneyFormat.format(currentBalance));
        System.out.println("Enter Deposit Amount: ");
        double amount = input.nextDouble();
        if ((currentBalance + amount) >= 0) {
            calculateCurrentWithdraw(amount);
            System.out.println("Current Balance in Account : " + moneyFormat.format(currentBalance));
        } else {
            System.out.println("Invalid Amount " + "\n");
        }
    }

    public void getSavingDepositAmount() {
        System.out.println("Saving Account Balance : " + moneyFormat.format(savingBalance));
        System.out.println("Enter Deposit Amount: ");
        double amount = input.nextDouble();
        if ((savingBalance + amount) >= 0) {
            calculateSavingDeposit(amount);
            System.out.println("Current Balance in Account : " + moneyFormat.format(savingBalance));
        } else {
            System.out.println("Invalid Amount " + "\n");
        }
    }

    public static void main(String[] args) {
        Account account = new Account();
        // You may call your methods here or create an instance and call them later.
    }
}
