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

    public void insertEdge(int i, int j, int weight, int traffic) //oVertex, tVertex, distance, traffic
    {
	node p;
	p=list[i];
	node temp = new node(weight,j);
	temp.setTraffic(traffic);
	if(p==null)
	    list[i]=temp;
	else
	    {
		while(p.getNext()!=null)
		    p=p.getNext();
		p.setNext(temp);
	    }

	node p1;
        p1=list[j];
        node temp1 = new node(weight,i);
	temp1.setTraffic(traffic);
        if(p1==null)
            list[j]=temp1;
        else
            {
                while(p1.getNext()!=null)
                    p1=p1.getNext();
                p1.setNext(temp1);
            }
    }

    public void setTraffic(int i, int j, int traffic)
    {
	node p =list[i];
	node p1 =list[j];
	try
	    {
		while(p.getTvertex()!=j)
		    {
			p=p.getNext();
		    }
		p.setTraffic(traffic);

		while(p1.getTvertex()!=i)
                    {
                        p1=p1.getNext();
                    }
                p1.setTraffic(traffic);
	    }

	catch(Exception e)
	    {
		System.out.println(e);
	    }

    }

    public int vertexCount()
    {
	return vertices+1;
    }
    
    public void deleteEdge(int i, int j, int weight)
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