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
    // final keyword used for a fee applied to a withdrawal transaction. 
    // The final keyword is used
    // for a constant, unchanging variable. This helps me avoid 
    //making errors when applying the fee
    // to calculations.
    final int FEE = (int) 1;



    String menu = " \n 1 - Check Balances  \n " + 
    "2 - to withdrawal from savings \n "
        + "3 - to withdrawal from checking \n " + "4 - for savings deposit \n "
        + "5 - for checking deposit \n " + "6 - to transfer \n 7 - My Earnings";

    String transferMenu = "\n 1 - checking --> savings " + 
    "\n 2 - savings --> checking";


    // keepLoop boolean to determine whether to continue the program.
    // only changed to false when the user chooses the exit option.
    boolean keepLoop = true;

    do {
      System.out.println(menu);
      int userChoice = scan.nextInt();
      
      switch (userChoice) {
        case 1:
          System.out.printf("Checking:" + "%.2f" + "\n", user1.getCheckingBal());
          // This is a method call inside a print statement,
          // the arguments are the Account objects in parentheses.
          System.out.printf("Savings:" + "%.2f", user1.getSavingBal());
          //break is a keyword that immediately exits the loop and continues to
          //the next statement after the loop.
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
          System.out.println(transferMenu);
          int acctChoice = scan.nextInt();
          do {
            if (acctChoice != 1 && acctChoice != 2) {
              System.out.println("Not a valid option, try again.");
            } else if (acctChoice == 1) {
                System.out.println("Enter amount to transfer: ");
                int transferAmt = scan.nextInt();
                user1.transferSavToCheck(transferAmt);
                System.out.println("Success! Press 1 to check new balances.");
            } else if (acctChoice == 2) {
                System.out.println("Enter amount to transfer: ");
                int transferAmt = scan.nextInt();
                if(transferAmt > user1.getCheckingBal()) {
                  System.out.println("Sorry, not enough funds.");
              }
                else {
                  user1.transferCheckToSav(transferAmt);
                  System.out.println("Success! Press 1 to check new balances.");
                }
              } 
          } while (acctChoice != 1 && acctChoice != 2);
          break;
        case 7:
          System.out.println("Enter year you would like to calculate: ");
          int year = scan.nextInt();
          System.out.printf("Balance in the year " + year + "%.2f", 
              /*This is a method call, and year is the argument*/
              user1.getCompInt(year));
          break;
        default:
          keepLoop = true;
          System.out.println("This is not a valid option," + 
          " please choose one of the above.");
      }
      // The continue keyword causes the loop to immediately jump to the next
      // iteration of the loop.
      continue;
    } while (keepLoop);
    scan.close();
    System.out.println("Thank you for choosing Bank of Java!");
  }
}
