import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

// Adam Dressel
// Basic ATM machine simulator. Integrating basic skills learned about java.


public class Main {

  public static void main(String[] args) {
    // New scanner object reads user input
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to to Bank of Java termninal!");
    DecimalFormat money = new DecimalFormat(".##");
    // Random balance generated for each account. And stored as double balance
    Account checking = new Account();
    checking.setBalance();
    Account savings = new Account();
    savings.setBalance();

    // final keyword used for a fee applied to a withdrawal transaction. The final keyword is used
    // for a constant, unchanging variable. This helps me avoid making errors when applying the fee
    // to calculations.
    final int FEE = (int) 1;

    String menu = " - Enter 1 for Withdrawal \n " + "- Enter 2 for Deposit \n "
        + "- Enter 3 to Check Balances \n " + "- Enter 4 to Exit";


    // keepLoop boolean to determine whether to continue the program.
    // only changed to false when the user chooses the exit option.
    boolean keepLoop = true;

    do {
      System.out.println(menu);
      int userChoice = scan.nextInt();
      // 1st choice. If user tries to withdrawal more money than the balance,
      // an error message appears. The withdrawal method is called on the chosen
      // account.

      if (userChoice == 1) {
        System.out.println(Account.acctMenu(checking, savings).withdrawal());
      }
      // Second option, simply a deposit option.
      // User can currently deposit any integer they choose.
      // Similar to withdrawal option, calls the deposit method on the chosen
      // account.
      else if (userChoice == 2) {
        System.out.println(Account.acctMenu(checking, savings).deposit());
      }

      // Third option, displays indicated balance by calling the getBalance()
      // method on the chosen account.
      else if (userChoice == 3) {
        System.out.println(Account.acctMenu(checking, savings).getBalance());
        // Exit menu option, turns the keepLoop boolean variable to false, this
        // exit the loop and close the scanner.
      } else if (userChoice == 4) {
        keepLoop = false;
      }
      // All other integers, result in repeating the loop.
      else {
        keepLoop = true;
        System.out.println("This is not a valid option, please choose one of the above.");
        userChoice = scan.nextInt();
      }
    } while (keepLoop);
    scan.close();
    System.out.println("Thank you for choosing Bank of Java!");
  }
}
