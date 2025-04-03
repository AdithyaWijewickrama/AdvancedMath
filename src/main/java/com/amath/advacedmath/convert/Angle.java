package com.amath.advacedmath.convert;

public enum Angle {

    degrees(1, "Degrees"),
    radians(degrees.ANG_IN_DEGREES * 57.29578, "Radians"),
    gradians(degrees.ANG_IN_DEGREES * 0.9, "Gradians");
    private final double ANG_IN_DEGREES;
    private final String STR;

    private Angle(double ang, String str) {
        ANG_IN_DEGREES = ang;
        STR = str;
    }

    public double getVal() {
        return ANG_IN_DEGREES;
    }

    public String getStr() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object Names[] = Angle.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Angle g : Angle.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }

}
