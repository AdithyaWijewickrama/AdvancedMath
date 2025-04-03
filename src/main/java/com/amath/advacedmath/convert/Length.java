package com.amath.advacedmath.convert;

public enum Length {

    /**
     * Meters
     */
    Meter(1, "Meters"),
    /**
     * Nanometers
     */
    NM(Units.nano.getVal() * Meter.LEN, "Nanometers"),
    /**
     * Microns
     */
    MCN(Units.micro.getVal() * Meter.LEN, "Microns"),
    /**
     * Millimeters
     */
    MM(Units.mili.getVal() * Meter.LEN, "Milimeters"),
    /**
     * Centimeters
     */
    CM(Units.centi.getVal() * Meter.LEN, "Centimeters"),
    /**
     * Feet
     */
    Feets(CM.getVal() * 30.48, "Feets"),
    /**
     * Kilometers
     */
    inch(.0254, "Inches"),
    /**
     * Kilometers
     */
    KM(Units.kilo.getVal() * Meter.LEN, "Kilometers"),
    /**
     * Miles
     */
    Mil(Meter.getVal() * 1609.344, "Miles"),
    /**
     * Yards
     */
    Yards(CM.getVal() * 91.44, "Yards"),
    /**
     * Hectometers
     */
    hectM(Meter.getVal() * Units.hect.getVal(), "Hect miles");

    public final double LEN;
    public final String DESC;

    private Length(double len, String desc) {
        LEN = len;
        DESC = desc;
    }

    public double getVal() {
        return LEN;
    }

    public String getDesc() {
        return DESC;
    }
    
    public static Object[][] getAllVars() {
        Object Names[] = Length.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Length g : Length.values()) {
            Vars[Index][0] = g.getDesc();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }
    
}
