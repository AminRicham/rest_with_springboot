package com.amin;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amin.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
    @RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        Double result = Functions.covertToDouble(numberOne) + Functions.covertToDouble(numberTwo);
        return result;        
    }
    @RequestMapping(value="/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double mult(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception{
    	if(!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Bota um valor ai fi");
    	}
    	Double result = Functions.covertToDouble(numberOne) * Functions.covertToDouble(numberTwo);
    	return result;
    }
    
    @RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
    public Double div(@PathVariable("numberOne") String numberOne,@PathVariable("numberTwo") String numberTwo) throws Exception{
    	if(!Functions.isNumeric(numberOne) || !Functions.isNumeric(numberTwo)) {
    		throw new UnsupportedMathOperationException("Bota um valor ai fi");
    	}
    	Double result = Functions.covertToDouble(numberOne) / Functions.covertToDouble(numberTwo);
    	return result;
    }
}