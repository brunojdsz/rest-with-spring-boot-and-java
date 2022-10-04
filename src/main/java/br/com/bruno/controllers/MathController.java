package br.com.bruno.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bruno.exceptions.UnsupportedMathOperationException;
import br.com.bruno.math.SimpleMath;
import br.com.bruno.utils.Utility;

@RestController
public class MathController {

	
	private SimpleMath math = new SimpleMath();
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne, 
						@PathVariable(value = "numberTwo" ) String numberTwo) throws Exception{
		
		if(!Utility.isNumeric(numberOne) || !Utility.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.Sum(Utility.convertToDouble(numberOne), Utility.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double Subtraction(@PathVariable(value = "numberOne") String numberOne, 
						@PathVariable(value = "numberTwo" ) String numberTwo) throws Exception{
		
		if(!Utility.isNumeric(numberOne) || !Utility.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.Subtraction(Utility.convertToDouble(numberOne), Utility.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double Multiplication(@PathVariable(value = "numberOne") String numberOne, 
						@PathVariable(value = "numberTwo" ) String numberTwo) throws Exception{
		
		if(!Utility.isNumeric(numberOne) || !Utility.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.Multiplication(Utility.convertToDouble(numberOne), Utility.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double Division(@PathVariable(value = "numberOne") String numberOne, 
						@PathVariable(value = "numberTwo" ) String numberTwo) throws Exception{
		
		if(!Utility.isNumeric(numberOne) || !Utility.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.Division(Utility.convertToDouble(numberOne), Utility.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double Mean(@PathVariable(value = "numberOne") String numberOne, 
						@PathVariable(value = "numberTwo" ) String numberTwo) throws Exception{
		
		if(!Utility.isNumeric(numberOne) || !Utility.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.Mean(Utility.convertToDouble(numberOne), Utility.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value = "/square/{number}", method=RequestMethod.GET)
	public Double Square(@PathVariable(value = "number") String number) throws Exception{
		
		if(!Utility.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.Square(Utility.convertToDouble(number));
	}

}
