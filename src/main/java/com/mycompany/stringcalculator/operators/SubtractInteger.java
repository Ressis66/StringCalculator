/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator.operators;

/**
 *
 * @author Admin
 */
import com.mycompany.stringcalculator.operators.Operator;
import java.util.List;


public class SubtractInteger extends Operator<Integer>{
    public SubtractInteger(int numOfOperand) {
        super(numOfOperand);
    }

    @Override
    public Integer calc(List<Integer> vals) {
        double total = vals.get(0);
        for (int i = 1; i < vals.size(); i++) {
            total -= vals.get(i);
        }

        if (total > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer value overflow");
        }
        if (total < Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer value underflow");
        }
        return (int) total;
    }
}
