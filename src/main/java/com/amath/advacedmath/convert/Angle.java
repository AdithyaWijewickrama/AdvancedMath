package com.amath.advacedmath.convert;

public enum Angle {

    DEGREE(1, "Degrees"),
    RADIAN(DEGREE.ANG_IN_DEGREES * 57.29578, "Radians"),
    GRADIAN(DEGREE.ANG_IN_DEGREES * 0.9, "Gradians");
    private final double ANG_IN_DEGREES;
    private final String STR;

    private Angle(double ang, String str) {
        ANG_IN_DEGREES = ang;
        STR = str;
    }

    public double getVal() {
        return ANG_IN_DEGREES;
    }

    public String toString() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object names[] = Angle.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Angle g : Angle.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }

}
