package com.amath.advacedmath.convert;

public enum Volume {
    /**
     * For 01 Liter miliLiters 1000
     */
    ml(1000, "MiliLiters"),
    /**
     * For 01 Liter Cubic centimeters 1000
     */
    CubicCM(ml.VOLUME, "Cubic centimeters"),
    /**
     * For 01 Liter Liters 01
     */
    L(1, "Liters"),
    /**
     * For 01 Liter Cubic meters 0.001
     */
    CubicM(0.001, "Cubic meters"),
    /**
     * For 01 Liter Teaspoons(US) 202.8841
     */
    TsUS(202.8841, "Teaspoons(US)"),
    /**
     * For 01 Liter Tablespoons(US) 67.62805
     */
    TbsUS(67.62805, "Tablespoons(US)"),
    /**
     * For 01 Liter Fluid ounces(US) 33.81402
     */
    FounsUS(33.81402, "Fluid uonses(US)"),
    /**
     * For 01 Liter Cups(US) 4.226753
     */
    CupsUS(4.226753, "Cups(US)"),
    /**
     * For 01 Liter Pints(US) 2.113376
     */
    PintsUS(2.113376, "Pints(US)"),
    /**
     * For 01 Liter Quarts(US) 1.056688
     */
    QuartsUS(1.056688, "Quarts(US)"),
    /**
     * For 01 Liter Gallons(US) 0.264172
     */
    GlUS(0.264172, "Gallons(US)"),
    /**
     * For 01 Liter Cubic inches 61.02374
     */
    CubicI(61.02374, "Cubic inches"),
    /**
     * For 01 Liter Cubic feet 0.035315
     */
    CubicF(0.035315, "Cubic feets"),
    /**
     * For 01 Liter Cubic Yards 0.001308
     */
    CubicY(0.001308, "Cubic Yards"),
    /**
     * For 01 Liter Teaspoons(UK) 168.9364
     */
    TsUK(168.9364, "Teaspoons(UK)"),
    /**
     * For 01 Liter Tablespoons(UK) 56.31213
     */
    TbsUK(56.31213, "Tablespoons(UK)"),
    /**
     * For 01 Liter Fluid ounces(UK) 35.19508
     */
    FounsUK(35.19508, "Fluid ounces(UK)"),
    /**
     * For 01 Liter Pints(UK) 1.759754
     */
    PintsUK(1.759754, "Pints(UK)"),
    /**
     * For 01 Liter Quarts(UK) 0.879877
     */
    QuartsUK(0.879877, "Quarts(UK)"),
    /**
     * For 01 Liter Gallons(UK) .219969
     */
    GlUK(.219969, "Gallons(UK)");

    private final double VOLUME;
    private final String STR;

    private Volume(double vol, String str) {
        VOLUME = vol;
        STR = str;
    }

    public double getVal() {
        return VOLUME;
    }

    public String toString() {
        return STR;
    }

    public static Object[][] getAllVars() {
        Object names[] = Volume.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Volume g : Volume.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }

}
