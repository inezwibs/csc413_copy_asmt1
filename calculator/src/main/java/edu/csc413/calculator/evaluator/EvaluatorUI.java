package edu.csc413.calculator.evaluator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    private static final String DELIMITERS = "+-*^/()";

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
        "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
        "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent arg0) {
        // You need to fill in this fuction

            if(arg0.getSource().equals(buttons[0])){
                txField.setText(txField.getText() + bText[0]);
            }else if (arg0.getSource().equals(buttons[1])) {//button 8
                txField.setText(txField.getText() + bText[1]);
            }else if(arg0.getSource().equals(buttons[2])){//button 9
                txField.setText(txField.getText() + bText[2]);
            }else if(arg0.getSource().equals(buttons[3])){//button +
                txField.setText(txField.getText() + bText[3]);
            }else if(arg0.getSource().equals(buttons[4])){//button 4
                txField.setText(txField.getText() + bText[4]);
            }else if(arg0.getSource().equals(buttons[5])){ //button 5
                txField.setText(txField.getText() + bText[5]);
            }else if(arg0.getSource().equals(buttons[6])){//button 6
                txField.setText(txField.getText() + bText[6]);
            }else if(arg0.getSource().equals(buttons[7])){//button -
                txField.setText(txField.getText() + bText[7]);
            }else if (arg0.getSource().equals(buttons[8])) {//button 1
                txField.setText(txField.getText() + bText[8]);
            }else if(arg0.getSource().equals(buttons[9])){//button 2
                txField.setText(txField.getText() + bText[9]);
            }else if(arg0.getSource().equals(buttons[10])){//button 3
                txField.setText(txField.getText() + bText[10]);
            }else if(arg0.getSource().equals(buttons[11])){//button *
                txField.setText(txField.getText() + bText[11]);
            }else if(arg0.getSource().equals(buttons[12])){ //button 0
                txField.setText(txField.getText() + bText[12]);
            }else if(arg0.getSource().equals(buttons[13])){//button ^
                txField.setText(txField.getText() + bText[13]);
            }else if(arg0.getSource().equals(buttons[14])) {//button = equals button needs to evaluate

                Evaluator myEv = new Evaluator();
                int result = myEv.eval(txField.getText());
                txField.setText(Integer.toString(result));

            }else if(arg0.getSource().equals(buttons[15])){ //button /
                txField.setText(txField.getText() + bText[15]);
            }else if(arg0.getSource().equals(buttons[16])){//button (
                txField.setText(txField.getText() + bText[16]);
            }else if(arg0.getSource().equals(buttons[17])){//button )
                txField.setText(txField.getText() + bText[17]);
            }else if (arg0.getSource().equals(buttons[18])){
                txField.setText(" ");

            }else if (arg0.getSource().equals(buttons[19])){
                
                    String result = txField.getText();
                    txField.setText(result.substring(0, result.length() - 1));

            }else{
                txField.setText("Something went wrong.Please re-enter");
            }


    }
}
