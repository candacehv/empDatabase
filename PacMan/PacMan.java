
/**
 * This program creates a simple version of the gamePacman. It asks the player 
 * for the size of the gameboard, populates a grid of dots, and fills in 15% 
 * of the board with "cookies" which the Pacman will try to collect. Upon 
 * quitting the game, the statistics of the round will be displayed, including 
 * number of moves made, number of cookies collected, and moves per cookie.
 * 
 * @author Candace Holcombe-Volke
 *
 */

import java.util.Scanner; 

public class PacMan 
{
    /**
     * The main method calls all of the action throughout this program. It is
     * responsible for the main loop that controls gameplay. 
     * 
     * @param h is the height of the gameboard
     * @param w is the width of the gameboard
     * @param s is the row index of Padman's current location
     * @param t is the column index of Pacman's current location   
     * @param moves is the number of times Pacman attempts (successfully or 
     * not) to move to a new location on the gameboard     
     * @param grid updates the original gameboard display to reflect dots
     * visited, cookies eaten, and current location through the game
     * @param currentDirection starts Pacman facing in the correct direction
     * @param cookies counts the number of "O" (cookies) collected in game 
     * @param menuChoice is the user input determining next move from menu 
     * display
     *
     * @precondition: h, w, s, t are integers
     * @precondition: moves and cookies are floats
     * @precondition: s, t, moves, cookies are initialized at 0
     * @precondition: h, w, menuChoice are initialized by user input through 
     * methods
     * @precondition: grid is initialized as the result of createDisplay
     * @precondition: menuSelection must be an integer
     * @precondition: currentDirection is set to ">"
     *
     * @postcondition: grid will be updated according to user input
     * @postconidition:
     * 
     * @author: Candace Holcombe-Volke
     */

    public static void main( String [] args )
    {
        //  Declare and initialize variables

        int h = howTallGrid();  // Number of rows on game board
        int w = howWideGrid();  // Number of columns on game board
        int s = 0; // Row index of current location
        int t = 0; // Column index of current location       
        float moves = 0f; // Number of moves Pacman completes/attempts
        String grid[][] = new String[h][w]; // copy of initial display
        String currentDirection = ">"; // Starting Pacman position

        // Initialize game board
        grid = createDisplay( h, w, s, t, currentDirection);  
        float cookies = 0f; // Number of "O" collected in game
        menuDisplay();
        int menuChoice = menuSelection(); //  Initialize user menuChoice      
        
        // Primary game control loop; Invalid entry sent to default case
        while( menuChoice == 0 || menuChoice != 0 ) 
        {
            switch ( menuChoice )
            {
                case 0: // Re-display menu and collect menu choice
                    menuDisplay();
                    menuChoice = menuSelection();
                    break; // End redisplay menu loop
                    
                case 1:  // Left Turn
                    // Turn Pacman counter-clockwise, update game board, 
                    // display game board, get next menu choice
                    currentDirection = turnLeft( currentDirection );
                    movePac( h, w, s, t, grid, currentDirection );
                    menuChoice = menuSelection();
                    break;  // End left turn loop

                case 2: // Right Turn
                    // Turn Pacman to clockwise,update game board, 
                    // display game board get next menu choice
                    currentDirection = turnRight(currentDirection);
                    movePac(h, w, s, t, grid, currentDirection );
                    menuChoice = menuSelection();
                    break;  // End right turn loop
                    
                case 3: // Move Ahead
                    // Check if ok to move based on game board boundaries
                    // If ok, move in the correct direction, then update
                    // game board and display new board. 
                    // Display error if move is invalid. Move attempt counts 
                    // toward total moves

                    // checkOKToMove checks the boundaries of the game board
                    if( checkOkToMove( s, t, h, w, currentDirection ) == true)
                    {
                        // For left and right moves only: changes t value
                        if(currentDirection == ">" || currentDirection == "<")
                        {                           
                            // Update PacMan current location to " "
                            grid[s][t] = " "; 

                            // Move PacMan to new location
                            t = newLocationT( t, currentDirection ); 
                           
                            
                            // Check if new location is a cookie
                            if ( grid[s][t] == "O")
                            {    
                                cookies = ( cookies + 1); // add cookie
                                System.out.println("Yum! Cooookies!");
                            }
                        } // End loop to check approval for right & left moves 

                        // For up and down moves only: changes s value
                        else if(
                        currentDirection == "^" || currentDirection == "V")
                        {
                            // Update PacMan current location to " "
                            grid[s][t] = " ";
                            
                            // Move PacMan to new location
                            s = newLocationS( s, currentDirection );
                            
                            // Check if new location is a cookie
                            if ( grid[s][t] == "O" )
                            {
                                cookies = ( cookies + 1);
                                System.out.println("Yum! Cooookies!");
                            }
                        }

                        // Increase moves by 1
                        moves = (moves + 1); 

                        // Removes "." from last space, prints updated board
                        movePac( h, w, s, t, grid, currentDirection);

                        // Prompt user for next action
                        menuChoice = menuSelection();
                    } // End checkOkToMove is true
                   
                    else  // Move not successful - at game board boundary
                    {
                        // Reprompt user for action
                        System.out.println("Oops. Can't go that way." +
                            " Make another selection: ");
                        moves = (moves + 1); 
                        //redisplays game board before collecting menuChoice
                        movePac( h, w, s, t, grid, currentDirection );
                        menuChoice = menuSelection();
                    }
                    break; // End menu option 3 (move) loop
                    
                case 4:  // Begin quit game loop
                    // Display parting message and stats when player ends game
                    System.out.println("Hey! Thanks for playing!" + 
                        " Here are your stats: ");

                    printStats( moves, cookies ); //calculate moves/cookie
                    // and display the stats and 
                    
                    return; // End game
                    
                    
                default:  // Invalid numeric entry
                    System.out.println("Error: Invalid entry." +
                        " Please make another selection.");

                    // Prompt user for a valid choice, save current game board
                    menuChoice = menuSelection();
                    break;                    
            }
        }
    }
    



