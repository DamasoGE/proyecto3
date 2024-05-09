package programacion.piano.programa;

import programacion.piano.teclas.ElementoVisual;
import programacion.piano.teclas.Tecla;

import java.awt.*;

public abstract class Piano implements ElementoVisual{

    private int teclaInicial;

    private int teclaFinal;

    protected Point posicion;

    protected Graphics graphics;

    public Piano(int ti, int tf){
        this.teclaInicial=ti;
        this.teclaFinal=tf;
    }


    public int getTeclaInicial(){
        return this.teclaInicial;
    }

    public int getTeclaFinal(){
        return this.teclaFinal;
    }

    public abstract Tecla getTecla(int canal, int nota);

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void setPosicion(Point posicion){

        this.posicion=posicion;
    }
}
