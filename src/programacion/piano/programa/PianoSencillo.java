package programacion.piano.programa;

import programacion.piano.teclas.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano implements Medible {

    private Map<Integer, Tecla> teclas;

    public PianoSencillo(int teclaInicial, int teclaFinal) {

        super(teclaInicial, teclaFinal);
        this.teclas=new HashMap<>();

        for (int i = teclaInicial; i <=teclaFinal ; i++) {

            Tecla tecla=TeclaFactory.crearTecla(i);
            this.teclas.put(i,tecla);
        }
    }

    @Override
    public void dibujar() {

        for(int i=this.getTeclaInicial(); i<=this.getTeclaFinal(); i++){
            teclas.get(i).setGraphics(graphics);
            teclas.get(i).setPosicion(posicion.x, posicion.y);
            if(teclas.get(i) instanceof TeclaBlanca1){
                posicion.x+=TeclaNegra.ANCHURA;
            }else if(teclas.get(i) instanceof TeclaBlanca2){
                posicion.x+=3/2*TeclaNegra.ANCHURA;
            }else if(teclas.get(i) instanceof TeclaBlanca3){
                posicion.x+=TeclaBlanca.ANCHURA;
            }else{
                posicion.x+=TeclaNegra.ANCHURA/2;
            }

            teclas.get(i).dibujar();
        }

    }

    @Override
    public Tecla getTecla(int canal, int nota) {
        return this.teclas.get(nota);
    }

    @Override
    public int getAnchura() {
        int sumaBlancas= 0;

        for (int i = getTeclaInicial(); i <= getTeclaFinal() ; i++) {
            if (teclas.get(i) instanceof TeclaBlanca){
                sumaBlancas+=TeclaBlanca.ANCHURA;
            }
        }

        return sumaBlancas;
    }

    @Override
    public int getAltura() {
        return TeclaBlanca.ALTURA;
    }
}
