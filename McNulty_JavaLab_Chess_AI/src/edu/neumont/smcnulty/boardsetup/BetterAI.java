package edu.neumont.smcnulty.boardsetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BetterAI extends AI 
{

	// pass in what team the AI should be
	public BetterAI(boolean teamColorLight) 
	{
		super(teamColorLight);
	}
	
	//add up the totals of point values of pieces on the board, separated by team
	public int getBoardStatus(HashMap<String, Piece> pieceMap)
	{
		//these hold the score of the board
		int lightValue = 0, darkValue = 0;
	
		//get board state - light total and dark total.
	    for (Map.Entry<String, Piece> entry : pieceMap.entrySet()) 
	    {
	        String key = entry.getKey();
	        Piece value = entry.getValue();
	        
	        //  evalpiece to modify
	        if(value.isLight())
	        {
	        	lightValue += evalPiece(key, pieceMap);
	        }
	        if(!value.isLight())
	        {
	        	darkValue += evalPiece(key, pieceMap);
	        }
	    }
			
	    int boardStatus; 
	    
	    //modify the value of check and checkmate
	    if(Piece.inCheck(true, pieceMap))
	    {
	    	if(Piece.inCheckMate(true, pieceMap))
		    {
		    	darkValue += 10000; 
		    }
	    	else
	    	{
	    		darkValue += 2;
	    	}
	    	
	    }
	    else if(Piece.inCheck(false, pieceMap))
	    {
	    	if(Piece.inCheckMate(false, pieceMap))
		    {
		    	lightValue += 10000; 
		    }
	    	else
	    	{
	    		lightValue += 2;
	    	}
	    	
	    }
	    // avoid a stalemate at all costs, it has a low value
	    else if(Piece.inStalemate(pieceMap))
	    {
	    	if(teamColorLight)
	    	{
	    		lightValue -= 10000;
	    		darkValue = 0;
	    	}
	    	else
	    	{
	    		darkValue -= 10000;
	    		lightValue = 0;
	    	}
	    	
	    }
	    
	    
	    //prepare status according to what team it is
	    if(teamColorLight)
	    {
	    	boardStatus = lightValue-darkValue;
	    }
	    else
	    {
	    	boardStatus = darkValue- lightValue;
	    }
	    
	    return boardStatus;
	}
	
	
	
	
	//allows for tweaking the value of a move by affecting the value
	public int evalPiece(String start, HashMap<String, Piece> pieceMap)
	{
		// TO DO change piece weights according to conditions
		return pieceMap.get(start).getPieceValue();
	}
	
	//go through enemy moves, find the one that gives me the worst result
	private int getWorstOutcome(HashMap<String,Piece> map)
	{
		
		ArrayList<Move> enemyMoves = findAllPossibleMoves(!teamColorLight, map);
		
		int worstOutcome = Integer.MAX_VALUE;
		
		for (Move move : enemyMoves) 
		{
			HashMap<String, Piece> clonedMap = (HashMap<String, Piece>) map.clone();

			//make the move
			//get the piece, move it into the current ArrayList element's square, get rid of 1st position piece.
			clonedMap.put(move.getDestinationPosition(), clonedMap.get(move.getStartPosition()));
			clonedMap.remove(move.getStartPosition());
			
			worstOutcome = Math.min( getBoardStatus(clonedMap), worstOutcome);
			
		}
		return worstOutcome;
	}
	
	@Override
	public String aiGetTurn(HashMap<String, Piece> pieceMap) 
	{
		//take the pieceMap, call findAllPossibleMoves()
	    ArrayList<Move> moves = findAllPossibleMoves(teamColorLight, pieceMap);
	    
	    //current board summary
	    int boardValue  = getBoardStatus(pieceMap);
	    
	    //for each move, simulate move and check board status change
	    for (Move move : moves) 
	    {
	    	
	    	//clone the 'pieceMap' (the pieces in play)
			HashMap<String, Piece> cloneMap = (HashMap)pieceMap.clone();

			//make the move
			//get the piece, move it into the current ArrayList element's square, get rid of 1st position piece.
			cloneMap.put(move.getDestinationPosition(), cloneMap.get(move.getStartPosition()));
			cloneMap.remove(move.getStartPosition());

			//each move uses the board improvement/reduction in value as 
			int cloneBoardValue = getWorstOutcome(cloneMap);
	    	
			move.setMoveValue(cloneBoardValue);
		}
	    
	    ArrayList<Move> bestMoves = new ArrayList<Move>();
	    int currentHighestValue = Integer.MIN_VALUE;
	    
	    //get the best move(s)
	    for (Move move : moves) 
	    {
	    	int currentValue = move.getMoveValue();
	    	if(currentValue > currentHighestValue)
	    	{
	    		currentHighestValue = currentValue;
	    		bestMoves.clear();
	    	}
	    	if(currentValue >= currentHighestValue)
	    	{
	    		bestMoves.add(move);
	    	}
	    }
      //if more than one with the same value, randomly pick one to return.
   
	    // RANDOMLY GRAB A MOVE
	    Random gen = new Random();
	    
	    int randomMoveNumber = gen.nextInt(bestMoves.size());
   
	    Move bestMove = bestMoves.get(randomMoveNumber);
	    
	    String chosenMove = bestMove.getStartPosition() + " " + bestMove.getDestinationPosition();
	    
	    return BoardLoader.printResults(chosenMove);
	}

}


