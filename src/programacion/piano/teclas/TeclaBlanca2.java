package programacion.piano.teclas;

import java.awt.*;

public class TeclaBlanca2 extends TeclaBlanca{
    TeclaBlanca2(int n){
        super(n);
    }

    @Override
    public Color getColorNoPulsado(){
        return Color.WHITE;
    }

    @Override
    public int getAnchura(){
        return ANCHURA;
    }

    @Override
    public int getAltura(){
        return ALTURA;
    }

    @Override
    protected int[] getVerticesX() {
        int[] verticesX = new int[8];
        int N=TeclaNegra.ANCHURA, B=TeclaBlanca.ANCHURA;
        verticesX[0]=this.posicion.x+N/2;
        verticesX[1]=this.posicion.x+B-N/2;
        verticesX[2]=this.posicion.x+B-N/2;
        verticesX[3]=this.posicion.x+B;
        verticesX[4]=this.posicion.x+B;
        verticesX[5]=this.posicion.x;
        verticesX[6]=this.posicion.x;
        verticesX[7]=this.posicion.x+N/2;

        return verticesX;
    }

    @Override
    protected int[] getVerticesY() {
        int[] verticesY = new int[8];
        int N=TeclaNegra.ANCHURA, B=TeclaBlanca.ANCHURA;
        verticesY[0]=this.posicion.y;
        verticesY[1]=this.posicion.y;
        verticesY[2]=this.posicion.y+TeclaNegra.ALTURA;
        verticesY[3]=this.posicion.y+TeclaNegra.ALTURA;
        verticesY[4]=this.posicion.y+TeclaBlanca.ALTURA;
        verticesY[5]=this.posicion.y+TeclaBlanca.ALTURA;
        verticesY[6]=this.posicion.y+TeclaNegra.ALTURA;
        verticesY[7]=this.posicion.y+TeclaNegra.ALTURA;
        return verticesY;
    }
}
