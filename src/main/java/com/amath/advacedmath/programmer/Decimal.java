package com.amath.advacedmath.programmer;

import java.math.BigDecimal;
import com.amath.advacedmath.programmer.Base;

public class Decimal {

    public static String DecimaltoNBase(double val, Base b) {
        String r = "";
        while (true) {
            double re = val % b.BASE;
            val -= re;
            val /= b.BASE;
            if (re > 9) {
                r = Hexa.HEXCHARS[(int) (re - 10)] + r;
            } else {
                r = new BigDecimal(re).toPlainString() + r;
            }
            if (val <= 0) {
                break;
            }

        }
        return r;
    }

    public static String getValue(String val, Base b1, Base b2) {
        return DecimaltoNBase(getDecimal(val, b1), b2);
    }

    public static Double getDecimal(String val, Base b) {
        Double r = 0.;
        char[] split = val.toCharArray();
        int pow = 0;
        if (b.BASE < 10) {
            for (char c : split) {
                if (!Character.isDigit(c)) {
                    throw new NumberFormatException("Not a " + b.name().toLowerCase() + " base number");
                }
            }
        }
        for (int i = split.length - 1; i > -1; i--) {
            r += Math.pow(b.BASE, pow) * (split[i] == 'A' ? 10
                    : split[i] == 'B' ? 11
                            : split[i] == 'C' ? 12 : split[i] == 'D' ? 13 : split[i] == 'E' ? 14 : split[i] == 'F' ? 15 : Integer.parseInt(split[i] + ""));
            pow++;
        }
        return r;
    }

    public static Double getInteger(Double Val) {
        if (Val < Integer.MAX_VALUE) {
            Integer value = Val.intValue();
            return value.doubleValue();
        }
        String vl = Double.toString(Val);
        char cc[] = vl.toCharArray();
        boolean b = false;
        int Index = 0;
        for (int i = 0; i < cc.length; i++) {
            if (cc[i] == Hexa.HEXCHARS[4]) {
                b = true;
                Index = i++;
                break;
            }
        }
        if (b) {
            String vlBeforeE = String.valueOf(cc, 0, Index);
            String vlAfterE = String.valueOf(cc, Index + 1, cc.length - vlBeforeE.length() - 1);
            String vlAfterDot = String.valueOf(cc, 2, Index - 2);
            if (vlAfterDot.length() <= Integer.parseInt(vlAfterE)) {
                return Val;
            } else {
                vl = String.copyValueOf(cc, 0, Integer.parseInt(vlAfterE) + 2);
                return Double.valueOf(vl + Hexa.HEXCHARS[4] + Integer.valueOf(vlAfterE));
            }
        } else {
            return Val;
        }
    }

    public static String toPlainString(double val) {
        return BigDecimal.valueOf(val).toPlainString();
    }
}
