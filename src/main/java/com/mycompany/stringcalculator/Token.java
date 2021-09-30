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
public interface Token<T> {
    void process(Deque<T> stack);
}
