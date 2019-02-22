import java.util.Random;
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
    Random randBal = new Random();
    Account user1 = new Account();
    user1.setCheckingBal(randBal.nextDouble() * 1000);
    user1.setSavingBal(randBal.nextDouble() * 1000);
    // final keyword used for a fee applied to a withdrawal transaction. The final keyword is used
    // for a constant, unchanging variable. This helps me avoid making errors when applying the fee
    // to calculations.
    final int FEE = (int) 1;



    String menu = " \n 1 - Check Balances  \n " + "2 - to withdrawal from savings \n "
        + "3 - to withdrawal from checking \n " + "4 - for savings deposit \n "
        + "5 - for checking deposit \n " + "6 - to Exit";


    // keepLoop boolean to determine whether to continue the program.
    // only changed to false when the user chooses the exit option.
    boolean keepLoop = true;

    do {
      System.out.println(menu);
      int userChoice = scan.nextInt();
      // 1st option If user tries to withdrawal more money than the balance,
      // an error message appears. The withdrawal method is called on the chosen
      // account.
      // Second option simply a deposit option.
      // User can currently deposit any integer they choose.
      // Similar to withdrawal option, calls the deposit method on the chosen
      // account.
      // Third option displays indicated balance by calling the getBalance()
      // method on the chosen account.
      // Fourth option exits the loop and closes the scanner.
      // All other integers, result in repeating the loop.
      switch (userChoice) {
        case 1:
          System.out.printf("Checking:" + "%.2f" + "\n", user1.getCheckingBal());
          // This is a method call inside a print statement,
          // the arguments are the Account objects in parentheses.
          System.out.printf("Savings:" + "%.2f", user1.getSavingBal());
          break;
        case 2:
          System.out.println("Choose amount to withdraw:");
          System.out.printf("%.2f", user1.savingWthdrwl(scan.nextInt()));
          break;
        case 3:
          System.out.println("Choose amount to withdraw:");
          System.out.printf("%.2f", user1.checkingWthdrwl(scan.nextInt()));
          break;
        case 4:
          System.out.println("Choose amount to deposit:");
          System.out.printf("%.2f", user1.savingDep(scan.nextInt()));
          break;
        case 5:
          System.out.println("Choose amount to deposit:");
          System.out.printf("%.2f", user1.checkingDep(scan.nextInt()));
          break;
        case 6:
          keepLoop = false;
          break;
        default:
          keepLoop = true;
          System.out.println("This is not a valid option," + " please choose one of the above.");
      }
    } while (keepLoop);
    scan.close();
    System.out.println("Thank you for choosing Bank of Java!");
  }
}
