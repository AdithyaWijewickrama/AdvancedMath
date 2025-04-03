package com.amath.advacedmath.convert;

public enum Mass {
    carats(.2, "Carats"),
    mg(Units.mili.UNIT, "Miligrams"),
    centig(Units.centi.UNIT, "Centigrams"),
    decig(Units.deci.UNIT, "Decigrams"),
    g(1, "Grams"),
    dekag(Units.deka.UNIT, "Dekagrams"),
    hectog(Units.deka.UNIT, "Hectograms"),
    Kg(Units.kilo.UNIT, "Kilograms"),
    Mtons(1E6, "Metric tonnes"),
    ounces(28.34952, "Ounces"),
    pounds(453.5924, "Pounds"),
    stone(6350.293, "Stone"),
    tonUS(907184.7, "Short tones(US)"),
    tonUK(1016047, "Long tones(UK)");

    private Mass(double mass, String str) {
        this.MASS = mass;
        this.STR = str;
    }
    private final double MASS;
    private final String STR;

    public static Object[][] getAllVars() {
        Object Names[] = Mass.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Mass g : Mass.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }

    public double getVal() {
        return MASS;
    }

    public String getStr() {
        return STR;
    }
}
