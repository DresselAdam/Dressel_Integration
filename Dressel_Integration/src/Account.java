import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
  private double balance;
  private Scanner scan = new Scanner(System.in);

  // Withdrawal method, main class takes user input and subtracts it
  // from the balance.
  public void setBalance() {
    balance = (Math.random() * 1000);
  }

  public double getBalance() {
    return balance;
  }

  public double withdrawal() {
    int withAmnt = scan.nextInt();
    if (withAmnt > balance) {
      System.out.println("Not enough funds.");
    } else {
      balance -= withAmnt;
    }
    return balance;
  }

  public double deposit() {
    int depAmnt = scan.nextInt();
    balance += depAmnt;
    System.out.println("Thank you! Your new balance is ");
    return balance;
  }

}
