import java.util.Random;
import java.util.Scanner;

public class Account {
  private double balance;
  private static Scanner scan = new Scanner(System.in);
  private static String acctMenu =
      "Choose an account - Enter 1 for Checking " + "- Enter 2 for Savings";
  private static int acctNum;
  private Random randBal = new Random();

  // setBalance method uses random to generate a random balance for an account.
  public void setBalance() {
    balance = randBal.nextDouble() * 1000;
  }

  // getBalance returns the value of balance, first created by setBalance,
  // and then altered by the various other methods.
  public double getBalance() {
    return balance;
  }
  
  // The acctMenu method option is used to choose an account inside each menu
  // option in main. For example if the user chooses withdrawal, the main
  // method will run the acctMenu method, let the user decide on an account,
  // and then run the withdrawal for that account. The acctMenu is static
  // because we are using it to choose a specific class object.
  public static Account acctMenu(Account acctNum1, Account acctNum2) {
    Account chosenAcct = new Account();
    do {
      System.out.println(acctMenu);
      acctNum = scan.nextInt();
      if (acctNum == 1) {
        chosenAcct = acctNum1;
      } else if (acctNum == 2) {
        chosenAcct = acctNum2;
      } else {
        System.out.println("Error, please choose a valid option.");
      }
    } while (acctNum != 1 && acctNum != 2);
    return chosenAcct;
  }

  // The withdrawal method is used by subtracting a given amount from the
  // object's current balance. An if statement is used in case a user attempts
  // to withdraw more money than they have in their account balance.
  public double withdrawal() {
    System.out.println("Choose amount to withdraw:");
    int withAmnt = scan.nextInt();
    if (withAmnt > balance) {
      System.out.println("Not enough funds.");
    } else {
      balance -= withAmnt;
    }
    return balance;
  }

  // The deposit method works similar to the withdraw, except we are adding to
  // the balance of the chosen account.
  public double deposit() {
    int depAmnt = scan.nextInt();
    balance += depAmnt;
    System.out.println("Thank you! Your new balance is ");
    return balance;
  }

}
