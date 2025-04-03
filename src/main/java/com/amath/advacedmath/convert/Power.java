package com.advancedMath.convert;

public enum Power {
    W(1000, "Watts"),
    kW(1,"kilo Watts"),
    hp(1.341022,"Horse Power"),
    fppm(44253.73,"Foot-pounds//Minute"),
    BTUpm(56.86902,"BTUs//Minute"),
    ;

    private final double POWER;
    private final String STR;

    private Power(double pow, String str) {
        POWER = pow;
        STR = str;
    }
    
    public double getVal(){
        return POWER;
    }
    
    public String getStr(){
        return STR;
    }
    
    public static Object[][] getAllVars() {
        Object Names[] = Power.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Power g : Power.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }
    
}