    /**
     * This method receives the total moves attempted and completed, the 
     * cookies collected. It calculates the moves per cookie, and displays all 
     * the stats upon the player ending the game. 
     * 
     * @param: movesPerCookie is the number of moves made divided by number of 
     * cookies collected
     * 
     * @precondition: moves and cookies are passed in as floats
     * @precondition: method is called by main() when menuChoice equals 4 
     * (end game)
     * 
     * @postcondition: moves/cookie is calculated
     * @postcondition: control is passed back to main()
     * 
     * @author: Candace Holcombe-Volke
     */

    public static void printStats( float moves, float cookies )
    {
        if( cookies == 0 ) // 0 cookies collected - No division by 0
        {
            System.out.println( "Total Moves: " + moves + "\t\t" + 
                "Total Cookies: " + cookies + "\n" + "Moves per Cookie can't" +
                " be calculated because you caught 0 cookies." );  //  Stats
            System.out.println();
        }    
        
        else // At least one cookie collected
        {
            float movesPerCookie = (moves / cookies); 
            System.out.print("Total Moves: " + moves + "\t" + 
                "Total Cookies: " + cookies + "\t" + "Moves per Cookie: " + 
                movesPerCookie);  // Stats
            System.out.println();
        }
    } // End printStats()




    /**
     * This method updates the t (column) index value after
     * checkOkToMove() approves Pacman's move.
     * This method determines if PacMan is moving left or right
     * based on its currentDirection, and then adds or subtracts 1 to t. Then 
     * it returns the new t value.
     *
     * No new variables declared
     *
     * @precondition: int t and String currentDirection are passed in
     * 
     * @postcondition: An updated t value is returned and control returned to 
     * main() switch case 3.
     *
     * @author Candace Holcombe-Volke
     */

