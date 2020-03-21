package and.luc.sil.ApiRestSpringBootDocker.converters;

public class NumberConverter {

	public static Double convertToDouble(String number) {
        if (number == null) {
        	return 0d; 
        }
        String strNumber = number.replaceAll(",", ".");
        if (isNumeric(strNumber)) {
        	return Double.parseDouble(strNumber);
        }
        return 0d;
	}

	public static boolean isNumeric(String number) {
		if(number == null) {
			return false;
		}
		String strNumber = number.replace(",", ".");
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
