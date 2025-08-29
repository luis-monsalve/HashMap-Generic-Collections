//*************************************************************
//
//
//  Program #:     Four
//
//  File Name:     ProgramFour.java
//
//  Course:        ITSE 2317 Java Programming (Intermediate)
//
//  Chapter:       16
//
//  Description:   The program should prompt the user for a year in the range of 1903 through 2021. It
//                 should then display the name of the team that won the World Series that year and the
//                 number of times that team has won the World Series.
//
//******************************************************************

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProgranFour
{
	private Scanner input;
	//***************************************************************
   //
   //  Method:       main
   // 
   //  Description:  The main method of the program
   //
   //  Parameters:   String array
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public static void main(String[] args)
   {
       // Hashmap to store String keys and Integer values.
	   Map<String,Integer> myMap1 = new HashMap<>();
	   //Hashmap to store Integer as key and String as value.
       Map<Integer,String> myMap2 = new HashMap<>();

	    // Create an object of the main class and use it to call
	    // the non-static developerInfo,openFile,readFile and userInput.
	    ProgranFour obj1 = new ProgranFour();
	    obj1.developerInfo();
	    obj1.openFile();
        obj1.readFile(myMap1,myMap2);
        obj1.userInput(myMap1,myMap2);


	} // End of the main method
	
   //***************************************************************
   //
   //  Method:       developerInfo (Non Static)
   // 
   //  Description:  The developer information method of the program
   //
   //  Parameters:   None
   //
   //  Returns:      N/A 
   //
   //**************************************************************
   public void developerInfo()
   {
      System.out.println("Name:    Luis Alfredo Monsalve Ibarra");
      System.out.println("Course:  ITSE 2317 Java Programming (Intermediate)");
      System.out.println("Project: Four\n");
   } // End of the developerInfo method

    //***************************************************************
    //
    //  Method:       openFile
    //
    //  Description:  open a text file
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void openFile() {
        try {
             input = new Scanner(Paths.get("Program4.txt"));
            //output = new PrintWriter("Program10-output.txt");
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }
    }
    //***************************************************************
    //
    //  Method:       readFile
    //
    //  Description:  read and process a text file
    //
    //  Parameters:   None
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public void readFile(Map<String, Integer> myMap1, Map<Integer, String> myMap2){

        int year = 1903;


        //populate the two HashMap using a while loop.
        while(input.hasNext()){
            String name = input.nextLine();
            if(year == 1904 || year == 1994 ){  //skip year 1904
                year++;
            }
            myMap2.put(year,name);

            if(myMap1.containsKey(name)){
                myMap1.put(name, myMap1.get(name)+1);
            }
            else{
                myMap1.put(name,1);
            }

            year++;

        }

	}



    //***************************************************************
    //
    //  Method:       userInput
    //
    //  Description:  create map based on user input
    //
    //  Parameters:   yes
    //
    //  Returns:      N/A
    //
    //**************************************************************
   public void userInput(Map<String, Integer> myMap1, Map<Integer, String> myMap2){

       Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a year between 1903 and 2021 or press \"0\" to stop:");
        int year = scanner.nextInt();
        String teamName = getTeamYear(year,myMap2);

        while(year != 0 ) {

            if (teamName != null && !teamName.equalsIgnoreCase("")) {
                int winningCount = getWinning(teamName, myMap1);
                System.out.println(teamName + " won the World Series in: " + year);
                System.out.println("Total number of times " + teamName + " won the World Series is: " + winningCount);
            } else {
                System.out.println("No team won the World Series in: " + year);
            }

            System.out.println("\nEnter a year between 1903 and 2021 or press \"0\" to stop:");
            year = scanner.nextInt();
			teamName = getTeamYear(year,myMap2);
        }

   }


    //***************************************************************
    //
    //  Method:       getTeamYear
    //
    //  Description:  get a key associated value (Team name)
    //
    //  Parameters:   yes
    //
    //  Returns:      N/A
    //
    //**************************************************************


    public  String getTeamYear(int year, Map<Integer, String> myMap2){
        if(myMap2.get(year) != null){
            return myMap2.get(year);
        }else{
            return null;
        }


    }
    //***************************************************************
    //
    //  Method:       getWinning
    //
    //  Description:  get a key associated value (how many times a team has won)
    //
    //  Parameters:   yes
    //
    //  Returns:      N/A
    //
    //**************************************************************
    public int getWinning(String name, Map<String, Integer> myMap1){

        if(myMap1.get(name) != null){
            return myMap1.get(name);
        }else{
            return 0;
        }

    }
} // End of test class ProgramFour
