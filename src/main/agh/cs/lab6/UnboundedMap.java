package agh.cs.lab6;

import java.util.ArrayList;
import java.util.Collection;
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
        List<Car> carList = new ArrayList<>(cars.values());
        Position bottomLeftCorner = carList.get(0).getPosition();
        Position topRightCorner = carList.get(0).getPosition();
        for(Car car: carList){
            bottomLeftCorner = car.getPosition().lowerLeft(bottomLeftCorner);
            topRightCorner = car.getPosition().upperRight(topRightCorner);
        }
        for(HayStack stack: hayStacks){
            bottomLeftCorner = stack.getPosition().lowerLeft(bottomLeftCorner);
            topRightCorner = stack.getPosition().upperRight(topRightCorner);
        }
        return drawer.draw(bottomLeftCorner, topRightCorner);
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
