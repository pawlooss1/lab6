package agh.cs.lab6;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap{
    protected Map<Position,Car> cars = new LinkedHashMap<>();

    public boolean place(Car car){
        Position carPosition = car.getPosition();
        if(canMoveTo(carPosition)){
            cars.put(carPosition, car);
            return true;
        }
        else
            throw new IllegalArgumentException("Position " + carPosition.toString() + " is already occupied");
    }
    public void run(MoveDirection[] directions){
        if (cars.size() == 0)
            return;
        for(int i = 0; i<directions.length; i++){
            Car carToMove = cars.get(i%cars.size());
            Position oldPosition = carToMove.getPosition();
            carToMove.move(directions[i], this);
            i++;
        }
    }
    public boolean isOccupied(Position position){
        return this.objectAt(position) != null;
    }
    public Object objectAt(Position position){
        for(Car car: cars){
            if(car.getPosition().equals(position))
                return car;
        }
        return null;
    }
}
