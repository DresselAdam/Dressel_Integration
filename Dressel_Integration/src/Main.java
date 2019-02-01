import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

// Adam Dressel
// Basic ATM machine simulator. Integrating basic skills learned about java.

/*
 * byte: The byte data type is an 8-bit signed two's complement integer. It has 
 * a minimum value of -128 and a maximum value of 127 (inclusive). 
 * The byte data type can be useful for saving memory
 * in large arrays, where the memory savings actually matters. 
 * They can also be used in place of int
 * where their limits help to clarify your code; 
 * the fact that a variable's range is limited can
 * serve as a form of documentation.
 * 
 * short: The short data type is a 16-bit signed two's complement integer. 
 * It has a minimum value of -32,768 and a maximum value of 32,767 (inclusive). 
 * As with byte, the same guidelines apply: you
 * can use a short to save memory in large arrays, 
 * in situations where the memory savings actually matters.
 * 
 * int: By default, the int data type is a 32-bit signed two's complement 
 * integer, which has a minimum value of -231 and a maximum value of 231-1. 
 * In Java SE 8 and later, you can use the int data type to represent an 
 * unsigned 32-bit integer, which has a minimum value of 0 and a maximum
 * value of 232-1. Use the Integer class to use int data type as an unsigned 
 * integer. See the section The Number Classes for more information. 
 * Static methods like compareUnsigned, divideUnsigned etc have been added to 
 * the Integer class to support the arithmetic operations for unsigned integers.
 * 
 * long: The long data type is a 64-bit two's complement integer. 
 * The signed long has a minimum value of -263 and a maximum value of 263-1. 
 * In Java SE 8 and later, you can use the long data type to represent an 
 * unsigned 64-bit long, which has a minimum value of 0 and a maximum value of
 * 264-1. Use this data type when you need a range of values wider than those 
 * provided by int. The Long class also contains methods like compareUnsigned, 
 * divideUnsigned etc to support arithmetic operations for unsigned long.
 * 
 * float: The float data type is a single-precision 32-bit IEEE 754 floating point. Its range of
 * values is beyond the scope of this discussion, but is specified in the Floating-Point Types,
 * Formats, and Values section of the Java Language Specification. As with the recommendations for
 * byte and short, use a float (instead of double) if you need to save memory in large arrays of
 * floating point numbers. This data type should never be used for precise values, such as currency.
 * For that, you will need to use the java.math.BigDecimal class instead. Numbers and Strings covers
 * BigDecimal and other useful classes provided by the Java platform.
 * 
 * double: The double data type is a double-precision 64-bit IEEE 754 floating point. Its range of
 * values is beyond the scope of this discussion, but is specified in the Floating-Point Types,
 * Formats, and Values section of the Java Language Specification. For decimal values, this data
 * type is generally the default choice. As mentioned above, this data type should never be used for
 * precise values, such as currency.
 * 
 * boolean: The boolean data type has only two possible values: true and false. Use this data type
 * for simple flags that track true/false conditions. This data type represents one bit of
 * information, but its "size" isn't something that's precisely defined.
 * 
 * char: The char data type is a single 16-bit Unicode character. It has a minimum value of '\u0000'
 * (or 0) and a maximum value of '\uffff' (or 65,535 inclusive).
 * 
 * source: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 */

// Variables - a location in memory
// Scope - A variable is only accessible in the method it was declared.

// Input from numbers to strings - must clear buffer.


/*
 * Whenever you divide integers, the result is an integer, and any floating point number gets
 * truncated.
 */
public class Main {

  public static void main(String[] args) {
    // New scanner object reads user input
    Scanner scan = new Scanner(System.in);
    System.out.println("Welcome to to Bank of Java termninal!");
    // Random balance generated for each account. And stored as double balance
    DecimalFormat money = new DecimalFormat(".##");
    double checkingBalance = (Math.random() * 1000);
    double savingBalance = (Math.random() * 1000);

    /*
     * final keyword used for a fee applied to a withdrawal transaction. 
     * The final keyword is used
     * for a constant, unchanging variable. 
     * This helps me avoid making errors when applying the fee to calculations.
     */
    /*Casting variables is used to convert variable types. This is useful 
     *performing operations with two different variable types, such as an int
     *and a double. 
     * */
    final int FEE = (int)1;

    String accountMenu = 
        "Choose an account - Enter 1 for Checking - Enter 2 for Savings";

    /*
     * User enters branch where they can either add or subtract money 
     * from current balance.
     */

    String menu = 
        "Enter 1 for Withdrawal - Enter 2 for Deposit - "
        + "Enter 3 to Check Balances";

    // keepLoop boolean to determine whether to continue the program.

    boolean keepLoop = false;
    /*
     * Scans for number the user enters, if a correct choice is not entered, 
     * an error will appear.
     * Each case has two options, one to access their checking account, 
     * the other to access their savings.
     */

    /*
     * A do/while loop is used so that the messages will replay if 
     * the user enters an invalid option
     * or input. At the end of each branch the keepLoop value is set to the 
     * corresponding value.
     */

    do {
      System.out.println(menu);
      int userChoice = scan.nextInt();

      /*
       * 1st choice. If user tries to withdrawal more money than the balance, 
       * an error message appears.
       */
      if (userChoice == 1) {
        System.out.println(accountMenu);
        int accountNum = scan.nextInt();
        if (accountNum == 1) {
          System.out.println("Enter amount you wish to withdraw ");
          keepLoop = false;
          int userWithdrawal = scan.nextInt();
          if (userWithdrawal > checkingBalance) {
            System.out.println("Not enough funds.");
            keepLoop = true;
          } else {
            System.out.println("Thank you! Your new balance is "
                + money.format(checkingBalance - (userWithdrawal + FEE)) + "$");
          }
        } 
        else if (accountNum == 2) {
          System.out.println("Enter amount you wish to withdraw ");
          keepLoop = false;
          int userWithdrawal = scan.nextInt();
          if (userWithdrawal > savingBalance) {
            System.out.println("Not enough funds.");
            keepLoop = true;
          } 
          else {
            System.out.println("Thank you! Your new balance is "
                + money.format(savingBalance - (userWithdrawal + FEE)) + "$");
          }
        }
      }

      /* Second option, simply a deposit option. 
      User can currently deposit any integer they choose.*/
      else if (userChoice == 2) {
        keepLoop = false;
        System.out.println(accountMenu);
        int accountNum = scan.nextInt();
        if (accountNum == 1) {
          System.out.println("Enter amount you wish to deposit");
          int userDeposit = scan.nextInt();
          System.out.println(
              "Thank you! Your new balance is " + 
               money.format(checkingBalance + userDeposit) + "$");
        } 
        else if (accountNum == 2) {
          System.out.println("Enter amount you wish to deposit");
          int userDeposit = scan.nextInt();
          System.out.println(
              "Thank you! Your new balance is " + 
               money.format(savingBalance + userDeposit) + "$");
        }
      }

      // Third option, displays indicated balance
      else if (userChoice == 3) {
        System.out.println(accountMenu);
        int accountNum = scan.nextInt();
        if (accountNum == 1) {
          System.out.println(money.format(checkingBalance) + "$");
        } 
        else if (accountNum == 2) {
          System.out.println(money.format(savingBalance) + "$");
        } 
        else {

        }
        keepLoop = true;
      }

      // All other integers, result in repeating the loop.
      else {
        keepLoop = true;
        System.out.println
        ("This is not a valid option, please choose one of the above.");
        userChoice = scan.nextInt();
      }
    } while (keepLoop);
    scan.close();
  }
}


