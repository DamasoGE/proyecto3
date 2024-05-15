package programacion.piano.programa;

import programacion.piano.teclas.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PianoSencillo extends Piano {

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
    public void setPosicion(int x, int y) {

    }

    @Override
    public void setGraphics(Graphics g) {

    }

    @Override
    public void dibujar() {

        for(int i=this.getTeclaInicial(); i<=this.getTeclaFinal(); i++){
            teclas.get(i).setGraphics(graphics);
            teclas.get(i).setPosicion(posicion.x,20);
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

            sumaBlancas+=TeclaBlanca.ANCHURA;

        }

        return sumaBlancas;
    }

    @Override
    public int getAltura() {
        return TeclaBlanca.ALTURA;
    }
}
