package br.com.bruno.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.bruno.exceptions.UnsupportedMathOperationException;
import br.com.bruno.utils.Utility;

public class SimpleMath {

	public Double Sum(Double numberOne, Double numberTwo) throws Exception{
		return numberOne + numberTwo;
	}
	
	public Double Subtraction(Double numberOne, Double numberTwo) throws Exception{
		return numberOne - numberTwo;
	}
	
	public Double Multiplication(Double numberOne,  Double numberTwo) throws Exception{
		return numberOne * numberTwo;
	}
	
	public Double Division(Double numberOne,  Double numberTwo) throws Exception{	
		return numberOne / numberTwo;
	}
	
	public Double Mean(Double numberOne, Double numberTwo) throws Exception{
		return (numberOne + numberTwo) / 2;
	}
	
	public Double Square(Double number) throws Exception{
		return Math.sqrt(number);
	}
	
}
