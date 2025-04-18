package com.amath.advacedmath.convert;

public enum Temperature {

    FAHRENHEIT("Fahrenheit"),
    CELCIUS("Celcius"),
    KELVIN("Kelvin");
    private final String STR;

    private Temperature(String des) {
        STR = des;
    }

    public String toString() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object names[] = Temperature.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Temperature g : Temperature.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }

}