    public static int newLocationT(int t, String currentDirection )
    {
        // Direction for moving left
        if(currentDirection == ">")
        {
            t = ( t - 1 );
        }        
        // Direction for moving right
        else 
        {
            t = ( t + 1 );
        }
        return t;
    } // End newLocationT()
    
    


    /**
     * This method updates the s (row) index value after
     * checkOkToMove() approves Pacman's move.
     * This method determines if PacMan is moving up or down based on 
     * currentDirection, and then adds or subtracts 1 to t. Then it returns 
     * the new s value.
     *
     * No new variables declared
     *
     * @precondition: int s and String currentDirection are passed in
     * 
     * @postcondition: An updated s value is returned and control returned to 
     * main() switch case 3.
     *
     * @author Candace Holcombe-Volke
     */

    public static int newLocationS( int s, String currentDirection )
    {
        // Direction for moving down
        if(currentDirection == "^")
        {
            s = ( s + 1);
        }
        // Direction for moving up
        else 
        {
            s = ( s - 1);
        }
        return s;
    }  // End newLocationS



    /**
     * This method is called when user attempts to move to a new location. It 
     * checks whether PacMan is already at the boundary of the game board. It 
     * returns a boolean result indicating whether the move is valid or not. 
     * 
     * @moveOrNot is a boolean that identifies if PacMan is on the game board 
     * border or not. True results indicate that PacMan's attempted move IS 
     * valid. False indicates that PacMan is on the border and the move IS NOT 
     * valid.
     *
     * @precondition: integers s, t, h, and w are passed in from main()
     * @precondition: String currentDirection is passed in from main()
     *
     * @postcondition: moveOrNot is returned to main() switch case 3
     * as a boolean
     * 
     * @author: Candace Holcombe-Volke
     */

    public static boolean checkOkToMove(int s, int t, int h, int w, String currentDirection)
    {
        boolean moveOrNot = true;  // Initialize moveOrNot
        if (currentDirection == ">")
         {
            moveOrNot = t > 0;  // Check if OK to move left
         }
        
        else if (currentDirection == "V")
        {
            moveOrNot = s > 0;  // Check if OK to move up
        }  
        
        else if (currentDirection == "<") 
        {
            moveOrNot = t < (w-1);  // Check if OK to move right
        }
        
        else if (currentDirection == "^")
        {
            moveOrNot = s < (h-1);  // Check if OK to move down
        }
        return moveOrNot;
    } // End checkOkToMove()






    /** This method prompts user to enter how tall they want the game board.
     * 
     * @param: Scanner gridHeight collects user input
     * @param: height is an integer and is the number of rows on the game board
     *
     * @precondition: method is called from main with no parameters
     * 
     * @postcondition: method returns the height value to main()
     *
     * @author: Candace Holcombe-Volke
     * 
     */

    public static int howTallGrid()
    {
        Scanner gridHeight = new Scanner( System.in );
        System.out.println( "Enter the size of the game: ");

        // Prompt user for how many rows on the board
        System.out.println( "How many rows tall? "); 
        int height = gridHeight.nextInt(); // Store height as user input
        
        return height; // Return value to main()
    }  // End howTallGrid()
    
    
    
    /** This method prompts user to enter how wide they want the game board.
     * 
     * @param: Scanner gridWidth collects user input
     * @param: width is an integer and is the number of columns on the board
     *
     * @precondition: method is called from main with no parameters
     * 
     * @postcondition: method returns the width value to main()
     *
     * @author: Candace Holcombe-Volke
     * 
     */
    public static int howWideGrid()
    {
        Scanner gridWidth = new Scanner( System.in );
        System.out.println( "How many columns wide? ");
        
        // Prompt user for how many columns on the board
        int width = gridWidth.nextInt(); // Store width as user input
        
        return width;  // Return width value to main()
    }  // End howWideGrid()
    
    
    


    /**
     * This method only prints out a welcome message. It takes no parameters 
     * and returns nothing. 
     *
     * @precondition: This method is called by main() at the initiation of game
     *
     * @postcondition: This method returns control to main()
     * 
     * @author Candace Holcombe-Volke
     * 
     */

