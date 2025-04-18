package com.amath.advacedmath.convert;

public enum Mass {
    CARAT(.2, "Carats"),
    MILIGRAM(Units.mili.UNIT, "Miligrams"),
    CENTIGRAM(Units.centi.UNIT, "Centigrams"),
    DECIGRAM(Units.deci.UNIT, "Decigrams"),
    GRAM(1, "Grams"),
    DEKAGRAM(Units.deka.UNIT, "Dekagrams"),
    HECTOGRAM(Units.deka.UNIT, "Hectograms"),
    KILOGRAM(Units.kilo.UNIT, "Kilograms"),
    METRIC_TON(1E6, "Metric tonnes"),
    OUNCE(28.34952, "Ounces"),
    POUND(453.5924, "Pounds"),
    STONE(6350.293, "Stone"),
    SHORT_TON(907184.7, "Short tones(US)"),
    LONG_TON(1016047, "Long tones(UK)");

    private Mass(double mass, String str) {
        this.MASS = mass;
        this.STR = str;
    }
    private final double MASS;
    private final String STR;

    public static Object[][] getAllVars() {
        Object names[] = Mass.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Mass g : Mass.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }

    public double getVal() {
        return MASS;
    }

    public String toString() {
        return STR;
    }
}
