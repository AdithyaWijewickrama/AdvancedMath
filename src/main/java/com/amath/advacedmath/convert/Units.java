package com.amath.advacedmath.convert;

/**
 *
 * @author Adithya Wijewickrama
 */
public enum Units {

    deci(1E-1),
    centi(1E-2),
    mili(1E-3),
    micro(1E-6),
    nano(1E-9),
    piko(1E-12),
    femto(1E-15),
    ato(1E-18),
    deka(1E1),
    hect(1E2),
    kilo(1E3),
    Mega(1E6),
    Giga(1E9),
    Tera(1E12),
    Peta(1E15),
    Exa(1E18),
    Zeta(1E21),
    Yotta(1E24),
    kibi(Math.pow(2, 10)),
    mebi(Math.pow(2, 20)),
    gibi(Math.pow(2, 30)),
    tebi(Math.pow(2, 40)),
    pebi(Math.pow(2, 50)),
    exbi(Math.pow(2, 60)),
    zebi(Math.pow(2, 70)),
    yobi(Math.pow(2, 80));

    public final double UNIT;

    private Units(double unit) {
        UNIT = unit;
    }

    public double getVal() {
        return UNIT;
    }

    public static Object[][] getAllUnits() {
        Object unitNames[] = Units.values();
        Object units[][] = new Object[unitNames.length][2];
        int Index = 0;
        for (Units g : Units.values()) {
            units[Index][0] = g;
            units[Index][1] = g.getVal();

            Index++;
        }
        return units;
    }

}
