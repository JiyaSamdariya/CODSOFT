import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class Menu extends Account {
    Scanner menuInputScanner = new Scanner(System.in);
    DecimalFormat money = new DecimalFormat("'$'###,##0.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void login() throws IOException {
        int x = 1;
        do {
            try {
                data.put(313233, 1234);
                data.put(212223, 1235);

                System.out.println("Welcome");
                System.out.println("Please Enter Your Account No.");
                setAccountNo(menuInputScanner.nextInt());
                System.out.println("Please Enter Your PIN No.");
                setPin(menuInputScanner.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid PIN No. Enter only Numbers." + "\n");
                x = 2;
            }

            int ac = getAccountNo();
            int p = getPin();
            if (data.containsKey(ac) && data.get(ac) == p) {
                getSelectAccountType();
            } else
                System.out.println("\n" + "Incorrect Account No or PIN No." + "\n");
        } while (x == 1);
    }

    public void getSelectAccountType() {
        System.out.println("Select Your Account Type: ");
        System.out.println("1 - Current Account");
        System.out.println("2 - Savings Account");
        System.out.println("3 - Exit");

        int selected = menuInputScanner.nextInt();

        switch (selected) {
            case 1:
                getCurrentAccount();
                break;

            case 2:
                getSavingAccount();
                break;

            case 3:
                System.out.println("Thank You for Visiting Us.");
                System.out.println("Have a Good Day!!");
                break;

            default:
                System.out.println("\n" + "Invalid Request" + "\n");
                getSelectAccountType();
        }
    }

    public void getCurrentAccount() {
        System.out.println("Current Account : ");
        System.out.println("1 - Check Balance");
        System.out.println("2 - Withdraw Money");
        System.out.println("3 - Deposit Money");
        System.out.println("4 - Exit");
        System.out.println("Enter Your Choice : ");

        int selected = menuInputScanner.nextInt();
        switch (selected) {
            case 1:
                System.out.println("Checking Balance : " + money.format(getCurrentBalance()));
                getSelectAccountType();
                break;

            case 2:
                getCurrentWithdrawAmount();
                break;

            case 3:
                getCurrentDepositAmount();
                break;

            case 4:
                System.out.println("Thanks For Your Visit.");
                break;

            default:
                System.out.println("\n" + "Invalid Request" + "\n");
                getCurrentAccount();
                break;
        }
    }

    public void getSavingAccount() {
        System.out.println("Savings Account");
        System.out.println("1 - Check Balance");
        System.out.println("2 - Withdraw Money");
        System.out.println("3 - Deposit Money");
        System.out.println("4 - Exit");
        System.out.println("Enter Your Choice : ");

        int selected = menuInputScanner.nextInt();
        switch (selected) {
            case 1:
                System.out.println("Checking Balance : " + money.format(getSavingBalance()));
                getSelectAccountType();
                break;

            case 2:
                getSavingWithdrawAmount();
                break;

            case 3:
                getSavingDepositAmount();
                break;

            case 4:
                System.out.println("Thanks For Your Visit.");
                break;

            default:
                System.out.println("\n" + "Invalid Request" + "\n");
                getSavingAccount();
                break;
        }
    }
}
