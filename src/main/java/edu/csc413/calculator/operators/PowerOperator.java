package edu.csc413.calculator.operators;

import edu.csc413.calculator.evaluator.Operand;

public class PowerOperator extends Operator {

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public Operand execute(Operand op1, Operand op2) {
        double num = Math.pow(op1.getValue(),op1.getValue());
        Operand resultPowObj = new Operand ((int) num); //cast double to integer
        return resultPowObj;
    }
}
