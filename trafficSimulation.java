import java.util.Random;
import java.util.Scanner;
import java.io.*;

class trafficSimulation
{
	public static void main(String[] args)
	{

    adjList a1 =new adjList(13);
  
    a1.insertEdge(1,2,161,3);  //1
    a1.insertEdge(2,3,90,2);  //2
    a1.insertEdge(3,4,150,2);  //3
    a1.insertEdge(4,5,192,1);  //4
    a1.insertEdge(5,6,211,3);  //5
    a1.insertEdge(6,7,192,1);  //6
    a1.insertEdge(7,8,182,2);  //7
    a1.insertEdge(1,8,170,1);  //8
    a1.insertEdge(2,7,95,2);  //9
    a1.insertEdge(6,3,229,2);  //10
    a1.insertEdge(8,13,150,3);  //11
    a1.insertEdge(8,10,150,1);  //12
    a1.insertEdge(8,9,240,2);  //13
    a1.insertEdge(6,9,134,2);  //14
    a1.insertEdge(9,10,150,1);  //15
    a1.insertEdge(9,12,210,3);  //16
    a1.insertEdge(11,12,150,3);  //17
    a1.insertEdge(10,11,120,2);  //18
  
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

    public static void createGraph()
    {

      circle(60,270,40,"GRN");
      circle(120,120,40,"GRN");
      circle(150,210,40,"GRN");
      circle(180,390,40,"GRN");
      circle(90,510,40,"GRN");
      circle(210,120,40,"GRN");
      circle(300,330,40,"GRN");
      circle(330,30,40,"GRN");
      circle(300,480,40,"GRN");
      circle(450,180,40,"GRN");
      circle(420,390,40,"GRN");
      circle(420,480,40,"GRN");
      circle(570,540,40,"GRN");


      line(60,270,120,120,"BLK");  //1
      line(120,120,210,120,"BLK"); //2
      line(210,120,330,30,"BLK");  //3
      line(330,30,450,180,"BLK");  //4
      line(450,180,300,330,"BLK");  //5
      line(300,330,150,210,"BLK");  //6
      line(150,210,180,390,"BLK");  //7
      line(60,270,180,390,"BLK");  //8
      line(120,120,150,210,"BLK");  //9
      line(300,330,210,120,"BLK");  //10
      line(180,390,90,510,"BLK");  //11
      line(180,390,300,480,"BLK");  //12
      line(180,390,420,390,"BLK");  //13
      line(300,330,420,390,"BLK");  //14
      line(420,390,300,480,"BLK");  //15
      line(420,390,570,540,"BLK");  //16
      line(420,480,570,540,"BLK");  //17
      line(300,480,420,480,"BLK");  //18
      //line(300,480,570,540,"BLK");  //19
      

    }

    public static void circle(int x, int y, int r, String col )
    {
    	y = y +40; // to shift the graph by 20 pixels up

    	PrintWriter fout = null;
    	BufferedReader fin = null;
    	String str = new String("");

    	String temp = new String("");
   
    	
    	///Creating the string

        temp = temp + "CIRL_";

        temp = temp + (char)((x/100)+48);      
        temp = temp + (char)(((x%100)/10)+48);
        temp = temp +(char)((x%10)+48);

        temp = temp + "_";

        temp = temp + (char)((y/100)+48);     
        temp = temp + (char)(((y%100)/10)+48);
        temp = temp +(char)((y%10)+48);


        temp = temp + "_";

        temp = temp + (char)((r/100)+48);      
        temp = temp + (char)(((r%100)/10)+48);
        temp = temp +(char)((r%10)+48);

        temp = temp + "_" + col + "     -----Ghazz Sumedh !!";
       
        

    	

    	try
    	{
            fin = new BufferedReader(new FileReader("test.txt"));
              String ch;
             

              ch = str = fin.readLine();

             while(ch!= null) 
             {
                 ch = fin.readLine();
                 if(ch == null)
                 	 break;

             	str = str +"\n"+ch;
             }
    	}

    	catch(Exception e)
    	{
    		 System.out.println("File output error !!");
    	}

    	/*finally
		{
		    if(fin != null) fin.close();
		}*/

       // ___________Store back to the file  
		try
    	{
            fout = new PrintWriter(new FileWriter("test.txt"));
            str = str + "\n" + temp; 
            fout.println(str);
    	}

    	catch(Exception e)
    	{System.out.println("File output error !!");}

    	finally
		{
		    if(fout != null) fout.close();
		}
    }



    public static void line(int x1, int y1, int x2, int y2, String col )
    {
    	y1 = y1 +40; // to shift the graph by 20 pixels up
    	y2 = y2 +40;

    	PrintWriter fout = null;
    	BufferedReader fin = null;
    	String str = new String("");

    	String temp = new String("");
   
    	
    	///Creating the string

        temp = temp + "LINE_";

        temp = temp + (char)((x1/100)+48);      
        temp = temp + (char)(((x1%100)/10)+48);
        temp = temp +(char)((x1%10)+48);

        temp = temp + "_";

        temp = temp + (char)((y1/100)+48);     
        temp = temp + (char)(((y1%100)/10)+48);
        temp = temp +(char)((y1%10)+48);

        temp = temp + "_";

        temp = temp + (char)((x2/100)+48);      
        temp = temp + (char)(((x2%100)/10)+48);
        temp = temp +(char)((x2%10)+48);

        temp = temp + "_";

        temp = temp + (char)((y2/100)+48);     
        temp = temp + (char)(((y2%100)/10)+48);
        temp = temp +(char)((y2%10)+48);

        
        temp = temp + "_" + col + "     -----Ghazz Sumedh !!";
       
    	

    	try
    	{
            fin = new BufferedReader(new FileReader("test.txt"));
              String ch;
             

              ch = str = fin.readLine();

             while(ch!= null) 
             {
                 ch = fin.readLine();
                 if(ch == null)
                 	 break;

             	str = str +"\n"+ch;
             }
    	}

    	catch(Exception e)
    	{
    		 System.out.println("File output error !!");
    	}

    	/*finally
		{
		    if(fin != null) fin.close();
		}*/

       // ___________Store back to the file  
		try
    	{
            fout = new PrintWriter(new FileWriter("test.txt"));
            str = str + "\n" + temp; 
            fout.println(str);
    	}

    	catch(Exception e)
    	{System.out.println("File output error !!");}

    	finally
		{
		    if(fout != null) fout.close();
		}
    }



public static void character(char ch_dash, int x, int y, String col ) 
    {

    	y = y +40; // to shift the graph by 20 pixels up

    	PrintWriter fout = null;
    	BufferedReader fin = null;
    	String str = new String("");

    	String temp = new String("");
   
    	
    	///Creating the string

        temp = temp + "CHAR_" + ch_dash +"_";

        temp = temp + (char)((x/100)+48);      
        temp = temp + (char)(((x%100)/10)+48);
        temp = temp +(char)((x%10)+48);

        temp = temp + "_";

        temp = temp + (char)((y/100)+48);     
        temp = temp + (char)(((y%100)/10)+48);
        temp = temp +(char)((y%10)+48);

        temp = temp + "_" + col + "     -----Ghazz Sumedh !!";
       
            	

    	try
    	{
            fin = new BufferedReader(new FileReader("test.txt"));
              String ch;
             

              ch = str = fin.readLine();

             while(ch!= null) 
             {
                 ch = fin.readLine();
                 if(ch == null)
                 	 break;

             	str = str +"\n"+ch;
             }
    	}

    	catch(Exception e)
    	{
    		 System.out.println("File output error !!");
    	}

    	/*finally
		{
		    if(fin != null) fin.close();
		}*/

       // ___________Store back to the file  
		try
    	{
            fout = new PrintWriter(new FileWriter("test.txt"));
            str = str + "\n" + temp; 
            fout.println(str);
    	}

    	catch(Exception e)
    	{System.out.println("File output error !!");}

    	finally
		{
		    if(fout != null) fout.close();
		}
    }

	public static int getRno()
	{
		Random rand = new Random();
		double rn=0;

		rn = rand.nextDouble();
		int no = (int)(rn*10);
		no = no %3 ; 
		//System.out.println(no+1);
	
        return no;   
	}
}