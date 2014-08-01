package edu.neumont.smcnulty.fileio;

/*********************************
 ********************************* 
 **       Scott McNulty         **
 **     Neumont University      **
 **     Spring Quarter 2012     **
 **         CSC230 Java         **
 **  Project Module - FileIO    **
 *********************************
 *********************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileIOModule 
{

	/************************
	 *  Instance Variables  *
	 ************************/
	private Scanner fileScan;
	private String theString;
	private String fileName;
	
	/********************
	 *  Constructor(s)  *
	 ********************/  
	public FileIOModule(String fileName)
	{
		theString = "";
		this.fileName = fileName;
		processFile();
	}

	/*************************
	 *     Other Methods     *
	 *************************/
	/*
	 *  Read in file line by line and evaluate
	 */
	public void processFile()
	{
		try
		{
			fileScan = new Scanner(new File(fileName));
			while(fileScan.hasNextLine())
			{	
				//use scanner to read in a file, make a string
				theString = fileScan.nextLine();
				
				//evaluate the string;
				printResults(theString);	
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
	}

	/*
	 *  Match and print out results
	 */
	/***********************************************
	 * Regex has to catch 4 types of commands:
	 *
	 * QLA1              Queen Light to A1
	 * D8 H4             unit at D8 move to H4
	 * F5 C5*            unit at F5 move to C5 and attack
	 * E1 G1 H1 F1       castling move
	 ************************************************/
	public void printResults(String text)
	{
		
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

		else if(identifyMatcher.matches())
		{
			System.out.println("IDENTIFICATION:");
			System.out.println("Piece " + identifyMatcher.group("pieceType") + " at position " + identifyMatcher.group("location1"));
		}

		else if(moveAndAttackMatcher.matches())
		{
			System.out.println("MOVE AND ATTACK:");
			System.out.println("Piece located in " + moveAndAttackMatcher.group("location1") +  " moves to " + moveAndAttackMatcher.group("location2") + " and ATTACK!!!!");
		}

		else if(regularMoveMatcher.matches())
		{
			System.out.println("REGULAR MOVE:");
			System.out.println("Piece located in " + regularMoveMatcher.group("location1") +  " moves to " + regularMoveMatcher.group("location2"));
		}
		else
		{
			System.out.println("INVALID DATA:");
			System.out.println(textToSearch);
		}
	}
}