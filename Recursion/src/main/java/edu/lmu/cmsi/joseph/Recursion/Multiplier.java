package edu.lmu.cmsi.joseph.Recursion;

public class Multiplier{

	public Multiplier(){
	}

	public int multiply(int num1, int num2){
		if((num1 < 0) || (num2 < 0)){
			throw new IllegalArgumentException("Can't be negative numbers");
		}else if((num1 == 0) || (num2 == 0)){
			return 0;
		}else{
		    return(num1 + multiply(num1, num2 - 1));
		}
	}
}