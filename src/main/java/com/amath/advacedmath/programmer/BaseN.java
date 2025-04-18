package com.amath.advacedmath.programmer;

import static com.amath.advacedmath.programmer.Decimal.DecimaltoNBase;
import static com.amath.advacedmath.programmer.Decimal.getDecimal;

public class BaseN {

    public Base base;

    public BaseN(Base base) {
        this.base = base;
    }

    public String add(String a, String b) {
        return DecimaltoNBase(getDecimal(a, base) + getDecimal(b, base), base);
    }

    public String substract(String a, String b) {
        return DecimaltoNBase(getDecimal(a, base) - getDecimal(b, base), base);
    }

    public String divide(String a, String b) {
        return DecimaltoNBase(getDecimal(a, base) / getDecimal(b, base), base);
    }

    public String multiply(String a, String b) {
        return DecimaltoNBase(getDecimal(a, base) * getDecimal(b, base), base);
    }

    public String add(double a, double b) {
        return DecimaltoNBase(a + b, base);
    }

    public String sub(double a, double b) {
        return DecimaltoNBase(a - b, base);
    }

    public String div(double a, double b) {
        return DecimaltoNBase(a / b, base);
    }

    public String mult(double a, double b) {
        return DecimaltoNBase(a * b, base);
    }

    public double toDecimal(String val) {
        return Double.parseDouble(DecimaltoNBase(getDecimal(val, base), Base.DEC));
    }

    public double addtoDec(String a, String b) {
        return toDecimal(a) + toDecimal(b);
    }

    public double subtoDec(String a, String b) {
        return toDecimal(a) - toDecimal(b);
    }

    public double divtoDec(String a, String b) {
        return toDecimal(a) / toDecimal(b);
    }

    public double multtoDec(String a, String b) {
        return toDecimal(a) * toDecimal(b);
    }
}
