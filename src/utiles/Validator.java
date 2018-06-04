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
	
	public static boolean isDniCif(String string) {
		return true;
//		string = string.toUpperCase();
//		boolean retorno = false;
//		if ((Pattern.matches("\\d{8}+[ABCDEFGHJKLMNPQRSTVWXYZ]", string))
//				|| (Pattern.matches("[PQSW]\\d{7}+[A-Z]", string))
//				|| (Pattern.matches("[ABEH]\\d{7}+[0-9]", string))
//				|| (Pattern.matches("[CDFGJNRUV]\\d{7}\\w", string))) {
//			return true;
//		}
//		return retorno;
	}

	public static boolean isPhone(String string) {
		return true;
//		return Pattern.matches("[6-7-9]\\d{8}", string);
	}

	public static boolean isInteger(String string) {
		return Pattern.matches("\\d{" + String.valueOf(string.length()) + "}", string);
	}

}
