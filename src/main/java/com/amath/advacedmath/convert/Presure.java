package com.amath.advacedmath.convert;

public enum Presure {
    ATM(101325,"Atmospheres"),
    BAR(100000,"Bars"),
    KP(1000,"Kilopascals"),
    MILIMETERS_OF_MERCURY(133.3,"Milimeteres of mercury"),
    PASCALS(1,"Pascals"),
    POUNDS_PER_SQUARE_INCH(6894.757,"Pounds per square inch");
    private final double PRES;
    private final String STR;

    private Presure(double PRES, String STR) {
        this.PRES = PRES;
        this.STR = STR;
    }

    public double getPRES() {
        return PRES;
    }

    public String toString() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object names[] = Presure.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Presure g : Presure.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }
    
}
