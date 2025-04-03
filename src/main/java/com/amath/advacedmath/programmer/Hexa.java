package com.amath.advacedmath.programmer;

import static com.amath.advacedmath.programmer.Decimal.DecimaltoNBase;
import static com.amath.advacedmath.programmer.Decimal.getDecimal;
import com.amath.advacedmath.programmer.Base;

public class Hexa extends BaseN {

    static final double[] HEXDECS
            = {
                10,
                11,
                12,
                13,
                14,
                15
            };
    static final Character HEXCHARS[]
            = {
                'A',
                'B',
                'C',
                'D',
                'E',
                'F'
            };

    public Hexa() {
        super(Base.HEX);
    }

    public String toBinary(String val) {
        return DecimaltoNBase(getDecimal(val, base), Base.BIN);
    }

    public String toOctal(String val) {
        return DecimaltoNBase(getDecimal(val, base), Base.OCT);
    }

}
