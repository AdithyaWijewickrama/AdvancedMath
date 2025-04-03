package com.amath.advacedmath.convert;

/**
 *
 * @author Adithya Wijewickrama
 */
public enum Energy {

    eV(3.829294e-20, "Electron Volts"),
    J(0.239006, "Jouls"),
    kJ(Units.kilo.UNIT * J.ENERGY, "Kilo Jouls"),
    tCal(1, "Thermal Calories"),
    fCal(1000, "Food Calories"),
    fp(0.324048, "Foot-Pounds"),
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

    public String getStr() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object Names[] = Energy.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Energy g : Energy.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }
}
