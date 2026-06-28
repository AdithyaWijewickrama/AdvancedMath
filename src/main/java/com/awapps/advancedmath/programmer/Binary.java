package com.awapps.advancedmath.programmer;

import static com.awapps.advancedmath.programmer.Decimal.DecimaltoNBase;
import static com.awapps.advancedmath.programmer.Decimal.getDecimal;

public class Binary extends BaseN {

    public Binary() {
        super(Base.BIN);

    }

    public String toHexa(String val) {
        return DecimaltoNBase(getDecimal(val, base), Base.HEX);
    }

    public String toOctal(String val) {
        return DecimaltoNBase(getDecimal(val, base), Base.OCT);
    }

}
