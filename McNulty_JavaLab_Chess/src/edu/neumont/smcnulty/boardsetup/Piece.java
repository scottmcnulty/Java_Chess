package edu.neumont.smcnulty.boardsetup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;

public enum Piece 
{
	
	  LIGHTKING("kl.png", true, 1)
	{
		@Override
		public ArrayList<String> getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
			if(!checking)
			{
				removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			}
			return tempList;
		}

		@Override
		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			
			//**NORTH** 
			String north = getNorth(start);
			
			//is it a square on the board?
			if(isValidSpace(north))
			{
				//is it an unoccupied square?
				if(pieceMap.get(north) == null)
				{
					//add this to the valid moves
					tempList.add(north);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(north).equals(DARKPAWN) || pieceMap.get(north).equals(DARKROOK) || pieceMap.get(north).equals(DARKKNIGHT) || pieceMap.get(north).equals(DARKBISHOP) || pieceMap.get(north).equals(DARKKING) || pieceMap.get(north).equals(DARKQUEEN) )
				{
					tempList.add(north);
					System.out.println("attack");
				}
			}
			
			//**SOUTH** 
			String south = getSouth(start);
			
			//is it a square on the board?
			if(isValidSpace(south))
			{
				//is it an unoccupied square?
				if(pieceMap.get(south) == null)
				{
					//add this to the valid moves
					tempList.add(south);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(south).equals(DARKPAWN) || pieceMap.get(south).equals(DARKROOK) || pieceMap.get(south).equals(DARKKNIGHT) || pieceMap.get(south).equals(DARKBISHOP) || pieceMap.get(south).equals(DARKKING) || pieceMap.get(south).equals(DARKQUEEN) )
				{
					tempList.add(south);
					System.out.println("attack");
				}
			}
			
			//**EAST** 
			String east = getEast(start);
			
			//is it a square on the board?
			if(isValidSpace(east))
			{
				//is it an unoccupied square?
				if(pieceMap.get(east) == null)
				{
					//add this to the valid moves
					tempList.add(east);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(east).equals(DARKPAWN) || pieceMap.get(east).equals(DARKROOK) || pieceMap.get(east).equals(DARKKNIGHT) || pieceMap.get(east).equals(DARKBISHOP) || pieceMap.get(east).equals(DARKKING) || pieceMap.get(east).equals(DARKQUEEN) )
				{
					tempList.add(east);
					System.out.println("attack");
				}
			}
			
			//**WEST** 
			String west = getWest(start);
			
			//is it a square on the board?
			if(isValidSpace(west))
			{
				//is it an unoccupied square?
				if(pieceMap.get(west) == null)
				{
					//add this to the valid moves
					tempList.add(west);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(west).equals(DARKPAWN) || pieceMap.get(west).equals(DARKROOK) || pieceMap.get(west).equals(DARKKNIGHT) || pieceMap.get(west).equals(DARKBISHOP) || pieceMap.get(west).equals(DARKKING) || pieceMap.get(west).equals(DARKQUEEN) )
				{
					tempList.add(west);
					System.out.println("attack");
				}
			}
			
			//**NORTH_EAST** 
			String northEast = getNorthEast(start);
			
			//is it a square on the board?
			if(isValidSpace(northEast))
			{
				//is it an unoccupied square?
				if(pieceMap.get(northEast) == null)
				{
					//add this to the valid moves
					tempList.add(northEast);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(northEast).equals(DARKPAWN) || pieceMap.get(northEast).equals(DARKROOK) || pieceMap.get(northEast).equals(DARKKNIGHT) || pieceMap.get(northEast).equals(DARKBISHOP) || pieceMap.get(northEast).equals(DARKKING) || pieceMap.get(northEast).equals(DARKQUEEN) )
				{
					tempList.add(northEast);
					System.out.println("attack");
				}
			}
			
			//**SOUTH_EAST** 
			String southEast = getSouthEast(start);
			
			//is it a square on the board?
			if(isValidSpace(southEast))
			{
				//is it an unoccupied square?
				if(pieceMap.get(southEast) == null)
				{
					//add this to the valid moves
					tempList.add(southEast);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(southEast).equals(DARKPAWN) || pieceMap.get(southEast).equals(DARKROOK) || pieceMap.get(southEast).equals(DARKKNIGHT) || pieceMap.get(southEast).equals(DARKBISHOP) || pieceMap.get(southEast).equals(DARKKING) || pieceMap.get(southEast).equals(DARKQUEEN) )
				{
					tempList.add(southEast);
					System.out.println("attack");
				}
			}
			
			
			//**NORTH_WEST** 
			String northWest = getNorthWest(start);
			
			//is it a square on the board?
			if(isValidSpace(northWest))
			{
				//is it an unoccupied square?
				if(pieceMap.get(northWest) == null)
				{
					//add this to the valid moves
					tempList.add(northWest);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(northWest).equals(DARKPAWN) || pieceMap.get(northWest).equals(DARKROOK) || pieceMap.get(northWest).equals(DARKKNIGHT) || pieceMap.get(northWest).equals(DARKBISHOP) || pieceMap.get(northWest).equals(DARKKING) || pieceMap.get(northWest).equals(DARKQUEEN) )
				{
					tempList.add(northWest);
					System.out.println("attack");
				}
			}
			
			
			//**SOUTH_WEST** 
			String southWest = getSouthWest(start);
			
