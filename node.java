import java.util.*;

public class node
{
    private int traffic; //thte traffic intensity will vary dynamically
    private int distance; //the distance is fixed and is expressed in metres
    private int tvertex;  //indicates the terminal vertex
    private int speed;  //measure of how fast will it take to reach this node
    private node next;

    public node(int distance, int traffic, int tvertex) //constructor
    {
	this.traffic =traffic;
	this.distance =distance;
	this.speed = distance/traffic;
	this.tvertex =tvertex;
	this.next=null;
    }

    public node(int distance, int tvertex) //constructor
    {
	this.tvertex =tvertex;
	this.distance = distance;
	this.traffic =1; //default light traffic; 1-light; 2-moderate; 3-heavy
	this.speed =distance;
	this.next=null;
    }

    public int getTraffic() //getter method
    {
	return this.traffic;
    }

    public int getDistance()
    {
	return this.distance;
    }

    public int getTvertex()
    {
	return tvertex;
    }

    public node getNext()
    {
	return this.next;
    }

    public int getSpeed()
    {
	return this.distance/this.traffic;
    }

    public void setNext(node n)
    {
	this.next =n;
    }

    public void setTraffic(int t)
    {
	this.traffic =t;
    }

    public String toString()
    {
	return "This road has traffic intensity "+this.traffic+" and distance is "+this.distance+"m\nSpeed:"+getSpeed();
    }
}