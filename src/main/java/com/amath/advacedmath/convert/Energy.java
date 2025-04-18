package com.amath.advacedmath.convert;

public enum Energy {

    eVOLT(3.829294e-20, "Electron Volts"),
    JOUL(0.239006, "Jouls"),
    KILOJOUL(Units.kilo.UNIT * JOUL.ENERGY, "Kilo Jouls"),
    THERMALCALORY(1, "Thermal Calories"),
    FOODCALORY(1000, "Food Calories"),
    FOOTPOUND(0.324048, "Foot-Pounds"),
    BTU(252.1644, "British thermal units(BTU)");

    public final double ENERGY;
    public final String STR;

    private Energy(double en, String str) {
        ENERGY = en;
        STR = str;
    }

    public double getVal() {
        return ENERGY;
    }

    public String toString() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object name[] = Energy.values();
        Object vars[][] = new Object[name.length][2];
        int Index = 0;
        for (Energy g : Energy.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }
}
