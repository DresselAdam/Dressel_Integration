// Adam Dressel
// Basic ATM machine simulator. Integrating basic skills learned about java.
public class Residual {
  private String first = "I am";
  private String second = "I am not";
  
  
  
  public void stringDemo() {
  //equals method returns a boolean value.
    first.equals(second);
    //compareTo method returns an integer value, determined by how one
    //string compares lexicographically to another string.
    second.compareTo(first);
    // The == operator does not compare the actual value of the argument in
    // the object, but it compares the object reference value. Which is
    // determined when the object is instanced.
  }
  public void ternary() {
    // Will return "Nope" since the value of first string does not equal second.
   String isIT = first.equals(second) ? "Yes" : "Nope";
  }
}
