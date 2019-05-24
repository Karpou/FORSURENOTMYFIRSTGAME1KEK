/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game1;

/**
 *
 * @author philipkarpouzie
 */
public class Player implements InterFaceforPlayer {
    
   double y, yVel, x, xVel;
   boolean upAccel, downAccel, leftAccel, rightAccel;
   final double GRAVITY = .9, FRICTION = .9;
   int player;
    
   public void space()
   {
       
   }
    public void thingy()
    {
        
    }
    public void MoveY()
    {
      if(upAccel)
      {
          yVel += -2;
      }
      else if (downAccel)
      {
        yVel -= -2;
      }
      else if(!upAccel && !downAccel)
      {
          yVel *= GRAVITY;
      }
    }
    public void MoveX()
    {
       if(rightAccel)
      {
          xVel += -2;
      }
      else if (leftAccel)
      {
        xVel -= -2;
      }
      else if(!rightAccel && !leftAccel)
      {
          xVel *= FRICTION;
      } 
    }
    public void setUpAccel(boolean input)
    {
     upAccel = input;
    }
    public void setDownAccel(boolean input)
    {
     downAccel = input;
    }
    public void setRightAccel(boolean input)
    {
     rightAccel = input;   
    }
      public void setLetfAccel(boolean input)
    {
      leftAccel = input;
    }
}
