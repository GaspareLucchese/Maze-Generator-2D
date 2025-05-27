package mazegenerator;

//This class is responsible for printing the maze to the console
public class MazePrint 
{
    public static void printMaze(char[][] maze)
    {
        //Character to represent walls
        char ascii = '\u2588';

        for(int i = 2; i < maze.length-2; i++)
        {
            for(int j = 2;  j < maze[0].length-2;  j++)
            {
                if(maze[i][j] == '*')
                {
                    //Print the wall character twice for better visibility
                    System.out.print(ascii);
                    System.out.print(ascii);
                }
                else
                {
                    //Print the character twice for better visibility
                    System.out.print(maze[i][j]);
                    System.out.print(maze[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}