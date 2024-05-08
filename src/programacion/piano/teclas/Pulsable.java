package programacion.piano.teclas;

import java.awt.*;

public interface Pulsable extends ElementoVisual{
    public void pulsar();
    public void soltar();
    public boolean estaPulsado();
    public void setColorPulsado(Color c);
    public Color getColorPulsado();
    public Color getColorNoPulsado();
    public default Color getColor(){
        Color color;
        if (estaPulsado()){
            color=this.getColorPulsado();
        }else{
            color=this.getColorNoPulsado();
        }
        return color;
    }
}
