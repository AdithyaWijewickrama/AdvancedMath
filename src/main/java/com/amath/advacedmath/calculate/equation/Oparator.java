package com.amath.advacedmath.calculate.equation;

import com.amath.advacedmath.tokenizing.Token;
import static com.amath.advacedmath.tokenizing.Token.DIVIDE;
import static com.amath.advacedmath.tokenizing.Token.MINUS;
import static com.amath.advacedmath.tokenizing.Token.RAISED;
import static com.amath.advacedmath.tokenizing.Token.PLUS;
import com.amath.advacedmath.tokenizing.TokenType;
import com.amath.advacedmath.calculate.CNumber;
import static com.amath.advacedmath.tokenizing.Token.MULTIPLY;

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
        }
        return null;
    }
}
