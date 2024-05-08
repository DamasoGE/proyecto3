package programacion.piano.teclas;

import java.awt.*;

public abstract class Tecla implements Medible,Pulsable{
    protected Point posicion;
    private int nota;
    private boolean pulsada;
    private Color colorPulsada;
    private Graphics graphics;

    Tecla(int n){
        this.nota = n;
        this.colorPulsada = null;
        this.posicion = null;
    }

    public int getNumeroNota(){
        return nota;
    }

    @Override
    public void setPosicion(int x, int y) {
        
    }

    @Override
    public void setGraphics(Graphics g) {

    }

    @Override
    public void dibujar() {

    }

    @Override
    public void pulsar() {

    }

    @Override
    public void soltar() {

    }

    @Override
    public boolean estaPulsado() {
        return false;
    }

    @Override
    public void setColorPulsado(Color c) {

    }

    @Override
    public Color getColorPulsado() {
        return null;
    }

    @Override
    public Color getColorNoPulsado() {
        return null;
    }
    @Override
    public int getAnchura() {
        return 0;
    }

    @Override
    public int getAltura() {
        return 0;
    }

    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();
}
