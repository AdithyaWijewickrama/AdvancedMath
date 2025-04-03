package com.amath.advacedmath.programmer;

import static com.amath.advacedmath.programmer.Decimal.DecimaltoNBase;
import static com.amath.advacedmath.programmer.Decimal.getDecimal;
import com.amath.advacedmath.programmer.Base;

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