    public static void welcome()
    {
        System.out.println("Welcome to PacMan!");
    } 
    
    
    

    /**
    * This method creates the initial game display. It is only used at the 
    * initiation of the game. It takes in the parameters, loops through and 
    * adds dots to each space, replaces the starting dot with the starting
    * PacMan direction, and randomly selects 15% of dots to be replaces as
    * "cookies". 
    * 
    * @param: i, j, c, are integers and are used for loop control. i and j 
    * control the initial loop which places the dots in every space. c 
    * controls the loop that assigns the cookies
    * @param: col and row are randomly selected integers and as pairs, 
    * become the location of the cookies
    * @param: numOfCookiesToCreate is a double (which through loop control is 
    * rounded down to the closest integer) and is 15% of the total number of 
    * spaces on the game board. It is used in cookie assignment loop control
    * @param: k is a string that first assigns dots, then changes to assign    
    * cookies
    *
    * @precondition: Is passed height, width, s, t as integers
    * @precondition: Accepts currentDirection to set on initial game board
    * @precondition: i, j, c, col, row are initialized to 0
    * 
    * @postcondition: i increases to 1 less than height
    * @postcondition: j increases to 1 less than width
    * @postcondition: col and row are randomly assigned the number of times 
    * that is equal to numOfCookiesToCreate
    * @postcondition: k is changed to "O"
    * @postcondition: welcome() is called and control returned
    * @postcondition: display[][] becomes the initial game board and is 
    * returned to main()
    * 
    * @author: Candace Holcombe-Volke
    */

    public static String[][] createDisplay( int height, int width, int s, 
    int t, String currentDirection )
    {
        // Initialize display with size of user input height x width
        String [][] display = new String [height][width];

        // Initialize loop control variables to 0
        int i = 0;    // Loop control for dots
        int j = 0;    // Loop control for dots
        int c = 0;    // Loop control for cookies
        int col = 0;  // loop for cookies random rows
        int row = 0;  // Loop for cookies random columns

        //Number of cookies needed to display 15% of spaces as cookies 
        double numOfCookiesToCreate = (int) ((height * width) * (.15)); 

        String k = "."; // Set all spaces equal to "."   


        
        // Begin loop to assign dots
        for( i = 0; i < height; i++) // Columns
        {
            for( j = 0; j < width; j++) // Rows   
            {
                display[i][j] = k;           
            }
        }  // End dot assignment
                
        k = "O";  // Reset to assign cookies
        for (c = 0; c < numOfCookiesToCreate; c++ )
        {
            // Collect random num for column index, gameboard width as maximum 
            col = (int) (( width * Math.random() ) ); 

            // Collect random num for row index, gameboard height as maximum
            row = (int) (( height * Math.random() ) );

            // Check if space is already assigned as cookie
            if( display[col][row] == "O")
            {
                // If already assigned, run loop an extra time
                numOfCookiesToCreate = ( numOfCookiesToCreate + 1 );
            }
            display[col][row] = "O";  // Assign random space as cookie
        }
  
        welcome(); // Get game welcome message
        
        // Reinitialize i and j to 0 and loop to print display as assigned
        for( i = 0; i < height; i++)
        {
            for(j = 0; j < width; j++)
            {
                display[s][t] = currentDirection;
                System.out.print(display[i][j]);
            }
            System.out.println();
        }     
        return display;
    }  // End createDisplay()
    




