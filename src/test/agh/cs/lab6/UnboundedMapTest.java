package agh.cs.lab6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UnboundedMapTest {
    @Test
    public void canMoveToTest(){
        List<HayStack> testHayStacks = new ArrayList<HayStack>();
        Position stackPosition = new Position(2,2);
        HayStack testStack = new HayStack(stackPosition);
        testHayStacks.add(testStack);
        UnboundedMap testMap = new UnboundedMap(testHayStacks);

        Position testPosition = new Position(5,5);
        Car testCar = new Car(testMap, testPosition);
        assertTrue(testMap.canMoveTo(testPosition));
        testMap.place(testCar);
        assertFalse(testMap.canMoveTo(testPosition));
        assertFalse(testMap.canMoveTo(stackPosition));
    }
    @Test
    public void placeTest(){
        List<HayStack> testHayStacks = new ArrayList<HayStack>();
        Position stackPosition = new Position(2,2);
        HayStack testStack = new HayStack(stackPosition);
        testHayStacks.add(testStack);
        UnboundedMap testMap = new UnboundedMap(testHayStacks);

        Position position1 = new Position(5,5);
        Car testCar = new Car(testMap, position1);
        assertTrue(testMap.place(testCar));
    }
    @Test
    public void runTest(){
        String[] testArguments = {"f", "f", "l", "r", "f", "b"};
        MoveDirection[] testDirections = OptionsParser.parse(testArguments);
        List<HayStack> testHayStacks = new ArrayList<HayStack>();
        Position stackPosition = new Position(1,3);
        HayStack testStack = new HayStack(stackPosition);
        testHayStacks.add(testStack);
        UnboundedMap testMap = new UnboundedMap(testHayStacks);

        Position startPosition1 = new Position(2, 2);
        Position startPosition2 = new Position(4,2);
        Position targetPosition1 = new Position(2,3);
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
        List<HayStack> testHayStacks = new ArrayList<HayStack>();
        Position stackPosition = new Position(2,2);
        HayStack testStack = new HayStack(stackPosition);
        testHayStacks.add(testStack);
        UnboundedMap testMap = new UnboundedMap(testHayStacks);

        Position testPosition = new Position(5,5);
        Car testCar = new Car(testMap, testPosition);
        assertFalse(testMap.isOccupied(testPosition));
        testMap.place(testCar);
        assertTrue(testMap.isOccupied(testPosition));
        assertTrue(testMap.isOccupied(stackPosition));
    }
    @Test
    public void objectAtTest(){
        List<HayStack> testHayStacks = new ArrayList<HayStack>();
        Position stackPosition = new Position(2,2);
        HayStack testStack = new HayStack(stackPosition);
        testHayStacks.add(testStack);
        UnboundedMap testMap = new UnboundedMap(testHayStacks);
        Position carPosition = new Position(5,5);
        Car testCar = new Car(testMap, carPosition);
        testMap.place(testCar);

        assertEquals(testCar, (Car)testMap.objectAt(carPosition));
        assertEquals(testStack, (HayStack)testMap.objectAt(stackPosition));
    }
}
