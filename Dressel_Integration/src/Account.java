import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;
//Adam Dressel
//Basic ATM machine simulator. Integrating basic skills learned about java.
public class Account {
  // At this point each account object can hold a value for a checking and
  // savings account.
  private double checkingBal;
  private double savingBal;
  //Variables for future use.
  private String acctName;
  private int acctNum;
  
  // setBalance methods are used to set the balance fields to the arguments
  // passed by main.
  public void setCheckingBal(double bal) {
    checkingBal= bal;
  }
  //setSavingBal is a header and double bal is the parameter of this method.
  public void setSavingBal(double bal) {
    savingBal = bal;
  }
//getBalance methods return the value of the corresponding balance, 
 // first created by the setBalance methods,
 // and then altered by the various other methods.
  public double getSavingBal() {
    return savingBal;
  }
  public double getCheckingBal() {
    return checkingBal;
  }
  // Takes away value from the savingBal, returns no actual money
  public double savingWthdrwl(int withAmnt) {
    if (withAmnt > savingBal) {
      System.out.println("Not enough funds.");
    } else {
      savingBal -= withAmnt;
    }
    return savingBal;
  }
  // Takes away value from the checkingBal, returns no actual money
  public double checkingWthdrwl(int withAmnt) {
    if (withAmnt > checkingBal) {
      System.out.println("Not enough funds.");
    } else {
      checkingBal -= withAmnt;
    }
    return checkingBal;
}
  // Deposit methods add value to the corresponding balance based on the
  // arguments called by the methods.
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
  // The transfer methods take a constant transfer amount, subtract that value
  // from one balance and add it to the other balance.
  public double transferSavToCheck(int tranAmt) {
      savingBal -= tranAmt;
      checkingBal += tranAmt;
      return checkingBal;  
  }
  public double transferCheckToSav(int tranAmt) {
      savingBal += tranAmt;
      checkingBal -= tranAmt;
      return savingBal;  
  }
  //The compound interest method calculates the interest accumulated in a 
  //savings account over the next ten years. It returns the value of an element
  // of the array indexed at the integer NumofYears, which is the number of 
  // years in advance being calculated.
  public double getCompInt(int year){
    // Variables used in compound interest calculation. r = annual interest
    // A = amount after compounded interests, n = the # of times r is compounded
    // P = initial amount, t = time in years.
    Calendar cal = Calendar.getInstance();
    int NumofYears = year - cal.get(Calendar.YEAR);
    final double r = .08; double A; double P; int n = 12;
    P = savingBal;
    double[] newBalances = new double[10];
    for(int t = 0; t < 10; t++) {
     A = P * Math.pow(1 + (r/n),n*t);
     newBalances[t] = A;
    }
    return newBalances[NumofYears];
  }
}

