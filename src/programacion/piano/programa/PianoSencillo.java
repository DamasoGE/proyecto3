package programacion.piano.programa;

import programacion.piano.teclas.ElementoVisual;
import programacion.piano.teclas.Tecla;
import programacion.piano.teclas.TeclaFactory;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano{

    private Map<Integer, Tecla> teclas;

    public PianoSencillo(int teclaIncial, int teclaFinal) {

        super(teclaIncial, teclaFinal);
        this.teclas=new HashMap<>();

        for (int i = teclaIncial; i <=teclaFinal ; i++) {

            Tecla tecla=TeclaFactory.crearTecla(i);
            this.teclas.put(i,tecla);
        }
    }

    @Override
    public void dibujar() {

        for(Tecla tecla: teclas.values()){

            tecla.setGraphics(graphics);
            tecla.setPosicion(posicion);

            posicion.x+=getAnchura();

            tecla.dibujar();


        }


    }

    @Override
    public void setPosicion(int x, int y) {

        this.posicion.x=x;
        this.posicion.y=y;

    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }



}
