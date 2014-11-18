package edu.lmu.cmsi.joseph.Recursion;

public class StringToInt{

	private int integer;
	private int value = 0;
	private int position;
	private int place = 1;
	private String word;
	
	public StringToInt(String input){
		this.word = input;
		this.position = input.length() - 1;
	}

	public int convert() {
        this.integer = Integer.parseInt(Character.toString(word.charAt(this.position)));
        this.value += this.integer * this.place;
        if(this.position == 0){
        	return value;
        }else{
        	this.position--;
        	this.place *= 10;
        	return convert();
        }
    }
}