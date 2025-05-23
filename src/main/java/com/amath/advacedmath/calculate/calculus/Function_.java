package com.amath.advacedmath.calculate.calculus;

import com.amath.advacedmath.tokenizing.Token;
import static com.amath.advacedmath.tokenizing.Token.*;
import com.amath.advacedmath.tokenizing.TokenList;
import com.amath.advacedmath.tokenizing.TokenType;
import com.amath.advacedmath.calculate.CNumber;
import com.amath.advacedmath.convert.Angle;

/**
 *
 * @author AW Developer
 */
public class Function_ extends DifferentialCalculus {

    Token function_;
    Angle angleType = Angle.RADIAN;

    public Function_(Token function_, TokenList fx) {
        super(fx, TokenType.FUNCTION_);
        this.function_ = function_;
    }

    public Function_(Token function_, TokenList fx, Angle angleType) {
        super(fx, TokenType.FUNCTION_);
        this.function_ = function_;
        this.angleType = angleType;
    }

    @Override
    public TokenList doTheMath() {
        TokenList t = new TokenList();
        try {
            if (function_ == COS
                    || function_ == SIN
                    || function_ == TAN
                    || function_ == COSH
                    || function_ == SINH
                    || function_ == TANH
                    || function_ == ACOS
                    || function_ == ASIN
                    || function_ == ATAN
                    || function_ == ACOSH
                    || function_ == ASINH
                    || function_ == ATANH
                    || function_ == SEC
                    || function_ == CSC
                    || function_ == COT
                    || function_ == ASEC
                    || function_ == ACSC
                    || function_ == ACOT
                    || function_ == SECH
                    || function_ == CSCH) {
                return new Triaganometry(fx, function_, angleType).doTheMath();
            } else if (function_ == CUBE) {
                t.addToken(new Token(TokenType.NUMBER, CNumber.parseNumber(3.)));
                return new Operator(fx, RAISED, t).doTheMath();
            } else if (function_ == CUBEROOT) {
                t.addToken(new Token(TokenType.NUMBER, CNumber.parseNumber(1 / 3.)));
                return new Operator(fx, RAISED, t).doTheMath();
            } else if (function_ == SQUARED) {
                t.addToken(new Token(TokenType.NUMBER, CNumber.parseNumber(2.)));
                return new Operator(fx, RAISED, t).doTheMath();
            } else if (function_ == SQUREROOT) {
                t.addToken(new Token(TokenType.NUMBER, CNumber.parseNumber(1 / 2.)));
                return new Operator(fx, RAISED, t).doTheMath();
            } else if (function_ == TENRAISED) {
                t.addToken(new Token(TokenType.NUMBER, CNumber.parseNumber(10.)));
                return new Operator(t, RAISED, fx).doTheMath();
            } else if (function_ == TWORAISED) {
                t.addToken(new Token(TokenType.NUMBER, CNumber.parseNumber(2.)));
                return new Operator(t, RAISED, fx).doTheMath();
            } else if (function_ == eRAISED) {
                t.addToken(new Token(TokenType.NUMBER, e.number));
                return new Operator(t, RAISED, fx).doTheMath();
            } else if (function_ == LOG10) {
                t.addToken(new Token(TokenType.NUMBER, CNumber.parseNumber(10.)));
                return new _Function_(LOGBASEY, t, fx).doTheMath();
            } else if (function_ == LN) {
                t.addToken(RECIPROCAL);
                t.addTokens(fx.pranthesise());
            } else if (function_ == RECIPROCAL) {
                t.addToken(RECIPROCAL);
                t.addToken(OPEN_PRANTHESIS);
                t.addTokens(fx);
                t.addToken(CLOSE_PRANTHESIS);
            }  else {
                makeError("Unsuppported token");
            }
            t.addToken(MULTIPLY);
            t.addTokens(new Differentiator(t).differentiate(1));
            return t;
        } catch (Exception ex) {
            makeError(ex);
        }
        return null;
    }

}
