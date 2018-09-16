package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.operators.AddOperator;
import edu.csc413.calculator.operators.SubtractOperator;
import edu.csc413.calculator.operators.DivideOperator;
import edu.csc413.calculator.operators.MultiplyOperator;
import edu.csc413.calculator.operators.Operator;
import edu.csc413.calculator.operators.PowerOperator;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Evaluator {
  private Stack<Operand> operandStack;//this stack contains operand objects
  private Stack<Operator> operatorStack;//this stack contains operator objects
  private StringTokenizer tokenizer;
  private static final String DELIMITERS = "+-*^/";

  public Evaluator() {//constructor enables creation of the stacks
    operandStack = new Stack<>();
    operatorStack = new Stack<>();

    Operator.operators.put("+", new AddOperator());
    Operator.operators.put("-", new SubtractOperator ());
    Operator.operators.put("*", new MultiplyOperator());
    Operator.operators.put("/", new DivideOperator());
    Operator.operators.put("^", new PowerOperator());



  }

  public int eval( String expression ) {
    String token;

    // The 3rd argument is true to indicate that the delimiters should be used
    // as tokens, too. But, we'll need to remember to filter out spaces.
    this.tokenizer = new StringTokenizer( expression, DELIMITERS, true );

    // initialize operator stack - necessary with operator priority schema
    // the priority of any operator in the operator stack other than
    // the usual mathematical operators - "+-*/" - should be less than the priority
    // of the usual operators


    //parses expression
   
while (this.tokenizer.hasMoreTokens()) {
        // filter out spaces
        if (!(token = this.tokenizer.nextToken()).equals(" ")) {
            token.replaceAll(" " , "");
          // check if token is an operand
          if (Operand.check(token)) {
            operandStack.push(new Operand(token));
          } else {
            if (!Operator.check(token)) {//invalid
              System.out.println("*****invalid token******");
              throw new RuntimeException("*****invalid token******");
            } else { //an operator
              Operator newOperator = Operator.operators.get(token);//need to create a new operator object
              if (operatorStack.isEmpty()) {
                operatorStack.push(newOperator);
              }
              /*else if ((operatorStack.peek().priority() <= newOperator.priority())) {
                operatorStack.push(newOperator);
              }*/
              else{
                  if (operandStack.size() >=2 && operatorStack.peek().priority() >= newOperator.priority()) {
                          Operator oldOpr = operatorStack.pop();
                          Operand op2 = operandStack.pop();
                          Operand op1 = operandStack.pop();
                          operandStack.push(oldOpr.execute(op1, op2));

                          operatorStack.push(newOperator);
                  }else{
                      operatorStack.push(newOperator);
                  }


              }
            }
          }
        }//close loop to filter out spaces

      }

    //while (operatorStack.peek().priority() >= newOperator.priority()) {
    // note that when we eval the expression 1 - 2 we will
    // push the 1 then the 2 and then do the subtraction operation
    // This means that the first number to be popped is the
    // second operand, not the first operand - see the following code
    while(!operatorStack.isEmpty()) {
      Operator oldOpr = operatorStack.pop();
      Operand op2 = operandStack.pop();
      Operand op1 = operandStack.pop();
      operandStack.push(oldOpr.execute(op1, op2));
    }
    return operandStack.pop().getValue();

  }
}
