package com.amath.advacedmath.convert;

public enum Power {
    WATT(1000, "Watts"),
    KILO_WATT(1,"kilo Watts"),
    HORSE_POWER(1.341022,"Horse Power"),
    FOOT_POUNDS_PER_MINUTE(44253.73,"Foot-pounds//Minute"),
    BTUS_PER_MINUTE(56.86902,"BTUs//Minute"),
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
        Object names[] = Power.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Power g : Power.values()) {
            vars[Index][0] = g.getStr();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }
    
}
