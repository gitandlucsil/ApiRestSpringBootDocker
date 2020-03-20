package and.luc.sil.ApiRestSpringBootDocker;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import and.luc.sil.ApiRestSpringBootDocker.exception.UnsuportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, insert a numeric value!");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}

	private Double convertToDouble(String number) {
        if (number == null) {
        	return 0d; 
        }
        String strNumber = number.replaceAll(",", ".");
        if (isNumeric(strNumber)) {
        	return Double.parseDouble(strNumber);
        }
        return 0d;
	}

	private boolean isNumeric(String number) {
		if(number == null) {
			return false;
		}
		String strNumber = number.replace(",", ".");
		return strNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}
