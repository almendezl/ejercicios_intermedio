
package mundo;

/**
 *
 * @author Angie Mendez
 */
public class Color {
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue){
        if(red == 255)
            this.red = red;
        else 
            this.red = 0;
        if( green == 255)
            this.green = green;
        else
            this.green = 0;
        if(blue == 255)
            this.blue = blue;
        else 
            this.blue = 0;
    }
    
    public int getRed(){
        return red;
    }
    public void setRed(int red){
        if(red == 255)
            this.red = red;
        else 
            this.red = 0;
    }
    public int getGreen(){
        return green;
    }
    public void setGreen(int green){
        if(green == 255)
            this.green = green;
        else
            this.green = 0;
    }
    public int getBlue(){
        return blue;
    }
    public void setBlue(int blue){
        if(blue == 255)
            this.blue = blue;
        else 
            this.blue = 0;
    }
    public String identificarColor(){
        if(red == 255 && green == 0 && blue == 0)
            return "Red";
        else 
            if(red == 0 && green == 255 && blue == 0)
                return "Green";
            else
                 if(red == 0 && green ==0 && blue == 255)
                     return "Blue";
                 else 
                     if(red == 255 && green== 255 && blue == 0 )
                         return "Yellow";
                    else
                         if(red ==0 && green ==255 && blue == 255)
                             return "Cyan";
                         else 
                             if(red==255 && green==0 && blue ==255)
                                 return "violet";
                             else
                                 if(red == 255 && green ==255 && blue ==255)
                                    return "White";
                                 else  
                                    return "Color no encontrado";
    }
}
