package and.luc.sil.ApiRestSpringBootDocker.services;

import org.springframework.stereotype.Service;

@Service
public class NumberConverterService {

	public Double convertToDouble(String number) {
        if (number == null) {
        	return 0d; 
        }
        String strNumber = number.replaceAll(",", ".");
        if (isNumeric(strNumber)) {
        	return Double.parseDouble(strNumber);
        }
        return 0d;
	}

	public boolean isNumeric(String number) {
		if(number == null) {
			return false;
		}
		String strNumber = number.replace(",", ".");
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
