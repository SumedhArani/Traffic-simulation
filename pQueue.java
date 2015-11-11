class element 
{
    private int vertex;
    private int weight;

    element(int v, int w)
    {
	this.vertex =v;
	this.weight =w;
    }

    public int getVertex()
    {
	return vertex;
    }
 
    public int getWeight()
    {
	return weight;
    }

    public void setValues(int v, int w)
    {
	vertex =v;
	weight =w;	
    }
}
    
public class pQueue
{
    private element[] q;
    private int size;
    private int count;
    public pQueue(int sz)
    {
	q=new element[sz];
	size=sz;
	count=0;
    }
  
    public void display()
    {
	System.out.println();
	for(int i=0;i<count;i++)
	    {
		System.out.print(" "+ q[i].getVertex());
		System.out.print(","+ q[i].getWeight());
		System.out.print("---");
	    }
    }

    public boolean isEmpty()
    {
	if (count==0)
	    return true;
	else
	    return false;
    }

    public element getMin()
    {
	element t;
	t=q[0];
	q[0]=q[count-1]; //shift the last element to the first
	count--; // decrease the size of the heap
	adjust(); //recreating the minimum heap
	return t;
    }

    public void adjust() //trickle down
    {
	element key;
	int j=0;
	key =q[j]; //root
	int i=2*j+1; //left child

	while(i<=count-1)
	    {
		if((i+1)<=count-1) //i+1 =2*j+2 => right child
		    {
			if(q[i+1].getWeight()<=q[i].getWeight())
			    i++; //index position now goes to the right child
		    }

		if (key.getWeight()>q[i].getWeight()) //trickle down
		    {
			q[j]=q[i]; //moving the child up as it's a min heap
			j=i; //the key has the index now of the child that has been moved up
			//earlier child's postion is now the parent
			i=2*j+1;
		    }
		else
		    break;
	    }
	q[j]=key; //finally insert the child in its' rightful place
    }

    public void replace(int v, int w)
    {
	for(int i=0; i<count; i++)
	    {
		if(v==q[i].getVertex())
		    q[i].setValues(v,w);
	    }
    }
		   
    public void insert(int v, int w)
    {
	int i,j;
	element temp=new element(v,w);
	q[count++] =temp; //insert at the end of the heap

	i =count-1;
	j =(i-1)/2; //find parent of the inserted element
	
	while(i>0 && temp.getWeight()<q[j].getWeight()) //if key<parent => trickle up
	    {
		q[i]=q[j]; //move the parent down
		i=j;       
		j=(i-1)/2; //find the new parent
	    }
	q[i]= temp; //inserting the key in it's right place
    }
}
		
