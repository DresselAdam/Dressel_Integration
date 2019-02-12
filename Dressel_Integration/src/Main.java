import java.util.Scanner;
import java.lang.Math;

// Adam Dressel
// Basic ATM machine simulator. Integrating basic skills learned about java.


public class Main {

  public static void main(String[] args) {
    // New scanner object reads user input
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to to Bank of Java terminal!");
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
      // Second option, simply a deposit option.
        // User can currently deposit any integer they choose.
        // Similar to withdrawal option, calls the deposit method on the chosen
        // account.
      // Third option, displays indicated balance by calling the getBalance()
        // method on the chosen account.
      // All other integers, result in repeating the loop.
      switch(userChoice) {
        case 1: System.out.printf
        ("%.2f",Account.acctMenu(checking, savings).withdrawal());
                break;
        case 2: System.out.printf
        ("%.2f",Account.acctMenu(checking, savings).deposit());
                break;
        case 3: System.out.printf
        ("%.2f",Account.acctMenu(checking, savings).getBalance());
                break;
        case 4: keepLoop = false;
                break;
        default: keepLoop = true;
                 System.out.println("This is not a valid option,"
                 + " please choose one of the above."); 
      }
    } while (keepLoop);
    scan.close();
    System.out.println("Thank you for choosing Bank of Java!");
  }
}
