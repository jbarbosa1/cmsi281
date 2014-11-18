package edu.lmu.cmsi.joseph.Recursion;

import java.util.Stack;

public class BalancedParenthesis{

	private String balanced;
	private char left1 = '(';
	private char left2 = '[';
	private char right1 = ')';
	private char right2 = ']';

	public BalancedParenthesis(String ex){
		this.balanced = ex;
		int count = 0;
		for(int i = 0; i < ex.length(); i++){
			if(ex.charAt(i) == left1){
				count++;
			}else if(ex.charAt(i) == left2){
				count++;
			}else if(ex.charAt(i) == right1){
				count++;
			}else if(ex.charAt(i) == right2){
				count++;
			}

			if(count == 0){
				throw new IllegalArgumentException("Not a parenthesis or bracket");
			}
		}
	}

	public boolean balanced(){
		Stack<Character> abused = new Stack<Character>();
		for (int i = 0; i < balanced.length(); i++) {
			if(balanced.charAt(i) == left1){
				abused.push(left1);
			}else if(balanced.charAt(i) == left2){
				abused.push(left2);
			}else if(balanced.charAt(i) == right1){
				if(abused.isEmpty()){
					return(!abused.isEmpty());
				}
				if(abused.pop() != left1){
					return(right1 == left1);
				}
			}else if(balanced.charAt(i) == right2){
				if(abused.isEmpty()){
					return(!abused.isEmpty());
				}
				if(abused.pop() != left2){
					return(right2 == left2);
				}
			}
		}
		return(abused.isEmpty());
	}
/*push all of the open instances & at every closed i pop and check if its not equal, because then the whole booean will be false*/
}