/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator.operators;

import com.mycompany.stringcalculator.operators.Operator;
import java.util.List;

/**
 *
 * @author Admin
 */
public class MinusInteger extends Operator<Integer> {
    public MinusInteger(int numOfOperand) {
        super(numOfOperand);
    }

    @Override
    public Integer calc(List<Integer> vals) {
        double total = -vals.get(0);
        

        if (total > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer value overflow");
        }
        if (total < Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer value underflow");
        }
        return (int) total;
    }
}
