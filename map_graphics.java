import javax.swing.JFrame;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout; 

    public class map_graphics extends JPanel
    {
        public map_graphics()                       // set up graphics window
        {
            super();
            setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g)  // draw graphics in the panel
        {
            int width = getWidth();             // width of window in pixels
            int height = getHeight();           // height of window in pixels

            super.paintComponent(g);            // call superclass to make panel display correctly


            // Drawing code goes here
        }

        public static void main(String[] args)
        {
            int maxX, maxY;
            map_graphics panel = new map_graphics();                            // window for drawing
            JFrame application = new JFrame();                            // the program itself
            
            application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
                                                                          // when it is closed
            application.add(panel);           

            maxX = 1000;
            maxY = 700;
            application.setSize(maxX, maxY);         // window is 500 pixels wide, 400 high
            application.setVisible(true);  

            /////////////////////////////////////////////////////////////////////////////

            //Infinite read loop.

            //Drawings and equivalent strings
            // 1.  CHAR_*_x_y_COLOR             // will print the specified char
            // 2.  RECT_x1_y1_x2_y2_COLOR       // will draw a rectangle 
            // 3.  CIR_x_y_radius_COLOR         // circle
            // 4.  LINE_x1_y1_x2_y2_COLOR       // line

            // Note:
            //      1. Coordinate must be 3 digit number
            //      2. COLOR codes  : BLUE , BLACK , RED , YELLOW , GREEN .
            //      3. Assume coordinate system of mathematics. 


            FileReader fin = null;

            try
            {
                fin = new BufferedReader(new FileReader("test.txt"));


                String ch;

                while((ch = fin.readLine()) != null)
                {
                    fout.println(ch);
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
                
        }

    }

