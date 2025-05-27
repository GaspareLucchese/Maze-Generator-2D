package mazegenerator;

import java.util.Random;

//This class is responsible for generating entry and exit points in a maze.
public class MazeEntryExitGenerator 
{
    Random rand = new Random();
    private Position entry = new Position();
    private Position exit = new Position();

    //Randomly select an entry border (0: top, 1: right, 2: bottom, 3: left)
    private int entryBorder = rand.nextInt(4);
    private int exitBorder;

    public Position[] generatePositions(int input, char[][] maze, Position position)
    {
        //Generate an entry point based on the selected border
        this.generateEntryAndExit(this.entryBorder, this.entry, maze);
        switch (input) 
        {
            case 1:
                //If input is 1, we reuse the provided position (the path generator)
                this.exit = position;
                break;
            case 2:
                //Randomly select an entry border (0: top, 1: right, 2: bottom, 3: left)
                this.exitBorder = rand.nextInt(4);
                //Generate an exit point based on the selected border
                this.generateEntryAndExit(this.exitBorder, this.exit, maze);
                break;
            case 3:
                //Calculate the exit border opposite to the entry border
                this.exitBorder = (this.entryBorder + 2) % 4;
                //Generate an exit point based on the selected border
                this.generateEntryAndExit(this.exitBorder, this.exit, maze);
                break;
        }
        
        //Return the entry and exit positions
        return new Position[] {this.entry, this.exit};
    }

    //Generate entry or exit points based on the specified border
    private void generateEntryAndExit(int border, Position pos, char[][] maze)
    {
        boolean positionFound = false;
        int width = maze[0].length - 2;
        int height = maze.length - 2;

        //Loop until a valid position is found on the specified border
        while(!positionFound)
        {
            switch (border) 
            {
                //Top border
                case 0:
                    pos.setXY(rand.nextInt(width) + 2, 2);
                    if(maze[3][pos.getX()] == ' ')
                    {   
                        //If the position is valid (near a path), set the flag to true
                        positionFound = true;
                    }
                    break;

                //Right border
                case 1:
                    pos.setXY(maze[0].length-3, rand.nextInt(height) + 2);
                    if(maze[pos.getY()][maze[0].length-4] == ' ')
                    {
                        //If the position is valid (near a path), set the flag to true
                        positionFound = true;
                    }
                    break;

                //Bottom border
                case 2:
                    pos.setXY(rand.nextInt(width) + 2, maze.length-3);
                    if(maze[maze.length-4][pos.getX()] == ' ')
                    {
                        //If the position is valid (near a path), set the flag to true
                        positionFound = true;
                    }
                    break;

                //Left border
                case 3:
                    pos.setXY(2, rand.nextInt(height) + 2);
                    if(maze[pos.getY()][3] == ' ')
                    {
                        //If the position is valid (near a path), set the flag to true
                        positionFound = true;
                    }
                    break;
            }
        }
    }
}