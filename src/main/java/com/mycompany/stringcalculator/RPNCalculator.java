/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface RPNCalculator<T> {
    default T evaluate(String expression) {
        return evaluate(parse(expression));
    }

    default T evaluate(List<Token<T>> tokens) {
        Deque<T> stack = new LinkedList<>();
        for (Token<T> t : tokens) {
            t.process(stack);
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Reverse Polish Notation Provided");
        }
        return stack.poll();
    }

    List<Token<T>> parse(String expression);
}
