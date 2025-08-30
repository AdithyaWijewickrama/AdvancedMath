package com.amath.advacedmath.calculate;

import static com.amath.advacedmath.calculate.FormatType.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import com.amath.advacedmath.programmer.Base;
import static com.amath.advacedmath.programmer.Base.BIN;
import static com.amath.advacedmath.programmer.Base.DEC;
import static com.amath.advacedmath.programmer.Base.HEX;
import static com.amath.advacedmath.programmer.Base.OCT;
import com.amath.advacedmath.programmer.WordSize;

enum FormatType {
    GROUPING,
    NORMAL;
}

/**
 * Enum representing various number formats and their operations.
 * Provides functionality for grouping, ungrouping, and converting numbers between different bases.
 */
public enum NumberFormat {
    GROUPING_DECIMAL(GROUPING, 10, "###,###,###,###,###,###,###,###,###,###,###.##########################", ','),
    GROUPING_BINARY(GROUPING, 2, "####,####,####,####,####,####,####,####,####,####,####,####,####,####,####", ' '),
    GROUPING_HEXA(GROUPING, 16, "####,####,####,####", ' '),
    GROUPING_OCTAL(GROUPING, 8, "###,###,###,###,###,###,###", ' '),
    NORMAL_BINARY(NORMAL, 2, "#"),
    NORMAL_HEXA(NORMAL, 16, "#"),
    NORMAL_OCTAL(NORMAL, 8, "#"),
    NORMAL_DECIMAL(NORMAL, 10, "#############.#########");

    public final DecimalFormat format;
    public final FormatType formatType;
    public final int radix;
    public static final ArrayList<String> DIGITS = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"));

    /**
     * Constructs a NumberFormat instance with the specified format type, radix, and format pattern.
     *
     * @param formatType The type of format to be used (e.g., grouping or normal).
     * @param radix      The base or radix to be used for number representation.
     * @param format     The pattern string used to format numbers.
     */
    private NumberFormat(FormatType formatType, int radix, String format) {
        this.format = new DecimalFormat(format);
        this.radix = radix;
        this.formatType = formatType;
    }

    /**
     * Constructs a NumberFormat instance with the specified format type, radix, format pattern, and grouping separator.
     *
     * @param formatType   The type of format to be used (e.g., grouping or normal).
     * @param radix        The base or radix to be used for number representation.
     * @param format       The pattern string used to format numbers.
     * @param groupingSep  The character used as a grouping separator.
     */
    private NumberFormat(FormatType formatType, int radix, String format, char groupingSep) {
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(groupingSep);
        this.radix = radix;
        this.format = new DecimalFormat(format, symbols);
        this.formatType = formatType;
    }

    /**
     * Groups a number according to the specified number format.
     *
     * @param unformatedNumber The unformatted number as a string.
     * @return The grouped number as a string, or the original string if the format type is grouping.
     */
    public String groupNumber(String unformatedNumber) {
        if (unformatedNumber.equals("0")) {
            return "0";
        }
        if (radix < 10) {
            return format.format(new BigDecimal(unformatedNumber));
        } else if (radix == 10) {
            return format.format(new BigDecimal(unformatedNumber));
        } else {
            String[] n = GROUPING_BINARY.format.format(Double.parseDouble("1".repeat(unformatedNumber.length()))).split("");
            int j = 0;
            for (int i = 0; i < n.length; i++) {
                if (n[i].equals("1")) {
                    n[i] = Character.toString(unformatedNumber.charAt(j++));
                }
            }
            unformatedNumber = "";
            for (String chr : n) {
                unformatedNumber += chr;
            }
            return unformatedNumber;
        }
    }

    /**
     * Removes grouping from a formatted number.
     *
     * @param formatedNumber The formatted number as a string.
     * @return The ungrouped number as a string.
     */
    public String ungroupNumber(String formatedNumber) {
        return formatedNumber.replace(Character.toString(format.getDecimalFormatSymbols().getGroupingSeparator()), "");
    }

    /**
     * Converts a number from the current radix to its decimal representation.
     *
     * @param formatedNumber The formatted number as a string.
     * @param wordSize       The word size for binary representation (optional).
     * @return The decimal representation of the number as a BigDecimal.
     * @throws Exception If the input number is invalid for the current radix.
     */
    public BigDecimal convRadixToDecimal(String formatedNumber, WordSize wordSize) throws Exception {
        String parseNumber = ungroupNumber(formatedNumber);
        if (radix == 10) {
            if (wordSize == null) {
                return new BigDecimal(parseNumber);
            } else {
                return NORMAL_BINARY.convRadixToDecimal(NORMAL_BINARY.convDecimalToRadix(new BigDecimal(parseNumber), wordSize), wordSize);
            }
        }
        BigDecimal radixBig = BigDecimal.valueOf(radix);
        BigDecimal number = new BigDecimal(0);
        if (wordSize == null) {
            int pow = 0;
            for (int i = parseNumber.length() - 1; i >= 0; i--) {
                String dgt = Character.toString(parseNumber.charAt(i));
                if (DIGITS.indexOf(dgt) >= radix) {
                    throw new NumberFormatException("For input digit \"" + dgt + "\" under radix " + radix);
                }
                number = number.add(radixBig.pow(pow++).multiply(new BigDecimal(DIGITS.indexOf(dgt))));
            }
        } else {
            BigDecimal dec = convRadixToDecimal(parseNumber, null);
            String bin = radix == 2 ? parseNumber : NORMAL_BINARY.convDecimalToRadix(dec, null);
            if (bin.length() < wordSize.BITS) {
                return dec;
            }
            char[] trimedBin = new char[wordSize.BITS];
            bin.getChars(bin.length() - wordSize.BITS, bin.length(), trimedBin, 0);
            number = NORMAL_BINARY.convRadixToDecimal(String.valueOf(trimedBin), null);
            if (trimedBin[0] == '1') {
                number = number.subtract(BigDecimal.ONE);
                bin = NORMAL_BINARY.convDecimalToRadix(number, null);
                bin = "0".repeat(wordSize.BITS - bin.length()) + bin;
                for (int i = 0; i < wordSize.BITS; i++) {
                    trimedBin[i] = bin.charAt(i) == '1' ? '0' : '1';
                }
                number = NORMAL_BINARY.convRadixToDecimal(String.valueOf(trimedBin), null).multiply(BigDecimal.valueOf(-1));
            }
        }
        return number;
    }

