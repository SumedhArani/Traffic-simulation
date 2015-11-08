public class testclient
{
    public static void main(String[] args)
    {
	//node n = new node(distance, traffic) 
	node n1 =new node(10);
	n1.setTraffic(1);
	node n2 =new node(20,3);
	System.out.println(n1);
	System.out.println(n2);
    }
}