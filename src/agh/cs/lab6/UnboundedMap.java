package agh.cs.lab6;

import java.util.List;

/**
 * Created by Student33 on 2018-10-29.
 */
public class UnboundedMap extends AbstractWorldMap{
    private List<HayStack> hayStacks;

    public UnboundedMap(List<HayStack> hayStacksToPlace){
        this.hayStacks = hayStacksToPlace;
    }
    public String toString(){
        MapVisualizer drawer = new MapVisualizer(this);
        Position lowerLeft = cars.get(0).getPosition();
        Position upperRight = cars.get(0).getPosition();
        for(Car car: cars){
            if(car.getPosition().smaller(lowerLeft))
                lowerLeft = car.getPosition();
            if(car.getPosition().larger(upperRight))
                upperRight = car.getPosition();
        }
        for(HayStack stack: hayStacks){
            if(stack.getPosition().smaller(lowerLeft))
                lowerLeft = stack.getPosition();
            if(stack.getPosition().larger(upperRight))
                upperRight = stack.getPosition();
        }
        return drawer.draw(lowerLeft, upperRight);
    }
    public boolean canMoveTo(Position position){
        return !this.isOccupied(position);
    }
    public Object objectAt(Position position){
        Object carAt = super.objectAt(position);
        if(carAt != null)
            return carAt;
        for(HayStack stack: this.hayStacks){
            if(stack.getPosition().equals(position))
                return stack;
        }
        return null;
    }
}
