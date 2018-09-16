package edu.csc413.calculator.evaluator;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    String regex = "[+-]?[0-9][0-9]*";//using regext to check for integer in string

    if (token.contains(regex)){

      return true;
    }

    return false;
  }
}
