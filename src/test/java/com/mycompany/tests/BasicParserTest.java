/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tests;

import com.mycompany.stringcalculator.ExpressionParser;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Admin
 */
public class BasicParserTest {
    @Test
    public void shouldParse()throws Exception{
        String s = "1+0";
        ExpressionParser parser = new ExpressionParser();
        assertNotNull(parser.parse(s));
}
}
