package edu.neumont.smcnulty.boardsetup;

public class Move 
{

	private String startPosition;
	private String destinationPosition;
	private int moveValue;
	
	
	public Move(String startPosition, String destinationPosition)
	{
		
		this.startPosition = startPosition;
		this.destinationPosition = destinationPosition;
		this.moveValue = Integer.MIN_VALUE;
	}
	
	
	public String getStartPosition() 
	{
		return startPosition;
	}
	
	public String getDestinationPosition() 
	{
		return destinationPosition;
	}
	
	public int getMoveValue()
	{
		return moveValue;
	}
	
	public void setMoveValue(int value)
	{
		moveValue = value;
	}
	
}
