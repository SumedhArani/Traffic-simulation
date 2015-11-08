import java.util.*;

public class node
{
    private int traffic; //thte traffic intensity will vary dynamically
    private final int distance; //the distance is fixed and is expressed in metres
    private final node tvertex;  //indicates the terminal vertex
    private double speed;  //measure of how fast will it take to reach this node

    public node(int distance, int traffic, node tvertex) //constructor
    {
	this.traffic =traffic;
	this.distance =distance;
	this.speed = distance/traffic;
	this.tvertex =tvertex;
    }

    public node(int distance, node tvertex) //constructor
    {
	this.tvertex =tvertex;
	this.distance = distance;
	this.traffic =1; //default light traffic; 1-light; 2-moderate; 3-heavy
	this.speed =distance;
    }

    public int getTraffic() //getter method
    {
	return this.traffic;
    }

    public int getDistance()
    {
	return this.distance;
    }

    public node getTvertex()
    {
	return tvertex;
    }

    public void setTraffic(int t)
    {
	this.traffic =t;
    }

    public String toString()
    {
	return "This road has traffic intensity "+this.traffic+" and distance is "+this.distance+"m\nSpeed:"+this.speed;
    }
}