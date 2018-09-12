/**Final Project Srinivas, Aishwarya.java
 * Description:      This program allows the user to view information about an element or a compound from a database (text file):
 *           1. ELEMENTS
 *              The user will enter the symbol of an element and they will get the name, atomic number, atomic mass and the substance type of the symbol.
 *              If the user enters an incorrect symbol, an error message will be displayed on the screen.
 *           2. COMPOUNDS
 *              The user will enter any compound they know and its symbol and molar mass will show up on the screen.
 *              Not all compounds are present on the database, therefore, the user can write their own compound and its
 *              relevant information onto the database.
 * Start: 9 December 2016
 * End: 12 January 2017
 * Author: Aishwarya Srinivas
 * Version: 1.0001
 * Course: 1CS3U-01
 **/

import java.awt.*;
import hsa.Console;
import java.io.*;
import java.awt.image.*;       //for diaplaying the image
import java.io.IOException;    //for the program to accept a text file
import java.io.FileReader;     //for reading a file
import java.io.BufferedReader; //for reading a file
import java.io.FileWriter;     //for reading a file
import java.io.BufferedWriter; //for reading a file
import java.util.Arrays;

public class SrinivasAishwarya implements ImageObserver  //interface for the image (Periodic Table)
{
    static Console c;
    public Image Pic;           //class name for displaying the image

