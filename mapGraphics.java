import java.awt.*; 
import java.util.*;
import java.*;
import java.io.*;


class mapGraphics extends Canvas
{

   static final int maxX = 1000;
   static final int maxY = 700;

  public mapGraphics()
    { 
    	setSize(200, 200); 
    	setBackground(Color.white); 
    }


  public static void main(String[] argS)
  {
    mapGraphics GP = new mapGraphics();

    Frame aFrame = new Frame(); 
    aFrame.setSize(maxX, maxY);  

    aFrame.add(GP);
    aFrame.setVisible(true);
   }
   
   public void paint(Graphics g)
   {

                                 /////////////////////////////////////////////////////////////////////////////

            //Infinite read loop.

            //Drawings and equivalent strings
            // 1.  CHAR_*_x_y_COLOR             // will print the specified char
            // 2.  RECT_x1_y1_x2_y2_COLOR       // will draw a rectangle 
            // 3.  CIRL_x_y_radius_COLOR         // circle
            // 4.  LINE_x1_y1_x2_y2_COLOR       // line

            // Note:
            //      1. Coordinate must be 3 digit number
            //      2. COLOR codes  : BLU , BLK , RED , YLW , GRN .
            //      3. Assume coordinate system of mathematics. 

             
        int pos=1; //records the next line number to be read
        String str=null; 

        g.setColor(Color.black);   
        
 
        while(true)
        {
          try{
               str = readFile(pos);
            }

         catch(Exception e){System.out.println("File Error!!");}   

          if(str!=null)
           {
             System.out.print(str);
             pos++;
             
              //___________________________________  draw module  

                            
             
              String fig ="" +  str.charAt(0) + str.charAt(1) + str.charAt(2) + str.charAt(3);

              g.setColor(Color.BLACK); //default color = BLACK

              

              if(fig.equals("CHAR") == true) /// for character 
              {
                int x = 0;
                int y = 0; 
                 String color ="" + str.charAt(15) + str.charAt(16) + str.charAt(17);

                  if(color.equals("BLU")) g.setColor(Color.BLUE);
                  if(color.equals("BLK")) g.setColor(Color.BLACK);
                  if(color.equals("RED")) g.setColor(Color.RED);
                  if(color.equals("YLW")) g.setColor(Color.YELLOW);
                  if(color.equals("GRN")) g.setColor(Color.GREEN);

                  x = ((int)str.charAt(7) -48)*100 + ((int)str.charAt(8) -48)*10 + ((int)str.charAt(9) -48) ;
                  y = ((int)str.charAt(11) -48)*100 + ((int)str.charAt(12) -48)*10 + ((int)str.charAt(13) -48) ;   
  
                  System.out.println("\n"+"Character -"+" "+str.charAt(5)+" "+x+" "+y+color+"\n"); 
                  g.drawString(""+str.charAt(5), x, maxY-y); 
              }


              else if(fig.equals("LINE") == true) /// for Line
              {
                int x1 = 0;
                int y1 = 0;
                int x2 = 0;
                int y2 = 0;
                 
                 String color ="" + str.charAt(21) + str.charAt(22) + str.charAt(23);

                  if(color.equals("BLU")) g.setColor(Color.BLUE);
                  if(color.equals("BLK")) g.setColor(Color.BLACK);
                  if(color.equals("RED")) g.setColor(Color.RED);
                  if(color.equals("YLW")) g.setColor(Color.YELLOW);
                  if(color.equals("GRN")) g.setColor(Color.GREEN);

                  x1 = ((int)str.charAt(5) -48)*100 + ((int)str.charAt(6) -48)*10 + ((int)str.charAt(7) -48) ;
                  y1 = ((int)str.charAt(9) -48)*100 + ((int)str.charAt(10) -48)*10 + ((int)str.charAt(11) -48) ;   
                  x2 = ((int)str.charAt(13) -48)*100 + ((int)str.charAt(14) -48)*10 + ((int)str.charAt(15) -48) ;
                  y2 = ((int)str.charAt(17) -48)*100 + ((int)str.charAt(18) -48)*10 + ((int)str.charAt(19) -48) ;    

                  System.out.println("\n"+"Line - "+x1+" "+y1+" "+x2+" "+y2+" "+color+"\n"); 
                  g.drawLine(x1, maxY-y1, x2, maxY-y2);
              }




              else if(fig.equals("RECT") == true) /// for rectangle 
              {
                int x1 = 0;
                int y1 = 0;
                int x2 = 0;
                int y2 = 0;
                 
                 String color ="" + str.charAt(21) + str.charAt(22) + str.charAt(23);

                  if(color.equals("BLU")) g.setColor(Color.BLUE);
                  if(color.equals("BLK")) g.setColor(Color.BLACK);
                  if(color.equals("RED")) g.setColor(Color.RED);
                  if(color.equals("YLW")) g.setColor(Color.YELLOW);
                  if(color.equals("GRN")) g.setColor(Color.GREEN);

                  x1 = ((int)str.charAt(5) -48)*100 + ((int)str.charAt(6) -48)*10 + ((int)str.charAt(7) -48) ;
                  y1 = ((int)str.charAt(9) -48)*100 + ((int)str.charAt(10) -48)*10 + ((int)str.charAt(11) -48) ;   
                  x2 = ((int)str.charAt(13) -48)*100 + ((int)str.charAt(14) -48)*10 + ((int)str.charAt(15) -48) ;
                  y2 = ((int)str.charAt(17) -48)*100 + ((int)str.charAt(18) -48)*10 + ((int)str.charAt(19) -48) ;    

                  System.out.println("\n"+"Rectangle - "+x1+" "+y1+" "+x2+" "+y2+" "+color+"\n"); 
                  g.drawRect(x1, maxY-y1, x2, maxY-y2);
                  g.fillRect(x1, maxY-y1, x2, maxY-y2);
              }


              else if(fig.equals("CIRL") == true) /// for rectangle 
              {
                int x = 0;
                int y = 0;
                int r = 0;
                 
                 String color ="" + str.charAt(17) + str.charAt(18) + str.charAt(19);

                  if(color.equals("BLU")) g.setColor(Color.BLUE);
                  if(color.equals("BLK")) g.setColor(Color.BLACK);
                  if(color.equals("RED")) g.setColor(Color.RED);
                  if(color.equals("YLW")) g.setColor(Color.YELLOW);
                  if(color.equals("GRN")) g.setColor(Color.GREEN);

                  x = ((int)str.charAt(5) -48)*100 + ((int)str.charAt(6) -48)*10 + ((int)str.charAt(7) -48) ;
                  y = ((int)str.charAt(9) -48)*100 + ((int)str.charAt(10) -48)*10 + ((int)str.charAt(11) -48) ;   
                  r = ((int)str.charAt(13) -48)*100 + ((int)str.charAt(14) -48)*10 + ((int)str.charAt(15) -48) ;


                  /*x = x - (int)(1.414*r); 
                  y = y - (int)(1.414*r);*/ 

                  System.out.println("\n"+"Circle - "+x+" "+y+" "+r+" "+color+"\n"); 

                  r = r/3;
                  x = x -r;
                  y = maxY - (y+(int)(r*1.2));

                  r = r*2;
                  g.drawOval(x, y, r, r);
                  g.fillOval(x, y, r, r);


              }



              // _________________  
           }
          }


   }

     public static String readFile(int index) throws IOException
    {
                    BufferedReader fin = null;

            int lc=0; // line counter        

            try
            {
                fin = new BufferedReader(new FileReader("test.txt"));


                String ch = null;

                while(true)
                {
                    ch = fin.readLine();
                     if(ch == null)
                        break; 
        
                    lc++;
                    if(lc == index)
                        return ch;
                }
            }

            catch(IOException e)
            {
                System.out.println(e);
            }

            finally
            {
                if(fin != null) fin.close();
            }
         
         return null;       
        }



}   
     