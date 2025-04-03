package com.amath.advacedmath.convert;

/**
 *
 * @author Adithya Wijewickrama
 */
public enum Data {

    bit(1, "bits"),
    /**
     * Byte 8 bits
     */
    Byte(Math.pow(2, 3), "Bytes"),
    /**
     * KibiBits 2^10 bits
     */
    kibib(Units.kibi.getVal() * bit.DATA, "KibiBits"),
    /**
     * MebiBits 2^20 bits
     */
    mebib(Units.mebi.getVal() * bit.DATA, "MebiBits"),
    /**
     * GibiBits 2^30 bits
     */
    gibib(Units.gibi.getVal() * bit.DATA, "GibiBits"),
    /**
     * TebiBits 2^40 bits
     */
    tebib(Units.tebi.getVal() * bit.DATA, "TebiBits"),
    /**
     * PebiBits 2^50 bits
     */
    pebib(Units.pebi.getVal() * bit.DATA, "PebiBits"),
    /**
     * ExbiBits 2^60 bits
     */
    exbib(Units.exbi.getVal() * bit.DATA, "ExbiBits"),
    /**
     * ZebiBits 2^70 bits
     */
    zebib(Units.zebi.getVal() * bit.DATA, "ZebiBits"),
    /**
     * YobiBits 2^80 bits
     */
    yobib(Units.yobi.getVal() * bit.DATA, "YobiBits"),
    /**
     * KibiBits 2^10 bits
     */
    kibiB(Units.kibi.getVal() * Byte.DATA, "KibiBits"),
    /**
     * MebiBytes 2^20 Bytes
     */
    mebiB(Units.mebi.getVal() * Byte.DATA, "MebiBytes"),
    /**
     * GibiBytes 2^30 Bytes
     */
    gibiB(Units.gibi.getVal() * Byte.DATA, "GibiBytes"),
    /**
     * TebiBytes 2^40 Bytes
     */
    tebiB(Units.tebi.getVal() * Byte.DATA, "TebiBytes"),
    /**
     * PebiBytes 2^50 Bytes
     */
    pebiB(Units.pebi.getVal() * Byte.DATA, "PebiBytes"),
    /**
     * ExbiBytes 2^60 Bytes
     */
    exbiB(Units.exbi.getVal() * Byte.DATA, "ExbiBytes"),
    /**
     * ZebiBytes 2^70 Bytes
     */
    zebiB(Units.zebi.getVal() * Byte.DATA, "ZebiBytes"),
    /**
     * YobiBytes 2^80 bytes
     */
    yobiB(Units.yobi.getVal() * Byte.DATA, "YobiBytes"),
    /**
     * KiloBits 10^3 bits
     */
    kilob(Units.kilo.getVal() * bit.DATA, "KiloBits"),
    /**
     * MegaBits 10^6 bits
     */
    Megab(Units.Mega.getVal() * bit.DATA, "MegaBits"),
    /**
     * GigaBits 10^9 bits
     */
    Gigab(Units.Giga.getVal() * bit.DATA, "GigaBits"),
    /**
     * TeraBits 10^12 bits
     */
    Terab(Units.Tera.getVal() * bit.DATA, "TeraBits"),
    /**
     * PetaBits 10^15 bits
     */
    Petab(Units.Peta.getVal() * bit.DATA, "PetaBits"),
    /**
     * ExaBits 10^18 bits
     */
    Exab(Units.Exa.getVal() * bit.DATA, "ExaBits"),
    /**
     * ZetaBits 10^21 bits
     */
    Zetab(Units.Zeta.getVal() * bit.DATA, "ZetaBits"),
    /**
     * YottaBits 10^24 bits
     */
    Yottab(Units.Yotta.getVal() * Byte.DATA, "YottaBits"),
    /**
     * KiloBytes 10^3 Bytes
     */
    kiloB(Units.kilo.getVal() * Byte.DATA, "KiloBytes"),
    /**
     * MegaBytes 10^6 Bytes
     */
    MegaB(Units.Mega.getVal() * Byte.DATA, "MegaBytes"),
    /**
     * GigaBytes 10^9 Bytes
     */
    GigaB(Units.Giga.getVal() * Byte.DATA, "GigaBytes"),
    /**
     * TeraBytes 10^12 Bytes
     */
    TeraB(Units.Tera.getVal() * Byte.DATA, "TeraBytes"),
    /**
     * PetaBytes 10^15 Bytes
     */
    PetaB(Units.Peta.getVal() * Byte.DATA, "PetaBytes"),
    /**
     * ExaBytes 10^18 Bytes
     */
    ExaB(Units.Exa.getVal() * Byte.DATA, "ExaBytes"),
    /**
     * ZetaBytes 10^21 Bytes
     */
    ZetaB(Units.Zeta.getVal() * Byte.DATA, "ZetaBytes"),
    /**
     * YottaBytes 10^24 Bytes
     */
    YottaB(Units.Yotta.getVal() * Byte.DATA, "YottaBytes"),;
    public final double DATA;
    public final String STR;

    private Data(double data, String str) {
        DATA = data;
        STR = str;
    }

    public double getVal() {
        return DATA;
    }

    public String getStr() {
        return STR;
    }
    
    public static Object[][] getAllVars() {
        Object Names[] = Data.values();
        Object Vars[][] = new Object[Names.length][2];
        int Index = 0;
        for (Data g : Data.values()) {
            Vars[Index][0] = g.getStr();
            Vars[Index][1] = g;
            Index++;
        }
        return Vars;
    }

}
