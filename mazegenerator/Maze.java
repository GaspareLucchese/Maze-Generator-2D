package mazegenerator;

import java.util.Random;

import mazegenerator.AvailableDirections.Direction;

//This class is responsible for generating a maze with paths and walls.
public class Maze 
{
    //The maze is represented as a 2D array of characters
    private char[][] maze;

    public void mazeGenerator(int width, int height) 
    {
        //We add a border of 2 cells around the maze to ensure that paths can be created without hitting the edges
        this.maze = new char[height+4][width+4];
        
        for(int i = 0; i < height+4; i++)
		{
			for(int j = 0;  j < width+4;  j++)
			{
				if((i < 2) || (j < 2) || (i > height+1) || (j > width+1))
				{
                    //Border walls
					maze[i][j] = 'B';
				}
				else
				{
                    //Inner walls
					maze[i][j] = '*';
				}
            }
        }
    }

    //Method to generate a path (carving it) in the maze starting from a given position
    public char[][] pathGenerator(Position start, int width, int height)
    {
        boolean pathComplete = false;
        AvailableDirections flag = new AvailableDirections();
        Random rand = new Random();

        //We define a target fill percentage for the maze
        final double TARGET_FILL_PERCENTAGE = 0.48;
        int pathCells = 0; //Number of cells (path) that will be carved from the maze walls

        int attempts = 0;
        do
        {
            while(!pathComplete)
            {

                //If is not possible to move in any direction, we stop the path generation
                if(flag.allBlocked())
                {
                    pathComplete = true;
                    break;
                }

                //We randomly choose a direction to move in the maze
                int randomDirection = rand.nextInt(4);
                switch (randomDirection)
                {
                    case 0: // UP
                        //if the UP direction is not available, we skip to the next iteration
                        if(!flag.isAvailable(Direction.UP))
                        {
                            break;
                        }
                        //Check if the UP direction is available and if it is not blocked by the borders or other paths
                        if((start.getY() <= 3) || ((this.maze[start.getY() - 1][start.getX()] == ' ') || (maze[start.getY() - 1][start.getX() - 1] == ' ') || (maze[start.getY() - 1][start.getX() + 1] == ' ') || (maze[start.getY() - 2][start.getX()] == ' ') || (maze[start.getY() - 2][start.getX() - 1] == ' ') || (maze[start.getY() - 2][start.getX() + 1] == ' ')))
                        {
                            flag.setBlockedDirection(Direction.UP);
                            break;
                        }
                        //Else we move to the UP
                        start.setXY(start.getX(), start.getY() - 1);
                        //Reset all directions except DOWN, because we just moved UP
                        flag.resetAllExcept(Direction.DOWN);
                        break;
                
                    case 1: // RIGHT
                        //if the RIGHT direction is not available, we skip to the next iteration
                        if(!flag.isAvailable(Direction.RIGHT))
                        {
                            break;
                        }
                        //Check if the RIGHT direction is available and if it is not blocked by the borders or other paths
                        if((start.getX() >= width) || ((this.maze[start.getY()][start.getX() + 1] == ' ') || (maze[start.getY() + 1][start.getX() + 1] == ' ') || (maze[start.getY() - 1][start.getX() + 1] == ' ') || (maze[start.getY()][start.getX() + 2] == ' ') || (maze[start.getY() - 1][start.getX() + 2] == ' ') || (maze[start.getY() + 1][start.getX() + 2] == ' ')))
                        {
                            flag.setBlockedDirection(Direction.RIGHT);
                            break;
                        }
                        //Else we move to the RIGHT
                        start.setXY(start.getX() + 1, start.getY());
                        //Reset all directions except LEFT, because we just moved RIGHT
                        flag.resetAllExcept(Direction.LEFT);
                        break;
                    
                    case 2: // DOWN
                        //if the DOWN direction is not available, we skip to the next iteration
                        if(!flag.isAvailable(Direction.DOWN))
                        {
                            break;
                        }
                        //Check if the DOWN direction is available and if it is not blocked by the borders or other paths
                        if((start.getY() >= height) || ((this.maze[start.getY() + 1][start.getX()] == ' ') || (maze[start.getY() + 1][start.getX() - 1] == ' ') || (maze[start.getY() + 1][start.getX() + 1] == ' ') || (maze[start.getY() + 2][start.getX()] == ' ') || (maze[start.getY() + 2][start.getX() - 1] == ' ') || (maze[start.getY() + 2][start.getX() + 1] == ' ')))
                        {
                            flag.setBlockedDirection(Direction.DOWN);
                            break;
                        }
                        //Else we move to the DOWN
                        start.setXY(start.getX(), start.getY() + 1);
                        //Reset all directions except UP, because we just moved DOWN
                        flag.resetAllExcept(Direction.UP);
                        break;
                    
                    case 3: // LEFT
                        //if the LEFT direction is not available, we skip to the next iteration
                        if(!flag.isAvailable(Direction.LEFT))
                        {
                            break;
                        }
                        //Check if the LEFT direction is available and if it is not blocked by the borders or other paths
                        if((start.getX() <= 3) || ((this.maze[start.getY()][start.getX() - 1] == ' ') || (maze[start.getY() + 1][start.getX() - 1] == ' ') || (maze[start.getY() - 1][start.getX() - 1] == ' ') || (maze[start.getY()][start.getX() - 2] == ' ') || (maze[start.getY() - 1][start.getX() - 2] == ' ') || (maze[start.getY() + 1][start.getX() - 2] == ' ')))
                        {
                            flag.setBlockedDirection(Direction.LEFT);
                            break;
                        }
                        //Else we move to the LEFT
                        start.setXY(start.getX() - 1, start.getY());
                        //Reset all directions except RIGHT, because we just moved LEFT
                        flag.resetAllExcept(Direction.RIGHT);
                        break;
                }

                //We carve the path in the maze
			    if(this.maze[start.getY()][start.getX()] != ' ')
                {
                    this.maze[start.getY()][start.getX()] = ' ';
                    pathCells++;
                }
            }

            //We choose a new starting point from a random path cell for the next path
            do
			{
				start.setXY(rand.nextInt(width) + 2, rand.nextInt(height) + 2);
			}
            while(this.maze[start.getY()][start.getX()] != ' ');

            //Reset the flags for the next path
            flag.resetAll();
            pathComplete = false;

            //Incrementiamo il contatore per evitare loop infiniti
            attempts++;

            //Check (every 100 attempts) if the fill percentage is reached
            if(((double) pathCells / (width * height) >= TARGET_FILL_PERCENTAGE) && (attempts % 100 == 0))
            {
                //If the fill percentage is reached, we stop generating paths
                break;
            }

        }while(attempts < height*width*10); //Limit the number of attempts to avoid infinite loops

        return this.maze;
    }
}
