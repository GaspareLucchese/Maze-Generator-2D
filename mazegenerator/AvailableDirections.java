package mazegenerator;

import java.util.EnumMap;

//This class is responsible for managing the available directions in the maze during the path generation.
public class AvailableDirections 
{
    //Enum to represent the four possible directions in the maze
    public enum Direction 
    {
        UP, RIGHT, DOWN, LEFT
    }

    //EnumMap to store the availability of each direction
    private final EnumMap<Direction, Boolean> flags = new EnumMap<>(Direction.class);
    
    public AvailableDirections() 
    {
        resetAll();
    }

    //Returns the current state of available directions
    public boolean isAvailable(Direction direction) 
    {
        return flags.getOrDefault(direction, false);
    }

    //Checks if all directions are blocked (false)
    public boolean allBlocked()
    {
        for (Boolean value : flags.values()) 
        {
            if (value) 
            {
                return false; // At least one direction is available
            }
        }
        return true; // All directions are blocked
    }

    //Sets the specified direction as blocked (false)
    public void setBlockedDirection(Direction direction) 
    {
        flags.put(direction, false);
    }

    //Resets all directions to available (true)
    public void resetAll() 
    {
        for (Direction direction : Direction.values()) 
        {
            flags.put(direction, true);
        }
    }

    //Resets all directions to available (true) except the specified direction
    public void resetAllExcept(Direction dir) 
    {
        for (Direction direction : Direction.values()) 
        {
            if(direction != dir) 
                flags.put(direction, true);
            else 
                flags.put(direction, false);
        }
    }
}
