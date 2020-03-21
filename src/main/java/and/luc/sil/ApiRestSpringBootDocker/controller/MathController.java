package and.luc.sil.ApiRestSpringBootDocker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import and.luc.sil.ApiRestSpringBootDocker.exception.UnsuportedMathOperationException;
import and.luc.sil.ApiRestSpringBootDocker.services.MathService;
import and.luc.sil.ApiRestSpringBootDocker.services.NumberConverterService;

@RestController
public class MathController {
	
	@Autowired
	private MathService mathservice;
	@Autowired
	private NumberConverterService numberconverterservice;

	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!numberconverterservice.isNumeric(numberOne) || !numberconverterservice.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, insert a numeric value!");
		}
		Double sum = mathservice.sum(numberconverterservice.convertToDouble(numberOne),numberconverterservice.convertToDouble(numberTwo));
		return sum;
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!numberconverterservice.isNumeric(numberOne) || !numberconverterservice.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, insert a numeric value!");
		}
		Double sub = mathservice.sub(numberconverterservice.convertToDouble(numberOne),numberconverterservice.convertToDouble(numberTwo));
		return sub;
	}
	
	@RequestMapping(value="/mul/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!numberconverterservice.isNumeric(numberOne) || !numberconverterservice.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, insert a numeric value!");
		}
		Double mul = mathservice.mul(numberconverterservice.convertToDouble(numberOne),numberconverterservice.convertToDouble(numberTwo));
		return mul;
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!numberconverterservice.isNumeric(numberOne) || !numberconverterservice.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, insert a numeric value!");
		}
		Double div = mathservice.div(numberconverterservice.convertToDouble(numberOne),numberconverterservice.convertToDouble(numberTwo));
		return div;
	}
	
	@RequestMapping(value="/avg/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!numberconverterservice.isNumeric(numberOne) || !numberconverterservice.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please, insert a numeric value!");
		}
		Double avg = mathservice.avg(numberconverterservice.convertToDouble(numberOne),numberconverterservice.convertToDouble(numberTwo));
		return avg;
	}
	
	@RequestMapping(value="/sqrt/{number}", method=RequestMethod.GET)
	public Double avg(@PathVariable("number") String number) throws Exception {
		if(!numberconverterservice.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please, insert a numeric value!");
		}
		Double sqrt = mathservice.sqrt(numberconverterservice.convertToDouble(number));
		return sqrt;
	}
}
