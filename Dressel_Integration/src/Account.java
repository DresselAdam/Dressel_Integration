import java.util.Random;
import java.util.Scanner;

public class Account {
  private double checkingBal;
  private double savingBal;
  //Variables for future use.
  private String acctName;
  private int acctNum;

  // setBalance method uses random to generate a random balance for an account.
  public void setCheckingBal(double bal) {
    checkingBal= bal;
  }
  public void setSavingBal(double bal) {
    savingBal = bal;
  }
  public double getSavingBal() {
    return savingBal;
  }
  // getBalance returns the value of balance, first created by setBalance,
  // and then altered by the various other methods.
  public double getCheckingBal() {
    return checkingBal;
  }
  public double savingWthdrwl(int withAmnt) {
    if (withAmnt > savingBal) {
      System.out.println("Not enough funds.");
    } else {
      savingBal -= withAmnt;
    }
    return savingBal;
  }
  public double checkingWthdrwl(int withAmnt) {
    if (withAmnt > checkingBal) {
      System.out.println("Not enough funds.");
    } else {
      checkingBal -= withAmnt;
    }
    return checkingBal;
}
  public double savingDep(int depAmnt) {
    savingBal += depAmnt;
    System.out.println("Thank you! Your new balance is ");
    return savingBal;
  }
  public double checkingDep(int depAmnt) {
    checkingBal += depAmnt;
    System.out.println("Thank you! Your new balance is ");
    return checkingBal;
  }
}
/*  
  // The acctMenu method option is used to choose an account inside each menu
  // option in main. For example if the user chooses withdrawal, the main
  // method will run the acctMenu method, let the user decide on an account,
  // and then run the withdrawal for that account. The acctMenu is static
  // because we are using it to choose a specific class object.
  
  // The following line is a header, 
  // and inside the parentheses are the parameters
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

}*/
