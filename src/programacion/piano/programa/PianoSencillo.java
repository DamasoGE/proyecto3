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
            if(tecla instanceof TeclaBlanca1 teclaBlanca1){
                teclaBlanca1.setGraphics(graphics);
                teclaBlanca1.setPosicion(posicion.x, posicion.y);
                posicion.x+=teclaBlanca1.getAnchura();
            } else if (tecla instanceof TeclaBlanca2 teclaBlanca2) {
                teclaBlanca2.setGraphics(graphics);
                teclaBlanca2.setPosicion(posicion.x, posicion.y);
                posicion.x+=teclaBlanca2.getAnchura();
            } else if (tecla instanceof TeclaBlanca3 teclaBlanca3) {
                teclaBlanca3.setGraphics(graphics);
                teclaBlanca3.setPosicion(posicion.x, posicion.y);
                posicion.x+=teclaBlanca3.getAnchura();
            } else if (tecla instanceof TeclaNegra teclaNegra){
                teclaNegra.setGraphics(graphics);
                teclaNegra.setPosicion(posicion.x, posicion.y);
                posicion.x+=teclaNegra.getAnchura();
            }
            tecla.dibujar();
        }

    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }



}
