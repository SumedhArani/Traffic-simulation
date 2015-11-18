import java.util.Random;
import java.util.Scanner;
import java.io.*;

class trafficSimulation
{
	public static void main(String[] args)
	{

       circle(100,100,50,"GRN");
       line(200,200,500,600,"BLU");
       character('@',400,400,"BLK");

	}


    public static void circle(int x, int y, int r, String col )
    {

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