			//is it a square on the board?
			if(isValidSpace(southWest))
			{
				//is it an unoccupied square?
				if(pieceMap.get(southWest) == null)
				{
					//add this to the valid moves
					tempList.add(southWest);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(southWest).equals(DARKPAWN) || pieceMap.get(southWest).equals(DARKROOK) || pieceMap.get(southWest).equals(DARKKNIGHT) || pieceMap.get(southWest).equals(DARKBISHOP) || pieceMap.get(southWest).equals(DARKKING) || pieceMap.get(southWest).equals(DARKQUEEN) )
				{
					tempList.add(southWest);
					System.out.println("attack");
				}
			}
			return tempList;
		}
	}
	, LIGHTQUEEN("ql.png", true, 9)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
		
			
				removeMovesThatPutKingInCheck(start, tempList, pieceMap);
		
			return tempList;
			
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			boolean collision = false;
			
			//NORTH_EXTENDED
			String north = getNorth(start);
			while(!collision && isValidSpace(north))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(north) == null)
					{
						//add this to the valid moves
						tempList.add(north);	
					}
					//is it an enemy piece?
					else if(pieceMap.get(north).equals(DARKPAWN) || pieceMap.get(north).equals(DARKROOK) || pieceMap.get(north).equals(DARKKNIGHT) || pieceMap.get(north).equals(DARKBISHOP) || pieceMap.get(north).equals(DARKKING) || pieceMap.get(north).equals(DARKQUEEN) )
					{
						tempList.add(north);
						System.out.println("attack");
						collision = true;
					}
					//hit my own piece
					else
					{
						collision = true;
					}
					//increment north
					north = getNorth(north);
			}
			
			//reset collision
			collision = false;
			
			//SOUTH_EXTENDED
			String south = getSouth(start);
			while(!collision && isValidSpace(south))
			{
				
					
					//is it an unoccupied square?
					if(pieceMap.get(south) == null)
					{
						//add this to the valid moves
						tempList.add(south);	
					}
					else if(pieceMap.get(south).equals(DARKPAWN) || pieceMap.get(south).equals(DARKROOK) || pieceMap.get(south).equals(DARKKNIGHT) || pieceMap.get(south).equals(DARKBISHOP) || pieceMap.get(south).equals(DARKKING) || pieceMap.get(south).equals(DARKQUEEN) )
					{
						tempList.add(south);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					south = getSouth(south);
			}
			
			//reset collision
			collision = false;
			
			//WEST_EXTENDED
			String west = getWest(start);
			while(!collision && isValidSpace(west))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(west) == null)
					{
						//add this to the valid moves
						tempList.add(west);	
					}
					else if(pieceMap.get(west).equals(DARKPAWN) || pieceMap.get(west).equals(DARKROOK) || pieceMap.get(west).equals(DARKKNIGHT) || pieceMap.get(west).equals(DARKBISHOP) || pieceMap.get(west).equals(DARKKING) || pieceMap.get(west).equals(DARKQUEEN) )
					{
						tempList.add(west);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					west = getWest(west);
			}
			
			//reset collision
			collision = false;
			
			//EAST_EXTENDED
			String east = getEast(start);
			while(!collision && isValidSpace(east))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(east) == null)
					{
						//add this to the valid moves
						tempList.add(east);	
					}
					else if(pieceMap.get(east).equals(DARKPAWN) || pieceMap.get(east).equals(DARKROOK) || pieceMap.get(east).equals(DARKKNIGHT) || pieceMap.get(east).equals(DARKBISHOP) || pieceMap.get(east).equals(DARKKING) || pieceMap.get(east).equals(DARKQUEEN) )
					{
						tempList.add(east);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					east = getEast(east);	
			}
			
			//reset collision
			collision = false;
			
			//NORTHEAST_EXTENDED
			String northEast = getNorthEast(start);
			while(!collision && isValidSpace(northEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northEast) == null)
					{
						//add this to the valid moves
						tempList.add(northEast);	
					}
					else if(pieceMap.get(northEast).equals(DARKPAWN) || pieceMap.get(northEast).equals(DARKROOK) || pieceMap.get(northEast).equals(DARKKNIGHT) || pieceMap.get(northEast).equals(DARKBISHOP) || pieceMap.get(northEast).equals(DARKKING) || pieceMap.get(northEast).equals(DARKQUEEN) )
					{
						tempList.add(northEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northEast = getNorthEast(northEast);
			}
			
			//reset collision
			collision = false;
			
			//NORTHWEST_EXTENDED
			String northWest = getNorthWest(start);
			while(!collision && isValidSpace(northWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northWest) == null)
					{
						//add this to the valid moves
						tempList.add(northWest);	
					}
					else if(pieceMap.get(northWest).equals(DARKPAWN) || pieceMap.get(northWest).equals(DARKROOK) || pieceMap.get(northWest).equals(DARKKNIGHT) || pieceMap.get(northWest).equals(DARKBISHOP) || pieceMap.get(northWest).equals(DARKKING) || pieceMap.get(northWest).equals(DARKQUEEN) )
					{
						tempList.add(northWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northWest = getNorthWest(northWest);
			}

			
			//reset collision
			collision = false;
			
			//SOUTHEAST_EXTENDED
			String southEast = getSouthEast(start);
			while(!collision && isValidSpace(southEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southEast) == null)
					{
						//add this to the valid moves
						tempList.add(southEast);	
					}
					//enemy in square?
					else if(pieceMap.get(southEast).equals(DARKPAWN) || pieceMap.get(southEast).equals(DARKROOK) || pieceMap.get(southEast).equals(DARKKNIGHT) || pieceMap.get(southEast).equals(DARKBISHOP) || pieceMap.get(southEast).equals(DARKKING) || pieceMap.get(southEast).equals(DARKQUEEN) )
					{
						tempList.add(southEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southEast = getSouthEast(southEast);
			}
			
			//reset collision
			collision = false;
			
			//SOUTHWEST_EXTENDED
			String southWest = getSouthWest(start);
			while(!collision && isValidSpace(southWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southWest) == null)
					{
						//add this to the valid moves
						tempList.add(southWest);	
					}
					//enemy in square?
					else if(pieceMap.get(southWest).equals(DARKPAWN) || pieceMap.get(southWest).equals(DARKROOK) || pieceMap.get(southWest).equals(DARKKNIGHT) || pieceMap.get(southWest).equals(DARKBISHOP) || pieceMap.get(southWest).equals(DARKKING) || pieceMap.get(southWest).equals(DARKQUEEN) )
					{
						tempList.add(southWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southWest = getSouthWest(southWest);
			}
			return tempList;
		}
	}
	, LIGHTROOK("rl.png", true, 5)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
			
		
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
			
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			boolean collision = false;
			
			//NORTH_EXTENDED
			String north = getNorth(start);
			while(!collision && isValidSpace(north))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(north) == null)
					{
						//add this to the valid moves
						tempList.add(north);	
					}
					//is it an enemy piece?
					else if(pieceMap.get(north).equals(DARKPAWN) || pieceMap.get(north).equals(DARKROOK) || pieceMap.get(north).equals(DARKKNIGHT) || pieceMap.get(north).equals(DARKBISHOP) || pieceMap.get(north).equals(DARKKING) || pieceMap.get(north).equals(DARKQUEEN) )
					{
						tempList.add(north);
						System.out.println("attack");
						collision = true;
					}
					//hit my own piece
					else
					{
						collision = true;
					}
				
					north = getNorth(north);
			}
			
			//reset collision
			collision = false;
			
			//SOUTH_EXTENDED
			String south = getSouth(start);
			while(!collision && isValidSpace(south))
			{
				
					
					//is it an unoccupied square?
					if(pieceMap.get(south) == null)
					{
						//add this to the valid moves
						tempList.add(south);	
					}
					else if(pieceMap.get(south).equals(DARKPAWN) || pieceMap.get(south).equals(DARKROOK) || pieceMap.get(south).equals(DARKKNIGHT) || pieceMap.get(south).equals(DARKBISHOP) || pieceMap.get(south).equals(DARKKING) || pieceMap.get(south).equals(DARKQUEEN) )
					{
						tempList.add(south);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					south = getSouth(south);
			}
			
			//reset collision
			collision = false;
			
			//WEST_EXTENDED
			String west = getWest(start);
			while(!collision && isValidSpace(west))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(west) == null)
					{
						//add this to the valid moves
						tempList.add(west);	
					}
					else if(pieceMap.get(west).equals(DARKPAWN) || pieceMap.get(west).equals(DARKROOK) || pieceMap.get(west).equals(DARKKNIGHT) || pieceMap.get(west).equals(DARKBISHOP) || pieceMap.get(west).equals(DARKKING) || pieceMap.get(west).equals(DARKQUEEN) )
					{
						tempList.add(west);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					west = getWest(west);
			}
			
			//reset collision
			collision = false;
			
			//EAST_EXTENDED
			String east = getEast(start);
			while(!collision && isValidSpace(east))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(east) == null)
					{
						//add this to the valid moves
						tempList.add(east);	
					}
					else if(pieceMap.get(east).equals(DARKPAWN) || pieceMap.get(east).equals(DARKROOK) || pieceMap.get(east).equals(DARKKNIGHT) || pieceMap.get(east).equals(DARKBISHOP) || pieceMap.get(east).equals(DARKKING) || pieceMap.get(east).equals(DARKQUEEN) )
					{
						tempList.add(east);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					east = getEast(east);
			}
			return tempList;
		}
	}
	, LIGHTKNIGHT("nl.png", true, 3)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
	
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			
			
			//ONE OCLOCK
			String oneOclock = getOneOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(oneOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(oneOclock) == null)
				{
					//add this to the valid moves
					tempList.add(oneOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(oneOclock).equals(DARKPAWN) || pieceMap.get(oneOclock).equals(DARKROOK) || pieceMap.get(oneOclock).equals(DARKKNIGHT) || pieceMap.get(oneOclock).equals(DARKBISHOP) || pieceMap.get(oneOclock).equals(DARKKING) || pieceMap.get(oneOclock).equals(DARKQUEEN) )
				{
					tempList.add(oneOclock);
					System.out.println("attack");
				}
			}
			
			//TWO OCLOCK
			String twoOclock = getTwoOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(twoOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(twoOclock) == null)
				{
					//add this to the valid moves
					tempList.add(twoOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(twoOclock).equals(DARKPAWN) || pieceMap.get(twoOclock).equals(DARKROOK) || pieceMap.get(twoOclock).equals(DARKKNIGHT) || pieceMap.get(twoOclock).equals(DARKBISHOP) || pieceMap.get(twoOclock).equals(DARKKING) || pieceMap.get(twoOclock).equals(DARKQUEEN) )
				{
					tempList.add(twoOclock);
					System.out.println("attack");
				}
			}
			
			//FOUR OCLOCK
			String fourOclock = getFourOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(fourOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(fourOclock) == null)
				{
					//add this to the valid moves
					tempList.add(fourOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(fourOclock).equals(DARKPAWN) || pieceMap.get(fourOclock).equals(DARKROOK) || pieceMap.get(fourOclock).equals(DARKKNIGHT) || pieceMap.get(fourOclock).equals(DARKBISHOP) || pieceMap.get(fourOclock).equals(DARKKING) || pieceMap.get(fourOclock).equals(DARKQUEEN) )
				{
					tempList.add(fourOclock);
					System.out.println("attack");
				}
			}
			
			//FIVE OCLOCK
			String fiveOclock = getFiveOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(fiveOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(fiveOclock) == null)
				{
					//add this to the valid moves
					tempList.add(fiveOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(fiveOclock).equals(DARKPAWN) || pieceMap.get(fiveOclock).equals(DARKROOK) || pieceMap.get(fiveOclock).equals(DARKKNIGHT) || pieceMap.get(fiveOclock).equals(DARKBISHOP) || pieceMap.get(fiveOclock).equals(DARKKING) || pieceMap.get(fiveOclock).equals(DARKQUEEN) )
				{
					tempList.add(fiveOclock);
					System.out.println("attack");
				}
			}
			
			//SEVEN OCLOCK
			String sevenOclock = getSevenOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(sevenOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(sevenOclock) == null)
				{
					//add this to the valid moves
					tempList.add(sevenOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(sevenOclock).equals(DARKPAWN) || pieceMap.get(sevenOclock).equals(DARKROOK) || pieceMap.get(sevenOclock).equals(DARKKNIGHT) || pieceMap.get(sevenOclock).equals(DARKBISHOP) || pieceMap.get(sevenOclock).equals(DARKKING) || pieceMap.get(sevenOclock).equals(DARKQUEEN) )
				{
					tempList.add(sevenOclock);
					System.out.println("attack");
				}
			}
			
			//EIGHT OCLOCK
			String eightOclock = getEightOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(eightOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(eightOclock) == null)
				{
					//add this to the valid moves
					tempList.add(eightOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(eightOclock).equals(DARKPAWN) || pieceMap.get(eightOclock).equals(DARKROOK) || pieceMap.get(eightOclock).equals(DARKKNIGHT) || pieceMap.get(eightOclock).equals(DARKBISHOP) || pieceMap.get(eightOclock).equals(DARKKING) || pieceMap.get(eightOclock).equals(DARKQUEEN) )
				{
					tempList.add(eightOclock);
					System.out.println("attack");
				}
			}
			
			//TEN OCLOCK
			String tenOclock = getTenOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(tenOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(tenOclock) == null)
				{
					//add this to the valid moves
					tempList.add(tenOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(tenOclock).equals(DARKPAWN) || pieceMap.get(tenOclock).equals(DARKROOK) || pieceMap.get(tenOclock).equals(DARKKNIGHT) || pieceMap.get(tenOclock).equals(DARKBISHOP) || pieceMap.get(tenOclock).equals(DARKKING) || pieceMap.get(tenOclock).equals(DARKQUEEN) )
				{
					tempList.add(tenOclock);
					System.out.println("attack");
				}
			}
			
			//ELEVEN OCLOCK
			String elevenOclock = getElevenOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(elevenOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(elevenOclock) == null)
				{
					//add this to the valid moves
					tempList.add(elevenOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(elevenOclock).equals(DARKPAWN) || pieceMap.get(elevenOclock).equals(DARKROOK) || pieceMap.get(elevenOclock).equals(DARKKNIGHT) || pieceMap.get(elevenOclock).equals(DARKBISHOP) || pieceMap.get(elevenOclock).equals(DARKKING) || pieceMap.get(elevenOclock).equals(DARKQUEEN) )
				{
					tempList.add(elevenOclock);
					System.out.println("attack");
				}
			}
			return tempList;
		}
	}
	, LIGHTBISHOP("bl.png", true, 3)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
		
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			
			boolean collision = false;
			
			//NORTHEAST_EXTENDED
			String northEast = getNorthEast(start);
			while(!collision && isValidSpace(northEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northEast) == null)
					{
						//add this to the valid moves
						tempList.add(northEast);	
					}
					else if(pieceMap.get(northEast).equals(DARKPAWN) || pieceMap.get(northEast).equals(DARKROOK) || pieceMap.get(northEast).equals(DARKKNIGHT) || pieceMap.get(northEast).equals(DARKBISHOP) || pieceMap.get(northEast).equals(DARKKING) || pieceMap.get(northEast).equals(DARKQUEEN) )
					{
						tempList.add(northEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northEast = getNorthEast(northEast);
			}
			
			//reset collision
			collision = false;
			
			//NORTHWEST_EXTENDED
			String northWest = getNorthWest(start);
			while(!collision && isValidSpace(northWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northWest) == null)
					{
						//add this to the valid moves
						tempList.add(northWest);	
					}
					else if(pieceMap.get(northWest).equals(DARKPAWN) || pieceMap.get(northWest).equals(DARKROOK) || pieceMap.get(northWest).equals(DARKKNIGHT) || pieceMap.get(northWest).equals(DARKBISHOP) || pieceMap.get(northWest).equals(DARKKING) || pieceMap.get(northWest).equals(DARKQUEEN) )
					{
						tempList.add(northWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northWest = getNorthWest(northWest);
			}

			
			//reset collision
			collision = false;
			
			//SOUTHEAST_EXTENDED
			String southEast = getSouthEast(start);
			while(!collision && isValidSpace(southEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southEast) == null)
					{
						//add this to the valid moves
						tempList.add(southEast);	
					}
					//enemy in square?
					else if(pieceMap.get(southEast).equals(DARKPAWN) || pieceMap.get(southEast).equals(DARKROOK) || pieceMap.get(southEast).equals(DARKKNIGHT) || pieceMap.get(southEast).equals(DARKBISHOP) || pieceMap.get(southEast).equals(DARKKING) || pieceMap.get(southEast).equals(DARKQUEEN) )
					{
						tempList.add(southEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southEast = getSouthEast(southEast);
			}
			
			//reset collision
			collision = false;
			
			//SOUTHWEST_EXTENDED
			String southWest = getSouthWest(start);
			while(!collision && isValidSpace(southWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southWest) == null)
					{
						//add this to the valid moves
						tempList.add(southWest);	
					}
					//enemy in square?
					else if(pieceMap.get(southWest).equals(DARKPAWN) || pieceMap.get(southWest).equals(DARKROOK) || pieceMap.get(southWest).equals(DARKKNIGHT) || pieceMap.get(southWest).equals(DARKBISHOP) || pieceMap.get(southWest).equals(DARKKING) || pieceMap.get(southWest).equals(DARKQUEEN) )
					{
						tempList.add(southWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southWest = getSouthWest(southWest);
			}
			return tempList;
		}
	}
	, LIGHTPAWN("pl.png",true, 1)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
			
//			if(!checking)
//			{
				removeMovesThatPutKingInCheck(start, tempList, pieceMap);
//			}
			return tempList;
		}

		@Override
		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList<String>();
			
			
			//**NORTH** pawn cannot attack straight move
			String north = getNorth(start);
			//is it a square on the board?
			if(isValidSpace(north))
			{
				//is it an unoccupied square?
				if(pieceMap.get(north) == null)
				{
					//add this to the valid moves
					tempList.add(north);	
				}	
			}
			//get one space north of the current north (2 space first pawn move)
			north = getNorth(north);
			
			//validate second square for first pawn move- all light pawns start on 2nd row
			if(isValidSpace(north) && start.charAt(1) == '2')
			{
				//is it an unoccupied square?  How about the 1st square?
				if(pieceMap.get(north) == null && pieceMap.get(getSouth(north)) == null)
				{
					//add this to the valid moves
					tempList.add(north);
				}
			}
			
			
			//**NORTH_WEST**--ATTACK
			String northwest = getNorthWest(start);
			if(isValidSpace(northwest))
			{
				//is it an unoccupied square?  can't move here 
				if(pieceMap.get(northwest) == null)
				{
					//don't add this to the valid moves
					//tempList.add(northwest);
					
				} 
				//is it an enemy piece? 
				else if(pieceMap.get(northwest).equals(DARKPAWN) || pieceMap.get(northwest).equals(DARKROOK) || pieceMap.get(northwest).equals(DARKKNIGHT) || pieceMap.get(northwest).equals(DARKBISHOP) || pieceMap.get(northwest).equals(DARKKING) || pieceMap.get(northwest).equals(DARKQUEEN) )
				{
					tempList.add(northwest);
					System.out.println("attack");
				}
			}
			
			//**NORTH_EAST**--ATTACK
			String northeast = getNorthEast(start);
			if(isValidSpace(northeast))
			{
				//is it an unoccupied square? can't move here
				if(pieceMap.get(northeast) == null)
				{
					//don't add this to the valid moves
					//tempList.add(northeast);
					
				}
				//is it an enemy piece? 
				else if(pieceMap.get(northeast).equals(DARKPAWN) || pieceMap.get(northeast).equals(DARKROOK) || pieceMap.get(northeast).equals(DARKKNIGHT) || pieceMap.get(northeast).equals(DARKBISHOP) || pieceMap.get(northeast).equals(DARKKING) || pieceMap.get(northeast).equals(DARKQUEEN) )
				{
					tempList.add(northeast);
					System.out.println("attack");
				}
			}
	
			
			
		/*	temp.add("NORTH_WEST");
			temp.add("NORTH_EAST");
			temp.add("NORTH");
			temp.add("NORTH_EXTENDED");*/
			return tempList;
		}
	}
	

	, DARKKING("kd.png", false, 1)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
	
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			
			//**NORTH** 
			String north = getNorth(start);
			
			//is it a square on the board?
			if(isValidSpace(north))
			{
				//is it an unoccupied square?
				if(pieceMap.get(north) == null)
				{
					//add this to the valid moves
					tempList.add(north);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(north).equals(LIGHTPAWN) || pieceMap.get(north).equals(LIGHTROOK) || pieceMap.get(north).equals(LIGHTKNIGHT) || pieceMap.get(north).equals(LIGHTBISHOP) || pieceMap.get(north).equals(LIGHTKING) || pieceMap.get(north).equals(LIGHTQUEEN) )
				{
					tempList.add(north);
					System.out.println("attack");
				}
			}
			
			//**SOUTH** 
			String south = getSouth(start);
			
			//is it a square on the board?
			if(isValidSpace(south))
			{
				//is it an unoccupied square?
				if(pieceMap.get(south) == null)
				{
					//add this to the valid moves
					tempList.add(south);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(south).equals(LIGHTPAWN) || pieceMap.get(south).equals(LIGHTROOK) || pieceMap.get(south).equals(LIGHTKNIGHT) || pieceMap.get(south).equals(LIGHTBISHOP) || pieceMap.get(south).equals(LIGHTKING) || pieceMap.get(south).equals(LIGHTQUEEN) )
				{
					tempList.add(south);
					System.out.println("attack");
				}
			}
			
			//**EAST** 
			String east = getEast(start);
			
			//is it a square on the board?
			if(isValidSpace(east))
			{
				//is it an unoccupied square?
				if(pieceMap.get(east) == null)
				{
					//add this to the valid moves
					tempList.add(east);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(east).equals(LIGHTPAWN) || pieceMap.get(east).equals(LIGHTROOK) || pieceMap.get(east).equals(LIGHTKNIGHT) || pieceMap.get(east).equals(LIGHTBISHOP) || pieceMap.get(east).equals(LIGHTKING) || pieceMap.get(east).equals(LIGHTQUEEN) )
				{
					tempList.add(east);
				}
			}
			
			//**WEST** 
			String west = getWest(start);
			
			//is it a square on the board?
			if(isValidSpace(west))
			{
				//is it an unoccupied square?
				if(pieceMap.get(west) == null)
				{
					//add this to the valid moves
					tempList.add(west);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(west).equals(LIGHTPAWN) || pieceMap.get(west).equals(LIGHTROOK) || pieceMap.get(west).equals(LIGHTKNIGHT) || pieceMap.get(west).equals(LIGHTBISHOP) || pieceMap.get(west).equals(LIGHTKING) || pieceMap.get(west).equals(LIGHTQUEEN) )
				{
					tempList.add(west);
					System.out.println("attack");
				}
			}
			
			//**NORTH_EAST** 
			String northEast = getNorthEast(start);
			
			//is it a square on the board?
			if(isValidSpace(northEast))
			{
				//is it an unoccupied square?
				if(pieceMap.get(northEast) == null)
				{
					//add this to the valid moves
					tempList.add(northEast);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(northEast).equals(LIGHTPAWN) || pieceMap.get(northEast).equals(LIGHTROOK) || pieceMap.get(northEast).equals(LIGHTKNIGHT) || pieceMap.get(northEast).equals(LIGHTBISHOP) || pieceMap.get(northEast).equals(LIGHTKING) || pieceMap.get(northEast).equals(LIGHTQUEEN) )
				{
					tempList.add(northEast);
					System.out.println("attack");
				}
			}
			
			//**SOUTH_EAST** 
			String southEast = getSouthEast(start);
			
			//is it a square on the board?
			if(isValidSpace(southEast))
			{
				//is it an unoccupied square?
				if(pieceMap.get(southEast) == null)
				{
					//add this to the valid moves
					tempList.add(southEast);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(southEast).equals(LIGHTPAWN) || pieceMap.get(southEast).equals(LIGHTROOK) || pieceMap.get(southEast).equals(LIGHTKNIGHT) || pieceMap.get(southEast).equals(LIGHTBISHOP) || pieceMap.get(southEast).equals(LIGHTKING) || pieceMap.get(southEast).equals(LIGHTQUEEN) )
				{
					tempList.add(southEast);
					System.out.println("attack");
				}
			}
			
			
			//**NORTH_WEST** 
			String northWest = getNorthWest(start);
			
			//is it a square on the board?
			if(isValidSpace(northWest))
			{
				//is it an unoccupied square?
				if(pieceMap.get(northWest) == null)
				{
					//add this to the valid moves
					tempList.add(northWest);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(northWest).equals(LIGHTPAWN) || pieceMap.get(northWest).equals(LIGHTROOK) || pieceMap.get(northWest).equals(LIGHTKNIGHT) || pieceMap.get(northWest).equals(LIGHTBISHOP) || pieceMap.get(northWest).equals(LIGHTKING) || pieceMap.get(northWest).equals(LIGHTQUEEN) )
				{
					tempList.add(northWest);
					System.out.println("attack");
				}
			}
			
			
			//**SOUTH_WEST** 
			String southWest = getSouthWest(start);
			
			//is it a square on the board?
			if(isValidSpace(southWest))
			{
				//is it an unoccupied square?
				if(pieceMap.get(southWest) == null)
				{
					//add this to the valid moves
					tempList.add(southWest);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(southWest).equals(LIGHTPAWN) || pieceMap.get(southWest).equals(LIGHTROOK) || pieceMap.get(southWest).equals(LIGHTKNIGHT) || pieceMap.get(southWest).equals(LIGHTBISHOP) || pieceMap.get(southWest).equals(LIGHTKING) || pieceMap.get(southWest).equals(LIGHTQUEEN) )
				{
					tempList.add(southWest);
					System.out.println("attack");
				}
			}
			return tempList;
		}
	}
	, DARKQUEEN("qd.png", false, 9)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
			
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			boolean collision = false;
			
			//NORTH_EXTENDED
			String north = getNorth(start);
			while(!collision && isValidSpace(north))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(north) == null)
					{
						//add this to the valid moves
						tempList.add(north);	
					}
					//is it an enemy piece?
					else if(pieceMap.get(north).equals(LIGHTPAWN) || pieceMap.get(north).equals(LIGHTROOK) || pieceMap.get(north).equals(LIGHTKNIGHT) || pieceMap.get(north).equals(LIGHTBISHOP) || pieceMap.get(north).equals(LIGHTKING) || pieceMap.get(north).equals(LIGHTQUEEN) )
					{
						tempList.add(north);
						System.out.println("attack");
						collision = true;
					}
					//hit my own piece
					else
					{
						collision = true;
					}
				
					north = getNorth(north);
			}
			
			//reset collision
			collision = false;
			
			//SOUTH_EXTENDED
			String south = getSouth(start);
			while(!collision && isValidSpace(south))
			{
				
					
					//is it an unoccupied square?
					if(pieceMap.get(south) == null)
					{
						//add this to the valid moves
						tempList.add(south);	
					}
					else if(pieceMap.get(south).equals(LIGHTPAWN) || pieceMap.get(south).equals(LIGHTROOK) || pieceMap.get(south).equals(LIGHTKNIGHT) || pieceMap.get(south).equals(LIGHTBISHOP) || pieceMap.get(south).equals(LIGHTKING) || pieceMap.get(south).equals(LIGHTQUEEN) )
					{
						tempList.add(south);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					south = getSouth(south);
			}
			
			//reset collision
			collision = false;
			
			//WEST_EXTENDED
			String west = getWest(start);
			while(!collision && isValidSpace(west))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(west) == null)
					{
						//add this to the valid moves
						tempList.add(west);	
					}
					else if(pieceMap.get(west).equals(LIGHTPAWN) || pieceMap.get(west).equals(LIGHTROOK) || pieceMap.get(west).equals(LIGHTKNIGHT) || pieceMap.get(west).equals(LIGHTBISHOP) || pieceMap.get(west).equals(LIGHTKING) || pieceMap.get(west).equals(LIGHTQUEEN) )
					{
						tempList.add(west);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					west = getWest(west);
			}
			
			//reset collision
			collision = false;
			
			//EAST_EXTENDED
			String east = getEast(start);
			while(!collision && isValidSpace(east))
			{
				
					//is it an unoccupied square?
					if(pieceMap.get(east) == null)
					{
						//add this to the valid moves
						tempList.add(east);	
					}
					else if(pieceMap.get(east).equals(LIGHTPAWN) || pieceMap.get(east).equals(LIGHTROOK) || pieceMap.get(east).equals(LIGHTKNIGHT) || pieceMap.get(east).equals(LIGHTBISHOP) || pieceMap.get(east).equals(LIGHTKING) || pieceMap.get(east).equals(LIGHTQUEEN) )
					{
						tempList.add(east);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					east = getEast(east);	
			}
			
			//reset collision
			collision = false;
			
			//NORTHEAST_EXTENDED
			String northEast = getNorthEast(start);
			while(!collision && isValidSpace(northEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northEast) == null)
					{
						//add this to the valid moves
						tempList.add(northEast);	
					}
					else if(pieceMap.get(northEast).equals(LIGHTPAWN) || pieceMap.get(northEast).equals(LIGHTROOK) || pieceMap.get(northEast).equals(LIGHTKNIGHT) || pieceMap.get(northEast).equals(LIGHTBISHOP) || pieceMap.get(northEast).equals(LIGHTKING) || pieceMap.get(northEast).equals(LIGHTQUEEN) )
					{
						tempList.add(northEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northEast = getNorthEast(northEast);
			}
			
			//reset collision
			collision = false;
			
			//NORTHWEST_EXTENDED
			String northWest = getNorthWest(start);
			while(!collision && isValidSpace(northWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northWest) == null)
					{
						//add this to the valid moves
						tempList.add(northWest);	
					}
					else if(pieceMap.get(northWest).equals(LIGHTPAWN) || pieceMap.get(northWest).equals(LIGHTROOK) || pieceMap.get(northWest).equals(LIGHTKNIGHT) || pieceMap.get(northWest).equals(LIGHTBISHOP) || pieceMap.get(northWest).equals(LIGHTKING) || pieceMap.get(northWest).equals(LIGHTQUEEN) )
					{
						tempList.add(northWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northWest = getNorthWest(northWest);
			}

			
			//reset collision
			collision = false;
			
			//SOUTHEAST_EXTENDED
			String southEast = getSouthEast(start);
			while(!collision && isValidSpace(southEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southEast) == null)
					{
						//add this to the valid moves
						tempList.add(southEast);	
					}
					//enemy in square?
					else if(pieceMap.get(southEast).equals(LIGHTPAWN) || pieceMap.get(southEast).equals(LIGHTROOK) || pieceMap.get(southEast).equals(LIGHTKNIGHT) || pieceMap.get(southEast).equals(LIGHTBISHOP) || pieceMap.get(southEast).equals(LIGHTKING) || pieceMap.get(southEast).equals(LIGHTQUEEN) )
					{
						tempList.add(southEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southEast = getSouthEast(southEast);
			}
			
			//reset collision
			collision = false;
			
			//SOUTHWEST_EXTENDED
			String southWest = getSouthWest(start);
			while(!collision && isValidSpace(southWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southWest) == null)
					{
						//add this to the valid moves
						tempList.add(southWest);	
					}
					//enemy in square?
					else if(pieceMap.get(southWest).equals(LIGHTPAWN) || pieceMap.get(southWest).equals(LIGHTROOK) || pieceMap.get(southWest).equals(LIGHTKNIGHT) || pieceMap.get(southWest).equals(LIGHTBISHOP) || pieceMap.get(southWest).equals(LIGHTKING) || pieceMap.get(southWest).equals(LIGHTQUEEN) )
					{
						tempList.add(southWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southWest = getSouthWest(southWest);
			}
			return tempList;
		}
	}
	, DARKROOK("rd.png", false, 5)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
		
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			boolean collision = false;
			
			//NORTH_EXTENDED
			String north = getNorth(start);
			while(!collision && isValidSpace(north))
			{
			
					//is it an unoccupied square?
					if(pieceMap.get(north) == null)
					{
						//add this to the valid moves
						tempList.add(north);	
					}
					else if(pieceMap.get(north).equals(LIGHTPAWN) || pieceMap.get(north).equals(LIGHTROOK) || pieceMap.get(north).equals(LIGHTKNIGHT) || pieceMap.get(north).equals(LIGHTBISHOP) || pieceMap.get(north).equals(LIGHTKING) || pieceMap.get(north).equals(LIGHTQUEEN) )
					{
						tempList.add(north);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					north = getNorth(north);
			}
			
			//reset collision
			collision = false;
			
			//SOUTH_EXTENDED
			String south = getSouth(start);
			while(!collision && isValidSpace(south))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(south) == null)
					{
						//add this to the valid moves
						tempList.add(south);	
					}
					else if(pieceMap.get(south).equals(LIGHTPAWN) || pieceMap.get(south).equals(LIGHTROOK) || pieceMap.get(south).equals(LIGHTKNIGHT) || pieceMap.get(south).equals(LIGHTBISHOP) || pieceMap.get(south).equals(LIGHTKING) || pieceMap.get(south).equals(LIGHTQUEEN) )
					{
						tempList.add(south);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
					south = getSouth(south);
			}
			
			//reset collision
			collision = false;
			
			//WEST_EXTENDED
			String west = getWest(start);
			while(!collision && isValidSpace(west))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(west) == null)
					{
						//add this to the valid moves
						tempList.add(west);	
					}
					else if(pieceMap.get(west).equals(LIGHTPAWN) || pieceMap.get(west).equals(LIGHTROOK) || pieceMap.get(west).equals(LIGHTKNIGHT) || pieceMap.get(west).equals(LIGHTBISHOP) || pieceMap.get(west).equals(LIGHTKING) || pieceMap.get(west).equals(LIGHTQUEEN) )
					{
						tempList.add(west);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
				    west = getWest(west);
			}
			
			//reset collision
			collision = false;
			
			//EAST_EXTENDED
			String east = getEast(start);
			while(!collision && isValidSpace(east))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(east) == null)
					{
						//add this to the valid moves
						tempList.add(east);	
					}
					else if(pieceMap.get(east).equals(LIGHTPAWN) || pieceMap.get(east).equals(LIGHTROOK) || pieceMap.get(east).equals(LIGHTKNIGHT) || pieceMap.get(east).equals(LIGHTBISHOP) || pieceMap.get(east).equals(LIGHTKING) || pieceMap.get(east).equals(LIGHTQUEEN) )
					{
						tempList.add(east);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
				
				    east = getEast(east);
			}
			return tempList;
		}
	}
	, DARKKNIGHT("nd.png",false, 3)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			
			ArrayList<String> tempList = getMoves(start, pieceMap);
			
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			
			//ONE OCLOCK
			String oneOclock = getOneOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(oneOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(oneOclock) == null)
				{
					//add this to the valid moves
					tempList.add(oneOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(oneOclock).equals(LIGHTPAWN) || pieceMap.get(oneOclock).equals(LIGHTROOK) || pieceMap.get(oneOclock).equals(LIGHTKNIGHT) || pieceMap.get(oneOclock).equals(LIGHTBISHOP) || pieceMap.get(oneOclock).equals(LIGHTKING) || pieceMap.get(oneOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(oneOclock);
					System.out.println("attack");
				}
			}
			
			//TWO OCLOCK
			String twoOclock = getTwoOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(twoOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(twoOclock) == null)
				{
					//add this to the valid moves
					tempList.add(twoOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(twoOclock).equals(LIGHTPAWN) || pieceMap.get(twoOclock).equals(LIGHTROOK) || pieceMap.get(twoOclock).equals(LIGHTKNIGHT) || pieceMap.get(twoOclock).equals(LIGHTBISHOP) || pieceMap.get(twoOclock).equals(LIGHTKING) || pieceMap.get(twoOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(twoOclock);
					System.out.println("attack");
				}
			}
			
			//FOUR OCLOCK
			String fourOclock = getFourOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(fourOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(fourOclock) == null)
				{
					//add this to the valid moves
					tempList.add(fourOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(fourOclock).equals(LIGHTPAWN) || pieceMap.get(fourOclock).equals(LIGHTROOK) || pieceMap.get(fourOclock).equals(LIGHTKNIGHT) || pieceMap.get(fourOclock).equals(LIGHTBISHOP) || pieceMap.get(fourOclock).equals(LIGHTKING) || pieceMap.get(fourOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(fourOclock);
					System.out.println("attack");
				}
			}
			
			//FIVE OCLOCK
			String fiveOclock = getFiveOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(fiveOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(fiveOclock) == null)
				{
					//add this to the valid moves
					tempList.add(fiveOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(fiveOclock).equals(LIGHTPAWN) || pieceMap.get(fiveOclock).equals(LIGHTROOK) || pieceMap.get(fiveOclock).equals(LIGHTKNIGHT) || pieceMap.get(fiveOclock).equals(LIGHTBISHOP) || pieceMap.get(fiveOclock).equals(LIGHTKING) || pieceMap.get(fiveOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(fiveOclock);
					System.out.println("attack");
				}
			}
			
			//SEVEN OCLOCK
			String sevenOclock = getSevenOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(sevenOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(sevenOclock) == null)
				{
					//add this to the valid moves
					tempList.add(sevenOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(sevenOclock).equals(LIGHTPAWN) || pieceMap.get(sevenOclock).equals(LIGHTROOK) || pieceMap.get(sevenOclock).equals(LIGHTKNIGHT) || pieceMap.get(sevenOclock).equals(LIGHTBISHOP) || pieceMap.get(sevenOclock).equals(LIGHTKING) || pieceMap.get(sevenOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(sevenOclock);
					System.out.println("attack");
				}
			}
			
			//EIGHT OCLOCK
			String eightOclock = getEightOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(eightOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(eightOclock) == null)
				{
					//add this to the valid moves
					tempList.add(eightOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(eightOclock).equals(LIGHTPAWN) || pieceMap.get(eightOclock).equals(LIGHTROOK) || pieceMap.get(eightOclock).equals(LIGHTKNIGHT) || pieceMap.get(eightOclock).equals(LIGHTBISHOP) || pieceMap.get(eightOclock).equals(LIGHTKING) || pieceMap.get(eightOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(eightOclock);
					System.out.println("attack");
				}
			}
			
			//TEN OCLOCK
			String tenOclock = getTenOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(tenOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(tenOclock) == null)
				{
					//add this to the valid moves
					tempList.add(tenOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(tenOclock).equals(LIGHTPAWN) || pieceMap.get(tenOclock).equals(LIGHTROOK) || pieceMap.get(tenOclock).equals(LIGHTKNIGHT) || pieceMap.get(tenOclock).equals(LIGHTBISHOP) || pieceMap.get(tenOclock).equals(LIGHTKING) || pieceMap.get(tenOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(tenOclock);
					System.out.println("attack");
				}
			}
			
			//ELEVEN OCLOCK
			String elevenOclock = getElevenOclock(start);
	
			//is it a square on the board?
			if(isValidSpace(elevenOclock))
			{
				//is it an unoccupied square?
				if(pieceMap.get(elevenOclock) == null)
				{
					//add this to the valid moves
					tempList.add(elevenOclock);	
				}
				//is it an enemy piece?
				else if(pieceMap.get(elevenOclock).equals(LIGHTPAWN) || pieceMap.get(elevenOclock).equals(LIGHTROOK) || pieceMap.get(elevenOclock).equals(LIGHTKNIGHT) || pieceMap.get(elevenOclock).equals(LIGHTBISHOP) || pieceMap.get(elevenOclock).equals(LIGHTKING) || pieceMap.get(elevenOclock).equals(LIGHTQUEEN) )
				{
					tempList.add(elevenOclock);
					System.out.println("attack");
				}
			}
			return tempList;
		}
	}
	, DARKBISHOP("bd.png",false, 3)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			
			ArrayList<String> tempList = getMoves(start, pieceMap);
			
			removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			
			return tempList;
		}

		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			
			boolean collision = false;
			
			//NORTHEAST_EXTENDED
			String northEast = getNorthEast(start);
			while(!collision && isValidSpace(northEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northEast) == null)
					{
						//add this to the valid moves
						tempList.add(northEast);	
					}
					else if(pieceMap.get(northEast).equals(LIGHTPAWN) || pieceMap.get(northEast).equals(LIGHTROOK) || pieceMap.get(northEast).equals(LIGHTKNIGHT) || pieceMap.get(northEast).equals(LIGHTBISHOP) || pieceMap.get(northEast).equals(LIGHTKING) || pieceMap.get(northEast).equals(LIGHTQUEEN) )
					{
						tempList.add(northEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northEast = getNorthEast(northEast);
			}
			
			//reset collision
			collision = false;
			
			//NORTHWEST_EXTENDED
			String northWest = getNorthWest(start);
			while(!collision && isValidSpace(northWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(northWest) == null)
					{
						//add this to the valid moves
						tempList.add(northWest);	
					}
					else if(pieceMap.get(northWest).equals(LIGHTPAWN) || pieceMap.get(northWest).equals(LIGHTROOK) || pieceMap.get(northWest).equals(LIGHTKNIGHT) || pieceMap.get(northWest).equals(LIGHTBISHOP) || pieceMap.get(northWest).equals(LIGHTKING) || pieceMap.get(northWest).equals(LIGHTQUEEN) )
					{
						tempList.add(northWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space NE
				    northWest = getNorthWest(northWest);
			}

			
			//reset collision
			collision = false;
			
			//SOUTHEAST_EXTENDED
			String southEast = getSouthEast(start);
			while(!collision && isValidSpace(southEast))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southEast) == null)
					{
						//add this to the valid moves
						tempList.add(southEast);	
					}
					//enemy in square?
					else if(pieceMap.get(southEast).equals(LIGHTPAWN) || pieceMap.get(southEast).equals(LIGHTROOK) || pieceMap.get(southEast).equals(LIGHTKNIGHT) || pieceMap.get(southEast).equals(LIGHTBISHOP) || pieceMap.get(southEast).equals(LIGHTKING) || pieceMap.get(southEast).equals(LIGHTQUEEN) )
					{
						tempList.add(southEast);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southEast = getSouthEast(southEast);
			}
			
			//reset collision
			collision = false;
			
			//SOUTHWEST_EXTENDED
			String southWest = getSouthWest(start);
			while(!collision && isValidSpace(southWest))
			{
					
					//is it an unoccupied square?
					if(pieceMap.get(southWest) == null)
					{
						//add this to the valid moves
						tempList.add(southWest);	
					}
					//enemy in square?
					else if(pieceMap.get(southWest).equals(LIGHTPAWN) || pieceMap.get(southWest).equals(LIGHTROOK) || pieceMap.get(southWest).equals(LIGHTKNIGHT) || pieceMap.get(southWest).equals(LIGHTBISHOP) || pieceMap.get(southWest).equals(LIGHTKING) || pieceMap.get(southWest).equals(LIGHTQUEEN) )
					{
						tempList.add(southWest);
						System.out.println("attack");
						collision = true;
					}
					else
					{
						//hit my own piece
						collision = true;
					}
					//increment one space SE
				    southWest = getSouthWest(southWest);
			}
			return tempList;
		}
	}
	, DARKPAWN("pd.png", false, 1)
	{
		@Override
		public ArrayList getValidMoves(String start, HashMap pieceMap)
		{
			ArrayList<String> tempList = getMoves(start, pieceMap);
			if(!checking)
			{
				removeMovesThatPutKingInCheck(start, tempList, pieceMap);
			}
			return tempList;
		}

		@Override
		public ArrayList<String> getMoves(String start, HashMap pieceMap) {
			ArrayList<String> tempList = new ArrayList();
			
			//**SOUTH** pawn cannot attack straight move
			String south = getSouth(start);
			//is it a square on the board?
			if(isValidSpace(south))
			{
				//is it an unoccupied square?
				if(pieceMap.get(south) == null)
				{
					//add this to the valid moves
					tempList.add(south);	
				}	
			}
			//get one space south of the current south (2 space first pawn move)
			south = getSouth(south);
			
			//validate second square for first pawn move- all dark pawns start on row 7
			if(isValidSpace(south) && start.charAt(1) == '7')
			{
				//is it an unoccupied square?
				if(pieceMap.get(south) == null && pieceMap.get(getNorth(south)) == null)
				{
					//add this to the valid moves
					tempList.add(south);
				}
			}
			
			
			//**south_WEST**
			String southwest = getSouthWest(start);
			if(isValidSpace(southwest))
			{
				//is it an unoccupied square?
				if(pieceMap.get(southwest) == null)
				{
					// don't add this to the valid moves
					//tempList.add(southwest);
					
				}
				//is it an enemy piece? 
				else if(pieceMap.get(southwest).equals(LIGHTPAWN) || pieceMap.get(southwest).equals(LIGHTROOK) || pieceMap.get(southwest).equals(LIGHTKNIGHT) || pieceMap.get(southwest).equals(LIGHTBISHOP) || pieceMap.get(southwest).equals(LIGHTKING) || pieceMap.get(southwest).equals(LIGHTQUEEN) )
				{
					tempList.add(southwest);
					System.out.println("attack");
				}
			}
			
			//**SOUTH_EAST**
			String southeast = getSouthEast(start);
			if(isValidSpace(southeast))
			{
				//is it an unoccupied square?
				if(pieceMap.get(southeast) == null)
				{
					//don't add this to the valid moves
					//tempList.add(southeast);
					
				}
				//is it an enemy piece? 
				else if(pieceMap.get(southeast).equals(LIGHTPAWN) || pieceMap.get(southeast).equals(LIGHTROOK) || pieceMap.get(southeast).equals(LIGHTKNIGHT) || pieceMap.get(southeast).equals(LIGHTBISHOP) || pieceMap.get(southeast).equals(LIGHTKING) || pieceMap.get(southeast).equals(LIGHTQUEEN) )
				{
					tempList.add(southeast);
					System.out.println("attack");
				}
			}
	
		/*	temp.add("SOUTH_WEST");
			temp.add("SOUTH_EAST");
			temp.add("SOUTH");
			temp.add("SOUTH_EXTENDED");*/
			return tempList;
		}
	};
	
	
	
	protected ImageIcon image;
	protected boolean isLight;
	protected boolean checking;
	protected int pieceValue;

	private final int TWO_SPACES = 2;

	
   /********************
    *  Constructor(s)  *
    ********************/ 
	private Piece(String imagetext, boolean isLight, int pieceValue)
	{
		image = new ImageIcon(imagetext);
		this.isLight = isLight;
		this.pieceValue = pieceValue;
	}
	
	
	
	public abstract ArrayList<String> getMoves(String start, HashMap pieceMap);


	/***************************
	 *    MOVEMENT Methods     *
	 ***************************/
	
	//Split string and increment/decrement the row/column for direction desired
	
	public String getNorth(String start)
	{
		
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return column + "" + (char)(row+1);
		
	
	}
	
	public String getNorthWest(String start)
	{
		
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return (char)(column-1) + "" + (char)(row+1);
		
	}
	
	public String getNorthEast(String start)
	{
		
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return (char)(column+1) + "" + (char)(row+1);
		
	}
	
	public String getSouth(String start)
	{
		
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return column + "" + (char)(row-1);
		
	}
	
	public String getSouthWest(String start)
	{
		
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return (char)(column-1) + "" + (char)(row-1);
		
	}
	
	public String getSouthEast(String start)
	{
		
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return (char)(column+1) + "" + (char)(row-1);
		
	}
	
	public String getEast(String start)
	{
		
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return (char)(column+1) + "" + row;
		
	}
	
	public String getWest(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		return (char)(column-1) + "" + row;
		
	}
	//Used for KNIGHT movement
	public String getOneOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column+1) + "" + (char)(row + TWO_SPACES);
		
	}
	//Used for KNIGHT movement
	public String getTwoOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column + TWO_SPACES) + "" + (char)(row+1);
		
	}
	//Used for KNIGHT movement
	public String getFourOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column + TWO_SPACES) + "" + (char)(row - 1);
		
	}
	//Used for KNIGHT movement
	public String getFiveOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column + 1) + "" + (char)(row - TWO_SPACES);
		
	}
	//Used for KNIGHT movement
	public String getSevenOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column - 1) + "" + (char)(row - TWO_SPACES);
		
	}
	//Used for KNIGHT movement
	public String getEightOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column - TWO_SPACES) + "" + (char)(row - 1);
		
	}
	//Used for KNIGHT movement
	public String getTenOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column - TWO_SPACES) + "" + (char)(row +1);
		
	}
	//Used for KNIGHT movement
	public String getElevenOclock(String start)
	{
		char column  = start.charAt(0);
		char row = start.charAt(1);
		
		return (char)(column - 1) + "" + (char)(row + TWO_SPACES);
		
	}
	
	
	/*************************
	 *     Other Methods     *
	 *************************/

	//check to see if I'm putting my KING in check
	public ArrayList<String> removeMovesThatPutKingInCheck(String start, ArrayList<String> uncheckedMoves, HashMap<String, Piece> pieceMap)
	{
		checking = true;
		boolean movingLight = pieceMap.get(start).isLight;
		StringBuilder strings = new StringBuilder();
		//--boolean lightPiece = ((Piece)pieceMap.get(start)).isLight();

		//for every move of my piece
		for(int i = 0; i < uncheckedMoves.size(); i++)
		{
			String prospectiveMove = uncheckedMoves.get(i);

			//clone the 'pieceMap' (the pieces in play)
			HashMap<String, Piece> cloneMap = (HashMap)pieceMap.clone();

			//make the move
			//get the piece, move it into the current ArrayList element's square, get rid of 1st position piece
			cloneMap.put(prospectiveMove, cloneMap.get(start));
			cloneMap.remove(start);

			//make sure that no pieces from other team can get my KING now.
			//iterate through the other color's pieces, checking all their moves for hitting my KING

			
			//for each piece in the cloned map
			boolean kingIsInCheck = inCheck(movingLight, cloneMap);	
			if(kingIsInCheck)
			{
				uncheckedMoves.remove(prospectiveMove);
				i--;
			}
		}

		//return the cleaned up moves list
		checking = false;
		return uncheckedMoves;
	}
	
	
	//determines if in checkmate
	public static boolean inCheckMate(boolean isLight, HashMap<String, Piece> map)
	{
		//is my king in check?
		boolean amIInCheckMate = inCheck(isLight, map);

		//do any of my pieces have a valid move?
		Set<String> keySet = map.keySet();
		String[] keys = keySet.toArray(new String[keySet.size()]);
		for (int i = 0; i < keys.length && amIInCheckMate; i++) 
		{
			String key = keys[i];
			//check each of my pieces
			if(((Piece)map.get(key)).isLight() == isLight)
			{
				
				//if there are no valid moves
				if(!map.get(key).getValidMoves(key, map).isEmpty())
				{
					amIInCheckMate = false;
				}
			}
		}
		return amIInCheckMate;
	}

	
	public static boolean inCheck(boolean isLight, HashMap<String, Piece> map) 
	{
		HashSet<String> temp = new HashSet<String>();
		boolean kingIsInCheck = false;
		for (String key : map.keySet()) 
		{
			
			// check the color of each cloned piece, we only want to check the opposite color 
			if(((Piece)map.get(key)).isLight() != isLight)
			{
				//get the valid moves for the piece
						
				temp.addAll(((Piece)map.get(key)).getMoves(key, map));
				//System.out.println("temp size" + temp.size());
				if(temp.size()!= 0)
				{
				//System.out.println("Temp: " + temp.toArray()[0].toString());
				//System.out.println("CloneMap: " + map.get("c6"));
				}
				for(String oppositeMoves : temp)
				{
					//is the opposite king in this move?  
					if(map.get(oppositeMoves) != null)
					{
						if(map.get(oppositeMoves).equals(LIGHTKING) &&  isLight)
						{
							kingIsInCheck = true;	
						}
						if(map.get(oppositeMoves).equals(DARKKING) && !isLight)
						{
							kingIsInCheck = true;
						}
						
					}
				}
			}
		}
		return kingIsInCheck;
	}
	

	// grabs a piece by matching its image name
	public static Piece getPieceByName(String name)
	{
		Piece returnPiece = null;
		for(Piece p : Piece.values())
		{
			String[] pieceName = p.image.toString().split("\\.");
			if(pieceName[0].equals(name))
			{
				returnPiece = p;
			}
		}
		return returnPiece;
	}
	
	// makes sure the location generated is a valid board location
	public boolean isValidSpace(String string)
	{
		boolean temp;
		if(string.charAt(0) <= 'h' && string.charAt(0) >= 'a' && string.charAt(1) <= '8' && string.charAt(1) >= '1')
		{
			temp = true;
		}
		else
		{
			temp = false;
		}
		return temp;
	}
	
	//gets the image of the piece
	public ImageIcon getImage()
	{
		 return this.image;
	}

	
	//gets the color of the piece
	public boolean isLight()
	{
		return isLight;
	}
	
	public int getPieceValue()
	{
		return pieceValue;
	}
	
	public ArrayList getValidMoves(String start, HashMap pieceMap)
	{
		ArrayList<String> validMoves = new ArrayList();
			
		return validMoves;	
	}
}
