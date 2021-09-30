/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator;

import java.util.Deque;

/**
 *
 * @author Admin
 */
public class Operand<T> implements Token<T> {
    private final T val;

    public Operand(T val) {
        this.val = val;
    }

    @Override
    public void process(Deque<T> stack) {
        stack.push(val);
    }
}
