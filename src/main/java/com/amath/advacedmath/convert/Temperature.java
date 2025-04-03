package com.amath.advacedmath.convert;

/**
 *
 * @author Adithya Wijewickrama
 */
public enum Temperature {

    F("Fahrenheit"),
    C("Celcius"),
    K("Kelvin");
    private final String DESC;

    private Temperature(String des) {
        DESC = des;
    }

    public String getStr() {
        return DESC;
    }

    public static Object[][] getAllVars() {
        Object Names[] = Temperature.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Temperature g : Temperature.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }
}
