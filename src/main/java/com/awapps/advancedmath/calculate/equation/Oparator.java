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
public class Oparator extends Calculate {

    Token oparator;

    public Oparator(Calculate v1, Token oparator, Calculate v2) {
        super(v1, TokenType.OPARATOR, v2);
        this.oparator = oparator;
    }

    public String toLatex(){
        try {
            if (oparator == PLUS) {
                return
            }
            if (oparator == MINUS) {
                return CNumber.parseNumber(Double.sum(value1.doTheMath().doubleValue(), -value2.doTheMath().doubleValue()));
            }
            if (oparator == RAISED) {
                return CNumber.parseNumber(Math.pow(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (oparator == MULTIPLY) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() * value2.doTheMath().doubleValue());
            }
            if (oparator == DIVIDE) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() / value2.doTheMath().doubleValue());
            } else {
                throw new AssertionError();
            }
        } catch (AssertionError assertionError) {
            Logger.getLogger(Oparator.class.getName()).log(Level.SEVERE,null,assertionError);
        }

        return null;d
    }

    @Override
    public CNumber doTheMath() {
        try {
            if (oparator == PLUS) {
                return CNumber.parseNumber(Double.sum(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (oparator == MINUS) {
                return CNumber.parseNumber(Double.sum(value1.doTheMath().doubleValue(), -value2.doTheMath().doubleValue()));
            }
            if (oparator == RAISED) {
                return CNumber.parseNumber(Math.pow(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (oparator == MULTIPLY) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() * value2.doTheMath().doubleValue());
            }
            if (oparator == DIVIDE) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() / value2.doTheMath().doubleValue());
            } else {
                throw new AssertionError();
            }
        } catch (AssertionError assertionError) {
            Logger.getLogger(Oparator.class.getName()).log(Level.SEVERE,null,assertionError);
        }

        return null;
    }
}
