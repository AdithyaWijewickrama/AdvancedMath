package com.amath.advacedmath.convert;

public enum Length {

    /**
     * Meters
     */
    METER(1, "Meters"),
    /**
     * Nanometers
     */
    NANOMETER(Units.nano.getVal() * METER.LEN, "Nanometers"),
    /**
     * Microns
     */
    MICROMETER(Units.micro.getVal() * METER.LEN, "Microns"),
    /**
     * Millimeters
     */
    MILIMETER(Units.mili.getVal() * METER.LEN, "Milimeters"),
    /**
     * Centimeters
     */
    CENTIMETER(Units.centi.getVal() * METER.LEN, "Centimeters"),
    /**
     * Feet
     */
    FEET(CENTIMETER.getVal() * 30.48, "Feets"),
    /**
     * Kilometers
     */
    INCH(.0254, "Inches"),
    /**
     * Kilometers
     */
    KILOMETER(Units.kilo.getVal() * METER.LEN, "Kilometers"),
    /**
     * Miles
     */
    MILE(METER.getVal() * 1609.344, "Miles"),
    /**
     * YARD
     */
    YARD(CENTIMETER.getVal() * 91.44, "Yards"),
    /**
     * Hectometers
     */
    HECTMILE(METER.getVal() * Units.hect.getVal(), "Hect miles");

    public final double LEN;
    public final String DESC;

    private Length(double len, String desc) {
        LEN = len;
        DESC = desc;
    }

    public double getVal() {
        return LEN;
    }

    public String toString() {
        return DESC;
    }
    
    public static Object[][] getAllVars() {
        Object names[] = Length.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Length g : Length.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }
    
}
