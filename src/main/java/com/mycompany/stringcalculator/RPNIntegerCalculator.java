/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.stringcalculator;

import com.mycompany.stringcalculator.operators.SubtractInteger;
import com.mycompany.stringcalculator.operators.MultiplyInteger;
import com.mycompany.stringcalculator.operators.MinusInteger;
import com.mycompany.stringcalculator.operators.DivideInteger;
import com.mycompany.stringcalculator.operators.Operator;
import com.mycompany.stringcalculator.operators.AddInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Admin
 */

public class RPNIntegerCalculator implements RPNCalculator<Integer> {
    private static final Map<String, Operator<Integer>> OPERATOR_MAP = new HashMap<>();

    public void addOperator(String symbol, Operator<Integer> operator) {
        OPERATOR_MAP.put(symbol, operator);
    }

    public void loadDefaultBinaryOperators() {
        OPERATOR_MAP.put("+", new AddInteger(2));
        OPERATOR_MAP.put("-", new SubtractInteger(2));
        OPERATOR_MAP.put("*", new MultiplyInteger(2));
        OPERATOR_MAP.put("/", new DivideInteger(2));
        OPERATOR_MAP.put("u-", new MinusInteger(1));
    }

    @Override
    public List<Token<Integer>> parse(String expression) {
        if(expression == null || expression.length() == 0) {
            throw new IllegalArgumentException("Invalid Reverse Polish Expression");
        }

        String[] tokens = expression.split(" ");
        List<Token<Integer>> tokenList = new ArrayList<>();
        for(String token : tokens) {
            if(OPERATOR_MAP.containsKey(token)) {
                tokenList.add(OPERATOR_MAP.get(token));
            } else {
                try {
                    tokenList.add(new Operand<>(Integer.decode(token)));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid Reverse Polish Token Found: " +
                            token, e);
                }
            }
        }

        return tokenList;
    }

    public static void main(String...args) {
        System.out.println("Введите выражение: ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        ExpressionParser ex = new ExpressionParser();
               
        String csv = String.join(" ", ex.parse(s));
        
        RPNIntegerCalculator calculator = new RPNIntegerCalculator();
        calculator.loadDefaultBinaryOperators();
        System.out.println("Результат: " + calculator.evaluate(csv));
    }
}
