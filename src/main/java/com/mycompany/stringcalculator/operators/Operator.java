/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator.operators;

import com.mycompany.stringcalculator.Token;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Admin
 */
public abstract class Operator<T> implements Token<T> {
    private final int numOfOperand;

    protected Operator(int numOfOperand) {
        this.numOfOperand = numOfOperand;
    }

    @Override
    public void process(Deque<T> stack) {
        if(stack == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        if(stack.size() < numOfOperand) {
            throw new IllegalArgumentException("There is not enough elements to calculate");
        }

        List<T> valList = new ArrayList<>(numOfOperand);
        for(int i = 0; i < numOfOperand; i++) {
            valList.add(0, stack.pop());
        }
        stack.push(calc(valList));
    }

    public abstract T calc(List<T> vals);
}
