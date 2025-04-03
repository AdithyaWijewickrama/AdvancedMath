package com.amath.advacedmath.convert;

import com.advancedMath.convert.Power;

/**
 *
 * @author Adithya Wijewickrama
 */
public class Convert {

    /**
     *
     *
     * @param val Variable Value
     * @param flen first Displacement/length
     * @param ftime first time lapse
     * @param slen second Displacement/length
     * @param stime second time lapse
     * @return
     */
    public static double speed(double val, Length flen, Time ftime, Length slen, Time stime) {
        return val * (flen.getVal() / slen.getVal()) / (ftime.getVal() / stime.getVal());
    }

    public static double length(double val, Length flen, Length slen) {
        return val * (flen.getVal() / slen.getVal());
    }

    public static double angle(double val, Angle fAng, Angle sAng) {
        return val * (fAng.getVal() / sAng.getVal());
    }

    public static double temperature(double val, Temperature fTemp, Temperature sTemp) {
        String fT = fTemp.getStr();
        String sT = sTemp.getStr();
        String C = Temperature.C.getStr();
        String F = Temperature.F.getStr();
        String K = Temperature.K.getStr();
        val = fT.equals(C) && sT.equals(F) ? (val * 9 / 5) + 32
                : fT.equals(C) && sT.equals(K) ? (val + 273.15)
                : fT.equals(F) && sT.equals(C) ? (val - 32) * 5 / 9
                : fT.equals(F) && sT.equals(K) ? temperature(temperature(val, Temperature.F, Temperature.C), Temperature.C, Temperature.K)
                : fT.equals(K) && sT.equals(C) ? val - 273.15
                : fT.equals(K) && sT.equals(F) ? temperature(val - 273.15, Temperature.C, Temperature.F) : val;
        return val;
    }

    public static double time(double val, Time fTime, Time sTime) {
        return val * (fTime.getVal() / sTime.getVal());
    }

    public static double data(double val, Data fD, Data sD) {
        return val * (fD.getVal() / sD.getVal());
    }

    public static double energy(double val, Energy fE, Energy sE) {
        return val * (fE.getVal() / sE.getVal());
    }

    public static double power(double val, Power fP, Power sP) {
        return val * (fP.getVal() / sP.getVal());
    }

    public static double power(double val, Energy fE, Time fT, Energy sE, Time sT) {
        return val * (fE.getVal() / fT.getVal()) / (sE.getVal() / sT.getVal());
    }

    public static double volume(double val, Volume fV, Volume sV) {
        return val * (sV.getVal() / fV.getVal());
    }

    public static double area(double val, Length flen, Length slen) {
        return val * (Math.pow(flen.LEN, 2) / Math.pow(slen.LEN, 2));
    }

    public static double presure(double val, Presure fP, Presure sP) {
        return val * (fP.getPRES() / sP.getPRES());
    }

    public static double mass(double val, Mass fP, Mass sP) {
        return val * (fP.getVal() / sP.getVal());
    }

}
