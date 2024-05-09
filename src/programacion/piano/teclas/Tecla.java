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
        this.pulsada = false;
    }

    public int getNumeroNota(){
        return nota;
    }

    @Override
    public void setPosicion(int x, int y) {
        posicion.setLocation(new Point(x, y));
    }

    @Override
    public void setGraphics(Graphics g) {
        this.graphics = g;
    }
    @Override
    public void pulsar() {
        this.pulsada = true;
    }

    @Override
    public void soltar() {
        this.pulsada = false;
    }

    @Override
    public void dibujar() {
        if (this.posicion==null || this.graphics==null){
            throw new IllegalArgumentException("Hay que llamar a setPosición y\n" +
                    "setGraphics antes de llamar al método dibujar");
        }
        this.graphics.setColor(this.getColor());
        this.graphics.fillPolygon(this.getVerticesX(),this.getVerticesY(), getVerticesX().length);
        this.graphics.setColor(Color.BLACK);
        this.graphics.drawPolygon(this.getVerticesX(),this.getVerticesY(), getVerticesX().length);
    }
    @Override
    public void setColorPulsado(Color c) {
        this.colorPulsada = c;
    }

    @Override
    public boolean estaPulsado() {
        boolean espulsado = false;
        if (this.estaPulsado()){
            espulsado = true;
        }
        return espulsado;
    }

    @Override
    public Color getColorPulsado() {
        return colorPulsada;
    }

    protected abstract int[] getVerticesX();
    protected abstract int[] getVerticesY();
}
