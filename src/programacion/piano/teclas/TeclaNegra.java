package programacion.piano.teclas;

import java.awt.*;

public class TeclaNegra extends Tecla{
    public static final int ANCHURA = 15;
    public static final int ALTURA = 50;
    TeclaNegra(int n){
        super(n);

    }
    @Override
    public Color getColorNoPulsado() {
        return Color.BLACK;
    }

    @Override
    public int getAnchura() {
        return ANCHURA;
    }

    @Override
    public int getAltura() {
        return ALTURA;
    }
    @Override
    protected int[] getVerticesX() {
        int[] verticesX = new int[4];
        verticesX[0]=this.posicion.x;
        verticesX[1]=this.posicion.x;
        verticesX[2]=this.posicion.x + TeclaNegra.ANCHURA;
        verticesX[3]=this.posicion.x + TeclaNegra.ANCHURA;
        return verticesX;
    }

    @Override
    protected int[] getVerticesY() {
        int[] verticesY = new int[4];
        verticesY[0]=this.posicion.y;
        verticesY[1]=this.posicion.y + TeclaNegra.ALTURA;
        verticesY[2]=this.posicion.y + TeclaNegra.ALTURA;
        verticesY[3]=this.posicion.y;
        return verticesY;
    }

}
