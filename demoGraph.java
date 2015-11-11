import java.util.*;
public class demoGraph
{
    public static void main(String[] args)
    {
	adjList a1 =new adjList(5);
	a1.insertEdge(1,100,2);
	a1.insertEdge(1,300,3);
	a1.insertEdge(2,400,4);
	a1.insertEdge(3,200,4);
	a1.insertEdge(4,600,5);
	a1.display();
	dijkstra(a1, 2);
    }
    
    static void dijkstra(adjList a1,int source)
    {
	pQueue pq = new pQueue(a1.vertexCount());
	int w;
	element v;
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
	System.out.println(Arrays.toString(path));
    }

}

