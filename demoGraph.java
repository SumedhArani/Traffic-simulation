import java.util.*;
public class demoGraph
{
    public static void main(String[] args)
    {
	adjList a1 =new adjList(4);
	a1.insertEdge(1,200,2);
	a1.insertEdge(1,500,3);
	a1.insertEdge(2,900,4);
	a1.insertEdge(3,400,4);
    }
}