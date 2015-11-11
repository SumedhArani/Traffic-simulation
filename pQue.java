public class pQue
{
    private int[] q;
    private int size;
    private int count;
    public pQue(int sz)
    {
	q=new int[sz];
	size=sz;
	count=0;
    }
  
    public void display()
    {
	System.out.println();
	for(int i=0;i<count;i++)
	    {
		System.out.print(" "+ q[i]);
		System.out.print(","+ q[i]);
		System.out.print("---");
	    }
    }

    public int getMin()
    {
	int t;
	t=q[0];
	q[0]=q[count-1]; //shift the last element to the first
	count--; // decrease the size of the heap
	adjust(); //recreating the minimum heap
	return t;
    }

    public void adjust() //trickle down
    {
	int key;
	int j=0;
	key =q[j]; //root
	int i=2*j+1; //left child

	while(i<=count-1)
	    {
		if((i+1)<=count-1) //i+1 =2*j+2 => right child
		    {
			if(q[i+1]<=q[i])
			    i++; //index position now goes to the right child
		    }

		if (key>q[i]) //trickle down
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
       
    public void insert(int key)
    {
	int i,j;
	q[count++] =key; //insert at the end of the heap

	i =count-1;
	j =(i-1)/2; //find parent of the inserted element
	
	while(i>0 && key<q[j]) //if key<parent => trickle up
	    {
		q[i]=q[j]; //move the parent down
		i=j;       
		j=(i-1)/2; //find the new parent
	    }
	q[i]= key; //inserting the key in it's right place
    }
}