    public static void main (String[] args) throws IOException, InterruptedException
    {
	c = new Console ();

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//VARIABLES

	String key;                //asking the user to enter 'p' for Periodic Table or 'c' for Compound List
	String symbol;             //asking the user to enter the symbol of an element
	String choice;               //asking the user to choose between looking up a compound or entering a new compound
	String name;               //asking the user to enter the name of a compound
	String nameNew;              //asking the user for the name of the unknown compound
	String symbolCompound;       //asking the user for the symbol of the unknown compound


	//For the program to read the text file: elements.txt
	String fileNameE = "elements.txt";        //name of the file
	String[] elements = new String [404];     //a String array to store tall the lines from the file
	int counterE = 0;                         //a counter for the do-while loop to store the lines

	//For the program to read the text file: compounds.txt
	String fileNameC = "compounds.txt";       //name of the file
	String[] compounds = new String [96];     //a String array to store tall the lines from the file
	int counterC = 0;                         //a counter for the do-while loop to store the lines


	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//Reading the text file to be used for the 'Elements' part of the program
	try
	{
	    FileReader fileReader = new FileReader (fileNameE);


	    BufferedReader bufferedReader = new BufferedReader (fileReader);

	    //Filling the array with all the words from the text file
	    do
	    {
		elements [counterE] = bufferedReader.readLine ();
		counterE++;
	    }
	    while (counterE < 404);

	    bufferedReader.close ();
	}
	catch (FileNotFoundException ex)        //If this file does not exist ...
	{
	    c.println ("Unable to open file '" + fileNameE + "'");
	}
	catch (IOException ex)
	{
	    c.println ("Error reading file '" + fileNameE + "'");

	}
	//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//Reading the text file to be used for the 'Compounds' part of the program
	try
	{
	    FileReader fileReader = new FileReader (fileNameC);


	    BufferedReader bufferedReader = new BufferedReader (fileReader);

	    //Filling the array with all the words from the text file
	    do
	    {
		compounds [counterC] = bufferedReader.readLine ();
		counterC++;
	    }
	    while (counterC < 96);

	    bufferedReader.close ();
	}
	catch (FileNotFoundException ex)               //If this text file does not exist...
	{
	    c.println ("Unable to open file '" + fileNameC + "'");
	}
	catch (IOException ex)
	{
	    c.println ("Error reading file '" + fileNameC + "'");

	}
	//---------------------------------------------------------------------------------------------------------------------------------------------------------------------------



	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//TITLE OR OPENING SCREEN
	Title ();

	Thread.sleep (3000);      //delay of 3 seconds

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//OPTIONS ON SECOND SCREEN
	Options ();     //method

	//Asking the user to enter a key to access the periodic table or the compound list
	c.setColor (new Color (69, 39, 39));  //maroon
	c.setFont (new Font ("Helvetica", Font.PLAIN, 20));
	c.drawString ("To access the periodic table, enter 'p'", 140, 300);
	c.drawString ("To access the list of compounds, enter 'c'", 130, 330);

	c.setFont (new Font ("Helvetica", Font.BOLD, 15));
	c.drawString ("(To quit the program or if you want to go back to)", 140, 380);       //if the user wants to quit the program, they can type 'quit'
	c.drawString ("(the options screen at any time, type 'quit')", 160, 410);
	c.setCursor (13, 40);                                //setting the position of the input cursor
	c.setTextBackgroundColor (new Color (255, 242, 248));
	key = c.readLine ();     //user's response



	//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	//IF STATEMENT
	//CHANGING SCREENS
	//ELEMENTS
	if (key.equals ("p"))      //if the user enters 'p'
	{
	    PeriodicTable ();       //displaying the question "Enter an element"

	    //Displaying image on screen
	    new SrinivasAishwarya ();     //constructor to display the periodic table

	    boolean matchElement = false;   //a boolean to check that an element has been not displayed, so that it can display the error message

	    //asking the user to enter a symbol     //asking the user
	    c.setCursor (21, 45);
	    c.setTextBackgroundColor (new Color (255, 206, 157));
	    symbol = c.readLine ();

	    //Background Colour
	    c.setColor (new Color (217, 234, 200));
	    c.fillRect (0, 0, 700, 500);

	    for (int e = 0 ; e < 1000 ; e++)
	    {
		for (int i = 0 ; i < (elements.length - 1) ; i++)
		{
		    //Background Color
		    c.setColor (new Color (217, 234, 200));
		    c.fillRect (0, 0, 700, 500);

		    if (symbol.equalsIgnoreCase ("quit"))
		    {
			break;
		    }
		    if (elements [i].equalsIgnoreCase (symbol))
		    {
			matchElement = true;      //since this part of the if statement has taken place, the boolean will become true

			//name
			c.setColor (new Color (1, 102, 65));
			c.setFont (new Font ("Helvetica", Font.PLAIN, 60));            //Name of the element
			c.drawString (elements [i + 1], 80, 100);

			//info
			c.setFont (new Font ("Helvetica", Font.PLAIN, 30));        //Information about the element
			c.drawString ("Symbol: ", 80, 160);
			c.drawString ("Atomic Number: ", 80, 210);
			c.drawString ("Atomic Mass: ", 80, 260);
			c.drawString (elements [i], 310, 160);
			c.drawString (elements [i + 2], 310, 210);
			c.drawString (elements [i + 3], 310, 260);

			//telling user to keep enetring elements
			c.setFont (new Font ("Helvetica", Font.PLAIN, 20));
			c.drawString ("Enter the symbol of another element: ", 100, 340);
			c.setCursor (20, 20);
			c.setTextBackgroundColor (new Color (217, 234, 200));
			symbol = c.readLine ();

		    }

		}
		if (symbol.equalsIgnoreCase ("quit"))        //if the user wants to go back to the home screen, they can tyoe 'quit' anytime
		{
		    break;
		}
		if (matchElement == false)       //if the boolean variable is STILL false, it will display the error message
		{
		    //Background Color
		    c.setColor (new Color (253, 231, 142));
		    c.fillRect (0, 0, 700, 500);

		    c.setColor (new Color (71, 54, 1));
		    c.setFont (new Font ("Helvetica", Font.PLAIN, 25));
		    c.drawString ("This element does not exist in the database.", 60, 150);

		    c.drawString ("Enter the symbol of another element:", 60, 200);
		    c.setCursor (12, 20);
		    c.setTextBackgroundColor (new Color (253, 231, 142));
		    symbol = c.readLine ();

		}

		matchElement = false;      //makes the boolean variable false again

		if (symbol.equalsIgnoreCase ("quit"))
		{
		    break;
		}
	    }

	    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    Thread.sleep (1000);

	    //OPTIONS ON SECOND SCREEN
	    Options ();     //method

	    //Asking the user to enter a key to access the periodic table or the compound list
	    c.setColor (new Color (69, 39, 39));  //maroon
	    c.setFont (new Font ("Helvetica", Font.PLAIN, 20));
	    c.drawString ("To access the periodic table, enter 'p'", 140, 300);
	    c.drawString ("To access the list of compounds, enter 'c'", 130, 330);

	    c.setFont (new Font ("Helvetica", Font.BOLD, 15));
	    c.drawString ("(To quit the program or if you want to go back to)", 140, 380);       //if the user wants to quit the program, they can type 'quit'
	    c.drawString ("(the options screen at any time, type 'quit')", 160, 410);
	    c.setCursor (13, 40);                                //setting the position of the input cursor
	    c.setTextBackgroundColor (new Color (255, 242, 248));
	    key = c.readLine ();     //user's response

	    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	}

	//-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//COMPOUNDS
	if (key.equals ("c"))
	{
	    CompoundScreen ();          //method to display the question: "Enter the name of the compound"
	    c.setCursor (11, 40);
	    c.setTextBackgroundColor (new Color (184, 231, 207));
	    choice = c.readLine ();     //getting the choice by the user to 1) look up a compound OR 2)enter a new compound

	    if (choice.equals ("ex"))     //string to access the first choice is 'ex'     //first choice
	    {

		//Background colour
		c.setColor (new Color (220, 185, 255));
		c.fillRect (0, 0, 700, 500);

		c.setColor (new Color (35, 0, 70));
		c.setFont (new Font ("Helvetica", Font.PLAIN, 30));
		c.drawString ("Enter the name of the compound:", 50, 100);      //asking user for the name of the compound
		c.setCursor (8, 20);
		c.setTextBackgroundColor (new Color (220, 185, 255));
		name = c.readLine ();

		boolean matchCompound = false;

		for (int o = 0 ; o < 1000 ; o++)
		{
		    for (int i2 = 0 ; i2 < (compounds.length - 1) ; i2++)
		    {
			//Background Color
			c.setColor (new Color (220, 185, 255));
			c.fillRect (0, 0, 700, 500);

			if (name.equalsIgnoreCase ("quit"))     //if the user want to go back to the options screen, they can type 'quit'
			{
			    break;
			}
			if (compounds [i2].equalsIgnoreCase (name))
			{
			    matchCompound = true;
			    //Screen
			    //Formatting for the text
			    c.setColor (new Color (35, 0, 70));
			    c.setFont (new Font ("Helvetica", Font.PLAIN, 50));              //name of compound
			    c.drawString (compounds [i2], 80, 100);

			    //Information about the compound
			    c.setFont (new Font ("Helvetica", Font.PLAIN, 30));
			    c.drawString ("Symbol: ", 80, 160);
			    c.drawString ("Molar Mass: ", 80, 210);
			    c.drawString (compounds [i2 - 1], 310, 160);
			    c.drawString ((compounds [i2 + 1]) + "   g/mol", 310, 210);

			    //Asking the user to enter again for more info.
			    c.setFont (new Font ("Helvetica", Font.PLAIN, 25));
			    c.drawString ("Enter the name of another compound:", 80, 280);
			    c.setCursor (16, 20);
			    name = c.readLine ();

			}

		    }
		    if (name.equalsIgnoreCase ("quit"))
		    {
			break;
		    }
		    if (matchCompound == false)
		    {
			//Background Color
			c.setColor (new Color (184, 231, 207));
			c.fillRect (0, 0, 700, 500);

			c.setColor (new Color (35, 0, 70));
			c.setFont (new Font ("Helvetica", Font.PLAIN, 25));
			c.drawString ("This compound does not exist in the database.", 60, 150);

			c.drawString ("Enter the symbol of another compound:", 60, 200);       //the user can keep entering the names until they click 'quit'
			c.setCursor (12, 20);
			c.setTextBackgroundColor (new Color (184, 231, 207));
			name = c.readLine ();

		    }

		    matchCompound = false;     //boolean variable becomes false again

		    if (name.equalsIgnoreCase ("quit"))
		    {
			break;
		    }
		}



	    }

	    //------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	    if (choice.equalsIgnoreCase ("cy"))
	    {
		//Background Color
		c.setColor (new Color (254, 189, 189));
		c.fillRect (0, 0, 700, 500);

		c.setColor (new Color (90, 3, 3));
		c.setFont (new Font ("Helvetica", Font.PLAIN, 25));
		c.drawString ("Enter the name of the new compound: ", 40, 130);
		c.setCursor (9, 20);
		c.setTextBackgroundColor (new Color (254, 189, 189));
		nameNew = c.readLine ();

		c.drawString ("Enter its symbol: ", 40, 240);
		c.setCursor (14, 20);
		c.setTextBackgroundColor (new Color (254, 189, 189));
		symbolCompound = c.readLine ();

		//Background Color
		c.setColor (new Color (253, 187, 187));
		c.fillRect (0, 0, 700, 500);

		c.setColor (new Color (90, 3, 3));
		c.setFont (new Font ("Helvetica", Font.PLAIN, 25));
		c.drawString ("The new compound is now in the database.", 60, 100);


		String fileName = "compounds.txt";

		try
		{

		    FileWriter fileWriter =
			new FileWriter (fileName, true);


		    BufferedWriter bufferedWriter =
			new BufferedWriter (fileWriter);


		    // bufferedWriter.newLine ();
		    // bufferedWriter.write (symbolCompound);
		    // bufferedWriter.newLine ();
		    // bufferedWriter.write (name);



		    bufferedWriter.close ();
		}
		catch (IOException ex)
		{
		    c.println (
			    "Error writing to file '"
			    + fileName + "'");
		}

		Thread.sleep (500);

	    }



	    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    Thread.sleep (1000);

	    //OPTIONS ON SECOND SCREEN
	    Options ();     //method

	    //Asking the user to enter a key to access the periodic table or the compound list
	    c.setColor (new Color (69, 39, 39));  //maroon
	    c.setFont (new Font ("Helvetica", Font.PLAIN, 20));
	    c.drawString ("To access the periodic table, enter 'p'", 140, 300);
	    c.drawString ("To access the list of compounds, enter 'c'", 130, 330);

	    c.setFont (new Font ("Helvetica", Font.BOLD, 15));
	    c.drawString ("(To quit the program or if you want to go back to)", 140, 380);       //if the user wants to quit the program, they can type 'quit'
	    c.drawString ("(the options screen at any time, type 'quit')", 160, 410);
	    c.setCursor (13, 40);                                //setting the position of the input cursor
	    c.setTextBackgroundColor (new Color (255, 242, 248));
	    key = c.readLine ();     //user's response
	    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	}

    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////METHODS/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void Title ()
    {
	////////////////////////////////////////////////////////////////////////////TITLE SCREEN
	//Background

	c.setColor (new Color (243, 238, 251));
	c.fillRect (0, 0, 800, 600);

	//title
	c.setColor (new Color (10, 20, 80));
	c.setFont (new Font ("Helvetica", Font.PLAIN, 40));
	c.drawString ("Chemistry 602", 185, 220);

	//author
	c.setFont (new Font ("Helvetica", Font.PLAIN, 18));
	c.drawString ("Aishwarya Srinivas", 235, 260);


	//////////////////////////////////////ICS3U symbols Boxes
	///////Iodine
	c.setColor (new Color (250, 241, 133));
	c.fillRect (120, 320, 80, 80);

	//Letter and Name
	c.setColor (Color.black);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 40));
	c.drawString ("I", 153, 370);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 15));
	c.drawString ("Iodine", 140, 390);

	///////Carbon
	c.setColor (new Color (242, 138, 45));
	c.fillRect (200, 320, 80, 80);

	//Letter and Name
	c.setColor (Color.black);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 40));
	c.drawString ("C", 223, 370);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 15));
	c.drawString ("Carbon", 214, 390);

	///////Sulphur
	c.setColor (new Color (72, 215, 75));
	c.fillRect (280, 320, 80, 80);

	//Letter and Name
	c.setColor (Color.black);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 40));
	c.drawString ("S", 303, 370);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 15));
	c.drawString ("Sulphur", 293, 390);

	///////3
	c.setColor (new Color (52, 159, 239));
	c.fillRect (360, 320, 80, 80);

	//Letter and Name
	c.setColor (Color.black);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 40));
	c.drawString ("4", 388, 370);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 15));
	c.drawString ("Four", 385, 390);

	///////Uranium
	c.setColor (new Color (196, 83, 162));
	c.fillRect (440, 320, 80, 80);

	//Letter and Name
	c.setColor (Color.black);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 40));
	c.drawString ("U", 463, 370);
	c.setFont (new Font ("Helvetica", Font.PLAIN, 15));
	c.drawString ("Uranium", 450, 390);



    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //OPTIONS
    public static void Options ()
    {
	//Background Colour
	c.setColor (new Color (255, 242, 248));
	c.fillRect (0, 0, 700, 500);

	//Titles of the options
	c.setColor (new Color (69, 39, 39));
	c.setFont (new Font ("Helvetica", Font.PLAIN, 30));
	c.drawString ("PERIODIC TABLE", 190, 150);
	c.drawString ("COMPOUND LIST", 190, 190);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //PERIODIC TABLE
    public static void PeriodicTable ()
    {
	//Background Colour
	c.setColor (new Color (255, 206, 157));
	c.fillRect (0, 0, 700, 500);

	//Asking user to enter a symbol
	c.setColor (new Color (91, 46, 0));
	c.drawString ("Enter the symbol of an element: ", 40, 420);

    }


    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    //GETTING IMAGE FILE
    public SrinivasAishwarya ()
    {
	Toolkit tk = Toolkit.getDefaultToolkit ();        //Object for the image
	Pic = tk.getImage ("PeriodicTable.png");

	tk.prepareImage (Pic, -1, -1, this);

    }


    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    //DISPLAYING IMAGE
    public boolean imageUpdate (Image img, int infoflags, int x, int y, int width, int height)
    {
	if (infoflags == 32)
	{
	    c.drawImage (Pic, 15, 15, null);        //Coordiantes of image on the screen

	}


	return true;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //COMPOUND SCREEN
    public static void CompoundScreen ()
    {
	//Background Color
	c.setColor (new Color (184, 231, 207));
	c.fillRect (0, 0, 700, 500);

	//Title on the screen
	c.setColor (new Color (23, 46, 68));
	c.setFont (new Font ("Helvetica", Font.PLAIN, 40));
	c.drawString ("COMPOUNDS", 180, 80);

	//Prompting the user to enter a name
	c.setFont (new Font ("Helvetica", Font.PLAIN, 22));
	c.drawString ("To look up an existing compound, type (ex)", 50, 157);
	c.drawString ("To add in the compounds you know, type (cy)", 50, 287);


    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




} //end of program



