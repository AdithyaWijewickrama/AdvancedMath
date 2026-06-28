package com.awapps.advancedmath.calculate.equation;

import com.awapps.advancedmath.tokenizing.Token;
import static com.awapps.advancedmath.tokenizing.Token.DIVIDE;
import static com.awapps.advancedmath.tokenizing.Token.MINUS;
import static com.awapps.advancedmath.tokenizing.Token.RAISED;
import static com.awapps.advancedmath.tokenizing.Token.PLUS;
import com.awapps.advancedmath.tokenizing.TokenType;
import com.awapps.advancedmath.calculate.CNumber;

import java.util.logging.Level;
import java.util.logging.Logger;

import static com.awapps.advancedmath.tokenizing.Token.MULTIPLY;

/**
 *
 * @author AW Developer
 */
public class Operator extends Calculate {

    Token operator;

    public Operator(Calculate v1, Token operator, Calculate v2) {
        super(v1, TokenType.OPARATOR, v2);
        this.operator = operator;
    }

    public CNumber toLatex(){
        try {
            if (operator == PLUS) {
                return CNumber.parseNumber(Double.sum(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (operator == MINUS) {
                return CNumber.parseNumber(Double.sum(value1.doTheMath().doubleValue(), -value2.doTheMath().doubleValue()));
            }
            if (operator == RAISED) {
                return CNumber.parseNumber(Math.pow(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (operator == MULTIPLY) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() * value2.doTheMath().doubleValue());
            }
            if (operator == DIVIDE) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() / value2.doTheMath().doubleValue());
            } else {
                throw new AssertionError();
            }
        } catch (AssertionError assertionError) {
            Logger.getLogger(Operator.class.getName()).log(Level.SEVERE,null,assertionError);
        }

        return null;
    }

    @Override
    public CNumber doTheMath() {
        try {
            if (operator == PLUS) {
                return CNumber.parseNumber(Double.sum(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (operator == MINUS) {
                return CNumber.parseNumber(Double.sum(value1.doTheMath().doubleValue(), -value2.doTheMath().doubleValue()));
            }
            if (operator == RAISED) {
                return CNumber.parseNumber(Math.pow(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (operator == MULTIPLY) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() * value2.doTheMath().doubleValue());
            }
            if (operator == DIVIDE) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() / value2.doTheMath().doubleValue());
            } else {
                throw new AssertionError();
            }
        } catch (AssertionError assertionError) {
            Logger.getLogger(Operator.class.getName()).log(Level.SEVERE,null,assertionError);
        }

        return null;
    }
}
