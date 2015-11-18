import java.util.*;
public class demoGraph
{
    public static void main(String[] args)
    {
	adjList a1 =new adjList(7);
	a1.insertEdge(1,2,200,2);
	a1.insertEdge(2,5,300,1);
	a1.insertEdge(5,7,100,3);
	a1.insertEdge(7,6,300,2);
	a1.insertEdge(6,4,400,1);
	a1.insertEdge(4,1,400,2);
	a1.insertEdge(4,3,200,1);
	a1.insertEdge(3,2,200,1);
	a1.insertEdge(3,5,500,2);
	a1.insertEdge(3,6,700,3);
	a1.insertEdge(3,1,100,2);
	dijkstra(a1, 1, 6);
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
    }

}

