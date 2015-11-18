import java.util.*;
public class demoGraph
{
    public static void main(String[] args)
    {
	adjList a1 =new adjList(13);
	
	a1.insertEdge(1,2,161,1);
	a1.insertEdge(2,3,90,2);
	a1.insertEdge(3,4,150,2);
	a1.insertEdge(4,5,192,1);
	a1.insertEdge(5,6,211,1);
	a1.insertEdge(6,7,192,1);
	a1.insertEdge(7,8,182,1);
	a1.insertEdge(1,8,170,1);
	a1.insertEdge(2,7,95,2);
	a1.insertEdge(6,3,229,2);
	a1.insertEdge(8,13,150,3);
	a1.insertEdge(8,10,150,3);
	a1.insertEdge(8,9,240,2);
	a1.insertEdge(6,9,134,2);
	a1.insertEdge(9,10,150,1);
	a1.insertEdge(9,12,210,3);
	a1.insertEdge(11,12,150,3);
 	a1.insertEdge(10,11,120,2);
 	
 		dijkstra(a1, 1, 12);
    }
    
    static void dijkstra(adjList a1,int source, int dest)
    {
	pQueue pq = new pQueue(a1.vertexCount());
	element v= new element(source, 0);
	int[] distance =new int[a1.vertexCount()];
	int[] path =new int[a1.vertexCount()];

	pq.insert(source,0);

	for(int i=0;i<a1.vertexCount();i++)
	    {
		distance[i]=-1;
	    }
	distance[source]=0;

	while(!pq.isEmpty())
	    {
		v =pq.getMin();
		int pvertex= v.getVertex();
		node temp =a1.list[pvertex];
		while(temp!=null)
		    {
			int dist = distance[pvertex]+temp.getDistance();
			if(distance[temp.getTvertex()]==-1)
			    {
				distance[temp.getTvertex()]=dist;
				pq.insert(temp.getTvertex(),dist);
				path[temp.getTvertex()]=pvertex;
			    }
			else if(distance[temp.getTvertex()]>dist)
			    {
				distance[temp.getTvertex()]=dist;
				pq.replace(temp.getTvertex(),dist);
				path[temp.getTvertex()]=pvertex;
			    }
			temp =temp.getNext();
		    }
	    }

	System.out.print(dest+"->");
	int index =dest;
	while(index!=source)
	    {
		System.out.print(path[index]+"->");
		index =path[index];
	    }
	System.out.println("Shortest path");

	fastestPath(a1,source,dest);
    }

 static void fastestPath(adjList a1,int source, int dest)
    {
	pQueue pq = new pQueue(a1.vertexCount());
	element v= new element(source, 0);
	int[] distance =new int[a1.vertexCount()];
	int[] path =new int[a1.vertexCount()];

	pq.insert(source,0);

	for(int i=0;i<a1.vertexCount();i++)
	    {
		distance[i]=-1;
	    }
	distance[source]=0;

	while(!pq.isEmpty())
	    {
		v =pq.getMin();
		int pvertex= v.getVertex();
		node temp =a1.list[pvertex];
		while(temp!=null)
		    {
			int dist = distance[pvertex]+temp.getSpeed();
			if(distance[temp.getTvertex()]==-1)
			    {
				distance[temp.getTvertex()]=dist;
				pq.insert(temp.getTvertex(),dist);
				path[temp.getTvertex()]=pvertex;
			    }
			else if(distance[temp.getTvertex()]>dist)
			    {
				distance[temp.getTvertex()]=dist;
				pq.replace(temp.getTvertex(),dist);
				path[temp.getTvertex()]=pvertex;
			    }
			temp =temp.getNext();
		    }
	    }

	System.out.print(dest+"->");
	int index =dest;
	while(index!=source)
	    {
		System.out.print(path[index]+"->");
		index =path[index];
	    }
	System.out.println("Fastest path");
    }

}

