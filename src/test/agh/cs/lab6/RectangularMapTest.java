package agh.cs.lab6;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangularMapTest{
    @Test
    public void canMoveToTest(){
        RectangularMap testMap = new RectangularMap(10,10);
        Position badPosition1 = new Position(-1,-1);
        Position badPosition2 = new Position(-1,10);
        Position badPosition3 = new Position(10,10);
        Position badPosition4 = new Position(10,-1);
        Position goodPosition1 = new Position(0,9);
        Position goodPosition2 = new Position(9, 0);
        Car testCar = new Car(testMap, 5, 5);
        testMap.place(testCar);
        Position occupiedPosition = new Position(5,5);

        assertFalse(testMap.canMoveTo(badPosition1));
        assertFalse(testMap.canMoveTo(badPosition2));
        assertFalse(testMap.canMoveTo(badPosition3));
        assertFalse(testMap.canMoveTo(badPosition4));
        assertTrue(testMap.canMoveTo(goodPosition1));
        assertTrue(testMap.canMoveTo(goodPosition2));
        assertFalse(testMap.canMoveTo(occupiedPosition));
    }
    @Test
    public void placeTest(){
        RectangularMap testMap = new RectangularMap(10,10);
        Position position1 = new Position(1, 1);
        Position position2 = new Position(1,2);
        Car car1 = new Car(testMap, position1);
        Car car2 = new Car(testMap, position2);
        assertTrue(testMap.place(car1));
        assertTrue(testMap.place(car2));
    }
    @Test
    public void runTest(){
        String[] testArguments = {"f", "f", "l", "r", "f", "b"};
        MoveDirection[] testDirections = OptionsParser.parse(testArguments);
        RectangularMap testMap = new RectangularMap(10,10);
        Position startPosition1 = new Position(2, 2);
        Position startPosition2 = new Position(4,2);
        Position targetPosition1 = new Position(1,3);
        Position targetPosition2 = new Position(3,3);
        Car car1 = new Car(testMap, startPosition1);
        Car car2 = new Car(testMap, startPosition2);
        testMap.place(car1);
        testMap.place(car2);
        testMap.run(testDirections);
        assertEquals(car1.getPosition(), targetPosition1);
        assertEquals(car2.getPosition(), targetPosition2);
    }
    @Test
    public void isOccupiedTest(){
        RectangularMap testMap = new RectangularMap(10,10);
        Position testPosition = new Position(5,5);
        Car testCar = new Car(testMap, testPosition);
        assertFalse(testMap.isOccupied(testPosition));
        testMap.place(testCar);
        assertTrue(testMap.isOccupied(testPosition));
    }
    @Test
    public void objectAtTest(){
        RectangularMap testMap = new RectangularMap(10,10);
        Position testPosition = new Position(5,5);
        Car testCar = new Car(testMap, testPosition);
        testMap.place(testCar);
        assertEquals(testCar, testMap.objectAt(testPosition));
    }
}