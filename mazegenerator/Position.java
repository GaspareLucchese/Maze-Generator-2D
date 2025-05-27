package mazegenerator;

//This class is used to represent a position in the maze with x and y coordinates.
public class Position 
{
    private int x;
    private int y;

    public Position() {}

    public Position(int x, int y)
    {
        this.setXY(x, y);
    }

    //Setter and Getter Methods
    public void setXY(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
}