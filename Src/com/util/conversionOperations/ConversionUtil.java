package com.util.conversionOperations;

import com.util.stringOperations.*;
import com.util.validationOperations.*;

/**
 * This class is a library of conversion utilities.
 * 
 * @author <i>Jomon Thanuvelil Johny</i>
 * 
 */
public abstract class ConversionUtil {
	private ConversionUtil() {
	}

	public static double fahrenheitToCelsius(double tempf) {
		return (((tempf - 32) * 5) / 9);
	}

	/**
	 *  
	 * Converts from a specified number format to Decimal format
	 * 
	 * @param value :
	 *            Input value
	 * @param base :
	 *            Base of the value passed
	 * @return Decimal equivalent of input value
	 * @author <i>Jomon Thanuvelil Johny</i>
	 */
	public static String toDecimal(String value, int base) {
		if (!((base == 2 || InputValidator.isBinaryNumber(value)) ? true
				: (base == 8 || InputValidator.isOctalNumber(value)) ? true
						: (base == 16 || InputValidator.isHexaNumber(value) ? true
								: false)))
			throw new NumberFormatException("Invalid input format");

		int decVal = 0;
		double pow = 0;
		int i = 0;
		for (char ch : StringUtil.reverseString(value).toCharArray()) {
			decVal += Integer.valueOf((int) (Math.pow(base, pow++) * Character
					.getNumericValue(ch)));
			i++;
		}
		return String.valueOf(decVal);
	}

	/**
	 * Converts from decimal format to desired Output format
	 * 
	 * @param value
	 *            Decimal input value
	 * @param base
	 *            Base of desired output format ---> 2/8/16
	 * @return
	 * @throws NumberFormatException
	 *             If {@code value} is not corresponding to {@code base} arg
	 */
	public static String fromDecimal(String value, int base) {
		if (!InputValidator.isNumber(value))
			throw new NumberFormatException("Invalid input format");
		long temp = Long.valueOf(value);
		StringBuffer out = new StringBuffer();
		if (base == 16) {
			String[] hexArray = { "A", "B", "C", "D", "E", "F" };
			while (temp > 0) {
				int r = (int) temp % base;
				if (r > 9)
					out.append(hexArray[r - 10]);
				else
					out.append(temp % base);
				temp /= base;
			}
			return StringUtil.reverseString(out.toString());
		}
		while (temp > 0) {
			out.append(temp % base);
			temp /= base;
		}
		return StringUtil.reverseString(out.toString());
	}

	/**
	 * Converts from binary format to octal Output format
	 * 
	 * @param bin :
	 *            Binary value
	 * @return : Octal equivalent
	 * @throws NumberFormatException
	 */
	public static String binaryToOctal(String bin) {
		return fromDecimal(toDecimal(bin, 2), 8);
	}

	/**
	 * Converts from octal to binary format *
	 * 
	 * @param octal :
	 *            Octal value
	 * @return : Binary equivalent
	 * @throws NumberFormatException
	 */
	public static String octalToBinary(String octal) {
		return fromDecimal(toDecimal(octal, 8), 2);
	}

	/**
	 * Converts from binary to hexadecimal format *
	 * 
	 * @param bin :
	 *            Binary value
	 * @return : Hexadecimal equivalent
	 * @throws NumberFormatException
	 */
	public static String binaryToHexa(String bin) {
		return fromDecimal(toDecimal(bin, 2), 16);
	}

	/**
	 * Converts from hexadecimal to binary format *
	 * 
	 * @param octal :
	 *            Binary value
	 * @return : Binary equivalent
	 * @throws NumberFormatException
	 */
	public static String hexaToBinary(String hexa) {
		return fromDecimal(toDecimal(hexa, 16), 2);
	}

	/**
	 * Converts from octal to hexadecimal format *
	 * 
	 * @param octal :
	 *            Octal value
	 * @return : Hexadecimal equivalent
	 * @throws NumberFormatException
	 */
	public static String octalToHexa(String octal) {
		return fromDecimal(toDecimal(octal, 8), 16);
	}

	/**
	 * Converts from hexadecimal to octal format *
	 * 
	 * @param octal :
	 *            Hexadecimal value
	 * @return : Octal equivalent
	 * @throws NumberFormatException
	 */
	public static String hexaToOctal(String hexa) {
		return fromDecimal(toDecimal(hexa, 16), 8);
	}

}
