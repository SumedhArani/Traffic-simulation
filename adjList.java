public class adjList
{
    node[] list;
    private int vertices;
    int []visit;

    public adjList(int v)
    {
	vertices =v;
	list = new node[v+1];
	visit = new int[v+1];
    }

    public void insertEdge(int i, int weight,int j) //oVertex, distance, tVertex
    {
	node p;
	p=list[i];
	node temp = new node(weight,j);
	if(p==null)
	    list[i]=temp;
	else
	    {
		while(p.getNext()!=null)
		    p=p.getNext();
		p.setNext(temp);
	    }
    }

    public void deleteEdge(int i, int weight, int j)
    {
	node p =list[i];
	node q =null;

	//empty
	if(p==null)
            {
		System.out.println("No edges to delete");
	    }   
	
	else
	    {
		//first 
	    if(p.getTvertex()==j && p.getDistance()==weight)
		{
		    list[i] =p.getNext();
		}
	    
	    else
		{
		    while(p.getNext()!=null && (p.getTvertex()!=j && p.getDistance()!=weight))
		    {
			q=p;
			p =p.getNext();
		    }
		    
		    //last node reached but edge not found
		    if(p.getTvertex()==j && p.getDistance()==weight)
			q.setNext(p.getNext());
		    else
			System.out.println("Edge not found");
		}
	    }
    }

    public void display()
    {
	for(int i=1; i<=vertices; i++)
	    {
		node temp =list[i];
		System.out.println("-----");
		while(temp!=null)
		    {
			System.out.println(temp);
			temp =temp.getNext();
		    }
	    }
    }
}