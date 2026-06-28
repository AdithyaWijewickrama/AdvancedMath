package com.awapps.advancedmath.programmer;

import static com.awapps.advancedmath.programmer.Decimal.DecimaltoNBase;
import static com.awapps.advancedmath.programmer.Decimal.getDecimal;

public class Octal extends BaseN {

    public Octal() {
        super(Base.OCT);
    }

    public String toBinary(String val) {
        return DecimaltoNBase(getDecimal(val, base), Base.BIN);
    }

    public String toHexa(String val) {
        return DecimaltoNBase(getDecimal(val, base), Base.HEX);
    }

}
