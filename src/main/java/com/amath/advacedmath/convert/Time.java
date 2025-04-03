package com.amath.advacedmath.convert;

/**
 *
 * @author Adithya Wijewickrama
 */
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

    public String getStr() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object Names[] = Time.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Time g : Time.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }

}
