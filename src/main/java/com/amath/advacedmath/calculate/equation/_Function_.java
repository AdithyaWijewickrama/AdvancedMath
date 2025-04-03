package com.amath.advacedmath.calculate.equation;

import com.amath.advacedmath.tokenizing.Token;
import static com.amath.advacedmath.tokenizing.Token.LOGBASEY;
import static com.amath.advacedmath.tokenizing.Token.MODULO;
import static com.amath.advacedmath.tokenizing.Token.YROOT;
import com.amath.advacedmath.tokenizing.TokenType;
import com.amath.advacedmath.calculate.CNumber;

/**
 *
 * @author AW Developer
 */
public class _Function_ extends Calculate {

    Token _function_;

    public _Function_(Token _func, Calculate v1, Calculate v2) {
        super(v1, TokenType._FUNCTION_, v2);
        this._function_ = _func;
    }

    @Override
    public CNumber doTheMath() {
        try {
            if (_function_ == YROOT) {
                return CNumber.parseNumber(Math.pow(value1.doTheMath().doubleValue(), value2.doTheMath().doubleValue()));
            }
            if (_function_ == MODULO) {
                return CNumber.parseNumber(value1.doTheMath().doubleValue() % value2.doTheMath().doubleValue());
            }
            if (_function_ == LOGBASEY) {
                return CNumber.parseNumber(Math.log(value2.doTheMath().doubleValue()) / Math.log(value1.doTheMath().doubleValue()));
            } else {
                throw new AssertionError();
            }
        } catch (AssertionError assertionError) {
            makeError("Function"+_function_+" is not valid");
        }
        return null;
    }
}
