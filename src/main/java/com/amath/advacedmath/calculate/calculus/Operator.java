package com.amath.advacedmath.calculate.calculus;

import com.amath.advacedmath.tokenizing.Token;
import static com.amath.advacedmath.tokenizing.Token.*;
import com.amath.advacedmath.tokenizing.TokenList;
import com.amath.advacedmath.tokenizing.TokenType;
import com.amath.advacedmath.calculate.equation.ExpressionEvaluator;
import com.amath.advacedmath.calculate.CNumber;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Represents an operator used in differential calculus.
 * This class handles operations such as multiplication, division, and exponentiation
 * between two mathematical expressions.
 */
public class Operator extends DifferentialCalculus {

    Token oparator;

    /**
     * Initializes an Operator instance to perform operations between two expressions.
     * <br>Example: f(x) = x, operator = ^, g(x) = 4 will return 4 * x^3.
     *
     * @param fx       The first expression (f(x)).
     * @param operator The operator to be applied (e.g., ^, *, /).
     * @param gx       The second expression (g(x)).
     */
    public Operator(TokenList fx, Token operator, TokenList gx) {
        super(fx, TokenType.OPARATOR, gx);
        this.oparator = operator;
    }

    /**
     * Constructs the mathematical expression represented by this operator.
     *
     * @return A {@link TokenList} representing the full expression (e.g., f(x) ^ g(x)).
     */
    public TokenList getExpression() {
        TokenList tk = new TokenList();
        tk.addTokens(fx);
        tk.addToken(RAISED);
        tk.addTokens(gx.pranthesise());
        return tk;
    }

    /**
     * Performs the mathematical operation represented by this operator.
     * Handles cases for exponentiation, multiplication, division, and other operators.
     *
     * @return A {@link TokenList} representing the result of the operation.
     */
    @Override
    public TokenList doTheMath() {
        TokenList tk = new TokenList();
        try {
            if (oparator == RAISED) {
                if ((fx.hasIndependent() || fx.hasDependent()) && !(gx.hasIndependent() || gx.hasDependent())) {
                    CNumber n = new ExpressionEvaluator(gx).evaluate();
                    tk.addToken(new Token(n));
                    tk.addToken(MULTIPLY);
                    tk.addTokens(fx.pranthesise());
                    n = n.substract(CNumber.parseNumber(1));
                    if (n.doubleValue() != 1) {
                        tk.addToken(RAISED);
                        tk.addToken(new Token(n));
                    }
                } else if (!fx.hasIndependent() && !fx.hasDependent() && (gx.hasIndependent() || gx.hasDependent())) {
                    CNumber n = new ExpressionEvaluator(fx).evaluate();
                    tk.addToken(LN);
                    tk.addToken(OPEN_PRANTHESIS);
                    tk.addToken(new Token(n));
                    tk.addToken(CLOSE_PRANTHESIS);
                    tk.addToken(MULTIPLY);
                    tk.addTokens(gx.pranthesise());
                    tk.addToken(MULTIPLY);
                    tk.addTokens(new Differentiator(gx).differentiate(1));
                } else {
                    tk.addTokens(fx);
                    tk.addToken(RAISED);
                    tk.addTokens(gx.pranthesise());
                    tk.addToken(MULTIPLY);
                    tk.addToken(Token.OPEN_PRANTHESIS);
                    tk.addTokens(new Differentiator(gx).differentiate(1));
                    tk.addToken(MULTIPLY);
                    tk.addToken(Token.LN);
                    tk.addTokens(fx.pranthesise());
                    tk.addToken(PLUS);
                    tk.addTokens(gx);
                    tk.addToken(MULTIPLY);
                    tk.addTokens(new Differentiator(fx).differentiate(1));
                    tk.addToken(DIVIDE);
                    tk.addTokens(fx.pranthesise());
                    tk.addToken(Token.CLOSE_PRANTHESIS);
                }
            } else if (oparator == MULTIPLY) {
                if ((fx.hasIndependent() || fx.hasDependent()) && (gx.hasIndependent() || gx.hasDependent())) {
                    tk.addTokens(new Differentiator(fx).differentiate(1));
                    tk.addToken(MULTIPLY);
                    tk.addTokens(gx);
                    tk.addToken(PLUS);
                    tk.addTokens(new Differentiator(gx).differentiate(1));
                    tk.addToken(MULTIPLY);
                    tk.addTokens(fx);
                } else {
                    if (!(fx.hasIndependent() || fx.hasDependent())) {
                        CNumber evaluate = new ExpressionEvaluator(fx).evaluate();
                        Token etoken = new Token(TokenType.NUMBER, evaluate);
                        if (evaluate.doubleValue() == 0) {
                            tk.addToken(etoken);
                        } else {
                            tk.addToken(etoken);
                            tk.addToken(MULTIPLY);
                            tk.addTokens(new Differentiator(gx).differentiate(1));
                        }
                    } else if (!(gx.hasIndependent() || gx.hasDependent())) {
                        CNumber evaluate = new ExpressionEvaluator(gx).evaluate();
                        Token etoken = new Token(TokenType.NUMBER, evaluate);
                        if (evaluate.doubleValue() == 0) {
                            tk.addToken(etoken);
                        } else {
                            tk.addToken(etoken);
                            tk.addToken(MULTIPLY);
                            tk.addTokens(new Differentiator(fx).differentiate(1));
                        }
                    }
                }
            } else if (oparator == DIVIDE) {
                tk.addToken(Token.OPEN_PRANTHESIS);
                tk.addTokens(new Differentiator(fx).differentiate(1));
                tk.addToken(MULTIPLY);
                tk.addTokens(gx);
                tk.addToken(MINUS);
                tk.addTokens(new Differentiator(gx).differentiate(1));
                tk.addToken(MULTIPLY);
                tk.addTokens(fx);
                tk.addToken(Token.CLOSE_PRANTHESIS);
                tk.addToken(DIVIDE);
                tk.addTokens(gx.pranthesise());
                tk.addToken(RAISED);
                tk.addToken(TWO);
            } else {
                tk.addTokens((new Differentiator(fx).differentiate(1)));
                tk.addToken(oparator);
                tk.addTokens((new Differentiator(gx).differentiate(1)));
            }

        } catch (Exception ex) {
            makeError(ex);
        }
        System.out.println("[OPARATION DONE]" + tk.toLocalString());
        return tk;
    }

    /**
     * Main method for testing the Operator class.
     * Demonstrates differentiation of an example expression.
     *
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        try {
            Differentiator d = new Differentiator("x^-1");
            TokenList dt = d.differentiate(1);
            System.out.println(dt.toLocalString());
        } catch (Exception ex) {
            Logger.getLogger(Operator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
