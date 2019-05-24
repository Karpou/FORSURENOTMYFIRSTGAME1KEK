
package game1;



import java.awt.Canvas;
import java.awt.Color;

import java.awt.image.BufferedImage;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;

import javax.imageio.ImageIO;

import java.io.IOException;

import java.awt.Image;

import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import java.lang.Runnable;
import java.lang.Thread;

import javax.swing.JFrame;

public class Game1 extends JFrame implements Runnable
{

private Canvas canvas = new Canvas();
  private int x = 0; //field variable.
  private int y = 0; //field variable.
  private RenderHandler Rend; //field variable.
  private BufferedImage testImage;
      
    
 public Game1() 
        {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            setBounds(00,00, 1000, 800);
            
            
            setLocationRelativeTo(null);
            
            //canvas helps with handling the buffer
            add(canvas);
            
            setVisible(true);
            
            canvas.createBufferStrategy(3);
            
            Rend = new RenderHandler(getWidth(), getHeight());
            
            testImage = loadImage("george.png");   
        }
    

//        public void paint(Graphics graphics)
//        {
//            
//            super.paint(graphics);
//            
//            graphics.setColor(Color.red);
//            
//            graphics.fillOval(200, 200, 50, 100);
//            
//        }
      
      
        
        public void update() //updates position
        {
           // x += 1;
            //y += 1;
        }
        private BufferedImage loadImage(String path)
         {
           try
           {
            BufferedImage loadedImage = ImageIO.read(Game1.class.getResource(path));
            
            BufferedImage formattedImage = new BufferedImage(loadedImage.getWidth(),loadedImage.getHeight(), BufferedImage.TYPE_INT_RGB);
            
            formattedImage.getGraphics().drawImage(loadedImage, 0, 0, null); 
            
            return formattedImage;
            
           }
           catch(IOException exception)
           {
             exception.printStackTrace();
             return null;
           }
           
        }
       
        
        public void render() //renders to the screen
        {
            
            BufferStrategy bufferStrategy = canvas.getBufferStrategy();
            Graphics graphics = bufferStrategy.getDrawGraphics();
            super.paint(graphics);
            
            graphics.setColor(Color.BLACK);
            graphics.fillRect(0, 0, getWidth(), getHeight());
          
            bufferStrategy = canvas.getBufferStrategy();
             
         //   graphics.setColor(Color.red);

          //  graphics.fillOval(x, y, 50, 100);
              
            Rend.renderImage(testImage, 100, 100, 1, 1);
            Rend.render(graphics);
          
            graphics.dispose();
 
            bufferStrategy.show();
             
        }
        
        public void run()
        {
            BufferStrategy bufferStrategy = canvas.getBufferStrategy();
//             //sets oval
           int i = 0;
           int x = 0; 
           
            Long lastTime = System.nanoTime(); 
            
            double nanoSecondConversion =  1000000000.0 / 60; // The frames per second (60)
            
            double ChangeInSec = 0;
            
            
            while (true) {
                Long now = System.nanoTime();
                
                ChangeInSec += (now - lastTime) / nanoSecondConversion;
                
               // System.out.println(ChangeInSec);
                
                while(ChangeInSec >= 1) 
                    {
                      update();  
                      ChangeInSec = 0;
                    }
                
                render(); //
                
                
                lastTime = now;
                }
//            while(true){
//             i++;
//             if (i == 10) {
//             i = 0;
//             x++;
//                }
//          }
        }
                
        
        
        public static void main(String[] args) 
        {
          //  RenderHandler handle = new RenderHandler();
            Game1 Game = new Game1();
            Thread Thready = new Thread(Game);
            Thready.start();
            
        }
}

/*
Buffered image, an image with a buffer. 
Allows us to edit all of the pixels in the buffer.
Colormodel and a raster of image data.
    ColorModel handles the RGB compennets 
    Raster is a a rectangular array of pixels.
*/
// Render(); This will run as fast the any computer can handle it.

// Update(); This will run at a specific rate.