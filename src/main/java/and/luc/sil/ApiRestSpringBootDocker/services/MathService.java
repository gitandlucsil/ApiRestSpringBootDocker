package and.luc.sil.ApiRestSpringBootDocker.services;

import org.springframework.stereotype.Service;

@Service
public class MathService {

	public Double sum(Double firstNumber, Double secondNumber) {
		return firstNumber + secondNumber;
	}
	
	public Double sub(Double firstNumber, Double secondNumber) {
		return firstNumber - secondNumber;
	}
	
	public Double mul(Double firstNumber, Double secondNumber) {
		return firstNumber * secondNumber;
	}
	
	public Double div(Double firstNumber, Double secondNumber) {
		return firstNumber / secondNumber;
	}
	
	public Double avg(Double firstNumber, Double secondNumber) {
		return (firstNumber + secondNumber)/2;
	}
	
	public Double sqrt(Double Number) {
		return Math.sqrt(Number);
	}
}
