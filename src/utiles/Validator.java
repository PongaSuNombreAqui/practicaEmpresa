package utiles;

import java.util.regex.Pattern;

public class Validator {

	public static boolean isNumber(String string) {
		boolean retorno = true;
		try {
			Double.parseDouble(string);
			char charAt = string.charAt(string.length() - 1);
			if (charAt == 'f' || charAt == 'd')
				retorno = false;
		} catch (NumberFormatException e) {
			retorno = false;
		}
		return retorno;
	}

	public static boolean isPhone(String string) {
		return Pattern.matches("[6-7-9]\\d{8}", string);
	}

	public static boolean isInteger(String string) {
		return Pattern.matches("\\d{" + String.valueOf(string.length()) + "}", string);
	}

}
