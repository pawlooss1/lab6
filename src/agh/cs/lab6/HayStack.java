package agh.cs.lab6;

/**
 * Created by Student33 on 2018-10-29.
 */
public class HayStack {
    private Position position;

    public HayStack(Position initialPosition){
        this.position = initialPosition;
    }
    public Position getPosition(){
        return this.position;
    }
    public String toString(){
        return "S";
    }
}
