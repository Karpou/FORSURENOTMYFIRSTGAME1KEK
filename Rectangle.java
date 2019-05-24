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
public class Rectangle {
    public int x,y,w,h;
    
    Rectangle (int x, int y, int w, int h)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    Rectangle(){
        this(0,0,0,0);
    }
    
}
