package edu.neumont.smcnulty.boardsetup;

/*********************************
 ********************************* 
 **       Scott McNulty         **
 **     Neumont University      **
 **     Spring Quarter 2012     **
 **         CSC230 Java         **
 **     Java Chess Project      **
 *********************************
 *********************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoardLoader 
{

	/************************
	 *  Instance Variables  *
	 ************************/
	private Scanner fileScan;
	private String theString;
	
	
	
	/********************
	 *  Constructor(s)  *
	 ********************/  
	public BoardLoader()
	{
		theString = "";
	}

	/*************************
	 *     Other Methods     *
	 *************************/
	/*
	 *  Read in file line by line and evaluate
	 */
	public ArrayList<String> processFile(String fileName)
	{
		ArrayList<String> list = new ArrayList();
		try
		{
			
			
			fileScan = new Scanner(new File(fileName));
			while(fileScan.hasNextLine())
			{	
				//use scanner to read in a file, make a string
				theString = fileScan.nextLine();
				
				//evaluate the string;
				String temp = printResults(theString);
				if(!temp.isEmpty())
				{
					list.add(temp);
				}
					
			}

			fileScan.close();
		}

		catch (FileNotFoundException e) 
		{
			System.out.println("File not found!  Terminating.");
		}

		catch(Exception e)
		{
			System.out.println("General Exception thrown!!!!!");
			e.printStackTrace();
		}
		return list;
	}

	/*
	 *  Match and print out results
	 */
	/*************************************************
	 * This Regex has to catch 4 types of commands:
	 *
	 * qla1              Queen Light place in A1
	 * d8 h4             unit at D8 move to H4
	 * f5 c5*            unit at F5 move to C5 and attack
	 * e1 g1 h1 f1       castling move
	 ************************************************/
	public static String printResults(String text)
	{
		
		String usable = "";
		
		//specify regex rules
		String identify = "(?i)(?<pieceType>[rnbkqp][ld])(?<location1>[a-h][1-8])";
		String regularMove = "(?i)(?<location1>[a-h][1-8]) (?<location2>[a-h][1-8])";
		String moveAndAttack = "(?i)(?<location1>[a-h][1-8]) (?<location2>[a-h][1-8])\\*";
		String castleMove = "(?i)(?<location1>[a-h][1-8]) (?<location2>[a-h][1-8]) (?<location3>[a-h][1-8]) (?<location4>[a-h][1-8])";

		//use string passed in 
		String textToSearch = text;

		//make pattern matchers using the regex string rules
		Matcher identifyMatcher = Pattern.compile(identify).matcher(textToSearch);
		Matcher regularMoveMatcher = Pattern.compile(regularMove).matcher(textToSearch);
		Matcher moveAndAttackMatcher = Pattern.compile(moveAndAttack).matcher(textToSearch);
		Matcher castleMoveMatcher = Pattern.compile(castleMove).matcher(textToSearch);

		if(castleMoveMatcher.matches())
		{
			System.out.println("CASTLE MOVE:");
			System.out.println("King in " + castleMoveMatcher.group("location1") + " moves to location " + castleMoveMatcher.group("location2") + " and Rook in " + castleMoveMatcher.group("location3") + " moves to location " + castleMoveMatcher.group("location4"));
		}

		else if(identifyMatcher.matches()) // sends string, comma delimited,       PLACE,pd,f7  example
		{
			
			usable = "PLACE," + identifyMatcher.group("pieceType") + "," + identifyMatcher.group("location1");
		}

		else if(moveAndAttackMatcher.matches())  // sends string, comma delimited,   like  MOVEANDATTACK,a7,a6
		{
			usable = "MOVEANDATTACK," + moveAndAttackMatcher.group("location1") + "," + moveAndAttackMatcher.group("location2");
		}

		else if(regularMoveMatcher.matches())   ///sends string, comma delimited,   like  MOVE,a7,a6
		{
			usable = "MOVE," + regularMoveMatcher.group("location1") + "," + regularMoveMatcher.group("location2");
			//System.out.println("move");
		}
		else
		{
			System.out.println("INVALID DATA:");
			System.out.println(textToSearch);
		}
		
		return usable;
	}
}