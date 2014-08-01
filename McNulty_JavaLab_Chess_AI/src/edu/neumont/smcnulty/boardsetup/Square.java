package edu.neumont.smcnulty.boardsetup;

import javax.swing.JButton;


public class Square extends JButton 
{
	
	private final String loc;
	
	
	public Square(char column, int row)
	{
		super(); 
		loc = column + "" + row;
		//System.out.println(loc);
	}
	
	
	public String getLoc()
	{
		return loc;
	}
	
	
}
