package com.amath.advacedmath.calculate;

import com.amath.advacedmath.calculate.equation.Calculate;

/**
 *
 * @author AW Developer
 */
public class Root extends Calculate{

    CNumber value;
    
    public Root(CNumber value) {
        super(null, null);
        this.value=value;
    }

    @Override
    public CNumber doTheMath() {
        return value;
    }
    
}
