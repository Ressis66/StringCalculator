/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tests;

import com.mycompany.stringcalculator.RPNIntegerCalculator;
import static org.junit.Assert.assertEquals;
import org.junit.Test; 

/**
 *
 * @author Admin
 */
public class BasicCalculatorTest {



    @Test
    public void shouldCalculateCorrectWhenAnyExample() throws Exception{
        RPNIntegerCalculator calculator = new RPNIntegerCalculator();
        calculator.loadDefaultBinaryOperators();
        assertEquals( calculator.evaluate( "-2" ) , Integer.valueOf(-2));
        assertEquals( calculator.evaluate( "3 4 +" ) , Integer.valueOf(7));
        assertEquals( calculator.evaluate( "12 4 / 1 -" ) , Integer.valueOf(2));
        assertEquals( calculator.evaluate( "12 4 1 - /" ) , Integer.valueOf(4));
        assertEquals( calculator.evaluate( "15 7 1 1 + - / 3 * 2 1 1 + + -" ) , Integer.valueOf(5));

    }
    }

