
package com.amath.advacedmath.programmer;

public enum Base {
    BIN(2),
    HEX(16),
    OCT(8),
    DEC(10);
    public final Integer BASE;

    private Base(int base) {
        BASE = base;
    }
    
    public int getVal(){
        return BASE;
    }

}