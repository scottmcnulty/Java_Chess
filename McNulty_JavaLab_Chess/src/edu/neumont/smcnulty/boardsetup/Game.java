package edu.neumont.smcnulty.boardsetup;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Game extends MouseAdapter
{
	private BoardViewer boardViewer;
	private BoardModel model;
	private BoardLoader loader;
	private AI chester;
	
	private Square selection;
	private boolean lightTurn;
	
	private final int ROWS = 8;
	private final int BOARD_DESTINATION = 2;
	
	// border for highlighting the valid moves of a piece
	Border thickBorder = new LineBorder(Color.GREEN, 12);
	
	//border for highlighting a KING in check
	Border checkBorder = new LineBorder(Color.RED, 12);
	
	
	public Game()
	{
		// loader object, uses regex to parse strings for moves
		loader = new BoardLoader();
		
		// the boardviewer contains the squareMap, a hashMap containing all the squares of the board (JButtons), used to display the chess iconImages of the pieces
		boardViewer = new BoardViewer();
		
		// the model contains the pieceMap, a hashMap of all of the actual pieces
		model = new BoardModel();
		
		chester = new AI();

		//add mouselistener to each square
		for(char c = 'a'; c < 'i' ; c++)
		{
			for(int j = ROWS; j > 0; j--)
			{
				//gets the square at <location> and adds an actionlistener to it
				boardViewer.getSquareMap().get( c + "" + j).addMouseListener(this);
			}
		}
		
		//initial state, light goes first
		lightTurn = true;
		
		//begin game
		gameFlow();
	}


	
	public void mousePressed(MouseEvent e)
	{
		
		/*********************************************************************************
		 *   Along with the instance variable "selection", the click2 variable stores a  *
		 *   square that was clicked.  This method determines if it is a first or second *
		 *   click, and performs the correct operation (move, select square,             *
		 *   clear squares).                                                             *
		 *********************************************************************************/
		
		
		Square click2 = (Square)e.getSource();
		System.out.println(click2.getLoc());

		//no previous selection- show the possible moves, check for piece there, and check if it is that color's turn
		if(selection == null && click2.getIcon() != null && model.getPiece(click2.getLoc()).isLight() == lightTurn)
		{
			selection = click2;

			//put valid moves in an arrayList and highlight them (get piece,get its valid moves passing the location and the pieceMap)
			ArrayList<String> validMoves = model.getPiece(selection.getLoc()).getValidMoves(selection.getLoc(), model.getPieceMap());
			for(String s : validMoves)
			{
				System.out.println(s.toString());
				boardViewer.getSquare(s).setBorder(thickBorder);
			}
		}
				
		// there is a selection, and it is in the valid moves of the first, make the move
		else if(selection != null)
		{
			
				// get the piece in the square, get the valid moves for it from the pieceMap
				ArrayList<String> validMoves = model.getPiece(selection.getLoc()).getValidMoves(selection.getLoc(), model.getPieceMap());
				
				//if the second click is in the set of valid moves 
				if(validMoves.contains(click2.getLoc()))
				{
					//make the move,
					//if there is an opposite color in the spot it will be in the valid moves list, it is an attack, will remove the current piece
					if(model.getPiece(click2.getLoc()) != null)
					{
						//piece killed (removed and image set to null)
						model.removePiece(click2.getLoc());
						boardViewer.getSquareMap().get(click2.getLoc()).setIcon(null);
					}

					//update pieceMap, put piece in new spot, delete it from the old spot
					model.setPiece(click2.getLoc(), model.getPiece(selection.getLoc()));
					model.removePiece(selection.getLoc());

					//get the destination square, get the piece, get the image of the piece, set the square to the image  (update squareMap)
					boardViewer.getSquareMap().get(click2.getLoc()).setIcon(model.getPiece(click2.getLoc()).getImage());

					//get the start square, set the square to empty (null, no image, update squareMap)
					boardViewer.getSquareMap().get(selection.getLoc()).setIcon(null);
				
					//erase borders
					for(String s : validMoves)
					{
						System.out.println(s.toString());
						boardViewer.getSquare(s).setBorder(null);
					}
					
					//reset selection for next move
					selection = null;
					
					//swap player turn, only doing this when a valid move has been completed
					lightTurn = !lightTurn;
					
					chester.performTurn(model.getPieceMap());
					
					if(Piece.inCheck(lightTurn, model.getPieceMap()))
					{
						if(Piece.inCheckMate(lightTurn, model.getPieceMap()))
						{
							//make a dialog box to tell check
							JOptionPane.showMessageDialog(null, "You are in CheckMate!!!  ");
						}
						else
						{
							//make a dialog box to tell check
							JOptionPane.showMessageDialog(null, "You are in Check!!!");
						}
					}
					
					
					
					
				}
				
				// if there is a piece of the same color in this square, then make this the first click
				else if(click2.getIcon() != null && model.getPiece(click2.getLoc()).isLight() == lightTurn)
				{
					selection = click2;
					
					//display moves
					for(String s : validMoves)
					{
						System.out.println(s.toString());
						boardViewer.getSquare(s).setBorder(null);
					}
					
					//highlight available moves
					validMoves = model.getPiece(selection.getLoc()).getValidMoves(selection.getLoc(), model.getPieceMap());
					for(String s : validMoves)
					{
						System.out.println(s.toString());
						boardViewer.getSquare(s).setBorder(thickBorder);
					}
				}
				
				//reset everything, a square has been clicked that is not my own piece or not a move
				else 
				{
					for(String s : validMoves)
					{
						System.out.println(s.toString());
						boardViewer.getSquare(s).setBorder(null);
					}
					selection = null;
				}
			}
		}


	
	//sets up the initial board and pieces
	public void setPieces()
	{
		//return a list of the 
		ArrayList<String> list = loader.processFile("ChessLoadStart.txt");

		for(String s : list)
		{
			//example string - "PLACE,pd,f7"
			String[] temp = s.split(",");

			// set a piece on the board (in the hashmap) using location(temp[BOARD_DESTINATION]) and a Piece(get from piece enum)
			model.setPiece(temp[BOARD_DESTINATION], Piece.getPieceByName(temp[1]));

			//check to make sure it is in the hashmap
			System.out.println("piece put in hashmap- " + temp[1] + " in " + temp[BOARD_DESTINATION]);
			System.out.println(model.getPiece(temp[BOARD_DESTINATION]).toString());

			//get the square, get the piece, get the image of the piece, set the square to the image
			boardViewer.getSquareMap().get(temp[BOARD_DESTINATION]).setIcon(model.getPiece(temp[BOARD_DESTINATION]).getImage());
		}		
	}

	
	// reads a file and moves the pieces in it accordingly
	public void runMovesFile()
	{
		ArrayList<String> list = loader.processFile("ChessMovementTest.txt");

		//Player swapping 
		boolean currentTurnIsLight = true;
		
		//go through the arraylist of moves and execute
		for(String s : list)
		{

			try {
				Thread.sleep(2000);
				} 
			catch(InterruptedException e) 
			{
				System.out.println("Sleep statement error");
			} 
			
			//example string - "MOVE,g7,g6"
			String[] temp = s.split(",");

			//get the valid moves for the piece in the square selected
			if(model.getPiece(temp[1]) != null)
			{

				if(model.getPiece(temp[1]).isLight() == currentTurnIsLight)
				{
					//using the piece in temp[1], get the valid moves for it
					ArrayList<String> validMoves = model.getPiece(temp[1]).getValidMoves(temp[1], model.getPieceMap());

					//if validMoves has the scripted move in it, make the move (checks are in the piece itself)
					if(validMoves.contains(temp[BOARD_DESTINATION]))
					{
						//if there is an opposite color in the spot it will be in the valid moves list, ATTACKMOVE, will remove the current piece
						if(model.getPiece(temp[BOARD_DESTINATION]) != null)
						{
							//piece killed
							model.removePiece(temp[BOARD_DESTINATION]);
							boardViewer.getSquareMap().get(temp[BOARD_DESTINATION]).setIcon(null);
						}

						//update pieceMap
						model.setPiece(temp[BOARD_DESTINATION], model.getPiece(temp[1]));
						model.removePiece(temp[1]);

						
						//update squareMap
						//get the destination square, get the piece, get the image of the piece, set the square to the image  
						boardViewer.getSquareMap().get(temp[BOARD_DESTINATION]).setIcon(model.getPiece(temp[BOARD_DESTINATION]).getImage());

						//get the start square, set the square to empty (null, no image)
						boardViewer.getSquareMap().get(temp[1]).setIcon(null);
						
					}
					else
					{
						System.out.println("Not valid move.");
					}
					currentTurnIsLight = !currentTurnIsLight;
					System.out.println("currentTurnIsLight is " + currentTurnIsLight);
				}
				else
				{
					System.out.println("Out of turn.");
				}
			}
			else
			{
				System.out.println("Error, that square does not contain a piece!");
			}
		}		
	}



	public void gameFlow()
	{
		//set up board, pieces
		setPieces();

		//enable this to show off moves from a text file
		//runMovesFile();

		
        /* FIRST DRAFT GAME LOGIC
		//set white to start - turn assignment

		/*do
		{
			do{

			    get a move from the player
			    if move is surrender, then return
			    get piece making move
			    highlight possible moves

			}while (piece == null)

			make the move
			print the board
			update the images
			swap player

		 */
	}

}


