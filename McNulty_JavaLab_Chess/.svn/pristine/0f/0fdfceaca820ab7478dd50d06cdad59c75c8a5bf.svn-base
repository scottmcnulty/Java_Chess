package edu.neumont.smcnulty.boardsetup;

import java.util.HashMap;

public class BoardModel 
{
	
	// the 32 pieces will be saved in a map 
	private HashMap<String, Piece> pieceMap;
	
	
	public BoardModel()
	{
		pieceMap = new HashMap();
	}
	
	public HashMap<String, Piece> getPieceMap()
	{
		return pieceMap;
	}
	
	
	public Piece getPiece(String location)
	{
		return pieceMap.get(location); 
	}
	
	public void setPiece(String location, Piece piece)
	{
		pieceMap.put(location, piece);
	}
	
	public void removePiece(String location)
	{
		pieceMap.remove(location);
	
	}
	
	
	
	
	/*
	public String toString()
	{
		// whole board state printout
		return "a";
	}*/
}

