package programacion.piano.programa;

import programacion.piano.teclas.Tecla;
import programacion.piano.teclas.TeclaFactory;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano{

    private Map<Integer, Tecla> teclas;

    public PianoSencillo(int teclaInicial, int teclaFinal){
        super(teclaInicial, teclaFinal);
        teclas = new HashMap<>();

        for(int i=teclaInicial; i<=teclaFinal; i++){
            Tecla t = TeclaFactory.crearTecla(i);
            teclas.put(i, t);
        }
    }

    @Override
    public void dibujar() {
        for(Tecla t : teclas.values()){
            t.setGraphics(graphics);
            t.setPosicion(posicion);
        }
    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }

    @Override
    public void setPosicion(int x, int y) {
        Point p = new Point(x,y);
        p.setLocation(x,y);
    }


    @Override
    public int getAnchura() {
        return 25;
    }

    @Override
    public int getAltura() {
        return 100;
    }
}
