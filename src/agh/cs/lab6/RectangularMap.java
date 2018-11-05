package agh.cs.lab6;

/**
 * Created by student33 on 2018-10-22.
 */
class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;
    private Position upperRightCorner;
    private Position lowerLeftCorner = new Position(0,0);

    RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
        this.upperRightCorner = new Position(width-1, height-1);

    }
    public String toString(){
        MapVisualizer drawer = new MapVisualizer(this);
        Position lowerLeft = new Position(0,0);
        Position upperRight = new Position(this.width, this.height);
        return drawer.draw(lowerLeft, upperRight);
    }
    public boolean canMoveTo(Position position){
        if (position.larger(this.lowerLeftCorner) && position.smaller(this.upperRightCorner) && !this.isOccupied(position))
            return true;
        else return false;
    }
}
