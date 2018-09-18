package edu.csc413.calculator.evaluator;
import java.lang.*;


/**
 * Operand class used to represent an operand
 * in a valid mathmetical expression.
 */
public class Operand {
  int value;
  /**
  * construct operand from string token.
  */  
  public Operand( String token ) {
      value = Integer.parseInt(token);
  }
  /**
   * construct operand from integer
   */
  public Operand( int value ) {

    this.value = value;
  }
  /**
   * return value of opernad
   */
  public int getValue() {

    return value;
    //changing this return 0 to return value
  }
  /**
   * Check to see if given token is a valid
   * operand.
   */
  public static boolean check( String token ) { //valid when token is an Operand  1,2,3,etc.

    try{
      int num = Integer.parseInt(token);
      return true;
    }catch (NumberFormatException e){
      return false;

    }

  }
}
