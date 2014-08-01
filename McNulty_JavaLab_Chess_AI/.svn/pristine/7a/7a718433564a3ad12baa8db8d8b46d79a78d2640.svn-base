package edu.neumont.smcnulty.boardsetup;

/*********************************
 ********************************* 
 **       Scott McNulty         **
 **     Neumont University      **
 **     Spring Quarter 2012     **
 **         PRO180 Java         **
 **        Board Module         **
 *********************************
 *********************************/

import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;


/*  This class has a HashMap of all the squares on the board
 * 		the key for the squares is the address, ie <a6>
 * 
 */


public class BoardViewer 
{

	/************************
	 *  Instance Variables  *
	 ************************/
	private JFrame frame;
	private final int APPLICATION_SIZE_WIDTH = 1000;
	private final int APPLICATION_SIZE_HEIGHT = 1000;
	private boolean colorShifter;
	private HashMap<String, Square> squareMap;
	
	private final int EIGHT = 8;
	
	//protected Square[][] squareArray;
	
	/********************
	 *  Constructor(s)  *
	 ********************/ 
	public BoardViewer()
	{
		frame = new JFrame("Scott's Chess");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(APPLICATION_SIZE_WIDTH, APPLICATION_SIZE_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridLayout(EIGHT,EIGHT));
		
		squareMap = new HashMap();
		
		colorShifter = false;
		makePanels();
	
		frame.setVisible(true);
	}
	
	
	/*************************
	 *    Getters/Setters    *
	 *************************/
	
	public HashMap<String, Square> getSquareMap()
	{
		return squareMap;
		
	}
	
	public Square getSquare(String location)
	{
		return squareMap.get(location);
	}
	
	
	/*************************
	 *     Other Methods     *
	 *************************/
	
	public void makePanels()
	{
																													
		for(int j = EIGHT; j > 0; j--)
		{
			
			colorShifter = !colorShifter;
			for(char c = 'a'; c < 'i' ; c++)
			{
				
				//iterate through, making the 64 squares with their locations
				Square temp = new Square(c, j);
				squareMap.put( c + "" + j, temp );
				addPanels(temp);
				System.out.println(temp.toString());
			}
																													
		}		
	
	}
	
	public void drawPiece()
	{
	
	}
	
	public void addPanels(Square panel)
	{
		if(colorShifter)
		{
			panel.setBackground(Color.gray);
			colorShifter = false;
		}
		else
		{
			panel.setBackground(Color.lightGray);
			colorShifter = true;
		}
		
		
		frame.add(panel);
		panel.setVisible(true);
	}
	
	
	/************************
	 *  To String OVERRIDE  *
	 ************************/
	
	
}
