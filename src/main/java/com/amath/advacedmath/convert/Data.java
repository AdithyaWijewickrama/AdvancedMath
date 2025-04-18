package com.amath.advacedmath.convert;

public enum Data {

    BIT(1, "bits"),
    /**
     * BYTE 8 bits
     */
    BYTE(Math.pow(2, 3), "Bytes"),
    /**
     * KibiBits 2^10 bits
     */
    KIBIBIT(Units.kibi.getVal() * BIT.DATA, "KibiBits"),
    /**
     * MebiBits 2^20 bits
     */
    MEBIBIT(Units.mebi.getVal() * BIT.DATA, "MebiBits"),
    /**
     * GibiBits 2^30 bits
     */
    GIBIBIT(Units.gibi.getVal() * BIT.DATA, "GibiBits"),
    /**
     * TebiBits 2^40 bits
     */
    TEBIBIT(Units.tebi.getVal() * BIT.DATA, "TebiBits"),
    /**
     * PebiBits 2^50 bits
     */
    PEBIBIT(Units.pebi.getVal() * BIT.DATA, "PebiBits"),
    /**
     * ExbiBits 2^60 bits
     */
    EXBIBIT(Units.exbi.getVal() * BIT.DATA, "ExbiBits"),
    /**
     * ZebiBits 2^70 bits
     */
    ZEBIBIT(Units.zebi.getVal() * BIT.DATA, "ZebiBits"),
    /**
     * YobiBits 2^80 bits
     */
    YOBIBIT(Units.yobi.getVal() * BIT.DATA, "YobiBits"),
    /**
     * KibiBits 2^10 bits
     */
    KIBIBYTE(Units.kibi.getVal() * BYTE.DATA, "KibiBytes"),
    /**
     * MebiBytes 2^20 Bytes
     */
    MEBIBYTE(Units.mebi.getVal() * BYTE.DATA, "MebiBytes"),
    /**
     * GibiBytes 2^30 Bytes
     */
    GIBIBYTE(Units.gibi.getVal() * BYTE.DATA, "GibiBytes"),
    /**
     * TebiBytes 2^40 Bytes
     */
    TEBIBYTE(Units.tebi.getVal() * BYTE.DATA, "TebiBytes"),
    /**
     * PebiBytes 2^50 Bytes
     */
    PEBIBYTE(Units.pebi.getVal() * BYTE.DATA, "PebiBytes"),
    /**
     * ExbiBytes 2^60 Bytes
     */
    EXBIBYTE(Units.exbi.getVal() * BYTE.DATA, "ExbiBytes"),
    /**
     * ZebiBytes 2^70 Bytes
     */
    ZEBIBYTE(Units.zebi.getVal() * BYTE.DATA, "ZebiBytes"),
    /**
     * YobiBytes 2^80 bytes
     */
    YOBIBYTE(Units.yobi.getVal() * BYTE.DATA, "YobiBytes"),
    /**
     * KiloBits 10^3 bits
     */
    KILOBIT(Units.kilo.getVal() * BIT.DATA, "KiloBits"),
    /**
     * MegaBits 10^6 bits
     */
    MEGABIT(Units.Mega.getVal() * BIT.DATA, "MegaBits"),
    /**
     * GigaBits 10^9 bits
     */
    GIGABIT(Units.Giga.getVal() * BIT.DATA, "GigaBits"),
    /**
     * TeraBits 10^12 bits
     */
    TERABIT(Units.Tera.getVal() * BIT.DATA, "TeraBits"),
    /**
     * PetaBits 10^15 bits
     */
    PETABIT(Units.Peta.getVal() * BIT.DATA, "PetaBits"),
    /**
     * ExaBits 10^18 bits
     */
    EXABIT(Units.Exa.getVal() * BIT.DATA, "ExaBits"),
    /**
     * ZetaBits 10^21 bits
     */
    ZETABIT(Units.Zeta.getVal() * BIT.DATA, "ZetaBits"),
    /**
     * YottaBits 10^24 bits
     */
    YOTTABIT(Units.Yotta.getVal() * BYTE.DATA, "YottaBits"),
    /**
     * KiloBytes 10^3 Bytes
     */
    KILOBYTE(Units.kilo.getVal() * BYTE.DATA, "KiloBytes"),
    /**
     * MegaBytes 10^6 Bytes
     */
    MEGABYTE(Units.Mega.getVal() * BYTE.DATA, "MegaBytes"),
    /**
     * GigaBytes 10^9 Bytes
     */
    GIGABYTE(Units.Giga.getVal() * BYTE.DATA, "GigaBytes"),
    /**
     * TeraBytes 10^12 Bytes
     */
    TERABYTE(Units.Tera.getVal() * BYTE.DATA, "TeraBytes"),
    /**
     * PetaBytes 10^15 Bytes
     */
    PETABYTE(Units.Peta.getVal() * BYTE.DATA, "PetaBytes"),
    /**
     * ExaBytes 10^18 Bytes
     */
    EXABYTE(Units.Exa.getVal() * BYTE.DATA, "ExaBytes"),
    /**
     * ZetaBytes 10^21 Bytes
     */
    ZETABYTE(Units.Zeta.getVal() * BYTE.DATA, "ZetaBytes"),
    /**
     * YottaBytes 10^24 Bytes
     */
    YOTTABYTE(Units.Yotta.getVal() * BYTE.DATA, "YottaBytes"),;
    public final double DATA;
    public final String STR;

    private Data(double data, String str) {
        DATA = data;
        STR = str;
    }

    public double getVal() {
        return DATA;
    }

    public String toString() {
        return STR;
    }
    
    public static Object[][] getAllVars() {
        Object names[] = Data.values();
        Object vars[][] = new Object[names.length][2];
        int Index = 0;
        for (Data g : Data.values()) {
            vars[Index][0] = g.toString();
            vars[Index][1] = g;
            Index++;
        }
        return vars;
    }

}