    /**
     * Converts a decimal number to the current radix.
     *
     * @param number    The decimal number as a BigDecimal.
     * @param wordSize  The word size for binary representation (optional).
     * @return The number in the current radix as a string.
     * @throws Exception If the conversion fails.
     */
    public String convDecimalToRadix(BigDecimal number, WordSize wordSize) throws Exception {
        if (number.compareTo(BigDecimal.ZERO) == 0) {
            return "0";
        }
        String num = "";
        if (radix == 10) {
            num = number.toString();
        } else if (wordSize == null) {
            if (number.compareTo(BigDecimal.ZERO) == -1) {
                String binary = NORMAL_BINARY.convDecimalToRadix(number.abs(), null);
                for (WordSize ws : WordSize.values()) {
                    if (ws.BITS >= binary.length()) {
                        wordSize = ws;
                        break;
                    }
                }
                if (wordSize == null) {
                    throw new IllegalArgumentException("Cannot parse negative decimals to base '" + radix + "' numbers when word size is null");
                } else {
                    num = convDecimalToRadix(number, wordSize);
                }
            } else {
                BigDecimal radixBig = BigDecimal.valueOf(radix);
                String n = "";
                while (number.compareTo(BigDecimal.ZERO) == 1) {
                    n += DIGITS.get(number.remainder(radixBig).intValue());
                    number = number.divide(radixBig, MathContext.DECIMAL64).subtract(number.remainder(radixBig).divide(radixBig, MathContext.DECIMAL64));
                }
                num = new StringBuffer(n).reverse().toString();
            }
        } else if (wordSize.compare(number.longValue()) == 0) {
            if (number.compareTo(BigDecimal.ZERO) == -1) {
                number = number.abs();
                String binary = NORMAL_BINARY.convDecimalToRadix(number, null);
                char[] bin = ("0".repeat(wordSize.BITS - binary.length()) + binary).toCharArray();
                for (int i = 0; i < wordSize.BITS; i++) {
                    bin[i] = bin[i] == '1' ? '0' : '1';
                }
                binary = addBin(String.valueOf(bin), "1");
                num = binary.substring(binary.length() - wordSize.BITS, binary.length());
            } else {
                num = convDecimalToRadix(number, null);
            }
        } else {
            if (number.compareTo(BigDecimal.ZERO) == -1) {
                String binary = NORMAL_BINARY.convDecimalToRadix(number, null);
                num = NORMAL_BINARY.convDecimalToRadix(number, null).substring(binary.length() - wordSize.BITS, binary.length());
            } else {
                String binary = NORMAL_BINARY.convDecimalToRadix(number, null);
                num = convDecimalToRadix(NORMAL_BINARY.convRadixToDecimal(binary.substring(binary.length() - wordSize.BITS, binary.length()), null), null);
            }
        }
        if (formatType.equals(FormatType.GROUPING)) {
            return groupNumber(num);
        } else {
            return num;
        }
    }

    /**
     * Adds two binary numbers.
     *
     * @param bin1 The first binary number as a string.
     * @param bin2 The second binary number as a string.
     * @return The sum of the two binary numbers as a string.
     */
    public static String addBin(String bin1, String bin2) {
        char[] b1 = new StringBuffer(bin1).reverse().toString().toCharArray();
        char[] b2 = new StringBuffer(bin2).reverse().toString().toCharArray();
        int r = 0;
        String addBin = "";
        for (int i = 0; i < Math.max(bin1.length(), bin2.length()); i++) {
            boolean b11 = b1.length > i ? b1[i] == '1' : false;
            boolean b22 = b2.length > i ? b2[i] == '1' : false;
            r += ((b11 ? 1 : 0) + (b22 ? 1 : 0));
            addBin += "" + r % 2;
            r = (r - (r % 2)) / 2;
        }
        if (r != 0) {
            addBin += "" + r % 2;
        }
        return new StringBuffer(addBin).reverse().toString();
    }

    /**
     * Retrieves the grouping number format for a given base.
     *
     * @param b The base (e.g., binary, decimal, hexadecimal, octal).
     * @return The corresponding grouping NumberFormat.
     */
    public static NumberFormat getGroupingNumberFormat(Base b) {
        switch (b) {
            case BIN:
                return GROUPING_BINARY;
            case DEC:
                return GROUPING_DECIMAL;
            case HEX:
                return GROUPING_HEXA;
            case OCT:
                return GROUPING_OCTAL;
            default:
                throw new AssertionError();
        }
    }

    /**
     * Retrieves the normal number format for a given base.
     *
     * @param b The base (e.g., binary, decimal, hexadecimal, octal).
     * @return The corresponding normal NumberFormat.
     */
    public static NumberFormat getNormalNumberFormat(Base b) {
        switch (b) {
            case BIN:
                return NORMAL_BINARY;
            case DEC:
                return NORMAL_DECIMAL;
            case HEX:
                return NORMAL_HEXA;
            case OCT:
                return NORMAL_OCTAL;
            default:
                throw new AssertionError();
        }
    }
}