    /**
     * This method replaces "." from new location replaces with the current 
     * direction of PacMan. 
     * Invoked from main() switch case 3 - user input for move - and accepts 
     * height, width, s, and t as integers and grid[][] and String 
     * currentDirection. 
     *
     * @param i and j are integers, initialized to 0 and used for loop control
     * @param s and t are integers passed as the coordinates of the new PacMan
     * location
     * @param grid is the gameboard with up-to-date changes that have been 
     * made after each action
     *
     * @precondition: Method called by main()
     * 
     * @postcondition: grid updated to reflect direction in the new location
     * @postcondition: grid returned to main() switch case 3
     *
     * @author: Candace Holcombe-Volke
     */
    public static String[][] movePac(int height, int width, int s, int t, String [][] grid, String currentDirection )
    {
        int i;  // Used for loop control to print updated grid
        int j;  // Used for loop control to print updated grid
        for( i = 0; i < height; i++)
        {
            for(j = 0; j < width; j++)
            {
                grid[s][t] = currentDirection; // Assign direction to new loc
                System.out.print(grid[i][j]);  // Display updated game board
            }
            System.out.println();
        }   
        return grid;  // Return to main() 
    } // End movePac
    



    /**
     * This method only reprints the menu upon user request. It is called 
     * from main() switch case 4. It returns nothing.
     * 
     * There are no values passed in or returned.
     *
     * @author Candace Holcombe-Volke
     */

    public static void menuDisplay()
    {
        System.out.println( 
            "Enter the number of the command you want to perform: ");
        System.out.println( "Display Commands\t <0>");
        System.out.println( "Turn left\t\t <1>");
        System.out.println( "Turn Right\t\t <2>");
        System.out.println( "Move Ahead\t\t <3>");
        System.out.println( "Quit\t\t\t <4>");    
    }  // End menuDisplay()
    
    
    

    /**
     * This method is called following menuDisplay() and after each new game 
     * board display and collects user input about what to do next. 
     *
     * @param: menuChoice is the user's menu selection, and is an integer
     * 
     * @postcondition: menuChoice is reset to user input and returned to main()
     *
     * @author Candace Holcombe-Volke
     */
    public static int menuSelection()
    {
        System.out.println("Command: ");
        Scanner menu = new Scanner( System.in );
        int menuChoice = menu.nextInt();
        
        return menuChoice; // Reset menuChoice action loop in main()
    } // End menuDisplay()
        

    

    /**
     * This method turns PacMan clockwise 90 degrees. It uses the 
     * currentDirection to determine what the new direction should be
     * and then sets currentDiretion equal to that direction.
     * It accepts the String currentDirection.
     * 
     * @postcondition: currentDirection is replaced with the direction to the
     * right
     * @postcondition: the updated currentDirection is returned to main()
     * 
     * @author Candace Holcombe-Volke
     */
    public static String turnRight( String currentDirection )
    {
        // Assess current direction, determine which string to apply, 
        // reset current direction and return
        if( currentDirection.equals( ">" ))
        {
            currentDirection = "V"; 
            return currentDirection;
        }
        
        else if( currentDirection.equals( "V" ))
        {
            currentDirection = "<";
            return currentDirection;
        }
        
        else if( currentDirection.equals( "<" ))
        {
            currentDirection = "^";
            return currentDirection;
        }
        
        else 
        {
            currentDirection = ">";
            return currentDirection;
        }
    }  // End turnRight()
    
    

    /**
     * This method turns PacMan counter-clockwise 90 degrees. It uses the 
     * currentDirection to determine what the new direction should be
     * and then sets currentDiretion equal to that new string direction.
     * It accepts the String currentDirection.
     * 
     * @postcondition: currentDirection is replaced with the direction to the
     * left
     * @postcondition: the updated currentDirection is returned to main()
     * 
     * @author Candace Holcombe-Volke
     */
    public static String turnLeft( String currentDirection )
    {
        // Assess current direction, determine which string to apply, 
        // reset current direction and return
        if( currentDirection.equals( ">" ))
        {
            currentDirection =  "^"; 
            return currentDirection;
        }
        
        else if( currentDirection.equals("^" ))
        {
            currentDirection = "<";
            return currentDirection;
        }
        
        else if( currentDirection.equals( "<" ))
        {
            currentDirection = "V";
            return currentDirection;
        }
        
        else 
        {
            currentDirection = ">";
        }
        return currentDirection; 
    } // End turnLeft()
} // End program
