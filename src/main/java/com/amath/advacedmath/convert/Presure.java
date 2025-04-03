package com.amath.advacedmath.convert;

public enum Presure {
    atmsp(101325,"Atmospheres"),
    Bars(100000,"Bars"),
    Kilopa(1000,"Kilopascals"),
    miliMercury(133.3,"Milimeteres of mercury"),
    Pascals(1,"Pascals"),
    PpSI(6894.757,"Pounds per square inch");
    private final double PRES;
    private final String STR;

    private Presure(double PRES, String STR) {
        this.PRES = PRES;
        this.STR = STR;
    }

    public double getPRES() {
        return PRES;
    }

    public String getStr() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object Names[] = Presure.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Presure g : Presure.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }
    
}
