import java.util.Date;
//Bill class will create bill objects that hold a payment balance,
//as well as a due date for which the payment is due.
public class Bill {
  private double billBal;
  private Date dueDate = new Date();
  
  public Bill(double billBal, Date dueDate) {
    billBal = this.billBal;
    dueDate = this.dueDate;
  }
  
  public void setBillBal(double billBal){
    billBal = this.billBal;
  }
  
  public void setDueDate(Date dueDate){
    dueDate = this.dueDate;
  }
}
