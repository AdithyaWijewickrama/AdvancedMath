package com.amath.advacedmath.programmer;

import static com.amath.advacedmath.programmer.Decimal.DecimaltoNBase;
import static com.amath.advacedmath.programmer.Decimal.getDecimal;
import com.amath.advacedmath.programmer.Base;

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
