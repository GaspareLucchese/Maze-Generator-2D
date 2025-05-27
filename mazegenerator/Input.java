package mazegenerator;

import java.util.InputMismatchException;
import java.util.Scanner;

//This class is responsible for handling user input
public class Input 
{
    private final Scanner scanner = new Scanner(System.in);

    public int[] inputSize()
    {
		System.out.println("\nWelcome to the Maze Generator!\n");
		
		int width = 0, height = 0;
		//Loop until valid input is received
        while(true)
		{
			try
			{
				System.out.print("Enter the maze width (minimum 3): ");
				width = scanner.nextInt();
				if (width < 3) 
				{
					//If the width is less than 3, throw an exception
					throw new IllegalArgumentException();
				}
				break; //Exit the loop if input is valid
			}
			catch (IllegalArgumentException e) 
			{
				System.out.println("Width must be at least 3. ");
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Invalid input! Please enter an integer! ");
				scanner.next();
			}
        } 

		System.out.println();
		
		//Loop until valid input is received
		while(true)
		{
			try
			{
				System.out.print("Enter the maze height (minimum 3): ");
				height = scanner.nextInt();
				if (height < 3) 
				{
					//If the width is less than 3, throw an exception
					throw new IllegalArgumentException();
				}
				break; //Exit the loop if input is valid
			}
			catch (IllegalArgumentException e) 
			{
				System.out.println("Height must be at least 3. ");
			}
			catch (InputMismatchException e) 
			{
				System.out.println("Invalid input! Please enter an integer: ");
				scanner.next();
			}
        } 

		//Return the width and height as an array
        return new int[] {width, height};
    }
    
    public int inputChoice()
    {
		int input = 0;
        System.out.println("\nGreat! Now select one of the available options for start and end positions:");
        System.out.println("1) Start on a border, end at a random position inside the maze");
        System.out.println("2) Start and end at random border positions");
        System.out.println("3) Start and end at opposite borders");

		//Loop until valid input is received
		while(true)
		{
			try
			{
				System.out.print("Your choice (1-3): ");
                input = scanner.nextInt();
				if (input < 1 || input > 3) 
				{
					//If the input is not between 1 and 3, throw an exception
					throw new IllegalArgumentException();
				}
				//Exit the loop if input is valid and return the input value
				System.out.println("");
				return input;
			} 
			catch (InputMismatchException e) 
			{
				System.out.println("Invalid input! Please enter an integer: ");
				scanner.next();
			}
			catch (IllegalArgumentException e) 
			{
				System.out.println("Invalid input! Please enter a number between 1 and 3. ");
			}
		}
    }
}