package com.amath.advacedmath.convert;

public enum Time {
    S(1, "Seconds"),
    NanoS(Units.nano.getVal() * S.TIME, "Nanoseconds"),
    McrS(Units.micro.getVal() * S.TIME, "Microseconds"),
    MilS(Units.mili.getVal() * S.TIME, "Miliseconds"),
    M(60, "Minutes"),
    H(M.TIME * 60, "Hours"),
    Day(H.TIME * 24, "Days"),
    Week(Day.TIME * 7, "Weeks"),
    Mon(Week.TIME * 30, "Months");

    public final double TIME;
    private final String STR;

    private Time(double time, String str) {
        TIME = time;
        STR = str;
    }

    public double getVal() {
        return TIME;
    }

    public String toString() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object names[] = Time.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Time g : Time.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }

}
