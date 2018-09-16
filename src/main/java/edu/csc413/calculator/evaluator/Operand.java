package com.company;

import static java.lang.Integer.getInteger;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;


/**
 * Operand class used to represent an operand
 * in a valid mathmetical expression.
 */
public class Operand {

  int value;
  /**
  * construct operand from string token.
  */
  public Operand (String token){
    this.value = Integer.parseInt(token);

  }
  /**
   * construct operand from integer
   */
  public Operand(int value ) {

    this.value = value;
  }
  /**
   * return value of opernad
   */
  public int getValue() {

    return value;
  }
  /**
   * Check to see if given token is a valid
   * operand.
   */
  public static boolean check( String token ) {

    try {
      int num = Integer.parseInt(token);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }

  }
}
