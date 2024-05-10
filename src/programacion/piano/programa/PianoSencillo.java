package programacion.piano.programa;

import programacion.piano.teclas.*;

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
            tecla.setPosicion(posicion.x, posicion.y);
            posicion.x+=tecla.getAnchura();
            tecla.dibujar();
        }

    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }

}
