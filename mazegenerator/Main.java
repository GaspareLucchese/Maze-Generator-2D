package mazegenerator;

import java.util.Random;

//This is the main class that runs the maze generator program.
public class Main
{
    public static void main(String[] args) 
    {
        //Initialize random number generator, input handler, and entry/exit generator
        Random rand = new Random();
        Input input = new Input();
		Position start, finish;
		MazeEntryExitGenerator entryAndExit = new MazeEntryExitGenerator();

        //Get maze size from user input
        int[] size = input.inputSize();
        int width = size[0];
        int height = size[1];

        //Generate the maze with the specified width and height
        Maze maze = new Maze();
        maze.mazeGenerator(width, height);

        //Generate a random starting position for the path
        Position position = new Position(rand.nextInt(width) + 2, rand.nextInt(height) + 2);
        
        //Generate the paths in the maze starting from the random position
        char[][] newMaze = maze.pathGenerator(position, width, height);
        
        //Generate entry and exit points based on user choice
        int choice = input.inputChoice();
		Position[] positions = entryAndExit.generatePositions(choice, newMaze, position);
		start = positions[0];
		finish = positions[1];

        //Mark the entry and exit points in the maze
		newMaze[start.getY()][start.getX()] = 'S'; //Start
		newMaze[finish.getY()][finish.getX()] = 'F'; //Finish

        //Print the generated maze to the console
        MazePrint.printMaze(newMaze);
    }
}