package edu.neumont.smcnulty.boardsetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JOptionPane;

public class AI 
{
	
	protected boolean teamColorLight;
	
	public AI(boolean teamColorLight)
	{
		this.teamColorLight = teamColorLight;
	}
	
	protected static ArrayList<Move> findAllPossibleMoves(boolean teamColorLight, HashMap<String, Piece> pieceMap)
	{
		
		ArrayList<Move> movesToReturn = new ArrayList<Move>();

		//for every entry in the pieceMap
		for (Map.Entry<String, Piece> entry : pieceMap.entrySet()) 
		{
			String key = entry.getKey();
			Piece value = entry.getValue();

			//if it is the same color as this AI
			if(value.isLight() == teamColorLight)
			{
				ArrayList<String> validMoves = value.getValidMoves(key, pieceMap);
				for (String destination : validMoves) 
				{
					movesToReturn.add(new Move(key, destination));
				}
			}

			
		}
		//find every possible move that the AI has to make
		return movesToReturn;
	}
	

	public String aiGetTurn(HashMap<String, Piece> pieceMap) 
	{
		//take the pieceMap, call findAllPossibleMoves()
	    ArrayList<Move> moves = findAllPossibleMoves(teamColorLight, pieceMap);
	    
	    // RANDOMLY GRAB A MOVE
	    Random gen = new Random();
	    String chosenMove;
	    
	    if(moves.size() == 0 && !Piece.inCheckMate(teamColorLight, pieceMap))
	    {
	    	//make a dialog box to tell check
			JOptionPane.showMessageDialog(null, "You are in StaleMate!!!  ");
			chosenMove = null;
	    }
	    else
	    {
	    	int randomMoveNumber = gen.nextInt(moves.size());
			
	    	chosenMove = moves.get(randomMoveNumber).getStartPosition() + " " + moves.get(randomMoveNumber).getDestinationPosition();
	  
	    }
	    return BoardLoader.printResults(chosenMove);
	}
}
