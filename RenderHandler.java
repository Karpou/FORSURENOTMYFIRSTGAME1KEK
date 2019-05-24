package game1;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;



/**
 * @author philipkarpouzie
 */
public class RenderHandler 
{
    
    private BufferedImage view;
    private int[] pixels;
    private Rectangle camera;
    
    public RenderHandler(int width, int height)
    {
        //creates a buffered image to use the view
        view = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        camera = new Rectangle(0,0, width, height);
        
        camera.x = -1800;
        camera.y = -300;
        
        pixels = ((DataBufferInt)view.getRaster().getDataBuffer()).getData();
        
         for(int heightindex = 0; heightindex < height; heightindex++)
         {
            int randomPixel = (int)(Math.random() * 0x00C2C7); 
            pixels[heightindex] = (int)(Math.random() * 0x00C2C7);
             
            for(int widthIndex = 0; widthIndex < width; widthIndex++)
            {
                pixels[heightindex*width + widthIndex] = randomPixel;
                pixels[widthIndex] = (int)(Math.random() * 0x00C2C7);
            }

        }
    }
    
    public void render(Graphics graphics)
    {
       
        graphics.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
    }
    
    public void renderImage(BufferedImage image, int xPosition, int yPosition, int xZoom, int yZoom)
    {
        int[] imagePixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        for (int y = 0; y <image.getHeight(); y++)
         for (int x= 0; x <image.getWidth(); x++)
          for(int yZoomPosition = 0; yZoomPosition < yZoom; yZoomPosition++)
           for(int xZoomPosition = 0; xZoomPosition < xZoom; xZoomPosition++)
             pixels[ ((x * xZoom) + xPosition + xZoomPosition ) + ((y * yZoom) + yPosition + yZoomPosition) * view.getWidth()]
             = imagePixels[x + y * image.getWidth()];
     }
    private void setPixel(int pixel, int x, int y)
    {
        if (x >= camera.x && y >= camera.y && x <= camera.x + camera.w && y <= camera.y +camera.h){
            int pixelIndex = (x - camera.x) + (y - camera.y) *view.getWidth();
              if(pixels.length >= pixelIndex)
              {
              pixels[pixelIndex] = pixel;
              }
        }
    }
    
    
}
